package com.mdsgpp.eef.model;

//grade grade for schhols per stateGrade/year
public class Grade {
		private double elementarySchoolGrade;
		private double highSchoolGrade;
		private int gradeYear;
		private State stateGrade;

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
			return stateGrade;
		}

		public void setState(State stateGrade) {
			this.stateGrade = stateGrade;
		}

		public int getGradeYear() {
			return gradeYear;
		}

		public void setGradeYear(int gradeYear) {
			this.gradeYear = gradeYear;
		}
}
