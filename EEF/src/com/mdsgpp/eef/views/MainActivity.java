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
			openAboutScreen();
			break;
		default:
			break;
		}
		
    	return true;
    }
    
    public void openAboutScreen() {
    	Intent intent = new Intent(this, ScreenOver.class);
    	startActivity(intent);
    }

    public void clickButtonGeneralComparations(View view) {
    	Intent intent = new Intent(this, ScreenGeneralComparations.class);

		startActivity(intent);
    }
    
    public void clickButtonGeneralConsultation(View view){
    	Intent intent = new Intent(this, ScreenStateList.class);
    	startActivity(intent);
    }
    
    public void clickButtonFeed(View view){
    	Intent intent = new Intent(this, ScreenFeed.class);
    	startActivity(intent);
    }
    public void clickButtonConsultationByIndicative(View view){
    	Intent intent = new Intent(this, ScreenQueryPerIndicative.class);
    	startActivity(intent);
    }
}