package com.mdsgpp.eef.tests.parse;

import android.content.Context;

import com.mdsgpp.eef.parse.ParseData;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class ParseDataTest {
    private final int ACRE_POSITION = 0;
    private ParseData test_object;

    @Mock
    Context mock_context = Mockito.mock(Context.class);

    @Test
    public void constructor_construct_with_valid_parameter() {
        this.test_object = new ParseData(mock_context);

        assertThat(test_object, is(notNullValue()));
    }

    @Test (expected = AssertionError.class)
    public void construct_does_not_construct_with_invalid_parameter() {
        ParseData test_object = new ParseData(null);
    }

//    @Test
    public void getState_return_non_null_data_with_valid_parameters() {
        try {
            assertThat(test_object.getState(ACRE_POSITION), is(notNullValue()));
        } catch (IOException e) {
            System.out.println("test failed");
        }
    }

//    @Test
//    public void readIndicatives_parse_correctly() {
//
//    }


}
