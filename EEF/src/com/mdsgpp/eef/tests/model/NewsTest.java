package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.News;
import com.mdsgpp.eef.model.Feed;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
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
}
