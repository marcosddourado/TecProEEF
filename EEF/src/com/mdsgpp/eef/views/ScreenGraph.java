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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ScreenGraph extends Activity {

	private int state1;
	private int state2;
	private String title;
	private String indicative;
	private TextView graphTitle;
	private float indicativeValueState1;
	private float indicativeValueState2;
	
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
			openAboutScreen();
			break;
		case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        break;
		default:
			break;
		}
		
    	return true;
	}
	
	public void openAboutScreen() {
		Intent intent = new Intent(this, ScreenOverGraphic.class);
    	startActivity(intent);
	}
	
	@SuppressWarnings({"unchecked"})
	private void catchInformation() {
		initializeTextFields();
		
		// Captura o intent que abriu a activity
		Intent intent = getIntent();
		// Captura o valor transferido através da intent
		state1 = intent.getIntExtra("INDEX_CHOOSED_STATE1", 0);
		state2 = intent.getIntExtra("INDEX_CHOOSED_STATE2", 0);
		title = intent.getStringExtra("TITULO");
		indicative = intent.getStringExtra("INDICATIVO");

		HashMap<String, String> stateInformations1 = new HashMap<String, String>();
		HashMap<String, String> stateInformations2 = new HashMap<String, String>();

		try {
			stateInformations1 = (HashMap<String, String>) StateConroller
					.getInstance(this).readState(state1).clone();
			stateInformations2 = (HashMap<String, String>) StateConroller
					.getInstance(this).readState(state2).clone();
			
			dataConversion(stateInformations1, stateInformations2);
			makeGraph(stateInformations1, stateInformations2);
			
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso es informaeees.", Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaComparaEstados",e.toString());
		}
	}
	
	private void makeGraph(HashMap<String, String> stateInformations1,
						   HashMap<String, String> stateInformations2) {
		
        Bar state1Bar = new Bar();
        state1Bar.setColor(Color.parseColor("#4682B4"));
        state1Bar.setName(stateInformations1.get("nome"));
		state1Bar.setValue(indicativeValueState1);
        
        Bar state2Bar = new Bar();
        state2Bar.setColor(Color.parseColor("#191970"));
        state2Bar.setName(stateInformations2.get("nome"));
        state2Bar.setValue(indicativeValueState2);

		ArrayList<Bar> bars = new ArrayList<Bar>();
        bars.add(state1Bar);
        bars.add(state2Bar);

        graphTitle.setText(title);
        
        BarGraph graph = (BarGraph)findViewById(R.id.graph);
        
        graph.setBars(bars);
	}

	private void dataConversion(HashMap<String, String> stateInformations1,
								HashMap<String, String> stateInformations2) {
		
		String state1Indicative = stateInformations1.get(indicative);
		String state2Indicative = stateInformations2.get(indicative);
	
				
		state1Indicative = state1Indicative.replaceAll("[^\\d,]", "");/*como os dados viram como estão escritos na tela
																					   aqui nós pegamos somente os não digitos (numeros)
																					   que estão na String*/
		state2Indicative = state2Indicative.replaceAll("[^\\d,]", "");
		
		state1Indicative = state1Indicative.replaceAll(",", ".");
		state2Indicative = state2Indicative.replaceAll(",", ".");
		
		indicativeValueState1 = Float.parseFloat(state1Indicative);
		indicativeValueState2 = Float.parseFloat(state2Indicative);
	}

	private void initializeTextFields() {
		graphTitle = (TextView) findViewById(R.id.text_view_titulo_grafico);
	}
}
