package com.mdsgpp.eef.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import com.mdsgpp.eef.model.State;

import android.content.Context;
import android.content.res.AssetManager;

public class ParseData {

	private Context context;

	private final String EXTENSION = ".txt";
	private final String FIRST_INDICATIVE = "censo_anos_finais";
	private final int LINES = 2;
	private final int PAIR = 2;
	private final int NAME_POSITION = 0;
	private final int ACRONYM_POSITION = 1;
	private final int STATES_MAX_INDEX = 26; // index counting starts with 0, so the maximum index for the 27 states is 26

	public ParseData(Context context) {
		assert(context != null) : "null context passed on constructor";
		this.context = context;
	}

	public HashMap<String, ArrayList<String[]>> getState(int state_position) throws IOException {
		assert(state_position >= 0) : "position must be positive. position was" + state_position;
		assert(state_position <= STATES_MAX_INDEX) : "position can't be greater than 26. position was" + state_position;

		HashMap<String, ArrayList<String[]>> state_data = new HashMap<String, ArrayList<String[]>>();

		insertAcronymName(state_position, state_data);
		readIndicatives(state_position, state_data);

		return state_data;
	}

	public BufferedReader readState(int state_position) throws IOException {
		AssetManager am = this.context.getAssets();
		InputStream is = am.open(State.states[state_position] + this.EXTENSION);
		BufferedReader state_stream = new BufferedReader(new InputStreamReader(is));

		return state_stream;
	}

	// Method responsible for sending state name and acronym through indicatives hashmap.
	public void insertAcronymName(int state_position, HashMap<String, ArrayList<String[]>> state_data) throws IOException {
		String nameAndAcronym[] = new String[PAIR];
		ArrayList<String[]> container = new ArrayList<String[]>();
		String name, acronym;

		BufferedReader state_stream = readState(state_position);

		name = state_stream.readLine();
		acronym = state_stream.readLine();

		nameAndAcronym[NAME_POSITION] = name;
		nameAndAcronym[ACRONYM_POSITION] = acronym;
		container.add(nameAndAcronym);

		state_data.put("nome_e_sigla", container);
	}

	// Method responsble for reading available data.
	public void  readIndicatives(int state_position, HashMap<String,
		ArrayList<String[]>> state_data) throws IOException {
		int aux = 0;
		String line;
		String indicatorName;
		ArrayList<String[]> data = new ArrayList<String[]>();

		BufferedReader state_stream = readState(state_position);


		state_stream.readLine();
		state_stream.readLine(); //this will skip name and acronym on file
		do {
			line = state_stream.readLine();
			if (!line.isEmpty()) {
				indicatorName = state_stream.readLine();
				do {
					data.add(line.split(": "));
				} while(!line.isEmpty());
				state_data.put(indicatorName, data);
			}
		} while (line != null);
		state_stream.close();
	}

}
