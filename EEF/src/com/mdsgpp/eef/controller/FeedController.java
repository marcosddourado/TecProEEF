package com.mdsgpp.eef.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.parse.ParserFeed;
import com.mdsgpp.eef.parse.PersistenceFeed;
import com.mdsgpp.eef.views.DataReceiver;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class FeedController extends AsyncTask<String, Void, Feed> {

	private Context context = null;
	private boolean updated = false;
	private DataReceiver dataReceiver = null;
	private ProgressDialog progressBar = null;

	public FeedController(Context context, DataReceiver dataReceiver) {
		this.dataReceiver = dataReceiver;
		this.context = context;
	}

	@Override
	protected void onPreExecute() {
		progressBar = new ProgressDialog(context, R.style.CustomProgressBar);
		progressBar.setIndeterminate(true);
		progressBar.setMessage("Carregando Noticias!");
		progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressBar.show();
		super.onPreExecute();
	}

	protected Feed doInBackground(String... urls) {
		Feed feed = null;

		try {
			URL url = new URL(urls[0]);
			ParserFeed handler = new ParserFeed();
			InputStream is = url.openStream();
			feed = handler.parse(is);

			PersistenceFeed.getInstance(this.context).writeFeedFile(feed);
			this.updated = true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			feed = PersistenceFeed.getInstance(this.context).readFeedFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return feed;
	}

	protected void onPostExecute(Feed feed) {

		if (progressBar != null) {
			progressBar.dismiss();
		}

		if (!this.updated) {
			Toast.makeText(this.context, "Não foi possivel atualizar as noticias! :(",
					Toast.LENGTH_LONG).show();
		}

		if (dataReceiver != null) {
			this.dataReceiver.receiveFeed(feed);
		}
	}
}