package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.Ideb;
import com.mdsgpp.eef.model.State;

import org.junit.Before;
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
    double elementary;
    double highSchool;
    double initialGrades;

    @Before
    public void setup() {

        elementary = this.random.nextDouble() * 10;
        highSchool = this.random.nextDouble() * 10;
        initialGrades = this.random.nextDouble() * 10;

        ideb = new Ideb(elementary, highSchool, initialGrades);
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

        assertThat(ideb.getElementary(), is(elementary));
        assertThat(ideb.getHighSchool(), is(highSchool));
        assertThat(ideb.getInitialGrades(), is(initialGrades));

    }

    @Test (expected = AssertionError.class)
    public void testAcceptableYear() {

        ideb.setIdebYear(1800);
    }

    @Test
    public void testSetGrades() {

        double elementary = random.nextDouble() * 10;
        double highSchool = random.nextDouble() * 10;

        ideb.setElementary(elementary);
        ideb.setHighSchool(highSchool);

        assertThat(ideb.getElementary(), is(elementary));
        assertThat(ideb.getHighSchool(), is(highSchool));
    }
}
