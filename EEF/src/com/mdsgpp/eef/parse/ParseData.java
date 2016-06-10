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

	private ArrayList<String[]> data;
	private Context context;
	private String indicatorName;

	private final String EXTENSION = ".txt";
	private final int LINES = 2;
	private final int PAIR = 2;
	private final int NAME_POSITION = 0;
	private final int ACRONYM_POSITION = 1;
	private final int STATES_MAX_INDEX = 26; // index counting starts with 0, so the maximum index for the 27 states is 26

	public ParseData(Context context) {
		assert(context != null) : "null context passed on constructor";
		this.context = context;
	}

	public HashMap<String, ArrayList<String[]>> getState(int position) throws IOException {
		assert(position >= 0) : "position must be positive. position was" + position;
		assert(position <= STATES_MAX_INDEX) : "position can't be greater than 26. position was" + position;

		HashMap<String, ArrayList<String[]>> state_data = new HashMap<String, ArrayList<String[]>>();

		insertAcronymName(name, acronym, state_data);
		readIndicatives(br, state_data);

		return state_data;
	}

	public BufferedReader readState(int state_position) throws IOException {
		AssetManager am = this.context.getAssets();
		InputStream is = am.open(State.states[state_position] + this.EXTENSION);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		return br;
	}

	// Method responsible for sending state name and acronym through indicatives hashmap.
	public void insertAcronymName(int state_position, HashMap<String, ArrayList<String[]>> state_data) throws IOException {
		String nameAndAcronym[] = new String[PAIR];
		ArrayList<String[]> container = new ArrayList<String[]>();
		String name, acronym;

		BufferedReader br = readState(state_position);

		name = br.readLine();
		acronym = br.readLine();

		nameAndAcronym[NAME_POSITION] = name;
		nameAndAcronym[ACRONYM_POSITION] = acronym;
		container.add(nameAndAcronym);

		state_data.put("nome_e_sigla", container);
	}

	public void eraseData() {
		this.data = new ArrayList<String[]>();
	}

	// Method responsble for reading available data.
	public void  readIndicatives(BufferedReader br, HashMap<String, ArrayList<String[]>> state_data) throws IOException {
		int aux = 0;
		String line;

		line = br.readLine();
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
				eraseData();
			}

			line = br.readLine();
		}

		br.close();
	}

}
