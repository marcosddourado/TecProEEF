package com.mdsgpp.eef.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;

import com.mdsgpp.eef.parse.ParseData;

public class ParseController {

	private static ParseController instance;
	ParseData parser;

	public ParseController(Context context) {
		parser = new ParseData(context);
	}

	public static ParseController getInstance(Context context) {
		if (instance == null) instance = new ParseController(context);
		return instance;
	}
	
	public HashMap<String, ArrayList<String[]>> getInformations(int position) throws IOException {
		return parser.getState(position);
	}
	
}
