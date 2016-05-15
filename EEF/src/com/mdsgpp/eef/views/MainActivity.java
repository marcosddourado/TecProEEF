package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_screens, menu);
        
        return true;
    }	
        
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
		switch (item.getItemId()) {

		case R.id.about:
			loadAboutScreen();
			break;
		default:
			break;
		}
		
    	return true;
    }
    
    public void loadAboutScreen() {
    	Intent intent = new Intent(this, TelaSobre.class);
    	startActivity(intent);
    }

    public void clickButtonGeneralComparations(View view) {
    	Intent intent = new Intent(this, ScreenGeneralComparations.class);

		startActivity(intent);
    }
    
    public void clickButtonGeneralConsult(View view){
    	Intent intent = new Intent(this, TelaListaEstado.class);
    	startActivity(intent);
    }
    
    public void clickButtonFeed(View view){
    	Intent intent = new Intent(this, TelaFeed.class);
    	startActivity(intent);
    }

    public void clickButtonConsultatByIndicative(View view){
    	Intent intent = new Intent(this, QueryPerIndicativeScreen.class);
    	startActivity(intent);
    }
}