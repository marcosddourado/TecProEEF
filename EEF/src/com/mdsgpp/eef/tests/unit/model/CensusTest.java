package com.mdsgpp.eef.tests.unit.model;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import com.mdsgpp.eef.model.Census;

import java.util.Random;

public class CensusTest {

    private Census census;
    Random random = new Random();

    @Before
    public void setup() {
        double initialElementaryYears = this.random.nextDouble() * 10;
        double finalElementaryYears = this.random.nextDouble() * 10;
        double highSchool = this.random.nextDouble() * 10;
        double elementaryEJA = this.random.nextDouble() * 10;
        double highSchoolEJA = this.random.nextDouble() * 10;

        this.census = new Census(initialElementaryYears, finalElementaryYears, highSchool,
                elementaryEJA, highSchoolEJA);
    }

    @Test
    public void construct_with_parameters() {

        double initialElementaryYears = this.random.nextDouble() * 10;
        double finalElementaryYears = this.random.nextDouble() * 10;
        double highSchool = this.random.nextDouble() * 10;
        double elementaryEJA = this.random.nextDouble() * 10;
        double highSchoolEJA = this.random.nextDouble() * 10;

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

    @Test
    public void set_final_elementary_years_test() {

        double finalElementaryYears = census.getFinalElementaryYears();
        assertThat(finalElementaryYears, is(census.getFinalElementaryYears()));

        finalElementaryYears = this.random.nextDouble() * 10;
        census.setFinalElementaryYears(finalElementaryYears);

        assertThat(finalElementaryYears, is(census.getFinalElementaryYears()));
    }
        
}
