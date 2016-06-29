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
	private static PersistenceFeed instance = null;
	private Context context = null;

	/**
	 * Class's constructor
	 * @param context
     */
	public PersistenceFeed(Context context) {
		assert(context != null) : "null context";
		this.context = context;
	}

	/**
	 * Return constructed instance of PersistenceFeed
	 * @param context
	 * @return
     */
	public static PersistenceFeed getInstance(Context context) {
		if (instance == null) {
			//Construct class if it wasn't already
			instance = new PersistenceFeed(context);
		} else {/*do nothing*/}
		return instance;
	}

	/**
	 *Write feed file. Overwrite it if it already exists
	 * @param feed
	 * @throws IOException
	 * @throws NullPointerException
     */
	public void writeFeedFile(Feed feed) throws IOException, NullPointerException {
		assert(context != null) : "null context";
		//Opening file
		FileOutputStream fileOut = this.context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);

		out.writeObject(feed);
		out.close();
	}

	/**
	 * Return Feed object read from file
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
     */
	public Feed readFeedFile() throws IOException, ClassNotFoundException {
		Feed feed;

		//Opening file
		FileInputStream fileIn = this.context.openFileInput(FILENAME);
		ObjectInputStream in = new ObjectInputStream(fileIn);

		//Filling object with read data
		feed = (Feed) in.readObject();
		in.close();
		
		return feed;
	}

}
