package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class TelaConsultaPorIndicativo extends ChooseIndicative {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_indicative_graph);
		
		TextView txtViewTitulo = (TextView) findViewById(R.id.textview_titulo);
		txtViewTitulo.setText("Escolha um indicativo para gerar a lista: ");
	}

	public void openAboutScreen() {
		Intent intent = new Intent(this, TelaSobreIndicativos.class);
		startActivity(intent);
	}
	
	public void clickButtonNext(View view) {
		Intent intent = new Intent(this, TelaResultadoConsultaPorIndicativo.class);

		intent.putExtra("INDICATIVO", getIndicative());
		intent.putExtra("TITULO", getTittle());

		startActivity(intent);
	}
	
}