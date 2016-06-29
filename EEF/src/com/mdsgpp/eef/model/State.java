package com.mdsgpp.eef.model;

import java.util.ArrayList;
import java.util.HashMap;


public class State {

	private String stateName = "";
	private String stateAbbreviation = "";
	private double percentageCollaborationWithPIB[] = {};
	private int statePopulation = 0;
	private Census census[] = {};
	private Ideb idebs[] = {};
	private Grade studentGradesPerClass[] = {};
	private Grade gradeClassHours[] = {};
	private Project scienceAndThecnologyProjects[] = {};
	private Project primeirosProjetos[] = {};
	private Project inctProject[] = {};
	private Project apoioCnpqProject[] = {};
	private Project jovensPesquisadoresProject[] = {};
	private Grade ageGradeDistortionRate[] = {};
	private Grade educationalAchievementRate[] = {};
	private Grade schoolDropoutRate[] = {};

	public static final String states[] = { "Acre", "Alagoas", "Amapa", "Amazonas", "Bahia", "Ceara",
			"Distrito Federal", "Espirito Santo", "Goias", "Maranhao", "Mato Grosso do Sul",
			"Mato Grosso", "Minas Gerais", "Para", "Paraiba", "Parana", "Pernambuco", "Piaui",
			"Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondonia", "Roraima",
			"Santa Catarina", "Sao Paulo", "Sergipe", "Tocantins" };
	public static final String stateAbbreviations[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
			"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR",
			"SC", "SP", "SE", "TO"};

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
		if(this.census != null) {
			return this.census;
		} else {
			return emptyCensus();
		}
	}

	public void setCensus(HashMap<String, ArrayList<String[]>> information) {
		assert (information != null) : "null information";
		ArrayList<String[]> elementaryFinalData;
		ArrayList<String[]> elementaryInitialData;
		ArrayList<String[]> highSchoolData;
		ArrayList<String[]> ejaHighSchoolData;
		ArrayList<String[]> ejaElementaryData;
		Census census[] = null;

		elementaryFinalData = information.get("census_anos_finais");
		elementaryInitialData = information.get("census_anos_iniciais");
		highSchoolData = information.get("census_high_school");
		ejaHighSchoolData = information.get("census_high_school_eja");
		ejaElementaryData = information.get("census_eja_elementary");

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
		if (this.percentageCollaborationWithPIB != null) {
			return this.percentageCollaborationWithPIB;
		} else {
			return emptyDouble();
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

		ArrayList<String[]> data = information.get("population");

		assert (data != null) : "null data";

		this.statePopulation = Integer.parseInt(data.get(0)[1].replaceAll(",", "."));

	}

	public Ideb[] getIdebs() {
		if (this.idebs != null) {
			return this.idebs;

		} else {
			return emptyIdeb();
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
		if (this.studentGradesPerClass != null) {
			return this.studentGradesPerClass;
		} else {
			return emptyGrade();
		}
	}

	public void setStudentGradesPerClass(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.studentGradesPerClass = this.setGrade(information, namesOfIndicative);
	}

	public Grade[] getGradeClassHours() {
		if (this.gradeClassHours != null) {
			return this.gradeClassHours;
		} else {
			return emptyGrade();
		}

	}

	public void setGradeClassHours(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.gradeClassHours = this.setGrade(information, namesOfIndicative);
	}

	public Grade[] getAgeGradeDistortionRate() {
		if (this.ageGradeDistortionRate != null) {
			return this.ageGradeDistortionRate;
		} else {
			return emptyGrade();
		}

	}

	public void setAgeGradeDistortionRate(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.ageGradeDistortionRate = this.setGrade(information, namesOfIndicative);
	}

	public String getStateName() {
		if (this.stateName != null) {
			return this.stateName;
		} else {
			return "Sem nome";
		}

	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateAbbreviation() {
		if (this.stateAbbreviation != null) {
			return this.stateAbbreviation;
		} else {
			return "Sem sigla";
		}
	}

	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
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
		if(this.scienceAndThecnologyProjects != null) {
			return this.scienceAndThecnologyProjects;
		} else {
			return emptyProject();
		}
	}

	public void setScienceAndThecnologyProjects(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.scienceAndThecnologyProjects = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getPrimeirosProjetos() {
		if (this.primeirosProjetos != null) {
			return this.primeirosProjetos;
		} else {
			return emptyProject();
		}

	}

	public void setPrimeirosProjetos(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.primeirosProjetos = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getProjectsInct() {
		if (this.inctProject != null) {
			return this.inctProject;
		} else {
			return emptyProject();
		}
	}

	public void setProjectsInct(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.inctProject = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getApoioCnpqProject() {
		if (this.apoioCnpqProject != null) {
			return this.apoioCnpqProject;
		} else {
			return emptyProject();
		}
	}

	public void setApoioCnpqProject(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.apoioCnpqProject = this.setProjects(information, namesOfIndicative);
	}

	public Project[] getJovensPesquisadoresProject() {
		if (this.jovensPesquisadoresProject != null) {
			return this.jovensPesquisadoresProject;
		} else {
			return emptyProject();
		}
	}

	public void setJovensPesquisadoresProject(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.jovensPesquisadoresProject = this.setProjects(information, namesOfIndicative);
	}

	public Grade[] getEducationalAchievementRate() {
		if (this.educationalAchievementRate != null) {
			return this.educationalAchievementRate;
		} else {
			return emptyGrade();
		}
	}

	public void setEducationalAchievementRate(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.educationalAchievementRate = this.setGrade(information, namesOfIndicative);
	}

	public Grade[] getSchoolDropoutRate() {
		if (this.schoolDropoutRate != null) {
			return this.schoolDropoutRate;
		} else {
			return emptyGrade();
		}
	}

	public void setSchoolDropoutRate(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.schoolDropoutRate = this.setGrade(information, namesOfIndicative);
	}

	public void fillData(HashMap<String, ArrayList<String[]>> information) {
		assert (information != null) : "null information";

		String[] gradeClassHoursIndicatives = { "daily_class_hours_average_elementary", "daily_class_hours_average_high_school" };
		String[] studentGradesPerClassIndicatives = { "alunos_por_turma_ensino_elementary", "alunos_por_turma_ensino_high_school" };
		String[] scienceAndThecnologyProjectsIndicatives = { "project_numbers", "valor_investido" };
		String[] primeirosProjetosIndicatives = { "first_program_projects", "valores_first_program_projects" };
		String[] apoioCnpqProjectIndicatives = { "projetos_apoio_pesquisa_cnpq", "valores_projetos_apoio_pesquisa_cnpq" };
		String[] jovensPesquisadoresProjectIndicatives = { "teen_searchers", "valores_teen_searchers" };
		String[] inctProjectsIndicatives = { "projetos_inct", "valores_projetos_inct" };
		String[] ageGradeDistortionRate = { "distortion_rate_elementary", "distortion_rate_ensino_high_school" };
		String[] educationalAchievementRate = { "utilization_rate_elementary", "utilization_rate_high_school" };
		String[] schoolDropoutRate = { "dropout_rate_elementary", "dropout_rate_high_school" };

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

	public Grade[] emptyGrade() {
		Grade emptyGrade[] = { new Grade(0,0) };
		emptyGrade[0].setGradeYear(0);

		return emptyGrade;
	}

	public Project[] emptyProject() {
		Project empty[] = { new Project() };
		empty[0].setProjectQuantity(0);
		empty[0].setProjectValue(0);
		empty[0].setProjectYear(0);

		return empty;
	}

	public Census[] emptyCensus() {
		Census empty[] = {new Census(0.0, 0.0, 0.0, 0.0, 0.0) };
		return empty;
	}

	public Ideb[] emptyIdeb() {
		Ideb empty[] = {new Ideb(0.0, 0.0, 0.0)};
		return empty;
	}

	public double[] emptyDouble() {
		double empty[] = {0};
		return empty;
	}
}
