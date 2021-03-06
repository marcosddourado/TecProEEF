package com.mdsgpp.eef.parse;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.mdsgpp.eef.controller.FeedParseController;
import com.mdsgpp.eef.model.Feed;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;

public class ParserFeed extends DefaultHandler {

	public Feed parse(InputStream is) {

		// Declaration of each element tag that we want to treat
		RootElement root = new RootElement("rss");

		assert (root != null): "Root element must have a valid instance! Referenced object is null.";

		Element chanElement = root.getChild("channel");

		Element chanItem = chanElement.getChild("item");
		Element itemTitle = chanItem.getChild("title");
		Element itemDescription = chanItem.getChild("description");
		Element itemCategory = chanItem.getChild("category");
		Element itemPubDate = chanItem.getChild("pubDate");
		Element itemLink = chanItem.getChild("link");

		/*
		 * To every tag, we define the desired action to be performed, for
		 * example: When the 'channel' element is opened
		 */
		chanElement.setStartElementListener(new StartElementListener() {
			public void start(Attributes attributes) {
				FeedParseController.getInstance().createNewFeed();
			}
		});

		// when the 'item' element is opened
		chanItem.setStartElementListener(new StartElementListener() {
			public void start(Attributes attributes) {
				FeedParseController.getInstance().createNewFeedItem();
			}
		});

		// When the 'item' element is closed
		chanItem.setEndElementListener(new EndElementListener() {
			public void end() {
				FeedParseController.getInstance().addItem();
			}
		});

		// When the 'title' element (inside 'item') is closed, we can get the
		// text
		itemTitle.setEndTextElementListener(new EndTextElementListener() {
			public void end(String body) {
				FeedParseController.getInstance().getItem().setNewsTitle(body);
			}
		});

		itemDescription.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				FeedParseController.getInstance().getItem().setNewsDescription(body);
			}
		});

		itemCategory.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				FeedParseController.getInstance().getItem().setNewsCategory(body);
			}
		});

		itemPubDate.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				FeedParseController.getInstance().getItem().setNewsDate(body);
			}
		});

		itemLink.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				FeedParseController.getInstance().getItem().setNewsLink(body);
			}
		});

		// Finally, we parse the xml file (through the InputStream) and return
		// it
		try {
			Xml.parse(is, Xml.Encoding.UTF_8, root.getContentHandler());
			return FeedParseController.getInstance().getFeed();
		} catch (SAXException e) {
			// XML conversion error
		} catch (IOException e) {
			// file opening error
		}

		return null;
	}
}
