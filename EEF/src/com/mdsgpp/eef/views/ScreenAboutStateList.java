package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

public class ScreenAboutStateList extends Activity {

	/**
	 * Sets the content view
	 * @param savedInstanceState Current app state.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_sobre_lista_estado);
	}

	/**
	 * Inflates a menu
	 * @param menu Menu reference.
	 * @return Should inflate menu.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas_sem_sobre, menu);
		return true;
	}

	/**
	 * Default item clicked behavior. Navigates Up.
	 * @param item Clicked item.
	 * @return Should navigate.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        break;
		default:
			break;
		}
		
    	return true;
	}

}
