package com.mdsgpp.eef.controller;

import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.model.News;

public class FeedParseController {

	private Feed feed = null;
	private News item = null;
	private static FeedParseController instance = null;
	
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
	
	public void createNewFeed() {
		this.feed.reset();
	}
	
	public void createNewFeedItem() {
		this.item = new News(this.feed);
	}
	
	public void addItem() {
		this.feed.addFeedItem(this.item);
	}
	
	public News getItem() {
		return this.item;
	}
	
}
