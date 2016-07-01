package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ScreenAboutQueryResult extends Activity {

	/**
	 * Sets the content view
	 * @param savedInstanceState Current app state.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_sobre_resultado_da_consulta);
	}

	/**
	 * Inflates a menu
	 * @param menu Menu reference.
	 * @return Should inflate menu.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.menu_telas_sem_sobre, menu);
		return true;
	}

}
