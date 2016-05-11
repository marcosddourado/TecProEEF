package com.mdsgpp.eef.model;

//grade grade for schhols per state/year
public class Grade {
		private double elementaryGrade;
		private double highSchoolGrade;
		private int gradeYear;
		private State state;

		public Grade() {
		}

		public Grade(double elementaryGrade, double highSchoolGrade){
			this.elementaryGrade = elementaryGrade;
			this.highSchoolGrade = highSchoolGrade;
		}

		public double getElementaryGrade() {
			return elementaryGrade;
		}

		public void setElementaryGrade(double elementaryGrade) {
			this.elementaryGrade = elementaryGrade;
		}

		public double getHighSchoolGrade() {
			return highSchoolGrade;
		}

		public void setHighSchoolGrade(double highSchoolGrade) {
			this.highSchoolGrade = highSchoolGrade;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		public int getGradeYear() {
			return gradeYear;
		}

		public void setGradeYear(int gradeYear) {
			this.gradeYear = gradeYear;
		}
}
