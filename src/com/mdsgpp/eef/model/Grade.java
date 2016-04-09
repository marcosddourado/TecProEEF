package com.mdsgpp.eef.model;

//average grade for schhols per state/year
public class Grade {
		private double elementarySchoolGrade;
		private double highSchoolGrade;
		private int gradeYear;
		private State state;

		public Grade() {
		}

		public Grade(double elementarySchoolGrade, double highSchoolGrade){
			this.elementarySchoolGrade = elementarySchoolGrade;
			this.highSchoolGrade = highSchoolGrade;
		}

		public double getElementarySchoolGrade() {
			return elementarySchoolGrade;
		}

		public void setElementarySchoolGrade(double elementarySchoolGrade) {
			this.elementarySchoolGrade = elementarySchoolGrade;
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
