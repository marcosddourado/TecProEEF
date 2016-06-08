package com.mdsgpp.eef.tests.parse;



import android.content.Context;
import com.mdsgpp.eef.parse.PersistenceFeed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;



public class PersistenceFeedTest {
    @Mock
    Context mock_context = Mockito.mock(Context.class);

    PersistenceFeed testObject = new PersistenceFeed(mock_context);

    @Test
    public void valid_instance_returned() {
        assertThat(testObject.getInstance(mock_context), is(notNullValue()));
    }

}
