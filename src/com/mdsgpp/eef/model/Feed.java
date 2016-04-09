package com.mdsgpp.eef.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Feed implements Serializable {
	// Default serial id
	private static final long serialVersionUID = 1L;

	private ArrayList<Noticias> feedItens;

	public Feed() {
		feedItens = new ArrayList<Noticias>();
	}

	public ArrayList<Noticias> getFeedItens() {
		return feedItens;
	}

	public Noticias getFeedItem(int position) {
		return feedItens.get(position);
	}

	public void setFeedItens(ArrayList<Noticias> feedItens) {
		this.feedItens = feedItens;
	}

	public void addFeedItem(Noticias newFeedItem) {
		this.feedItens.add(newFeedItem);
	}

	public int getFeedItensSize() {
		return feedItens.size();
	}

	public void reset() {
		this.feedItens.clear();
	}

}
