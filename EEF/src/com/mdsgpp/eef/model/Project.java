package com.mdsgpp.eef.model;

public class Project {
	private int projectQuantity;
	private double projectValue;
	private State projectState;
	private int projectYear;
	private final int accetableYear = 1900;

	/**
	 * Initializes the project object with default values.
	 *
	 * @return  New project object with default values.
	 */
	public Project() {
		this.projectQuantity = 0;
		this.projectValue 	 = 0;
		this.projectState 	 = null;
		this.projectYear 	 = 0;
	}

	public int getProjectQuantity() {
		return projectQuantity;
	}

	public void setProjectQuantity(int projectQuantity) {
		assert (projectQuantity >= 0) : "projectQuantity < 0. projectQuantity was " + projectQuantity;
		this.projectQuantity = projectQuantity;
	}

	public double getProjectValue() {
		return projectValue;
	}

	public void setProjectValue(double projectValue) {
		assert (projectValue>= 0.0) : "projectValue < 0. projectValue was " + projectValue;
		this.projectValue = projectValue;
	}

	public State getProjectState() {
		return projectState;
	}

	public void setState(State projectState) {
		assert (projectState != null) : "null projectState";
		this.projectState = projectState;
	}
	public int getProjectYear(){
		return projectYear;
	}
	public void setProjectYear(int projectYear){
		assert (projectYear >= accetableYear) : "projectYear non-acceptable. projectYear was" + projectYear;
		this.projectYear = projectYear;
	}


}
