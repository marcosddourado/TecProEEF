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

public abstract class Comparison extends Activity {

    /*
    * All the attributes that contain '01' reference to the first spinner
    * on the view. The ones that '02' reference to the second spinner
    * */

    private Spinner statesSpinner01 = null;
    private Spinner statesSpinner02 = null;
    private ArrayAdapter<String> statesAdapter01 = null;
    private ArrayAdapter<String> statesAdapter02 = null;
    private ArrayList<String> states01 = new ArrayList<String>();
    private ArrayList<String> states02 = new ArrayList<String>();
    private ArrayList<String> allStates = new ArrayList<String>();

    /**
     * Sets a default behavior for when a new instance of the class is created. Here, we initialize
     * the view components and adapters.
     * @param savedInstanceState The application state at time of creation.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparation);

        inicializeSpinners();

        states01 = fillStates(states01);
        states02 = fillStates(states02);
        allStates = fillStates(allStates);

        statesAdapter01 = setAdapterSpinner(statesAdapter01, statesSpinner01, states01);
        statesAdapter02 = setAdapterSpinner(statesAdapter02, statesSpinner02, states02);
    }

    /**
     * Inflates a menu.
     * @param menu The menu reference
     * @return Should inflate menu boolean value. true for yes.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_screens, menu);
        return true;
    }

    /**
     * Sets default values for the view's Spinners.
     */
    private void inicializeSpinners() {
        statesSpinner01 = (Spinner) findViewById(R.id.spinner1);
        setStatesOnSpinner(statesSpinner01, R.id.spinner1);

        statesSpinner02 = (Spinner) findViewById(R.id.spinner2);
        setStatesOnSpinner(statesSpinner02, R.id.spinner2);
    }

    /**
     * Sets state informations on a given spinner
     * @param spinner The spinner reference.
     * @param spinnerId The given spinner ID.
     */
    private void setStatesOnSpinner(Spinner spinner, final int spinnerId) {
        final Spinner finalSpinner = spinner;
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter,
                                       View view, int position, long id) {
                String stateBeingShowOnTheSpinner = finalSpinner.getSelectedItem().toString();

                if (spinnerId == R.id.spinner1) {
                    refreshValuesSpinner(stateBeingShowOnTheSpinner, statesSpinner02, states02,
                            statesAdapter02);
                } else {
                    refreshValuesSpinner(stateBeingShowOnTheSpinner, statesSpinner01, states01,
                            statesAdapter01);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // nothing to do
            }
        });
    }


    /**
     * Refreshes the spinner's values.
     * @param stateName The name of the state.
     * @param statesSpinner The spinner reference.
     * @param states An array of the states to be refreshed.
     * @param statesAdapter The adapters to be refreshed.
     */
    private void refreshValuesSpinner(String stateName, Spinner statesSpinner, ArrayList<String>
            states, ArrayAdapter<String> statesAdapter) {
        String selectedState = statesSpinner.getSelectedItem().toString();
        states = fillStates(states);
        states.remove(stateName);
        statesAdapter.notifyDataSetChanged();
        statesSpinner.setSelection(states.indexOf(selectedState));
    }

    /**
     * Sets the adapter values for a given state
     * @param statesAdapter The adapter array.
     * @param statesSpinner The spinner container.
     * @param states The states to be added.
     * @return An arraylist of adapters to be used by the view.
     */
    private ArrayAdapter<String> setAdapterSpinner(ArrayAdapter<String> statesAdapter, Spinner statesSpinner,
                                   ArrayList<String> states) {
        statesAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, states);
        statesAdapter
                .setDropDownViewResource(android.R.layout.simple_list_item_1);

        statesSpinner.setAdapter(statesAdapter);

        return  statesAdapter;
    }

    /**
     * Adds all state names to an array for later use.
     * @param states The state names.
     * @return Returns an arraylist containing all state names.
     */
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

    public abstract void clickButtonStatesComparation(View view);

    /**
     * Loads the about section.
     * @param view
     */
    public void clickButtonAboutComparation(View view) {
        Intent intent = new Intent(this, ScreenAboutQuery.class);
        startActivity(intent);
    }

    //Class getters

    public Spinner getStatesSpinner01() {
        return statesSpinner01;
    }

    public Spinner getStatesSpinner02() {
        return statesSpinner02;
    }

    public ArrayList<String> getAllStates() {
        return allStates;
    }
}
