package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.Project;
import com.mdsgpp.eef.model.State;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.theInstance;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by andreanmasiro on 23/06/16.
 */
public class ProjectTest {

    private Project project;
    private Random random = new Random();

    @Before
    public void setup() {
        project = new Project();
    }

    @Test
    public void testConstruction() {

        assertThat(project.getProjectQuantity(), is(0));
        assertThat(project.getProjectState(), is(nullValue()));
        assertThat(project.getProjectValue(), is(0.0));
        assertThat(project.getProjectYear(), is(0));
    }

    @Test (expected = AssertionError.class)
    public void testSetProjectQuantity() {
        int quantity = random.nextInt(1000);

        project.setProjectQuantity(quantity);
        assertThat(project.getProjectQuantity(), is(quantity));

        quantity = -20;
        project.setProjectQuantity(quantity);
    }

    @Test (expected = AssertionError.class)
    public void testSetState() {
        State state = new State();

        project.setState(state);
        assertThat(project.getProjectState(), is(state));

        project.setState(null);
    }

    @Test (expected = AssertionError.class)
    public void testSetProjectValue() {
        double value = random.nextDouble() * 100;

        project.setProjectValue(value);
        assertThat(project.getProjectValue(), is(value));

        value = -10.0;
        project.setProjectValue(value);
    }

    @Test (expected = AssertionError.class)
    public void testSetProjectYear() {
        int year = 1900 + random.nextInt(116);

        project.setProjectYear(year);
        assertThat(project.getProjectYear(), is(year));

        year = 1700;
        project.setProjectYear(year);
    }
}
