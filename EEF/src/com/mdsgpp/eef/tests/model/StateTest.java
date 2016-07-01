package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.Census;
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
    public void testEmptyIdeb() {
        final int UNIC_POSITION = 0;
        Ideb emptyIdebTest[] = {new Ideb(0.0, 0.0, 0.0)};
        Ideb stateIdebTest[] = state.emptyIdeb();

        //Testing the values for all the Ideb's attributes

        //Testing elementary values
        double elementaryTest = emptyIdebTest[UNIC_POSITION].getElementary();
        double elementaryState = stateIdebTest[UNIC_POSITION].getElementary();

        assertThat(elementaryTest, is(elementaryState));

        //Testing high school values
        double highSchoolTest = emptyIdebTest[UNIC_POSITION].getHighSchool();
        double highSchoolState = stateIdebTest[UNIC_POSITION].getHighSchool();

        assertThat(highSchoolTest, is(highSchoolState));

        //Testing high school values
        double initialGradesTest = emptyIdebTest[UNIC_POSITION].getInitialGrades();
        double initialGradesState = stateIdebTest[UNIC_POSITION].getInitialGrades();

        assertThat(initialGradesTest, is(initialGradesState));

    }

    @Test
    public void testEmptyCensus() {
        final int UNIC_POSITION = 0;
        Census emptyCensusTest[] = {new Census(0.0, 0.0, 0.0, 0.0, 0.0)};
        Census emptyCensusState[] = state.emptyCensus();

        //Testing the values for all the Census's attributes

        //Testing the values for the initial elementary years
        double initialElementaryYearsTest = emptyCensusTest[UNIC_POSITION].getInitialElementaryYears();
        double initialElementaryYearsState = emptyCensusState[UNIC_POSITION].getInitialElementaryYears();

        assertThat(initialElementaryYearsTest, is(initialElementaryYearsState));

        //Testing the values for the final elementary years
        double finalElementaryYearsTest = emptyCensusTest[UNIC_POSITION].getFinalElementaryYears();
        double finalElementaryYearsState = emptyCensusState[UNIC_POSITION].getFinalElementaryYears();

        assertThat(finalElementaryYearsTest, is(finalElementaryYearsState));

        //Testing the values for high school
        double highSchoolTest = emptyCensusTest[UNIC_POSITION].getHighSchool();
        double highSchoolState = emptyCensusState[UNIC_POSITION].getHighSchool();

        assertThat(highSchoolTest, is(highSchoolState));

        //Testing the values for EJA's high school
        double highSchoolEJATest = emptyCensusTest[UNIC_POSITION].getHighSchoolEJA();
        double highSchoolEJAState = emptyCensusState[UNIC_POSITION].getHighSchoolEJA();

        assertThat(highSchoolEJATest, is(highSchoolEJAState));
    }

}
