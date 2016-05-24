package com.mdsgpp.eef.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;
import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateConroller;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class GraphScreen extends Activity {

    private int estado1;
    private int estado2;
    private String titulo;
    private String indicativo;
    private TextView tituloGrafico;
    private float valorIndicativoEstado1;
    private float valorIndicativoEstado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_grafico);

        catchInformation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_screens, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about:
                loadAboutScreen();
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
            default:
                break;
        }

        return true;
    }

    public void loadAboutScreen() {
        Intent intent = new Intent(this, ScreenAboutGraphic.class);
        startActivity(intent);
    }

    @SuppressWarnings({"unchecked"})
    private void catchInformation() {
        inicializaCamposTexto();

        // Captura o intent que abriu a activity
        Intent intent = getIntent();
        // Captura o valor transferido através da intent
        estado1 = intent.getIntExtra("INDEX_CHOOSED_STATE1", 0);
        estado2 = intent.getIntExtra("INDEX_CHOOSED_STATE2", 0);
        titulo = intent.getStringExtra("TITULO");
        indicativo = intent.getStringExtra("INDICATIVO");

        HashMap<String, String> stateInformations1 = new HashMap<String, String>();
        HashMap<String, String> stateInformations2 = new HashMap<String, String>();

        try {
            stateInformations1 = (HashMap<String, String>) StateConroller
                    .getInstance(this).readState(estado1).clone();
            stateInformations2 = (HashMap<String, String>) StateConroller
                    .getInstance(this).readState(estado2).clone();

            converteDados(stateInformations1, stateInformations2);
            criaGrafico(stateInformations1, stateInformations2);

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Houve um erro no acesso es informaeees.", Toast.LENGTH_SHORT).show();
        }
    }

    private void criaGrafico(HashMap<String, String> stateInformations1,
                             HashMap<String, String> stateInformations2) {

        Bar estado1Barra = new Bar();
        estado1Barra.setColor(Color.parseColor("#4682B4"));
        estado1Barra.setName(stateInformations1.get("nome"));
        estado1Barra.setValue(valorIndicativoEstado1);

        Bar estado2Barra = new Bar();
        estado2Barra.setColor(Color.parseColor("#191970"));
        estado2Barra.setName(stateInformations2.get("nome"));
        estado2Barra.setValue(valorIndicativoEstado2);

        ArrayList<Bar> barras = new ArrayList<Bar>();
        barras.add(estado1Barra);
        barras.add(estado2Barra);

        tituloGrafico.setText(titulo);

        BarGraph grafico = (BarGraph) findViewById(R.id.graph);

        grafico.setBars(barras);
    }

    private void converteDados(HashMap<String, String> stateInformations1,
                               HashMap<String, String> stateInformations2) {

        String estado1IndicativoString = stateInformations1.get(indicativo);
        String estado2IndicativoString = stateInformations2.get(indicativo);

        // getting only the numbers on the string
        estado1IndicativoString = estado1IndicativoString.replaceAll("[^\\d,]", "");
        estado2IndicativoString = estado2IndicativoString.replaceAll("[^\\d,]", "");

        estado1IndicativoString = estado1IndicativoString.replaceAll(",", ".");
        estado2IndicativoString = estado2IndicativoString.replaceAll(",", ".");

        valorIndicativoEstado1 = Float.parseFloat(estado1IndicativoString);
        valorIndicativoEstado2 = Float.parseFloat(estado2IndicativoString);
    }

    private void inicializaCamposTexto() {
        tituloGrafico = (TextView) findViewById(R.id.text_view_titulo_grafico);
    }
}
