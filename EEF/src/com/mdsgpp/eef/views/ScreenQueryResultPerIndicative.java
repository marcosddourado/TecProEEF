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

public class ScreenQueryResultPerIndicative extends Activity {
	private final Context context = this;
	private ListView stateList = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_resultado_consulta_por_indicativo);
		initializeViews();
		
		loadStateIndicatives();
		
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
		Intent intent = new Intent(this, ScreenOverQueryResult.class);
    	startActivity(intent);
		
	}
	
	private void loadStateIndicatives() {
			Intent intent = getIntent();
			
			String indicative = intent.getStringExtra("INDICATIVO");
			String title = intent.getStringExtra("TITULO");
			
			IndicativeAdapter adapter = new IndicativeAdapter(title, indicative,
					context);
			
			stateList.setAdapter(adapter);
	}
	
	public void initializeViews(){
		stateList = (ListView) findViewById(R.id.listview_tela_resultado_consulta_por_indicativo);
	}
	
	
}
