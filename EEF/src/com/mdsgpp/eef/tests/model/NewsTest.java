package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.News;
import com.mdsgpp.eef.model.Feed;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by andreanmasiro on 23/06/16.
 */
public class NewsTest {

    @Mock
    Feed feed = Mockito.mock(Feed.class);

    private News news;
    private Random rand = new Random();

    @Before
    public void setup() {
        news = new News(feed);
    }

    @Test
    public void testConstruction() {

        assertThat(news.getNewsFeed(), is(feed));
        assertThat(news.getNewsTitle(), is(nullValue()));
        assertThat(news.getNewsCategory(), is(nullValue()));
        assertThat(news.getNewsDescription(), is(nullValue()));
        assertThat(news.getNewsLink(), is(nullValue()));
        assertThat(news.getNewsDate(), is(nullValue()));
    }

    @Test
    public void testSetNewsDate() {

        String date = "Date";

        news.setNewsDate(date);
        assertThat(news.getNewsDate(), is(date));
    }

    @Test
    public void testSetNewsTitle() {
        String title = "Title";

        news.setNewsTitle(title);
        assertThat(news.getNewsTitle(), is(title));
    }

    @Test
    public void testSetNewsCategory() {
        String category = "Category";

        news.setNewsCategory(category);
        assertThat(news.getNewsCategory(), is(category));
    }

    @Test
    public void testSetNewsDescription() {
        String description = "Description";

        news.setNewsDescription(description);
        assertThat(news.getNewsDescription(), is(description));
    }

    @Test
    public void testSetNewsLink() {
        String link = "Link";

        news.setNewsLink(link);
        assertThat(news.getNewsLink(), is(link));
    }

    @Test (expected = AssertionError.class)
    public void testSetInvalidTitle() {

        news.setNewsTitle("");
        news.setNewsTitle(null);
    }

    @Test (expected = AssertionError.class)
    public void testSetInvalidCategory() {

        news.setNewsCategory("");
        news.setNewsCategory(null);
    }

    @Test (expected = AssertionError.class)
    public void testSetInvalidDescription() {

        news.setNewsDescription("");
        news.setNewsDescription(null);
    }

    @Test (expected = AssertionError.class)
    public void testSetInvalidLink() {

        news.setNewsLink("");
        news.setNewsLink(null);
    }

    @Test (expected = AssertionError.class)
    public void testSetInvalidDate() {

        news.setNewsDate("");
        news.setNewsDate(null);
    }
}
