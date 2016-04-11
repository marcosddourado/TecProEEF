package com.mdsgpp.eef.model;

public class Project {
	private int projectAmount;
	private double projectValue;
	private State projectState;
	private int projectYear;

	public Project() {
	}

	public int getProjectAmount() {
		return projectAmount;
	}

	public void setProjectAmount(int projectAmount) {
		this.projectAmount = projectAmount;
	}

	public double getProjectValue() {
		return projectValue;
	}

	public void setProjectValue(double projectValue) {
		this.projectValue = projectValue;
	}

	public State getProjectState() {
		return projectState;
	}

	public void setState(State projectState) {
		this.projectState = projectState;
	}
	public int getProjectYear(){
		return projectYear;
	}
	public void setProjectYear(int projectYear){
		this.projectYear = projectYear;
	}


}
