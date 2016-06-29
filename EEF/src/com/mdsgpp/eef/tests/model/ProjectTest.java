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

    @Test
    public void testSetProjectProperties() {

        int quantity = random.nextInt(1000);
        State state = new State();
        double value = random.nextDouble() * 100;
        int year = 1900 + random.nextInt(116);

        project.setProjectQuantity(quantity);
        project.setState(state);
        project.setProjectValue(value);
        project.setProjectYear(year);

        assertThat(project.getProjectQuantity(), is(quantity));
        assertThat(project.getProjectState(), is(state));
        assertThat(project.getProjectValue(), is(value));
        assertThat(project.getProjectYear(), is(year));

    }

    @Test (expected = AssertionError.class)
    public void testSetInvalidProjectProperties() {

        project.setProjectQuantity(-20);
        project.setState(null);
        project.setProjectValue(-10.0);
        project.setProjectYear(1700);
    }
}
