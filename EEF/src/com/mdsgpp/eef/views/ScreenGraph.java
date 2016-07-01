package com.mdsgpp.eef.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;
import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateConroller;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ScreenGraph extends Activity {

	private String title;
	private String indicative;
	private TextView graphTitle;
	private float indicativeValueState1;
	private float indicativeValueState2;

	/**
	 * Sets the content view, then gets current feed info.
	 * @param savedInstanceState Current app state.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_grafico);
		
		catchInformation();
	}

	/**
	 * Inflates a menu
	 * @param menu Menu reference.
	 * @return Should inflate menu.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_screens, menu);
		return true;
	}

	/**
	 * Default item clicked behavior. Navigates up or loads about screen.
	 * @param item Clicked item.
	 * @return Should navigate.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
			case R.id.about:
				loadAboutScreen();
				break;
			case android.R.id.home:
				NavUtils.navigateUpFromSameTask(this);
				break;
			default:
				break;
			}
    	return true;
	}

	/**
	 * Loads about screen.
	 */
	public void loadAboutScreen() {
		Intent intent = new Intent(this, ScreenAboutGraphic.class);
    	startActivity(intent);
	}

	/**
	 * Retrieves information from a feed and the current hashMaps, sets the view data with it, then
	 * Sets the new application intent.
	 */
	@SuppressWarnings({"unchecked"})
	private void catchInformation() {
		initializeTextFields();
		
		// Get the caller intent
		Intent intent = getIntent();
		// Get the value passed through intent
		int state1 = intent.getIntExtra("INDEX_CHOOSED_STATE1", 0);
		int state2 = intent.getIntExtra("INDEX_CHOOSED_STATE2", 0);
		this.title = intent.getStringExtra("TITULO");
		this.indicative = intent.getStringExtra("INDICATIVO");

		HashMap<String, String> stateInformations1 = new HashMap<String, String>();
		HashMap<String, String> stateInformations2 = new HashMap<String, String>();

		try {
			stateInformations1 = (HashMap<String, String>) StateConroller
					.getInstance(this).readState(state1).clone();
			stateInformations2 = (HashMap<String, String>) StateConroller
					.getInstance(this).readState(state2).clone();
			
			dataConversion(stateInformations1, stateInformations2);
			makeGraph(stateInformations1, stateInformations2);
			
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso es informaeees.", Toast.LENGTH_SHORT).show();
			Log.i("IOException",e.toString());
		}
	}


	/**
	 * Generates a graph based on the data Hashmaps from two states of the user's selection.
	 * @param stateInformations1 Hashmap for first state.
	 * @param stateInformations2 Hashmap for comparison state.
     */
	private void makeGraph(HashMap<String, String> stateInformations1,
						   HashMap<String, String> stateInformations2) {
		
        Bar state1Bar = new Bar();
        state1Bar.setColor(Color.parseColor("#4682B4"));
        state1Bar.setName(stateInformations1.get("nome"));
		state1Bar.setValue(this.indicativeValueState1);
        
        Bar state2Bar = new Bar();
        state2Bar.setColor(Color.parseColor("#191970"));
        state2Bar.setName(stateInformations2.get("nome"));
        state2Bar.setValue(this.indicativeValueState2);

		ArrayList<Bar> bars = new ArrayList<Bar>();
        bars.add(state1Bar);
        bars.add(state2Bar);

        this.graphTitle.setText(this.title);
        
        BarGraph graph = (BarGraph)findViewById(R.id.graph);
        
        graph.setBars(bars);
	}

	/**
	 * Converts unparsed info from the two states' hashmaps.
	 * @param stateInformations1 First state hashmap.
	 * @param stateInformations2 Second state hashmap.
     */
	private void dataConversion(HashMap<String, String> stateInformations1,
								HashMap<String, String> stateInformations2) {
		
		String state1Indicative = stateInformations1.get(indicative);
		String state2Indicative = stateInformations2.get(indicative);
	
		/*como os dados virao como estão escritos na tela
		* aqui nós pegamos somente os não digitos (numeros)
	   	*que estão na String*/
		state1Indicative = state1Indicative.replaceAll("[^\\d,]", "");
		state2Indicative = state2Indicative.replaceAll("[^\\d,]", "");
		
		state1Indicative = state1Indicative.replaceAll(",", ".");
		state2Indicative = state2Indicative.replaceAll(",", ".");
		
		indicativeValueState1 = Float.parseFloat(state1Indicative);
		indicativeValueState2 = Float.parseFloat(state2Indicative);
	}

	private void initializeTextFields() {
		graphTitle = (TextView) findViewById(R.id.text_view_titulo_grafico);
	}
}
