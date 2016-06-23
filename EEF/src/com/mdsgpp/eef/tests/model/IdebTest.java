package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.Ideb;
import com.mdsgpp.eef.model.State;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by andreanmasiro on 23/06/16.
 */
public class IdebTest {

    private Ideb ideb;
    Random random = new Random();

    public void setUp() {

    }

    @Test
    public void testConstruction() {

        ideb = new Ideb();

        assertThat(ideb.getElementary(), is(0.0));
        assertThat(ideb.getHighSchool(), is(0.0));
        assertThat(ideb.getInitialGrades(), is(0.0));
        assertThat(ideb.getIdebYear(), is(0));
        assertThat(ideb.getState(), is(nullValue()));
    }

    @Test
    public void testConstructionWithParameters() {
    }

    @Test (expected = AssertionError.class)
    public void testAcceptableYear() {;
    }

    @Test
    public void testGrades() {
    }
}
