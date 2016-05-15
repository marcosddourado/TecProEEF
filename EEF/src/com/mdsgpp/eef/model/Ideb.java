	package com.mdsgpp.eef.model;

public class Ideb {

	private double elementary;
	private double highSchool;
	private double initialGrades;
	private State idebState;
	private int idebYear;
	private final int acceptableYear = 1900;

	public Ideb() {
	}

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
		assert (idebYear >= acceptableYear) : "idebYear < 1900. idebYear was " + idebYear;
		this.idebYear = idebYear;
	}
}
