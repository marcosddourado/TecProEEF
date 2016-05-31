package com.mdsgpp.eef.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.res.AssetManager;

public class ParseData {

	private HashMap<String, ArrayList<String[]>> informations; // Container for every educational indicative available for the state.
	private ArrayList<String[]> data;
	private Context context;
	private String indicatorName;

	private final String EXTENSION = ".txt";
	private final int LINES = 2;
	private final int PAIR = 2;
	private final int NAME_POSITION = 0;
	private final int ACRONYM_POSITION = 1;

	private final String states[] = { "Acre", "Alagoas", "Amapa", "Amazonas", "Bahia", "Ceara",
			"Distrito Federal", "Espirito Santo", "Goias", "Maranhao", "Mato Grosso do Sul",
			"Mato Grosso", "Minas Gerais", "Para", "Paraiba", "Parana", "Pernambuco", "Piaui",
			"Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondonia", "Roraima",
			"Santa Catarina", "Sao Paulo", "Sergipe", "Tocantins" };

	public ParseData(Context context) {
		assert(context != null) : "null context passed on constructor";
		this.context = context;
		this.informations = new HashMap<String, ArrayList<String[]>>();
	}

	public HashMap<String, ArrayList<String[]>> getState(int position) throws IOException {
		assert(position >=0) : "position must be positive. position was" + position;
		String name, acronym;

		AssetManager am = this.context.getAssets();
		InputStream is = am.open(this.states[position] + this.EXTENSION);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		assert (br != null) : "buffer cannot reference NULL";

		name = this.states[position];
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

	// Method responsible for sending state name and acronym through indicatives hashmap.
	public void insertAcronymName(String name, String acronym) {
		ArrayList<String[]> container = new ArrayList<String[]>();
		String nameAndAcronym[] = new String[PAIR];
		nameAndAcronym[NAME_POSITION] = name;
		nameAndAcronym[ACRONYM_POSITION] = acronym;

		container.add(nameAndAcronym);

		assert (container != null): "Dictionary input cannot be of NULL value!";

		this.informations.put("nome_e_sigla", container);
	}

	// Method responsble for reading available data.
	public void readIndicatives(BufferedReader br) throws IOException {
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
