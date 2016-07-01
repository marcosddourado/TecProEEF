package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.State;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by miknery on 30/06/16.
 */
public class StateTest {

    @Test
    public void construct_with_valid_params() {
        HashMap<String, ArrayList<String[]>> test_map = new HashMap<String, ArrayList<String[]>>();
        String test_name = "test_name";
        String test_abbreviation = "TA";

        State test_state = new State(test_name, test_abbreviation, test_map);

        assertThat(test_name, is(test_state.getStateName()));
        assertThat(test_abbreviation, is(test_state.getStateAbbreviation()));
    }

}
