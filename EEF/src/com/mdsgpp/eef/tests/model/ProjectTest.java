package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.Project;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
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
}
