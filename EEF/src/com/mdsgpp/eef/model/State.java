package com.mdsgpp.eef.model;

import java.util.ArrayList;
import java.util.HashMap;


public class State {

	private String stateName; 													//done
	private String stateAbbreviation; 											//done
	private double percentageCollaborationWithPIB[]; 							//done
	private int statePopulation; 												//done
	private Census census[];//controle;xml;declarados;inicializado; 			//done
	private Ideb idebs[]; //Índice de Desenvolvimento de Educação Básica		//done
	private Grade studentGradesPerClass[];//controle;xml;declarados;inicializado; //done
	private Grade gradeClassHours[];//controle;xml;declarados;inicializado;		//done
	private Project scienceAndThecnologyProjects[];								//done
	private Project firstProjects[];											//done
	private Project inctProject[];												//done
	private Project apoioCnpqProject[];											//done
	private Project jovensPesquisadoresProject[];								//done
	private Grade ageGradeDistortionRate[]; //controle;xml;declarados;inicializado; //done
	private Grade educationalAchievementRate[]; //controle;duvida: aprovaeao ou aproveitamento?;xml;declarados;inicializado; //done
	private Grade schoolDropoutRate[];//controle;xml;declaradoa;inicializado;	//done

	public State(){
	}

	public State(String stateName, String stateAbbreviation, HashMap<String, ArrayList<String[]>> information){
		this.stateName = stateName;
		this.stateAbbreviation = stateAbbreviation;

		fillData(information);
	}

	public Census[] getCensus() {
		return census;
	}

	public void setCensus(HashMap<String, ArrayList<String[]>> information) {
		ArrayList<String[]> elementarySchoolFinalData;
		ArrayList<String[]> elementarySchoolInitialData;
		ArrayList<String[]> highSchoolData;
		ArrayList<String[]> ejaHighSchoolData;
		ArrayList<String[]> ejaElementarySchoolData;
		Census census[] = null;

		elementarySchoolFinalData = information.get("censo_anos_finais");
		elementarySchoolInitialData = information.get("censo_anos_iniciais");
		highSchoolData = information.get("censo_ensino_high_school");
		ejaHighSchoolData = information.get("censo_eja_high_school");
		ejaElementarySchoolData = information.get("censo_eja_elementary");

		census = new Census[highSchoolData.size()];
		for (int i=0; i<census.length; i++) {
			census[i] = new Census();
			census[i].setCensusState(this);
			census[i].setCensusYear(Integer.parseInt(highSchoolData.get(i)[0]));
			census[i].setFinalElementarySchoolYears(Double.parseDouble(elementarySchoolFinalData.get(i)[1].replaceAll("\\.", "")));
			census[i].setHighSchool(Double.parseDouble(highSchoolData.get(i)[1].replaceAll("\\.", "")));
			census[i].setInitialElementarySchoolYears(Double.parseDouble(elementarySchoolInitialData.get(i)[1].replaceAll("\\.", "")));
			census[i].setHighSchoolEJA(Double.parseDouble(ejaHighSchoolData.get(i)[1].replaceAll("\\.", "")));
			census[i].setElementarySchoolEJA(Double.parseDouble(ejaElementarySchoolData.get(i)[1].replaceAll("\\.", "")));
		}

		this.census = census;
	}

	public double[] getPercentageCollaborationWithPIB() {
		if (percentageCollaborationWithPIB == null) {
			double[] empty = {0};
			return empty;
		}

		return percentageCollaborationWithPIB;
	}

	public void setPercentageCollaborationWithPIB(HashMap<String, ArrayList<String[]>> information) {

		double percentageCollaborationWithPIB[];
		ArrayList<String[]> data = information.get("participacao_estadual_pib");

		percentageCollaborationWithPIB = new double[data.size()];
		for (int i=0; i<data.size(); i++) {
			percentageCollaborationWithPIB[i] = Double.parseDouble(data.get(i)[1].replaceAll(",", "."));
		}

		this.percentageCollaborationWithPIB = percentageCollaborationWithPIB;
	}

	public int getstatePopulation() {
		return statePopulation;
	}

	public void setStatePopulation(HashMap<String, ArrayList<String[]>> information) {

		ArrayList<String[]> data = information.get("populacao");
		this.statePopulation = Integer.parseInt(data.get(0)[1].replaceAll(",", "."));

	}

	public Ideb[] getIdebs() {
		if (idebs == null) {
			Ideb empty[] = { new Ideb(0,0,0) }; //move initialization to constructor
			return empty;
		}

		return idebs;
	}

	public void setIdebs(HashMap<String, ArrayList<String[]>> information) {
		ArrayList<String[]> elementarySchoolFinalData;
		ArrayList<String[]> elementarySchoolInitialData;
		ArrayList<String[]> highSchoolData;
		Ideb ideb[] = null;

		elementarySchoolFinalData = information.get("5a_8a");
		elementarySchoolInitialData = information.get("series_iniciais");
		highSchoolData = information.get("ensino_high_school");

		ideb = new Ideb[highSchoolData.size()];
		for (int i=0; i<ideb.length; i++) {
			ideb[i] = new Ideb();
			ideb[i].setState(this);
			if(i<ideb.length-1){
				ideb[i].setIdebYear(Integer.parseInt(highSchoolData.get(i)[0]));
			}
			ideb[i].setElementarySchool(Double.parseDouble(elementarySchoolFinalData.get(i)[1].replaceAll(",",
					".")));
			ideb[i].setHighSchool(Double.parseDouble(highSchoolData.get(i)[1].replaceAll(",", ".")));
			ideb[i].setInitialGrades(Double.parseDouble(elementarySchoolInitialData.get(i)[1].replaceAll(",", ".")));
		}

		this.idebs = ideb;
	}

	public Grade[] returnEmptyGrade() {
		Grade emptyGrade[] = { new Grade(0,0) };
		emptyGrade[0].setGradeYear(0);

		return emptyGrade;
	}

	public Grade[] setGrade(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		ArrayList<String[]> dataFundamental;
		ArrayList<String[]> highSchoolData;
		Grade readGrade[] = null;

		dataFundamental = information.get(namesOfIndicative[0]);
		highSchoolData = information.get(namesOfIndicative[1]);

		readGrade = new Grade[highSchoolData.size()];
		for (int i=0; i<readGrade.length; i++) {
			readGrade[i] = new Grade();
			readGrade[i].setState(this);
			readGrade[i].setGradeYear(Integer.parseInt(highSchoolData.get(i)[0]));
			readGrade[i].setElementarySchoolGrade(Double.parseDouble(dataFundamental.get(i)[1].replaceAll(",", ".")));
			readGrade[i].setHighSchoolGrade(Double.parseDouble(highSchoolData.get(i)[1].replaceAll(",", ".")));
		}

		return readGrade;
	}

	public Grade[] getStudentGradesPerClass() {
		if (studentGradesPerClass == null) {
			return returnEmptyGrade();
		}

		return studentGradesPerClass;
	}

	public void setStudentGradesPerClass(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		this.studentGradesPerClass = this.setGrade(information, namesOfIndicative);
	}

	public Grade[] getGradeClassHours() {
		if (gradeClassHours == null) {
			return returnEmptyGrade();
		}

		return gradeClassHours;
	}

	public void setGradeClassHours(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		this.gradeClassHours = this.setGrade(information, namesOfIndicative);
	}

	public Grade[] getAgeGradeDistortionRate() {
		if (ageGradeDistortionRate == null) {
			return returnEmptyGrade();
		}

		return ageGradeDistortionRate;
	}

	public void setAgeGradeDistortionRate(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		this.ageGradeDistortionRate = this.setGrade(information, namesOfIndicative);
	}

	public String getStateName() {
		if (stateName == null) {
			return "Sem nome";
		}

		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateAbbreviation() {
		if (stateAbbreviation == null) {
			return "Sem sigla";
		}

		return stateAbbreviation;
	}

	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}

	public Project[] returnEmptyProject() {
		Project empty[] = { new Project() };
		empty[0].setProjectAmount(0);
		empty[0].setProjectValue(0);
		empty[0].setProjectYear(0);

		return empty;
	}

	public Project[] setProjects(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		ArrayList<String[]> investedValuesData = null;
		ArrayList<String[]> projectsAmountData = null;
		Project readProjects[] = null;

		if(information.containsKey(namesOfIndicative[0])){
			projectsAmountData = information.get(namesOfIndicative[0]);
			readProjects = new Project[projectsAmountData.size()];
			investedValuesData = information.get(namesOfIndicative[1]);
		}

		for (int i=0; readProjects!=null && i<readProjects.length; i++) {
			readProjects[i] = new Project();
			readProjects[i].setState(this);
			if(i<readProjects.length-1){
				readProjects[i].setProjectYear(Integer.parseInt(projectsAmountData.get(i)[0]));
			}
			readProjects[i].setProjectAmount(Integer.parseInt(projectsAmountData.get(i)[1].replaceAll(",", ".")));
			readProjects[i].setProjectValue(Double.parseDouble(investedValuesData.get(i)[1].replaceAll(",", ".")));
		}

		return readProjects;
	}

	public Project[] getScienceAndThecnologyProjects() {
		if(scienceAndThecnologyProjects == null){
			return returnEmptyProject();
		}

		return scienceAndThecnologyProjects;
	}

	public void setScienceAndThecnologyProjects(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		this.scienceAndThecnologyProjects = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getFirstProjects() {
		if (firstProjects == null) {
			return returnEmptyProject();
		}

		return firstProjects;
	}

	public void setFirstProjects(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		this.firstProjects = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getProjectsInct() {
		if (inctProject == null) {
			return returnEmptyProject();
		}

		return inctProject;
	}

	public void setProjectsInct(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		this.inctProject = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getApoioCnpqProject() {
		if (apoioCnpqProject == null) {
			return returnEmptyProject();
		}

		return apoioCnpqProject;
	}

	public void setApoioCnpqProject(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		this.apoioCnpqProject = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getJovensPesquisadoresProject() {
		if (jovensPesquisadoresProject == null) {
			return returnEmptyProject();
		}

		return jovensPesquisadoresProject;
	}

	public void setJovensPesquisadoresProject(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		this.jovensPesquisadoresProject = this.setProjects(information, namesOfIndicative);
	}

	public Grade[] getEducationalAchievementRate() {
		if (educationalAchievementRate == null) {
			return returnEmptyGrade();
		}

		return educationalAchievementRate;
	}

	public void setEducationalAchievementRate(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		this.educationalAchievementRate = this.setGrade(information, namesOfIndicative);
	}

	public Grade[] getSchoolDropoutRate() {
		if (schoolDropoutRate == null) {
			return returnEmptyGrade();
		}

		return schoolDropoutRate;
	}

	public void setSchoolDropoutRate(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		this.schoolDropoutRate = this.setGrade(information, namesOfIndicative);
	}

	public void fillData(HashMap<String, ArrayList<String[]>> information) {
		String[] gradeClassHoursIndicatives = { "horas_aula_ensino_elementary", "horas_aula_ensino_high_school" };
		String[] studentGradesPerClassIndicatives = { "alunos_por_turma_ensino_elementary", "alunos_por_turma_ensino_high_school" };
		String[] scienceAndThecnologyProjectsIndicatives = { "numero_projetos", "valor_investido" };
		String[] firstProjectsIndicatives = { "programa_primeiros_projetos", "valores_programa_primeiros_projetos" };
		String[] apoioCnpqProjectIndicatives = { "projetos_apoio_pesquisa_cnpq", "valores_projetos_apoio_pesquisa_cnpq" };
		String[] jovensPesquisadoresProjectIndicatives = { "jovens_pesquisadores", "valores_jovens_pesquisadores" };
		String[] inctProjectsIndicatives = { "projetos_inct", "valores_projetos_inct" };
		String[] ageGradeDistortionRate = { "distortion_rate_elementary", "distortion_rate_ensino_high_school" };
		String[] educationalAchievementRate = { "taxa_aprovacao_elementary", "taxa_aprovacao_high_school" };
		String[] schoolDropoutRate = { "taxa_abandono_elementary", "taxa_abandono_high_school" };

		this.setStatePopulation(information);
		this.setCensus(information);
		this.setIdebs(information);
		this.setPercentageCollaborationWithPIB(information);

		this.setProjectsInct(information, inctProjectsIndicatives);
		this.setJovensPesquisadoresProject(information, jovensPesquisadoresProjectIndicatives);
		this.setApoioCnpqProject(information, apoioCnpqProjectIndicatives);
		this.setFirstProjects(information, firstProjectsIndicatives);
		this.setScienceAndThecnologyProjects(information, scienceAndThecnologyProjectsIndicatives);

		this.setStudentGradesPerClass(information, studentGradesPerClassIndicatives);
		this.setGradeClassHours(information, gradeClassHoursIndicatives);
		this.setAgeGradeDistortionRate(information, ageGradeDistortionRate);
		this.setEducationalAchievementRate(information, educationalAchievementRate);
		this.setSchoolDropoutRate(information, schoolDropoutRate);

	}

}
