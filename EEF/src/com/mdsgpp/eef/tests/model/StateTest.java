package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.State;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by miknery on 30/06/16.
 */
public class StateTest {

    /**
     *
     */
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

}
