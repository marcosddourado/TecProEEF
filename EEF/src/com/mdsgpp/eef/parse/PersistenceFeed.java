package com.mdsgpp.eef.parse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mdsgpp.eef.model.Feed;

import android.content.Context;

public class PersistenceFeed {

	private static final String FILENAME = "feed.txt";
	private static PersistenceFeed instance;
	private Context context;
	
	public PersistenceFeed(Context context) {
		assert(context != null) : "null context";
		this.context = context;
	}

	//Returns an initialized instance of PErsistenceFeed
	public static PersistenceFeed getInstance(Context context) {
		if (instance == null) {
			assert(context != null) : "null context";
			instance = new PersistenceFeed(context);
		} else {/*do nothing*/}
		return instance;
	}
	//Rewrites a feed.txt
	public void writeFeedFile(Feed feed) throws IOException, NullPointerException {
		assert(context != null) : "null context";
		FileOutputStream fileOut = this.context.openFileOutput(this.FILENAME, Context.MODE_PRIVATE);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);

		assert(out != null) : "Output cannot be null!";

		out.writeObject(feed);
		out.close();
	}

	//Reads JSON data file and returns a serialized object of the data.
	public Feed readFeedFile() throws IOException, ClassNotFoundException {
		Feed feed;
		FileInputStream fileIn = this.context.openFileInput(FILENAME);
		ObjectInputStream in = new ObjectInputStream(fileIn);

		feed = (Feed) in.readObject();
		in.close();
		
		return feed;
	}
}
