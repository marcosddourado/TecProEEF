package com.mdsgpp.eef.model;

public class Census {

	private double initialElementarySchoolYears;
	private double finalElementarySchoolYears;
	private double highSchool;
	private double elementarySchoolEJA;
	private double highSchoolEJA;
	private int censusYear;
	private State censusState;

	public Census() {
	}

	public Census(double initialElementarySchoolYears, double finalElementarySchoolYears,
			     double highSchool, double elementarySchoolEJA, double highSchoolEJA){

		this.initialElementarySchoolYears = initialElementarySchoolYears;
		this.finalElementarySchoolYears = finalElementarySchoolYears;
		this.highSchool = highSchool;
		this.elementarySchoolEJA = elementarySchoolEJA;
		this.highSchoolEJA = highSchoolEJA;
	}

	public double getInitialElementarySchoolYears() {
		return initialElementarySchoolYears;
	}

	public void setInitialElementarySchoolYears(double initialElementarySchoolYears) {
		this.initialElementarySchoolYears = initialElementarySchoolYears;
	}

	public double getFinalElementarySchoolYears() {
		return finalElementarySchoolYears;
	}

	public void setFinalElementarySchoolYears(double finalElementarySchoolYears) {
		this.finalElementarySchoolYears = finalElementarySchoolYears;
	}

	public double getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(double highSchool) {
		this.highSchool = highSchool;
	}

	public double getElementarySchoolEJA() {
		return elementarySchoolEJA;
	}

	public void setElementarySchoolEJA(double elementarySchoolEJA) {
		this.elementarySchoolEJA = elementarySchoolEJA;
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
