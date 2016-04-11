	package com.mdsgpp.eef.model;

public class Ideb {

	private double elementarySchool;
	private double highSchool;
	private double initialGrades; //this Grade refers to 'graduation period'
	private State idebState;
	private int idebYear;

	public Ideb() {
	}

	public Ideb(double elementarySchool, double highSchool, double iniciais){
		this.elementarySchool = elementarySchool;
		this.highSchool = highSchool;
		this.initialGrades = iniciais;
	}

	public double getElementarySchool() {
		return elementarySchool;
	}

	public void setElementarySchool(double elementarySchool) {
		this.elementarySchool = elementarySchool;
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
		this.initialGrades = initialGrades;
	}

	public State getState() {
		return idebState;
	}

	public void setState(State idebState) {
		this.idebState = idebState;
	}
	public int getIdebYear(){
		return idebYear;
	}
	public void setIdebYear(int idebYear){
		this.idebYear = idebYear;
	}
}
