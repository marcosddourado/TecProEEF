package com.mdsgpp.eef.model;

public class Census {

	private double initialElementaryYears;
	private double finalElementaryYears;
	private double highSchool;
	private double elementaryEJA;
	private double highSchoolEJA;
	private int censusYear;
	private State censusState;
	private final int acceptableYear = 1900;

	/**
	 * Initializes the census object with default values.
	 *
	 * @return  New census object with default values.
	 */
	public Census() {

		this.initialElementaryYears = 0;
		this.finalElementaryYears = 0;
		this.highSchool = 0;
		this.elementaryEJA = 0;
		this.highSchoolEJA = 0;
	}

	/**
	 * Initializes the census object, setting properties according to the parameters.
	 *
	 * @param  initialElementaryYears Initial elementary years census data
	 * @param  finalElementaryYears   Final elementary years census data
	 * @param  highSchool 			  High school census data
	 * @param  elementaryEJA 		  Elementary EJA years census data
	 * @param  highSchoolEJA 		  High school EJA census data
	 * @return						  New census object with census data properties set.
	 */
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

	public void setFinalElementaryYears(double elementaryYears) {
		assert(elementaryYears >= 0) : "elementaryYears < 0. elementaryYears was " + elementaryYears;
		this.finalElementaryYears = elementaryYears;
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
		assert(censusYear >= acceptableYear):
				"censusYear non-acceptable. censusYear was = " + censusYear;
		this.censusYear = censusYear;
	}

}
