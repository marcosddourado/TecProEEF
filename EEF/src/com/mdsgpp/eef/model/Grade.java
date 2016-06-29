package com.mdsgpp.eef.model;

public class Grade {

	private double elementaryGrade;
	private double highSchoolGrade;
	private int gradeYear;
	private State state;
	private final int acceptableYear = 1900;

	/**
	 * Initializes the grade object. Also initializes all properties with default value.
	 *
	 * @return New grade object with default property values.
	 */
	public Grade() {
		this.elementaryGrade = 0;
		this.highSchoolGrade = 0;
		this.gradeYear = 0;
		this.state = null;
	}

	/**
	 * Initializes the grade object with elementary and high school grade parameters.
	 *
	 * @param  elementaryGrade The elementaryGrade property to be set.
	 * @param  highSchoolGrade The highSchoolGrade property to be set.
	 * @return New grade object with elementaryGrade and highSchoolGrade set.
	 */
	public Grade(double elementaryGrade, double highSchoolGrade){
		assert (elementaryGrade >= 0) : "elementaryGrade < 0. elementaryGrade was " + elementaryGrade;
		assert (highSchoolGrade >= 0) : "highSchoolGrade < 0 . elementaryGrade was " + highSchoolGrade;
		this.elementaryGrade = elementaryGrade;
		this.highSchoolGrade = highSchoolGrade;
	}

	public double getElementaryGrade() {
		return elementaryGrade;
	}

	public void setElementaryGrade(double elementaryGrade) {
		assert (elementaryGrade >= 0) : "elementaryGrade < 0 . elementaryGrade was " + elementaryGrade;
		this.elementaryGrade = elementaryGrade;
	}

	public double getHighSchoolGrade() {
		return highSchoolGrade;
	}

	public void setHighSchoolGrade(double highSchoolGrade) {
		assert (highSchoolGrade >= 0) : "highSchoolGrade < 0 . elementaryGrade was " + highSchoolGrade;
		this.highSchoolGrade = highSchoolGrade;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		assert (state != null) : "null state ";
		this.state = state;
	}

	public int getGradeYear() {
		return gradeYear;
	}

	public void setGradeYear(int gradeYear) {
		assert(gradeYear >= acceptableYear) : "gradeYear non-acceptable . gradeYear was = " + gradeYear;
		this.gradeYear = gradeYear;
	}
}
