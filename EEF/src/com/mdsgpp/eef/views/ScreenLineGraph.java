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

public class ScreenLineGraph extends Activity {

	private TextView graphTitle, history;
	private ArrayList<Float> historyList = new ArrayList<Float>();
	private ArrayList<String> temp;
	private HashMap<String, String> information;
	private String title, indicative;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_grafico_historico);
		
		initializeTextFields();
		catchInformation();
		fillTextFields();
			
		plotGraph();
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
	
	private void catchInformation() {
		int position;
		Intent intent;
		
		information = new HashMap<String, String>();
		
		intent = getIntent();
		temp = intent.getStringArrayListExtra("HISTORICO");
		title = intent.getStringExtra("TITULO");
		indicative = intent.getStringExtra("INDICATIVO_GRAFICO");
		position = intent.getIntExtra("POSICAO_ESTADO", 0);
		
		for(int i=0; i<temp.size(); i++) {
			historyList.add(Float.parseFloat(temp.get(i)));
		}
		
		try {
			information = StateConroller.getInstance(this).readCompleteState(position);
		} catch (IOException e) {
			Log.i("Error - ScreenLineGraph", "Erro ao capturar as informacoes do estado.");
			e.printStackTrace();
		}	
	}
	
	public void loadAboutScreen() {
		Intent intent = new Intent(this, ScreenAboutGraphic.class);
    	startActivity(intent);
	}
	

	private void initializeTextFields() {
		graphTitle = (TextView) findViewById(R.id.text_view_titulo_grafico_historico);
		history = (TextView) findViewById(R.id.text_view_grafico_historico);
	}
	
	private void fillTextFields() {
		graphTitle.setText(title);
		Log.i("teste_indicativo", indicative);
		Log.i("teste_indicativo", ""+ information.containsKey(indicative));
		history.setText(information.get(indicative));
	}
	
	private void plotGraph() {
		Line curve = new Line();
		
		for(int i = 0, passo = 10; i< historyList.size(); i++,passo+=10){
			LinePoint point = new LinePoint();
			point.setX(passo);
			point.setY(historyList.get(i));
			curve.addPoint(point);
		}
		curve.setColor(Color.parseColor("#4682B4"));
		LineGraph li = (LineGraph)findViewById(R.id.graph);
		li.addLine(curve);
		
		float maxY = 0;
		maxY = evaluateMaxHistoryValue(maxY);
		
		li.setRangeY(0, maxY);
		li.setLineToFill(0);
	}

	private float evaluateMaxHistoryValue(float maximo) {
		for(int i = 0; i< historyList.size(); i++){
			if(historyList.get(i) >= maximo)
				maximo = (float) historyList.get(i);
		}
		return (float)(1.1*maximo);
	}
}
