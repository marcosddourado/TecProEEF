package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    /**
     * Sets content view for the application.
     * @param savedInstanceState current app state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
    }

    /**
     * Inflates menus
     * @param menu Menu reference.
     * @return Should inflate boolean value.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_screens, menu);
        
        return true;
    }

    /**
     * Sets default behavior for given user item clicks.
     * @param item Clicked item.
     * @return Should navigate boolean value.
     */
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

    /**
     * Loads the "About" screen.
     */
    public void loadAboutScreen() {
    	Intent intent = new Intent(this, ScreenAbout.class);
    	startActivity(intent);
    }

    /**
     * Starts the activity for general comparison.
     * @param view A wildcard view object.
     */
    public void clickButtonGeneralComparations(View view) {
    	Intent intent = new Intent(this, ScreenGeneralComparations.class);

		startActivity(intent);
    }

    /**
     * Starts the activity for general consultation.
     * @param view A wildcard view object.
     */
    public void clickButtonGeneralConsultation(View view){
    	Intent intent = new Intent(this, ScreenStateList.class);
    	startActivity(intent);
    }

    /**
     * Reloads the feed and starts activity for feed info.
     * @param view Wildcard view reference.
     */
    public void clickButtonFeed(View view){
    	Intent intent = new Intent(this, ScreenFeed.class);
    	startActivity(intent);
    }

    /**
     * Starts the indicative comparison view.
     * @param view Wildcard view reference.
     */
    public void clickButtonConsultationByIndicative(View view){
    	Intent intent = new Intent(this, ScreenQueryPerIndicative.class);
    	startActivity(intent);
    }
}