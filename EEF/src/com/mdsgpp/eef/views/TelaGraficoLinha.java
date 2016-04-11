package com.mdsgpp.eef.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.LinePoint;
import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateConroller;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TelaGraficoLinha extends Activity {

	private TextView txtviewTituloGrafico, txtviewHistorico;
	private ArrayList<Float> historico = new ArrayList<Float>();
	private ArrayList<String> temp;
	private HashMap<String, String> informacoes;
	private String titulo, indicativo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_grafico_historico);
		
		inicializaCamposTexto();
		catchInformation();
		preencheCamposDeTexto();
			
		plotarGrafico();
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
		case R.id.sobre:
<<<<<<< HEAD
			loadAboutScreen();
=======
			openAboutScreen();
>>>>>>> 1d79114fdc0bff4e5ff2f85fef159ab0fdac2ee0
			break;
		case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        break;
		default:
			break;
		}
		
    	return true;
	}
	
	private void catchInformation() {
		int position;
		Intent intent;
		
		informacoes = new HashMap<String, String>();
		
		intent = getIntent();
		temp = intent.getStringArrayListExtra("HISTORICO");
		titulo = intent.getStringExtra("TITULO");
		indicativo = intent.getStringExtra("INDICATIVO_GRAFICO");
		position = intent.getIntExtra("POSICAO_ESTADO", 0);
		
		for(int i=0; i<temp.size(); i++) {
			historico.add(Float.parseFloat(temp.get(i)));
		}
		
		try {
			informacoes = StateConroller.getInstance(this).readStateCompleto(position);
		} catch (IOException e) {
			Log.i("Erro - TelaGraficoLinha", "Erro ao capturar as informacoes do estado.");
			e.printStackTrace();
		}	
	}
	
<<<<<<< HEAD
	public void loadAboutScreen() {
=======
	public void openAboutScreen() {
>>>>>>> 1d79114fdc0bff4e5ff2f85fef159ab0fdac2ee0
		Intent intent = new Intent(this, TelaSobreGrafico.class);
    	startActivity(intent);
	}
	

	private void inicializaCamposTexto() {
		txtviewTituloGrafico = (TextView) findViewById(R.id.text_view_titulo_grafico_historico);
		txtviewHistorico = (TextView) findViewById(R.id.text_view_grafico_historico);
	}
	
	private void preencheCamposDeTexto() {
		txtviewTituloGrafico.setText(titulo);
		Log.i("teste_indicativo", indicativo);
		Log.i("teste_indicativo", ""+informacoes.containsKey(indicativo));
		txtviewHistorico.setText(informacoes.get(indicativo));
	}
	
	private void plotarGrafico() {
		Line curva = new Line();
		
		for(int i=0, passo=10; i<historico.size(); i++,passo+=10){
			LinePoint ponto = new LinePoint();
			ponto.setX(passo);
			ponto.setY(historico.get(i));
			curva.addPoint(ponto);
		}
		curva.setColor(Color.parseColor("#4682B4"));
		LineGraph li = (LineGraph)findViewById(R.id.graph);
		li.addLine(curva);
		
		float yMaximo = 0;
		yMaximo = calculaValorMaximoHistorico(yMaximo);
		
		li.setRangeY(0, yMaximo);
		li.setLineToFill(0);
	}

	private float calculaValorMaximoHistorico(float maximo) {
		for(int i=0; i<historico.size(); i++){
			if(historico.get(i) >= maximo)
				maximo = (float) historico.get(i);  
		}
		return (float)(1.1*maximo);
	}
}
