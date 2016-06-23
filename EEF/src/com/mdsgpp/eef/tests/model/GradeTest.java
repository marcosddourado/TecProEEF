package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.Grade;
import com.mdsgpp.eef.model.State;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by AndreBedran on 6/12/16.
 */
public class GradeTest {

    private Grade grade;
    Random random = new Random();

    public void setUp() {
        double elementaryGrade = this.random.nextDouble() * 10 ;
        double highSchoolGrade = this.random.nextDouble() * 10;
        int gradeYear = this.random.nextInt() * 10;
    }

    @Test
    public void testConstruction() {

        Grade grade = new Grade();

        assertThat(grade.getElementaryGrade(), is(0.0));
        assertThat(grade.getGradeYear(), is(0));
        assertThat(grade.getHighSchoolGrade(), is(0.0));
        assertThat(grade.getState(), is(nullValue()));
    }

    @Test
    public void testConstructionWithParameters() {

        double elementaryGrade = this.random.nextDouble() * 10;
        double highSchoolGrade = this.random.nextDouble() * 10;

        Grade grade = new Grade(elementaryGrade, highSchoolGrade);

        assertThat(grade.getElementaryGrade(), is(elementaryGrade));
        assertThat(grade.getHighSchoolGrade(), is(highSchoolGrade));

    }

    @Test (expected = AssertionError.class)
    public void testAcceptableYear() {

        Grade grade = new Grade();

        grade.setGradeYear(1800);

        final int gradeYear = grade.getGradeYear();
    }

    @Test
    public void testGrades() {
        double elementaryGrade = this.random.nextDouble() * 10;
        double highSchoolGrade = this.random.nextDouble() * 10;

        Grade grade = new Grade(elementaryGrade, highSchoolGrade);

        assertThat(grade.getElementaryGrade(), is(elementaryGrade));
        assertThat(grade.getHighSchoolGrade(), is(highSchoolGrade));
    }
}
