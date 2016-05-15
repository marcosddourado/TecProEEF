package com.mdsgpp.eef.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Feed implements Serializable {
	// Default serial id
	private static final long serialVersionUID = 1L;

	private ArrayList<News> feedItens;

	public Feed() {
		feedItens = new ArrayList<News>();
	}

	public ArrayList<News> getFeedItens() {
		return feedItens;
	}

	public News getFeedItem(int position) {
		assert (position >= 0) : "position < 0. position was " + position;
		assert (feedItens.get(position) != null) : "null News object";
		return feedItens.get(position);
	}

	public void setFeedItens(ArrayList<News> feedItens) {
		assert(feedItens != null) : "null feedItens";
		this.feedItens = feedItens;
	}

	public void addFeedItem(News newFeedItem) {
		assert (newFeedItem != null) : "null newFeedItem";
		this.feedItens.add(newFeedItem);
	}

	public int getFeedItensSize() {
		return feedItens.size();
	}

	public void reset() {
		this.feedItens.clear();
	}

}
