package com.mdsgpp.eef.tests.model;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.mockito.Mock;
import com.mdsgpp.eef.model.Feed;

import java.util.Random;
import dalvik.annotation.TestTargetClass;

/**
 * Created by andreanmasiro on 09/06/16.
 */
public class FeedTest {

    private Feed feed;

    @Test
    public void construct() {
        this.feed = new Feed();

        assertThat(this.feed.getFeedItems(), is(notNullValue()));
    }
}
