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

	private HashMap<String, ArrayList<String[]>> informations = null; // Container for every educational indicative available for the state.
	private ArrayList<String[]> data = null;
	private Context context = null;
	private String indicatorName = null;

	private final String EXTENSION = ".txt";
	private final int LINES = 2;
	private final int PAIR = 2;
	private final int NAME_POSITION = 0;
	private final int ACRONYM_POSITION = 1;
	private final int STATES_MAX_INDEX = 26; // index counting starts with 0, so the maximum index for the 27 states is 26


	/**
	 * Class's constructor. It also initialize this.context with context and this.informations with default value
	 * @param context
     */
	public ParseData(Context context) {
		assert(context != null) : "null context passed on constructor";
		this.context = context;
		this.informations = new HashMap<String, ArrayList<String[]>>();
	}

	/**
	 * Return all informations about state matching with 'position' read from assets
	 * @param position
	 * @return informations
	 * @throws IOException
     */
	public HashMap<String, ArrayList<String[]>> getState(int position) throws IOException {
		assert(position >= 0) : "position must be positive. position was" + position;
		assert(position <= STATES_MAX_INDEX) : "position can't be greater than 26. position was" + position;

		String name, acronym;

		//Opening asset equivalent to 'position'
		AssetManager am = this.context.getAssets();
		InputStream is = am.open(State.states[position] + this.EXTENSION);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		name = br.readLine();
		acronym = br.readLine();

		eraseInformations();
		eraseData();

		insertAcronymName(name, acronym);
		readIndicatives(br);

		return informations;
	}

	public void eraseInformations() {
		this.informations.clear();
	}

	public void eraseData() {
		this.data = new ArrayList<String[]>();
	}

    /**
	 * Insert 'name' and 'acronym' into 'informations'
	 * @param name
	 * @param acronym
     */
	public void insertAcronymName(String name, String acronym) {
		ArrayList<String[]> container = new ArrayList<String[]>();
		String nameAndAcronym[] = new String[PAIR];
		nameAndAcronym[NAME_POSITION] = name;
		nameAndAcronym[ACRONYM_POSITION] = acronym;

		container.add(nameAndAcronym);

		assert (container != null): "Dictionary input cannot be of NULL value!";

		this.informations.put("nome_e_sigla", container);
	}

	/**
	 * Inser all read indicatives into 'informations'
	 * @param br
	 * @throws IOException
     */
	public void  readIndicatives(BufferedReader br) throws IOException {
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
				this.informations.put(indicatorName, data);
				indicatorName = br.readLine();
				eraseData();
			}
			line = br.readLine();
		}
		br.close();
	}

}
