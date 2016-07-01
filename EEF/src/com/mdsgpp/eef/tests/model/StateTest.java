package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.Census;
import com.mdsgpp.eef.model.Grade;
import com.mdsgpp.eef.model.Ideb;
import com.mdsgpp.eef.model.Project;
import com.mdsgpp.eef.model.State;

import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


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
        final int UNIQUE_POSITION = 0;
        Ideb emptyIdebTest[] = {new Ideb(0.0, 0.0, 0.0)};
        Ideb stateIdebTest[] = state.emptyIdeb();

        //Testing the values for all the Ideb's attributes

        //Testing elementary values
        double elementaryTest = emptyIdebTest[UNIQUE_POSITION].getElementary();
        double elementaryState = stateIdebTest[UNIQUE_POSITION].getElementary();

        assertThat(elementaryTest, is(elementaryState));

        //Testing high school values
        double highSchoolTest = emptyIdebTest[UNIQUE_POSITION].getHighSchool();
        double highSchoolState = stateIdebTest[UNIQUE_POSITION].getHighSchool();

        assertThat(highSchoolTest, is(highSchoolState));

        //Testing high school values
        double initialGradesTest = emptyIdebTest[UNIQUE_POSITION].getInitialGrades();
        double initialGradesState = stateIdebTest[UNIQUE_POSITION].getInitialGrades();

        assertThat(initialGradesTest, is(initialGradesState));

    }

    @Test
    public void construct_with_valid_params() {
        State test_state = new State();

        assertThat(test_state.getStateName(), is(""));
        assertThat(test_state.getStateAbbreviation(), is(""));
        assertThat(test_state.getPercentageCollaborationWithPIB().length, is(0));
        assertThat(test_state.getStatePopulation(), is(0));
        assertThat(test_state.getCensus().length, is(0));
        assertThat(test_state.getIdebs().length, is(0));
        assertThat(test_state.getStudentGradesPerClass().length, is(0));
        assertThat(test_state.getGradeClassHours().length, is(0));
        assertThat(test_state.getScienceAndThecnologyProjects().length, is(0));
        assertThat(test_state.getPrimeirosProjetos().length, is(0));
        assertThat(test_state.getProjectsInct().length, is(0));
        assertThat(test_state.getApoioCnpqProject().length, is(0));
        assertThat(test_state.getJovensPesquisadoresProject().length, is(0));
        assertThat(test_state.getAgeGradeDistortionRate().length, is(0));
        assertThat(test_state.getEducationalAchievementRate().length, is(0));
        assertThat(test_state.getSchoolDropoutRate().length, is(0));
    }

    @Test
    public void getCensus_returnNonNullValue() {
        assertThat(state.getCensus(), is(notNullValue()));
    }

    @Test
    public void getPercentageCollaborationWithPIB_returnNonNullValue() {
        assertThat(state.getPercentageCollaborationWithPIB(), is(notNullValue()));
    }

    @Test
    public void geIdebs_returnNonNullValue() {
        assertThat(state.getIdebs(), is(notNullValue()));
    }

    @Test
    public void getStudentGradesPerClass_returnNonNullValue() {
        assertThat(state.getStudentGradesPerClass(), is(notNullValue()));
    }

    @Test
    public void getGradeClassHours_returnNonNullValue() {
        assertThat(state.getGradeClassHours(), is(notNullValue()));
    }

    @Test
    public void getAgeGradeDistortionRate_returnNonNullValue() {
        assertThat(state.getAgeGradeDistortionRate(), is(notNullValue()));
    }

    @Test
    public void getStateName_returnNonNullValue() {
        assertThat(state.getStateName(), is(notNullValue()));
    }

    @Test
    public void getStateAbbreviation_returnNonNullValue() {
        assertThat(state.getStateAbbreviation(), is(notNullValue()));
    }

    @Test
    public void testEmptyCensus() {
        final int UNIQUE_POSITION = 0;
        Census emptyCensusTest[] = {new Census(0.0, 0.0, 0.0, 0.0, 0.0)};
        Census emptyCensusState[] = state.emptyCensus();

        //Testing the values for all the Census's attributes

        //Testing the values for the initial elementary years
        double initialElementaryYearsTest = emptyCensusTest[UNIQUE_POSITION].getInitialElementaryYears();
        double initialElementaryYearsState = emptyCensusState[UNIQUE_POSITION].getInitialElementaryYears();

        assertThat(initialElementaryYearsTest, is(initialElementaryYearsState));

        //Testing the values for the final elementary years
        double finalElementaryYearsTest = emptyCensusTest[UNIQUE_POSITION].getFinalElementaryYears();
        double finalElementaryYearsState = emptyCensusState[UNIQUE_POSITION].getFinalElementaryYears();

        assertThat(finalElementaryYearsTest, is(finalElementaryYearsState));

        //Testing the values for high school
        double highSchoolTest = emptyCensusTest[UNIQUE_POSITION].getHighSchool();
        double highSchoolState = emptyCensusState[UNIQUE_POSITION].getHighSchool();

        assertThat(highSchoolTest, is(highSchoolState));

        //Testing the values for EJA's high school
        double highSchoolEJATest = emptyCensusTest[UNIQUE_POSITION].getHighSchoolEJA();
        double highSchoolEJAState = emptyCensusState[UNIQUE_POSITION].getHighSchoolEJA();

        assertThat(highSchoolEJATest, is(highSchoolEJAState));
    }

    @Test
    public void testEmptyProject() {
        final int UNIQUE_POSITION = 0;
        final int ACCEPTABLE_YEAR = 1900;

        Project emptyProjectTest[] = {new Project()};
        emptyProjectTest[UNIQUE_POSITION].setProjectQuantity(0);
        emptyProjectTest[UNIQUE_POSITION].setProjectValue(0);
        emptyProjectTest[UNIQUE_POSITION].setProjectYear(ACCEPTABLE_YEAR);

        Project emptyProjectState[] = state.emptyProject();

        //Testing the values for all the Project's attributes

        //Testing the values for the project's quantity attribute
        double quantityTest = emptyProjectTest[UNIQUE_POSITION].getProjectQuantity();
        double quantityState = emptyProjectState[UNIQUE_POSITION].getProjectQuantity();

        assertThat(quantityTest, is(quantityState));

        //Testing the values for the project's value attribute
        double valueTest = emptyProjectTest[UNIQUE_POSITION].getProjectValue();
        double valueState = emptyProjectState[UNIQUE_POSITION].getProjectValue();

        assertThat(valueTest, is(valueState));

        //Testing the values for the project's year attribute
        double yearTest = emptyProjectTest[UNIQUE_POSITION].getProjectYear();
        double yearState = emptyProjectState[UNIQUE_POSITION].getProjectYear();

        assertThat(yearTest, is(yearState));
    }

    @Test
    public void testEmptyGrade() {
        final int UNIQUE_POSITION = 0;

        Grade emptyGradeTest[] = {new Grade(0,0)};

        Grade emptyGradeState[] = state.emptyGrade();

        //Testing the values for all the Project's attributes

        //Testing the values for the project's elementary attribute
        double elementaryTest = emptyGradeTest[UNIQUE_POSITION].getElementaryGrade();
        double elementaryState = emptyGradeState[UNIQUE_POSITION].getElementaryGrade();

        assertThat(elementaryTest, is(elementaryState));

        //Testing the values for the project's high school attribute
        double highSchoolTest = emptyGradeTest[UNIQUE_POSITION].getHighSchoolGrade();
        double highSchoolState = emptyGradeState[UNIQUE_POSITION].getHighSchoolGrade();

        assertThat(highSchoolTest, is(highSchoolState));
    }
}
