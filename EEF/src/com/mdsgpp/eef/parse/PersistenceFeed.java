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
		this.context = context;
	}

	public static PersistenceFeed getInstance(Context context) {
		if (instance == null) {
			instance = new PersistenceFeed(context);
		}
		return instance;
	}
	
	public void writeFeedFile(Feed feed) throws IOException {

		//Rewrites a data file.

		FileOutputStream fileout = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
		ObjectOutputStream out = new ObjectOutputStream(fileout);

		assert(out != null) : "Output cannot be null!";

		out.writeObject(feed);
		out.close();
	}

	public Feed readFeedFile() throws IOException, ClassNotFoundException {

		//Reads JSON data file and returns a serialized version of the data.

		Feed feed;


		FileInputStream filein = context.openFileInput(FILENAME);

		assert(filein != null) : "Fle handler cannot be null!";
		ObjectInputStream in = new ObjectInputStream(filein);

		assert(in != null) : "Object handler cannot be null!";

		feed = (Feed) in.readObject();
		in.close();

		assert (feed != null) : "Feed instance cannot be null!";

		return feed;
	}

}
