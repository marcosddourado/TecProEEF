package com.mdsgpp.eef.controle;

import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.model.News;

public class FeedParseController {

	private Feed feed;
	private News item;
	private static FeedParseController instance;
	
	public FeedParseController() {
		this.feed = new Feed();
	}
	
	public static FeedParseController getInstance() {
		if (instance == null) {
			instance = new FeedParseController();
		}
		return instance;
	}

	public Feed getFeed() {
		return this.feed;
	}
	
	public void criaNovoFeed() {
		this.feed.reset();
	}
	
	public void criaNovoItem() {
		this.item = new News(this.feed);
	}
	
	public void adicionaItem() {
		this.feed.addFeedItem(this.item);
	}
	
	public News getItem() {
		return this.item;
	}
	
}
