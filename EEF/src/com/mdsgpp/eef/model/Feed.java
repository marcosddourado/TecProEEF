package com.mdsgpp.eef.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Feed implements Serializable {

	// Default serial id
	private static final long serialVersionUID = 1L;

	private ArrayList<News> feedItems;

	/**
	 * Initializes the feed object. Also initializes feedItems property.
	 *
	 * @return New feed object with feed data properties set.
	 */
	public Feed() {
		feedItems = new ArrayList<News>();
	}

	public ArrayList<News> getFeedItems() {
		return feedItems;
	}

	/**
	 * Returns item from feedItems array.
	 *
	 * @param  position The position from the array from which the value will be gotten.
	 * @return Item from feedItems array in position.
	 */
	public News getFeedItem(int position) {
		assert (position >= 0) : "position < 0. position was " + position;
		assert (feedItems.get(position) != null) : "null News object";
		assert (position < feedItems.size()) : "invalid position in array";
		return feedItems.get(position);
	}

	public void setFeedItems(ArrayList<News> feedItems) {
		assert(feedItems != null) : "null feedItems";
		this.feedItems = feedItems;
	}

	public void addFeedItem(News newFeedItem) {
		assert (newFeedItem != null) : "null newFeedItem";
		this.feedItems.add(newFeedItem);
	}

	public int getFeedItemsSize() {
		return feedItems.size();
	}

	public void reset() {
		this.feedItems.clear();
	}

}
