package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.Ideb;
import com.mdsgpp.eef.model.State;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;

public class StateTest {
    private State state;
    Random random = new Random();

    @Before
    public void setup() {
        this.state = new State();
    }

    @Test
    public void testEmptyDouble() {
        double empty[] = {0};

        assertThat(state.emptyDouble(), is(empty));
    }

    @Test
    public void testEmptyIdeb(){
        Ideb empty[] = {new Ideb(0.0, 0.0, 0.0)};

        assertThat(state.emptyIdeb(), is(empty));

    }

}
