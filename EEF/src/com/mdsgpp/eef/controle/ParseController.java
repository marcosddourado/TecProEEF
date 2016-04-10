package com.mdsgpp.eef.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;

import com.mdsgpp.eef.parse.DadosParse;

public class ParseController {

	private static ParseController instancia;
	DadosParse parser;

	public ParseController(Context context) {
		parser = new DadosParse(context);
	}

	public static ParseController getInstancia(Context context) {
		if (instancia == null) instancia = new ParseController(context);
		return instancia;
	}
	
	public HashMap<String, ArrayList<String[]>> getInformacoes(int posicao) throws IOException {
		return parser.getEstado(posicao);
	}
	
}
