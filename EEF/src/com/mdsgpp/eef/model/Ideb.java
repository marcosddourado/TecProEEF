	package com.mdsgpp.eef.model;

public class Ideb {

	private double elementary;
	private double highSchool;
	private double initialGrades;
	private State idebState;
	private int idebYear;
	private final int acceptableYear = 1900;

	/**
	 * Initializes the ideb object. Also initializes all properties with default value.
	 *
	 * @return New ideb object with default property values.
	 */
	public Ideb() {
		this.elementary    = 0;
		this.highSchool    = 0;
		this.initialGrades = 0;
		this.idebYear 	   = 0;
		this.idebState 	   = null;
	}

	/**
	 * Initializes the ideb object with elementary, high school and initial grades parameters.
	 *
	 * @param  elementary The elementaryGrade property to be set.
	 * @param  highSchool The highSchoolGrade property to be set.
	 * @param  initialGrades The initialGrades property to be set.
	 * @return New ideb object with elementary, highSchool and initialGrades set.
	 */
	public Ideb(double elementary, double highSchool, double initialGrades){
		assert (initialGrades >= 0) : "initialGrades < 0. initialGrades was " + initialGrades;
		this.elementary = elementary;
		this.highSchool = highSchool;
		this.initialGrades = initialGrades;
	}

	public double getElementary() {
		return elementary;
	}

	public void setElementary(double elementary) {
		this.elementary = elementary;
	}

	public double getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(double highSchool) {
		this.highSchool = highSchool;
	}

	public double getInitialGrades() {
		return initialGrades;
	}

	public void setInitialGrades(double initialGrades) {
		assert (initialGrades >= 0) : "initialGrades < 0. initialGrades was " + initialGrades;
		this.initialGrades = initialGrades;
	}

	public State getState() {
		return idebState;
	}

	public void setState(State idebState) {
		assert (idebState != null) : "null idebState";
		this.idebState = idebState;
	}
	public int getIdebYear(){
		return idebYear;
	}
	public void setIdebYear(int idebYear){
		assert (idebYear >= acceptableYear) : "idebYear non-acceptable. idebYear was " + idebYear;
		this.idebYear = idebYear;
	}
}
