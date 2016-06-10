package com.mdsgpp.eef.tests.model;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.mockito.Mock;
import com.mdsgpp.eef.model.Census;

import dalvik.annotation.TestTargetClass;


/**
 * Created by andreanmasiro on 06/06/16.
 */
public class CensusTest {

    @Before
    public void setup() {
    }

    @Test
    public void construct_with_parameters() {

        double initialElementaryYears = 3.5;
        double finalElementaryYears = 4.5;
        double highSchool = 8.6;
        double elementaryEJA = 2.9;
        double highSchoolEJA = 10.0;

        Census census = new Census(initialElementaryYears, finalElementaryYears, highSchool,
                elementaryEJA, highSchoolEJA);

        assertThat(census.getInitialElementaryYears(), is(initialElementaryYears));
        assertThat(census.getFinalElementaryYears(), is(finalElementaryYears));
        assertThat(census.getHighSchool(), is(highSchool));
        assertThat(census.getElementaryEJA(), is(elementaryEJA));
        assertThat(census.getHighSchoolEJA(), is(highSchoolEJA));
    }

    @Test
    public void construct() {
        Census census = new Census();

        assertThat(census.getInitialElementaryYears(), is(0.0));
        assertThat(census.getFinalElementaryYears(), is(0.0));
        assertThat(census.getHighSchool(), is(0.0));
        assertThat(census.getElementaryEJA(), is(0.0));
        assertThat(census.getHighSchoolEJA(), is(0.0));
    }


        
}
