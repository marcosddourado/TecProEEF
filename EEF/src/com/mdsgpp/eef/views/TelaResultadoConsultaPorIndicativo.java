package com.mdsgpp.eef.views;


import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class TelaResultadoConsultaPorIndicativo extends Activity {
	private final Context context = this;
	private ListView listaDeEstados = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_resultado_consulta_por_indicativo);
		inicializaViews();
		
		carregaIndicativosDosEstados();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(
				R.menu.menu_screens, menu);
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
	
<<<<<<< HEAD
	public void loadAboutScreen() {
=======
	public void openAboutScreen() {
>>>>>>> 1d79114fdc0bff4e5ff2f85fef159ab0fdac2ee0
		Intent intent = new Intent(this, TelaSobreResultadoDaConsulta.class);
    	startActivity(intent);
		
	}
	
	private void carregaIndicativosDosEstados() {
			Intent intent = getIntent();
			
			String indicativo = intent.getStringExtra("INDICATIVO");
			String titulo = intent.getStringExtra("TITULO");
			
			IndicativeAdapter adapter = new IndicativeAdapter(titulo, indicativo,
					context);
			
			listaDeEstados.setAdapter(adapter);
	}
	
	public void inicializaViews(){
		listaDeEstados = (ListView) findViewById(R.id.listview_tela_resultado_consulta_por_indicativo);
	}
	
	
}
