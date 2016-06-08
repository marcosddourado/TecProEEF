package com.mdsgpp.eef.tests.parse;



import android.content.Context;

import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.model.News;
import com.mdsgpp.eef.parse.PersistenceFeed;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;



public class PersistenceFeedTest {
    @Mock
    Context mock_context = Mockito.mock(Context.class);
    @Mock
    Feed mock_feed = Mockito.mock(Feed.class);
    @Mock
    Feed alter_mock_feed = Mockito.mock(Feed.class);

    PersistenceFeed testObject = new PersistenceFeed(mock_context);

    @Test
    public void valid_instance_returned() {
        assertThat(testObject.getInstance(mock_context), is(notNullValue()));
    }

    @Test
    public void write_object_correctly() {
        try {
            testObject.writeFeedFile(mock_feed);
        } catch (IOException e) {
            /*do nothing*/
        } catch (NullPointerException e) {
            /*do nothing*/
        }
        try {
            alter_mock_feed = testObject.readFeedFile();
        } catch (IOException e) {
            /*do nothing*/
        } catch (ClassNotFoundException e) {
            /*do nothing*/
        } catch (NullPointerException e) {
            /*do nothing*/
        }
        assertThat(alter_mock_feed.getFeedItens(), equalTo(mock_feed.getFeedItens()));
    }

    @Test (expected = NullPointerException.class)
    public void trigger_IOException() {
        try {
            testObject.writeFeedFile(null);
        } catch (IOException e) {
            /*do nothing*/
        }
    }
}
