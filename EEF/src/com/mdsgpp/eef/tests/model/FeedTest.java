package com.mdsgpp.eef.tests.model;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.model.News;

import java.util.ArrayList;
import java.util.Random;

public class FeedTest {

    @Mock
    News news = Mockito.mock(News.class);

    private Feed feed;
    private Random rand = new Random();

    @Before
    public void setup() {
        this.feed = new Feed();
    }

    @Test
    public void construct() {

        assertThat(this.feed.getFeedItems(), is(notNullValue()));
    }

    @Test
    public void get_feed_item_returns_correctly() {

        this.setupFeedItems(this.rand.nextInt(10));

        ArrayList<News> feedItems = this.feed.getFeedItems();

        int index = this.rand.nextInt(feedItems.size());

        News news = this.feed.getFeedItem(index);
        assertThat(news, is(feedItems.get(index)));
    }

    @Test (expected = AssertionError.class)
    public void get_feed_item_negative_index() {

        this.setupFeedItems(this.rand.nextInt(10));

        News news = this.feed.getFeedItem(-1);
    }

    @Test (expected = AssertionError.class)
    public void get_feed_item_out_of_boudaries_index() {

        this.setupFeedItems(this.rand.nextInt(10));

        int feedItemsSize = this.feed.getFeedItemsSize();

        News news = this.feed.getFeedItem(feedItemsSize);
    }

    private void setupFeedItems(int count) {

        for (int i = 0; i < count ; i++) {
            this.feed.addFeedItem(new News(this.feed));
        }
    }
}
