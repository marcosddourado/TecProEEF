package com.mdsgpp.eef.tests.model;

import com.mdsgpp.eef.model.Grade;

import org.junit.Before;
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
    private double elementaryGrade;
    private double highSchoolGrade;


    @Before
    public void setUp() {

        this.elementaryGrade = this.random.nextDouble() * 10;
        this.highSchoolGrade = this.random.nextDouble() * 10;

        this.grade = new Grade(elementaryGrade, highSchoolGrade);
    }

    @Test
    public void testConstruction() {

        this.grade = new Grade();

        assertThat(grade.getElementaryGrade(), is(0.0));
        assertThat(grade.getGradeYear(), is(0));
        assertThat(grade.getHighSchoolGrade(), is(0.0));
        assertThat(grade.getState(), is(nullValue()));
    }

    @Test
    public void testConstructionWithParameters() {

        assertThat(grade.getElementaryGrade(), is(elementaryGrade));
        assertThat(grade.getHighSchoolGrade(), is(highSchoolGrade));

    }

    @Test (expected = AssertionError.class)
    public void testAcceptableYear() {

        grade.setGradeYear(1800);
    }

    @Test
    public void testSetGrades() {

        elementaryGrade = this.random.nextDouble() * 10;
        highSchoolGrade = this.random.nextDouble() * 10;

        grade.setElementaryGrade(elementaryGrade);
        grade.setHighSchoolGrade(highSchoolGrade);

        assertThat(grade.getElementaryGrade(), is(elementaryGrade));
        assertThat(grade.getHighSchoolGrade(), is(highSchoolGrade));
    }
}
