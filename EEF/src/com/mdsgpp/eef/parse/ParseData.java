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
	private final String extension = ".txt";
	private String indicatorName;
	private final int lines = 2;

	private final String states[][] = { { "Acre", "Acre" }, { "Alagoas", "Alagoas" },
			{ "Amape", "Amapa" }, { "Amazonas", "Amazonas" },
			{ "Bahia", "Bahia" }, { "Ceare", "Ceara" },
			{ "Distrito Federal", "Distrito Federal" },
			{ "Esperito Santo", "Espirito Santo" }, { "Goies", "Goias" },
			{ "Maranheo", "Maranhao" }, { "Mato Grosso", "Mato Grosso" },
			{ "Mato Grosso do Sul", "Mato Grosso do Sul" },
			{ "Minas Gerais", "Minas Gerais" }, { "Pare", "Para" },
			{ "Paraeba", "Paraiba" }, { "Parane", "Parana" },
			{ "Pernambuco", "Pernambuco" }, { "Piaue", "Piaui" },
			{ "Rio de Janeiro", "Rio de Janeiro" },
			{ "Rio Grande do Norte", "Rio Grande do Norte" },
			{ "Rio Grande do Sul", "Rio Grande do Sul" },
			{ "Rondenia", "Rondonia" }, { "Roraima", "Roraima" },
			{ "Santa Catarina", "Santa Catarina" },
			{ "Seo Paulo", "Sao Paulo" }, { "Sergipe", "Sergipe" },
			{ "Tocantins", "Tocantins" } };

	public ParseData(Context context) {
		assert(context != null) : "null context passed on constructor";
		this.context = context;
		this.informations = new HashMap<String, ArrayList<String[]>>();
	}

	public HashMap<String, ArrayList<String[]>> getState(int position) throws IOException {
		String name, acronym;

		AssetManager am = this.context.getAssets();
		InputStream is = am.open(this.states[position][1] + this.extension);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		assert (br != null) : "buffer cannot reference NULL";

		name = br.readLine();
		name = this.states[position][0];
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
		String nameAndAcronym[] = new String[2];
		nameAndAcronym[0] = name;
		nameAndAcronym[1] = acronym;

		container.add(nameAndAcronym);

		assert (container != null): "Dictionary inout cannot be of NULL value!";

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

			if (aux == lines) {
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
