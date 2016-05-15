package com.mdsgpp.eef.model;

import java.util.ArrayList;
import java.util.HashMap;


public class State {

	private String stateName;
	private String stateAbbreviation;
	private double percentageCollaborationWithPIB[];
	private int statePopulation;
	private Census census[];//controle;xml;declarados;inicializado;
	private Ideb idebs[]; //Índice de Desenvolvimento de Educação Básica
	private Grade studentGradesPerClass[];//controle;xml;declarados;inicializado;
	private Grade gradeClassHours[];//controle;xml;declarados;inicializado;
	private Project scienceAndThecnologyProjects[];
	private Project primeirosProjetos[];
	private Project inctProject[];
	private Project apoioCnpqProject[];
	private Project jovensPesquisadoresProject[];
	private Grade ageGradeDistortionRate[]; //controle;xml;declarados;inicializado;
	private Grade educationalAchievementRate[]; //controle;duvida: aprovaeao ou aproveitamento?;xml;declarados;inicializado;
	private Grade schoolDropoutRate[];//controle;xml;declaradoa;inicializado;

	public State(){
	}

	public State(String stateName, String stateAbbreviation, HashMap<String, ArrayList<String[]>> information){
		assert (stateName != null) : "null stateName";
		assert (stateName != "" || stateName != " ") : "empty stateName";
		assert (information != null) : "null information";

		this.stateName = stateName;
		this.stateAbbreviation = stateAbbreviation;

		fillData(information);
	}

	public Census[] getCensus() {
		return census;
	}

	public void setCensus(HashMap<String, ArrayList<String[]>> information) {
		assert (information != null) : "null information";
		ArrayList<String[]> elementaryFinalData;
		ArrayList<String[]> elementaryInitialData;
		ArrayList<String[]> highSchoolData;
		ArrayList<String[]> ejaHighSchoolData;
		ArrayList<String[]> ejaElementaryData;
		Census census[] = null;

		elementaryFinalData = information.get("censo_anos_finais");
		elementaryInitialData = information.get("censo_anos_iniciais");
		highSchoolData = information.get("censo_ensino_high_school");
		ejaHighSchoolData = information.get("censo_eja_high_school");
		ejaElementaryData = information.get("censo_eja_elementary");

		assert (elementaryFinalData != null) : "null elementaryFinalData";
		assert (elementaryInitialData != null) : "null elementaryInitialData";
		assert (highSchoolData != null) : "null highSchoolData";
		assert (ejaHighSchoolData != null) : "null ejaHighSchoolData";
		assert (ejaElementaryData != null) : "null ejaElementaryData";


		census = new Census[highSchoolData.size()];
		for (int i=0; i<census.length; i++) {
			census[i] = new Census();
			census[i].setCensusState(this);
			census[i].setCensusYear(Integer.parseInt(highSchoolData.get(i)[0]));
			census[i].setFinalElementaryYears(Double.parseDouble(elementaryFinalData.get(i)[1].replaceAll("\\.", "")));
			census[i].setHighSchool(Double.parseDouble(highSchoolData.get(i)[1].replaceAll("\\.", "")));
			census[i].setInitialElementaryYears(Double.parseDouble(elementaryInitialData.get(i)[1].replaceAll("\\.", "")));
			census[i].setHighSchoolEJA(Double.parseDouble(ejaHighSchoolData.get(i)[1].replaceAll("\\.", "")));
			census[i].setElementaryEJA(Double.parseDouble(ejaElementaryData.get(i)[1].replaceAll("\\.", "")));
		}

		this.census = census;
	}

	public double[] getPercentageCollaborationWithPIB() {
		if (percentageCollaborationWithPIB == null) {
			double[] empty = {0};
			return empty;
		} else {
			return percentageCollaborationWithPIB;
		}
	}

	public void setPercentageCollaborationWithPIB(HashMap<String, ArrayList<String[]>> information) {
		assert (information != null) : "null information";

		double percentageCollaborationWithPIB[];
		ArrayList<String[]> data = information.get("participacao_estadual_pib");

		assert (data != null) : "null data";

		percentageCollaborationWithPIB = new double[data.size()];
		for (int i=0; i<data.size(); i++) {
			percentageCollaborationWithPIB[i] = Double.parseDouble(data.get(i)[1].replaceAll(",", "."));
		}

		this.percentageCollaborationWithPIB = percentageCollaborationWithPIB;
	}

	public int getStatePopulation() {
		return statePopulation;
	}

	public void setStatePopulation(HashMap<String, ArrayList<String[]>> information) {
		assert (information != null) : "null information";

		ArrayList<String[]> data = information.get("populacao");

		assert (data != null) : "null data";

		this.statePopulation = Integer.parseInt(data.get(0)[1].replaceAll(",", "."));

	}

	public Ideb[] getIdebs() {
		if (idebs == null) {
			Ideb empty[] = { new Ideb(0,0,0) };
			return empty;
		} else {
			return idebs;
		}
	}

	public void setIdebs(HashMap<String, ArrayList<String[]>> information) {
		assert (information != null) : "null information";

		ArrayList<String[]> elementaryFinalData;
		ArrayList<String[]> elementaryInitialData;
		ArrayList<String[]> highSchoolData;
		Ideb ideb[] = null;

		elementaryFinalData = information.get("5a_8a");
		elementaryInitialData = information.get("series_iniciais");
		highSchoolData = information.get("ensino_high_school");

		assert (elementaryFinalData != null) : "null elementaryFinalData";
		assert (elementaryInitialData != null) : "null elementaryInitialData";
		assert (highSchoolData != null) : "null highSchoolData";

		ideb = new Ideb[highSchoolData.size()];
		for (int i=0; i<ideb.length; i++) {
			ideb[i] = new Ideb();
			ideb[i].setState(this);
			if(i<ideb.length-1) {
				ideb[i].setIdebYear(Integer.parseInt(highSchoolData.get(i)[0]));
			} else {
				//do nothing
			}
			ideb[i].setElementary(Double.parseDouble(elementaryFinalData.get(i)[1].replaceAll(",",
					".")));
			ideb[i].setHighSchool(Double.parseDouble(highSchoolData.get(i)[1].replaceAll(",", ".")));
			ideb[i].setInitialGrades(Double.parseDouble(elementaryInitialData.get(i)[1].replaceAll(",", ".")));
		}

		this.idebs = ideb;
	}

	public Grade[] returnEmptyGrade() {
		Grade emptyGrade[] = { new Grade(0,0) };
		emptyGrade[0].setGradeYear(0);

		return emptyGrade;
	}

	public Grade[] setGrade(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		ArrayList<String[]> elementarydata;
		ArrayList<String[]> highSchoolData;
		Grade readGrade[] = null;

		elementarydata = information.get(namesOfIndicative[0]);
		highSchoolData = information.get(namesOfIndicative[1]);

		assert (elementarydata != null) : "null elementarydata";
		assert (highSchoolData != null) : "null highSchoolData";

		readGrade = new Grade[highSchoolData.size()];
		for (int i=0; i<readGrade.length; i++) {
			readGrade[i] = new Grade();
			readGrade[i].setState(this);
			readGrade[i].setGradeYear(Integer.parseInt(highSchoolData.get(i)[0]));
			readGrade[i].setElementaryGrade(Double.parseDouble(elementarydata.get(i)[1].replaceAll(",", ".")));
			readGrade[i].setHighSchoolGrade(Double.parseDouble(highSchoolData.get(i)[1].replaceAll(",", ".")));
		}

		return readGrade;
	}

	public Grade[] getStudentGradesPerClass() {
		if (studentGradesPerClass == null) {
			return returnEmptyGrade();
		} else {
			return studentGradesPerClass;
		}
	}

	public void setStudentGradesPerClass(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.studentGradesPerClass = this.setGrade(information, namesOfIndicative);
	}

	public Grade[] getGradeClassHours() {
		if (gradeClassHours == null) {
			return returnEmptyGrade();
		} else {
			return gradeClassHours;
		}

	}

	public void setGradeClassHours(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.gradeClassHours = this.setGrade(information, namesOfIndicative);
	}

	public Grade[] getAgeGradeDistortionRate() {
		if (ageGradeDistortionRate == null) {
			return returnEmptyGrade();
		} else {
			return ageGradeDistortionRate;
		}

	}

	public void setAgeGradeDistortionRate(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.ageGradeDistortionRate = this.setGrade(information, namesOfIndicative);
	}

	public String getStateName() {
		if (stateName == null) {
			return "Sem nome";
		} else {
			return stateName;
		}

	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateAbbreviation() {
		if (stateAbbreviation == null) {
			return "Sem sigla";
		} else {
			return stateAbbreviation;
		}

	}

	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}

	public Project[] returnEmptyProject() {
		Project empty[] = { new Project() };
		empty[0].setProjectQuantity(0);
		empty[0].setProjectValue(0);
		empty[0].setProjectYear(0);

		return empty;
	}

	public Project[] setProjects(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		ArrayList<String[]> investedValuesData = null;
		ArrayList<String[]> projectsQuantityData = null;
		Project readProjects[] = null;

		if(information.containsKey(namesOfIndicative[0])) {
			projectsQuantityData = information.get(namesOfIndicative[0]);
			readProjects = new Project[projectsQuantityData.size()];
			investedValuesData = information.get(namesOfIndicative[1]);
		} else {
			//do nothing
		}

		for (int i=0; readProjects!=null && i<readProjects.length; i++) {
			readProjects[i] = new Project();
			readProjects[i].setState(this);
			if(i<readProjects.length-1) {
				readProjects[i].setProjectYear(Integer.parseInt(projectsQuantityData.get(i)[0]));
			} else {
				//do nothing
			}
			readProjects[i].setProjectQuantity(Integer.parseInt(projectsQuantityData.get(i)[1].replaceAll(",", ".")));
			readProjects[i].setProjectValue(Double.parseDouble(investedValuesData.get(i)[1].replaceAll(",", ".")));
		}

		return readProjects;
	}

	public Project[] getScienceAndThecnologyProjects() {
		if(scienceAndThecnologyProjects == null) {
			return returnEmptyProject();
		} else {
			return scienceAndThecnologyProjects;
		}

	}

	public void setScienceAndThecnologyProjects(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.scienceAndThecnologyProjects = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getPrimeirosProjetos() {
		if (primeirosProjetos == null) {
			return returnEmptyProject();
		} else {
			return primeirosProjetos;
		}

	}

	public void setPrimeirosProjetos(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.primeirosProjetos = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getProjectsInct() {
		if (inctProject == null) {
			return returnEmptyProject();
		} else {
			return inctProject;
		}
	}

	public void setProjectsInct(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.inctProject = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getApoioCnpqProject() {
		if (apoioCnpqProject == null) {
			return returnEmptyProject();
		} else {
			return apoioCnpqProject;
		}
	}

	public void setApoioCnpqProject(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.apoioCnpqProject = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getJovensPesquisadoresProject() {
		if (jovensPesquisadoresProject == null) {
			return returnEmptyProject();
		} else {
			return jovensPesquisadoresProject;
		}
	}

	public void setJovensPesquisadoresProject(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.jovensPesquisadoresProject = this.setProjects(information, namesOfIndicative);
	}

	public Grade[] getEducationalAchievementRate() {
		if (educationalAchievementRate == null) {
			return returnEmptyGrade();
		} else {
			return educationalAchievementRate;
		}
	}

	public void setEducationalAchievementRate(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.educationalAchievementRate = this.setGrade(information, namesOfIndicative);
	}

	public Grade[] getSchoolDropoutRate() {
		if (schoolDropoutRate == null) {
			return returnEmptyGrade();
		} else {
			return schoolDropoutRate;
		}
	}

	public void setSchoolDropoutRate(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.schoolDropoutRate = this.setGrade(information, namesOfIndicative);
	}

	public void fillData(HashMap<String, ArrayList<String[]>> information) {
		assert (information != null) : "null information";

		String[] gradeClassHoursIndicatives = { "horas_aula_ensino_elementary", "horas_aula_ensino_high_school" };
		String[] studentGradesPerClassIndicatives = { "alunos_por_turma_ensino_elementary", "alunos_por_turma_ensino_high_school" };
		String[] scienceAndThecnologyProjectsIndicatives = { "numero_projetos", "valor_investido" };
		String[] primeirosProjetosIndicatives = { "programa_primeiros_projetos", "valores_programa_primeiros_projetos" };
		String[] apoioCnpqProjectIndicatives = { "projetos_apoio_pesquisa_cnpq", "valores_projetos_apoio_pesquisa_cnpq" };
		String[] jovensPesquisadoresProjectIndicatives = { "jovens_pesquisadores", "valores_jovens_pesquisadores" };
		String[] inctProjectsIndicatives = { "projetos_inct", "valores_projetos_inct" };
		String[] ageGradeDistortionRate = { "distortion_rate_elementary", "distortion_rate_ensino_high_school" };
		String[] educationalAchievementRate = { "taxa_aprovacao_elementary", "taxa_aprovacao_high_school" };
		String[] schoolDropoutRate = { "taxa_abandono_elementary", "taxa_abandono_high_school" };

		assert (gradeClassHoursIndicatives != null) : "null gradeClassHoursIndicatives";
		assert (studentGradesPerClassIndicatives != null) : "null studentGradesPerClassIndicatives";
		assert (scienceAndThecnologyProjectsIndicatives != null) : "null scienceAndThecnologyProjectsIndicatives";
		assert (primeirosProjetosIndicatives != null) : "null primeirosProjetosIndicatives";
		assert (apoioCnpqProjectIndicatives != null) : "null apoioCnpqProjectIndicatives";
		assert (jovensPesquisadoresProjectIndicatives != null) : "null jovensPesquisadoresProjectIndicatives";
		assert (inctProjectsIndicatives != null) : "null inctProjectsIndicatives";
		assert (ageGradeDistortionRate != null) : "null ageGradeDistortionRate";
		assert (educationalAchievementRate != null) : "null educationalAchievementRate";
		assert (schoolDropoutRate != null) : "null schoolDropoutRate";


		this.setStatePopulation(information);
		this.setCensus(information);
		this.setIdebs(information);
		this.setPercentageCollaborationWithPIB(information);

		this.setProjectsInct(information, inctProjectsIndicatives);
		this.setJovensPesquisadoresProject(information, jovensPesquisadoresProjectIndicatives);
		this.setApoioCnpqProject(information, apoioCnpqProjectIndicatives);
		this.setPrimeirosProjetos(information, primeirosProjetosIndicatives);
		this.setScienceAndThecnologyProjects(information, scienceAndThecnologyProjectsIndicatives);

		this.setStudentGradesPerClass(information, studentGradesPerClassIndicatives);
		this.setGradeClassHours(information, gradeClassHoursIndicatives);
		this.setAgeGradeDistortionRate(information, ageGradeDistortionRate);
		this.setEducationalAchievementRate(information, educationalAchievementRate);
		this.setSchoolDropoutRate(information, schoolDropoutRate);

	}

}
