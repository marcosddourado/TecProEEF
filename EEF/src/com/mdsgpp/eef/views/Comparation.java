package com.mdsgpp.eef.views;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import com.mdsgpp.eef.R;

public abstract class Comparation extends Activity{
	private Spinner statesSpinner01;
	private Spinner statesSpinner;
	private ArrayAdapter<String> statesAdapter01;
	private ArrayAdapter<String> statesAdapter02;
	private ArrayList<String> states01;
	private ArrayList<String> states02;
	private ArrayList<String> allStates;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comparation);

		inicializeSpinners();
		states01 = fillStates(states01);
		states02 =fillStates(states02);
		allStates = fillStates(allStates);

		setAdapterSpinner01();
		setAdapterSpinner02();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
	}

	private void inicializeSpinners() {
		states01 = new ArrayList<String>();
		states02 = new ArrayList<String>();
		allStates = new ArrayList<String>();

		statesSpinner01 = (Spinner) findViewById(R.id.spinner1);
		statesSpinner01
				.setOnItemSelectedListener(new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> adapter,
							View view, int position, long id) {
						refreshValuesSpinner02(statesSpinner01
								.getSelectedItem().toString());
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// nada a fazer
					}
				});

		statesSpinner = (Spinner) findViewById(R.id.spinner2);
		statesSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapter, View view,
					int position, long id) {
				refreshValuesSpinner01(statesSpinner.getSelectedItem()
						.toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// nada a fazer
			}
		});

	}

	private void setAdapterSpinner01() {
		statesAdapter01 = new ArrayAdapter<String>(this,
				R.layout.spinner_item, states01);
		statesAdapter01
				.setDropDownViewResource(android.R.layout.simple_list_item_1);

		statesSpinner01.setAdapter(statesAdapter01);
	}

	private void setAdapterSpinner02() {
		statesAdapter02 = new ArrayAdapter<String>(this,
				R.layout.spinner_item, states02);
		statesAdapter02.setDropDownViewResource(android.R.layout.simple_list_item_1);

		// Define o adapter para os spinners
		statesSpinner.setAdapter(statesAdapter02);
	}

	private ArrayList<String> fillStates(ArrayList<String> states) {
		states.clear();

		states.add("Acre");
		states.add("Alagoas");
		states.add("Amape");
		states.add("Amazonas");
		states.add("Bahia");
		states.add("Ceara");
		states.add("Distrito Federal");
		states.add("Espirito Santo");
		states.add("Goias");
		states.add("Maranhao");
		states.add("Mato Grosso");
		states.add("Mato Grosso do Sul");
		states.add("Minas Gerais");
		states.add("Pare");
		states.add("Paraiba");
		states.add("Parane");
		states.add("Pernambuco");
		states.add("Piaui");
		states.add("Rio de Janeiro");
		states.add("Rio Grande do Norte");
		states.add("Rio Grande do Sul");
		states.add("Rondonia");
		states.add("Roraima");
		states.add("Santa Catarina");
		states.add("Sao Paulo");
		states.add("Sergipe");
		states.add("Tocantins");
		
		return states;
	}

	private void refreshValuesSpinner01(String name) {
		String selectedState = statesSpinner01.getSelectedItem().toString();
		states01 = fillStates(states01);
		states01.remove(name);
		statesAdapter01.notifyDataSetChanged();
		statesSpinner01.setSelection(states01.indexOf(selectedState));
	}

	private void refreshValuesSpinner02(String name) {
		String selectedState = statesSpinner.getSelectedItem().toString();
		states02 = fillStates(states02);
		states02.remove(name);
		statesAdapter02.notifyDataSetChanged();
		statesSpinner.setSelection(states02.indexOf(selectedState));
	}

	public abstract void clickButtonStatesComparation(View view);
	
	public void clickButtonAboutComparation(View view) {
		Intent intent = new Intent(this, TelaSobreConsulta.class);
		startActivity(intent);
	}	
	
	public Spinner getStatesSpinner01() {
		return statesSpinner01;
	}

	public Spinner getStatesSpinner() {
		return statesSpinner;
	}

	public ArrayList<String> getTodosEstados() {
		return allStates;
	}
}
