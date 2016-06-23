package com.mdsgpp.eef.model;

import java.io.Serializable;

public class News implements Serializable {

	private static final long serialVersionUID = 1L;
	private String newsTitle;
	private String newsCategory;
	private String newsDescription;
	private String newsLink;
	private String newsDate;
	private Feed newsFeed;

	/**
	 * Initializes the news object. Also initializes newsFeed property.
	 *
	 * @param  newsFeed newsFeed property.
	 * @return New news object with newsFeed property set.
	 */
	public News(Feed newsFeed) {
		assert (newsFeed != null) : "null newsFeed";
		this.newsFeed 		 = newsFeed;
		this.newsTitle 	 	 = null;
		this.newsCategory 	 = null;
		this.newsDescription = null;
		this.newsLink		 = null;
		this.newsDate		 = null;

	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		assert (newsTitle != null) : "null newsTitle";
		assert (newsTitle != "") : "empty newsTitle";
		this.newsTitle = newsTitle;
	}

	public String getNewsCategory() {
		return newsCategory;
	}

	public void setNewsCategory(String newsCategory) {
		assert (newsCategory != null) : "null newsCategory";
		assert (newsCategory != "") : "empty newsCategory";
		this.newsCategory = newsCategory;
	}

	public String getNewsDescription() {
		return newsDescription;
	}

	public void setNewsDescription(String newsDescription) {
		assert (newsDescription != null) : "null newsDescription";
		assert (newsDescription != "") : "empty newsDescription";
		this.newsDescription = newsDescription;
	}

	public String getNewsLink() {
		return newsLink;
	}

	public void setNewsLink(String newsLink) {
		assert (newsLink != null) : "null newsLink";
		assert (newsLink != "") : "empty newsLink";
		this.newsLink = newsLink;
	}

	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
		assert (newsDate != null) : "null newsDate";
		assert (newsDate != "") : "empty newsDate";
		this.newsDate = newsDate;
	}

	public Feed getNewsFeed() {
		return this.newsFeed;
	}

}
