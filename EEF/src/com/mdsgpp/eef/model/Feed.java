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
	 * @param  position The index from which the value will be gotten.
	 * @return 			Item from feedItems array at the given index.
	 */
	public News getFeedItem(final int position) {
		assert (position >= 0) : "position < 0. position was " + position;
		assert (position < feedItems.size()) : "invalid position in array. position was " + position;
		return feedItems.get(position);
	}

	public void setFeedItems(ArrayList<News> feedItems) {
		assert(feedItems != null) : "null feedItems";
		this.feedItems = feedItems;
	}

	/**
	 * Appends a new item to the feedItems array.
	 *
	 * @param  newFeedItem The item to be added.
	 */
	public void addFeedItem(News newFeedItem) {
		assert (newFeedItem != null) : "null newFeedItem";
		this.feedItems.add(newFeedItem);
	}

	public int getFeedItemsSize() {
		return feedItems.size();
	}

	/**
	 * Removes all objects from the feedItems array.
	 */
	public void reset() {
		this.feedItems.clear();
	}

}
