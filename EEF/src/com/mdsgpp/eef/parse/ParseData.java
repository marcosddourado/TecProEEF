package com.mdsgpp.eef.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.res.AssetManager;

import com.mdsgpp.eef.model.State;

public class ParseData {
	private Context context;

	private final String EXTENSION = ".txt";
	private final int LINES = 2;
	private final int PAIR = 2;
	private final int NAME_POSITION = 0;
	private final int ACRONYM_POSITION = 1;
	private final int STATES_MAX_INDEX = 26; // index counting starts with 0, so the maximum index for the 27 states is 26
	private final int EMPTY_LINES = 4;


	public ParseData(Context context) {
		assert(context != null) : "null context passed on constructor";
		this.context = context;
	}

	public HashMap<String, ArrayList<String[]>> getState(int state_position) throws IOException {
		assert(state_position >= 0) : "position must be positive. position was" + state_position;
		assert(state_position <= STATES_MAX_INDEX) : "position can't be greater than 26. position was" + state_position;

		String name, acronym;
		HashMap<String, ArrayList<String[]>> state_data = new HashMap<String, ArrayList<String[]>>();

		name = State.states[state_position];
		acronym = State.acronyms[state_position];

		insertAcronymName(name, acronym, state_data);
		readIndicatives(state_position, state_data);

		return state_data;
	}

	// Method responsible for sending state name and acronym through indicatives hashmap.
	public void insertAcronymName(String name, String acronym, HashMap<String, ArrayList<String[]>> state_data) {
		ArrayList<String[]> container = new ArrayList<String[]>();
		String nameAndAcronym[] = new String[PAIR];
		nameAndAcronym[NAME_POSITION] = name;
		nameAndAcronym[ACRONYM_POSITION] = acronym;

		container.add(nameAndAcronym);

		assert (container != null): "Dictionary input cannot be of NULL value!";

		state_data.put("nome_e_sigla", container);
	}

	// Method responsble for reading available data.
	public void  readIndicatives(int state_position, HashMap<String, ArrayList<String[]>> state_data) throws IOException {
		int aux = 0;
		String line;
		String indicatorName;
		ArrayList<String[]> data = new ArrayList<String[]>();

		AssetManager am = this.context.getAssets();
		InputStream is = am.open(State.states[state_position] + this.EXTENSION);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		for (int i = 0; i < EMPTY_LINES; i++) {
			br.readLine();
		}
		indicatorName = br.readLine();
		line = br.readLine();

		while (line != null) {
			if (line.isEmpty()) {
				aux++;
			} else {
				data.add(line.split(": "));
			}

			if (aux == LINES) {
				aux = 0;
				state_data.put(indicatorName, data);
				indicatorName = br.readLine();
			}

			line = br.readLine();
		}

		br.close();
	}

}
