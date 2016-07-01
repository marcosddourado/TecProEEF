package com.mdsgpp.eef.model;

import java.util.ArrayList;
import java.util.HashMap;


public class State {

	private String stateName;
	private String stateAbbreviation;
	private double percentageCollaborationWithPIB[];
	private int statePopulation;
	private Census census[];
	private Ideb idebs[];
	private Grade studentGradesPerClass[];
	private Grade gradeClassHours[];
	private Project scienceAndThecnologyProjects[];
	private Project primeirosProjetos[];
	private Project inctProject[];
	private Project apoioCnpqProject[];
	private Project jovensPesquisadoresProject[];
	private Grade ageGradeDistortionRate[];
	private Grade educationalAchievementRate[];
	private Grade schoolDropoutRate[];

	public static final String states[] = { "Acre", "Alagoas", "Amapa", "Amazonas", "Bahia",
			"Ceara", "Distrito Federal", "Espirito Santo", "Goias", "Maranhao",
			"Mato Grosso do Sul", "Mato Grosso", "Minas Gerais", "Para", "Paraiba", "Parana",
			"Pernambuco", "Piaui", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
			"Rondonia", "Roraima", "Santa Catarina", "Sao Paulo", "Sergipe", "Tocantins" };
	public static final String stateAbbreviations[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF",
			"ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS",
			"RO", "RR", "SC", "SP", "SE", "TO" };

	public static final String finalYearsCensusKey = "census_anos_finais";
	public static final String initialYearsCensusKey = "census_anos_iniciais";
	public static final String highSchoolCensusKey = "census_high_school";
	public static final String highSchoolEJACensusKey = "census_high_school_eja";
	public static final String elementaryEJACensusKey = "census_eja_elementary";
	public static final String pibStateContributionKey = "participacao_estadual_pib";
	public static final String populationKey = "population";
	public static final String fifthToEigthKey = "5a_8a";
	public static final String initialSeriesKey = "series_iniciais";
	public static final String highSchoolKey = "ensino_high_school";

	public static final String elementaryClassHours = "daily_class_hours_average_elementary";
	public static final String highSchoolClassHours = "daily_class_hours_average_high_school";
	public static final String elementaryStudentsPerClass = "alunos_por_turma_ensino_elementary";
	public static final String highSchoolStudentsPerClass = "alunos_por_turma_ensino_high_school";
	public static final String numberOfProjects = "numero_projetos";
	public static final String valueInvested = "valor_investido";
	public static final String primeirosProjetosProgram = "programa_primeiros_projetos";
	public static final String primeirosProjetosProgramValues = "valores_programa_primeiros_projetos";
	public static final String cnpqResearchSupportProgram = "projetos_apoio_pesquisa_cnpq";
	public static final String cnpqResearchSupportProgramValues = "valores_projetos_apoio_pesquisa_cnpq";
	public static final String youngResearchersProgram = "jovens_pesquisadores";
	public static final String youngResearchersProgramValues = "valores_jovens_pesquisadores";
	public static final String inctProjects = "projetos_inct";
	public static final String inctProjectsValues = "valores_projetos_inct";
	public static final String elementaryDistortionRate = "distortion_rate_elementary";
	public static final String highSchoolDistortionRate = "distortion_rate_ensino_high_school";
	public static final String elementaryApprovalRate = "utilization_rate_elementary";
	public static final String highSchoolApprovalRate = "utilization_rate_high_school";
	public static final String elementaryDropoutRate = "dropout_rate_elementary";
	public static final String highSchoolDropoutRate = "dropout_rate_high_school";

	public static final String unnamed = "Unnamed";
	public static final String noAbbreviation = "No abbreviation";

	/**
	 * Initializes the state object with default values.
	 *
	 * @return  New state object with default values.
	 */
	public State(){
		String emptyString			= "";
		double emptyDoubleArray[] 	= {};
		Census emptyCensusArray[] 	= {};
		Ideb emptyIdebArray[] 		= {};
		Grade emptyGradeArray[] 	= {};
		Project emptyProjectArray[] = {};

		this.stateName 				        = emptyString;
		this.stateAbbreviation 			    = emptyString;
		this.percentageCollaborationWithPIB = emptyDoubleArray;
		this.statePopulation 			    = 0;
		this.census						    = emptyCensusArray;
		this.idebs						    = emptyIdebArray;
		this.studentGradesPerClass 		    = emptyGradeArray;
		this.gradeClassHours 			    = emptyGradeArray;
		this.scienceAndThecnologyProjects   = emptyProjectArray;
		this.primeirosProjetos 			    = emptyProjectArray;
		this.inctProject 				    = emptyProjectArray;
		this.apoioCnpqProject 		        = emptyProjectArray;
		this.jovensPesquisadoresProject     = emptyProjectArray;
		this.ageGradeDistortionRate 	    = emptyGradeArray;
		this.educationalAchievementRate     = emptyGradeArray;
		this.schoolDropoutRate 			    = emptyGradeArray;
	}

	/**
	 * Initializes the state object with stateName and stateAbbreviation set,
	 * and with information parameter to fill object data.
	 *
	 * @return  New state object with default values.
	 */
	public State(String stateName, String stateAbbreviation, HashMap<String, ArrayList<String[]>> information){
		assert (stateName != null) : "null stateName";
		assert (!stateName.isEmpty()) : "empty stateName";
		assert (information != null) : "null information";

		this.stateName = stateName;
		this.stateAbbreviation = stateAbbreviation;

		fillData(information);
	}

	public Census[] getCensus() {
		if(this.census != null) {
			// Do nothing
		} else {
			this.census = emptyCensus();
		}
		return this.census;
	}

	public void setCensus(HashMap<String, ArrayList<String[]>> information) {
		assert (information != null) : "null information";

		ArrayList<String[]> elementaryFinalData = information.get(finalYearsCensusKey);
		ArrayList<String[]> elementaryInitialData = information.get(initialYearsCensusKey);
		ArrayList<String[]> highSchoolData = information.get(highSchoolCensusKey);
		ArrayList<String[]> ejaHighSchoolData = information.get(highSchoolEJACensusKey);
		ArrayList<String[]> ejaElementaryData = information.get(elementaryEJACensusKey);

		assert (elementaryFinalData != null) : "null elementaryFinalData";
		assert (elementaryInitialData != null) : "null elementaryInitialData";
		assert (highSchoolData != null) : "null highSchoolData";
		assert (ejaHighSchoolData != null) : "null ejaHighSchoolData";
		assert (ejaElementaryData != null) : "null ejaElementaryData";

		Census census[] = new Census[highSchoolData.size()];
		for (int i = 0; i < census.length; i++) {
			census[i] = new Census();
			census[i].setCensusState(this);
			census[i].setCensusYear(Integer.parseInt(highSchoolData.get(i)[0]));

			String initialElementaryYears = elementaryInitialData.get(i)[1];
			String finalElementaryYears = elementaryFinalData.get(i)[1];
			String highSchool = highSchoolData.get(i)[1];
			String highSchoolEja = ejaHighSchoolData.get(i)[1];
			String elementaryEja = ejaHighSchoolData.get(i)[1];

			initialElementaryYears.replaceAll("\\.", "");
			finalElementaryYears.replaceAll("\\.", "");
			highSchool.replaceAll("\\.", "");
			highSchoolEja.replaceAll("\\.", "");
			elementaryEja.replaceAll("\\.", "");

			census[i].setInitialElementaryYears(Double.parseDouble(initialElementaryYears));
			census[i].setFinalElementaryYears(Double.parseDouble(finalElementaryYears));
			census[i].setHighSchool(Double.parseDouble(highSchool));
			census[i].setHighSchoolEJA(Double.parseDouble(highSchoolEja));
			census[i].setElementaryEJA(Double.parseDouble(elementaryEja));
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
		ArrayList<String[]> data = information.get(pibStateContributionKey);

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

		ArrayList<String[]> data = information.get(populationKey);
		assert (data != null) : "null data";

		this.statePopulation = Integer.parseInt(data.get(0)[1].replaceAll(",", "."));

	}

	public Ideb[] getIdebs() {
		if (this.idebs != null) {
			//Do nothing
		} else {
			this.idebs = emptyIdeb();
		}
		return this.idebs;
	}

	public void setIdebs(HashMap<String, ArrayList<String[]>> information) {
		assert (information != null) : "null information";

		ArrayList<String[]> elementaryFinalData;
		ArrayList<String[]> elementaryInitialData;
		ArrayList<String[]> highSchoolData;
		Ideb ideb[] = null;

		elementaryFinalData = information.get(fifthToEigthKey);
		elementaryInitialData = information.get(initialSeriesKey);
		highSchoolData = information.get(highSchoolKey);

		assert (elementaryFinalData != null) : "null elementaryFinalData";
		assert (elementaryInitialData != null) : "null elementaryInitialData";
		assert (highSchoolData != null) : "null highSchoolData";

		ideb = new Ideb[highSchoolData.size()];
		for (int i = 0; i < ideb.length; i++) {
			ideb[i] = new Ideb();
			ideb[i].setState(this);
			if(i < ideb.length - 1) {
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

		elementarydata = information.get(namesOfIndicative[0]);
		highSchoolData = information.get(namesOfIndicative[1]);

		assert (elementarydata != null) : "null elementarydata";
		assert (highSchoolData != null) : "null highSchoolData";

		Grade readGrade[] = new Grade[highSchoolData.size()];

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
			//Do nothing
		} else {
			this.studentGradesPerClass = emptyGrade();
		}
		return this.studentGradesPerClass;
	}

	public void setStudentGradesPerClass(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.studentGradesPerClass = this.setGrade(information, namesOfIndicative);
	}

	public Grade[] getGradeClassHours() {
		if (this.gradeClassHours != null) {
			//Do nothing
		} else {
			this.gradeClassHours = emptyGrade();
		}
		return this.gradeClassHours;
	}

	public void setGradeClassHours(HashMap<String, ArrayList<String[]>> information, String[] namesOfIndicative) {
		assert (information != null) : "null information";
		assert (namesOfIndicative != null) : "null namesOfIndicative";

		this.gradeClassHours = this.setGrade(information, namesOfIndicative);
	}

	public Grade[] getAgeGradeDistortionRate() {
		if (this.ageGradeDistortionRate != null) {
			//Do nothing
		} else {
			this.ageGradeDistortionRate = emptyGrade();
		}
		return this.ageGradeDistortionRate;
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
			return unnamed;
		}

	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateAbbreviation() {
		if (this.stateAbbreviation != null) {
			return this.stateAbbreviation;
		} else {
			return noAbbreviation;
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

		String[] gradeClassHoursIndicatives = {elementaryClassHours, highSchoolClassHours};
		String[] studentGradesPerClassIndicatives = {elementaryStudentsPerClass, highSchoolStudentsPerClass};
		String[] scienceAndThecnologyProjectsIndicatives = {numberOfProjects, valueInvested};
		String[] primeirosProjetosIndicatives = {primeirosProjetosProgram, primeirosProjetosProgramValues};
		String[] apoioCnpqProjectIndicatives = {cnpqResearchSupportProgram, cnpqResearchSupportProgramValues};
		String[] jovensPesquisadoresProjectIndicatives = {youngResearchersProgram, youngResearchersProgramValues};
		String[] inctProjectsIndicatives = {inctProjects, inctProjectsValues};
		String[] ageGradeDistortionRate = {elementaryDistortionRate, highSchoolDistortionRate};
		String[] educationalAchievementRate = {elementaryApprovalRate, highSchoolApprovalRate};
		String[] schoolDropoutRate = {elementaryDropoutRate, highSchoolDropoutRate};

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
		Grade emptyGrade[] = {new Grade(0,0)};
		emptyGrade[0].setGradeYear(0);

		return emptyGrade;
	}

	public Project[] emptyProject() {
		Project empty[] = {new Project()};
		empty[0].setProjectQuantity(0);
		empty[0].setProjectValue(0);
		empty[0].setProjectYear(0);

		return empty;
	}

	public Census[] emptyCensus() {
		Census empty[] = {new Census(0.0, 0.0, 0.0, 0.0, 0.0)};
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
