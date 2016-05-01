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

	private HashMap<String, ArrayList<String[]>> informations;
	private ArrayList<String[]> data;
	private Context context;
	private String extension = ".txt";
	private String indicatorName;
	private int lines = 2;

	String states[][] = { { "Acre", "Acre" }, { "Alagoas", "Alagoas" },
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
		this.context = context;
		this.informations = new HashMap<String, ArrayList<String[]>>();
	}

	public HashMap<String, ArrayList<String[]>> getState(int position) throws IOException {
		String name, acronym;

		AssetManager am = this.context.getAssets();
		InputStream is = am.open(this.states[position][1] + this.extension);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

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

	// Metodo resposavel por mandar o nome e a sigla atraves do mesmo hashmap ds indicativos
	public void insertAcronymName(String name, String acronym) {
		ArrayList<String[]> container = new ArrayList<String[]>();
		String nameAndAcronym[] = new String[2];
		nameAndAcronym[0] = name;
		nameAndAcronym[1] = acronym;
		
		container.add(nameAndAcronym);
		this.informations.put("nome_e_sigla", container);
	}
	
	// Metodo responsavel pela leitura dos dados disponiveis
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
