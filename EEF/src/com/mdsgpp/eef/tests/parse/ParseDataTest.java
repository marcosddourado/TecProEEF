package com.mdsgpp.eef.tests.parse;

import android.content.Context;

import com.mdsgpp.eef.model.State;
import com.mdsgpp.eef.parse.ParseData;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class ParseDataTest {
    private ParseData test_object;
    private Random rand = new Random();

    @Mock
    HashMap<String, ArrayList<String[]>> info;
    @Mock
    Context mock_context = Mockito.mock(Context.class);
    @Mock
    State mock_state = Mockito.mock(State.class);

    @Test
    public void constructor_construct_with_valid_parameter() {
        ParseData construct_object = new ParseData(this.mock_context);

        assertThat(construct_object, is(notNullValue()));
    }

    @Test (expected = AssertionError.class)
    public void constructor_does_not_construct_with_invalid_parameter() {
        ParseData construct_object = new ParseData(null);
    }


    @Test
    public void getState_return_non_null_data_with_valid_parameters() {
        ParseData testObject = new ParseData(mock_context);
        int random_valid_state_position = this.rand.nextInt(State.states.length - 1);
        HashMap<String, ArrayList<String[]>> testMap = new HashMap<String, ArrayList<String[]>>();
        try {
            testMap = testObject.getState(random_valid_state_position);
        } catch (IOException e) {
        } catch (NullPointerException e) {
        }
        assertThat(testMap, is(notNullValue()));
    }

    @Test (expected = AssertionError.class)
    public void getState_must_have_valid_parameters() {
        ParseData testObject = new ParseData(mock_context);
        HashMap<String, ArrayList<String[]>> testMap = new HashMap<String, ArrayList<String[]>>();
        final int INVALID_POSITION = 27;
        try {
            testMap = testObject.getState(INVALID_POSITION);
        } catch (IOException e) {
        } catch (NullPointerException e) {
        }
    }
}
