package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ScreenQueryPerIndicative extends ChooseIndicative {

	/**
	 * Sets content view and initializes component text field.
	 * @param savedInstanceState
     */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_indicative_graph);
		
		TextView txtViewTitle = (TextView) findViewById(R.id.textview_titulo);
		txtViewTitle.setText("Escolha um indicativo para gerar a lista: ");
	}

	/**
	 * Loads the about screen.
	 */
	public void loadAboutScreen() {
		Intent intent = new Intent(this, ScreenAboutIndicatives.class);
		startActivity(intent);
	}

	/**
	 * Loads the query result screen.
	 * @param view Wildcard view reference.
     */
	public void clickButtonNext(View view) {
		Intent intent = new Intent(this, ScreenQueryResultPerIndicative.class);

		intent.putExtra("INDICATIVO", getIndicative());
		intent.putExtra("TITULO", getTittle());

		startActivity(intent);
	}
	
}