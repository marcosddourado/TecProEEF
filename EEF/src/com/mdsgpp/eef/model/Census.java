package com.mdsgpp.eef.model;

public class Census {

	private double initialElementaryYears;
	private double finalElementaryYears;
	private double highSchool;
	private double elementaryEJA;
	private double highSchoolEJA;
	private int censusYear;
	private State censusState;

	public Census() {
	}

	public Census(double initialElementaryYears, double finalElementaryYears,
			     double highSchool, double elementaryEJA, double highSchoolEJA){

		this.initialElementaryYears = initialElementaryYears;
		this.finalElementaryYears = finalElementaryYears;
		this.highSchool = highSchool;
		this.elementaryEJA = elementaryEJA;
		this.highSchoolEJA = highSchoolEJA;
	}

	public double getInitialElementaryYears() {
		return initialElementaryYears;
	}

	public void setInitialElementaryYears(double initialElementaryYears) {
		this.initialElementaryYears = initialElementaryYears;
	}

	public double getFinalElementaryYears() {
		return finalElementaryYears;
	}

	public void setFinalElementaryYears(double ElementaryYears) {
		this.finalElementaryYears = ElementaryYears;
	}

	public double getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(double highSchool) {
		this.highSchool = highSchool;
	}

	public double getElementaryEJA() {
		return elementaryEJA;
	}

	public void setElementaryEJA(double elementaryEJA) {
		this.elementaryEJA = elementaryEJA;
	}

	public double getHighSchoolEJA() {
		return highSchoolEJA;
	}

	public void setHighSchoolEJA(double highSchoolEJA) {
		this.highSchoolEJA = highSchoolEJA;
	}

	public State getCensusState() {
		return censusState;
	}

	public void setCensusState(State censusState) {
		this.censusState = censusState;
	}

	public int getCensusYear() {
		return censusYear;
	}

	public void setCensusYear(int censusYear) {
		this.censusYear = censusYear;
	}

}
