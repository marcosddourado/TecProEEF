package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ScreenQueryPerIndicative extends ChooseIndicative {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_indicative_graph);
		
		TextView txtViewTitle = (TextView) findViewById(R.id.textview_titulo);
		txtViewTitle.setText("Escolha um indicativo para gerar a lista: ");
	}

	public void loadAboutScreen() {
		Intent intent = new Intent(this, ScreenOverIndicatives.class);
		startActivity(intent);
	}
	
	public void clickButtonNext(View view) {
		Intent intent = new Intent(this, ScreenQueryResultPerIndicative.class);

		intent.putExtra("INDICATIVO", getIndicative());
		intent.putExtra("TITULO", getTittle());

		startActivity(intent);
	}
	
}