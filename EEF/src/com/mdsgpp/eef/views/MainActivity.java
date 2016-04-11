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
<<<<<<< HEAD
		case R.id.sobre:
			loadAboutScreen();
=======
		case R.id.about:
			openAboutScreen();
>>>>>>> 1d79114fdc0bff4e5ff2f85fef159ab0fdac2ee0
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
    	Intent intent = new Intent(this, TelaSobre.class);
    	startActivity(intent);
    }

    public void clickButtonGeneralComparations(View view) {
    	Intent intent = new Intent(this, ScreenGeneralComparations.class);

		startActivity(intent);
    }
    
    public void clickButtonGeneralConsultation(View view){
    	Intent intent = new Intent(this, TelaListaEstado.class);
    	startActivity(intent);
    }
    
    public void clickButtonFeed(View view){
    	Intent intent = new Intent(this, TelaFeed.class);
    	startActivity(intent);
    }
<<<<<<< HEAD
    public void clickBotaoConsultaPorIndicativo(View view){
    	Intent intent = new Intent(this, QueryPerInficativeScreen.class);
=======
    public void clickButtonConsultationByIndicative(View view){
    	Intent intent = new Intent(this, TelaConsultaPorIndicativo.class);
>>>>>>> 1d79114fdc0bff4e5ff2f85fef159ab0fdac2ee0
    	startActivity(intent);
    }
}