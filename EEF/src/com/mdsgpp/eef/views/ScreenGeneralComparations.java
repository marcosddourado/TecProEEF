package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ScreenGeneralComparations extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_comparacoes_gerais);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_screens, menu);
		return true;
	}
	
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
    	Intent intent = new Intent(this, ScreenOverGeneralComparisons.class);
    	startActivity(intent);
    }
	
	public void clickButtonComparation(View view) {
		Intent intent = new Intent(this, ScreenComparation.class);
		startActivity(intent);
	}
	
	public void clickButtonIndicatives(View view) {
		Intent intent = new Intent(this, ScreenQueryPerIndicative.class);
		startActivity(intent);
	}
	
}

