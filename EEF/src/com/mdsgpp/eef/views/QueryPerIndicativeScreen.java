package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

<<<<<<< HEAD:EEF/src/com/mdsgpp/eef/views/QueryPerIndicativeScreen.java
public class QueryPerIndicativeScreen extends EscolheIndicativo {
=======
public class TelaConsultaPorIndicativo extends ChooseIndicative {
>>>>>>> 1d79114fdc0bff4e5ff2f85fef159ab0fdac2ee0:EEF/src/com/mdsgpp/eef/views/TelaConsultaPorIndicativo.java
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_indicative_graph);
		
		TextView txtViewTitulo = (TextView) findViewById(R.id.textview_titulo);
		txtViewTitulo.setText("Escolha um indicativo para gerar a lista: ");
	}

<<<<<<< HEAD:EEF/src/com/mdsgpp/eef/views/QueryPerIndicativeScreen.java
	public void loadAboutScreen() {
=======
	public void openAboutScreen() {
>>>>>>> 1d79114fdc0bff4e5ff2f85fef159ab0fdac2ee0:EEF/src/com/mdsgpp/eef/views/TelaConsultaPorIndicativo.java
		Intent intent = new Intent(this, TelaSobreIndicativos.class);
		startActivity(intent);
	}
	
<<<<<<< HEAD:EEF/src/com/mdsgpp/eef/views/QueryPerIndicativeScreen.java
	public void clickAdvanceButton(View view) {
		Intent intent = new Intent(this, TelaResultadoConsultaPorIndicativo.class);

		intent.putExtra("INDICATIVO", getIndicative());
		intent.putExtra("TITULO", getTitle());
=======
	public void clickButtonNext(View view) {
		Intent intent = new Intent(this, TelaResultadoConsultaPorIndicativo.class);

		intent.putExtra("INDICATIVO", getIndicative());
		intent.putExtra("TITULO", getTittle());
>>>>>>> 1d79114fdc0bff4e5ff2f85fef159ab0fdac2ee0:EEF/src/com/mdsgpp/eef/views/TelaConsultaPorIndicativo.java

		startActivity(intent);
	}
	
}