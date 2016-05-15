package com.mdsgpp.eef.model;

//grade grade for schhols per state/year
public class Grade {
		private double elementaryGrade;
		private double highSchoolGrade;
		private int gradeYear;
		private State state;
		private final int acceptableYear = 1900;

		public Grade() {
		}

		public Grade(double elementaryGrade, double highSchoolGrade){
			assert (elementaryGrade >= 0) : "elementaryGrade >= 0 assertion failed. elementaryGrade was " + elementaryGrade;
			assert (highSchoolGrade >= 0) : "highSchoolGrade >= 0 assertion failed. elementaryGrade was " + highSchoolGrade;
			this.elementaryGrade = elementaryGrade;
			this.highSchoolGrade = highSchoolGrade;
		}

		public double getElementaryGrade() {
			return elementaryGrade;
		}

		public void setElementaryGrade(double elementaryGrade) {
			assert (elementaryGrade >= 0) : "elementaryGrade >= 0 assertion failed. elementaryGrade was " + elementaryGrade;
			this.elementaryGrade = elementaryGrade;
		}

		public double getHighSchoolGrade() {
			return highSchoolGrade;
		}

		public void setHighSchoolGrade(double highSchoolGrade) {
			assert (highSchoolGrade >= 0) : "highSchoolGrade >= 0 assertion failed. elementaryGrade was " + highSchoolGrade;
			this.highSchoolGrade = highSchoolGrade;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			assert (state != null) : "non-null state assertion failed";
			this.state = state;
		}

		public int getGradeYear() {
			return gradeYear;
		}

		public void setGradeYear(int gradeYear) {
			assert(gradeYear >= acceptableYear) : "gradeYear >= 1900 assertion failed. gradeYear was = " + gradeYear;
			this.gradeYear = gradeYear;
		}
}
