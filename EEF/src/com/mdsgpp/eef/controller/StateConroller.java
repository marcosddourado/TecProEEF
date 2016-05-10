package com.mdsgpp.eef.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;

import com.mdsgpp.eef.model.State;

public class StateConroller {

	private static StateConroller instance;
	private Context context;
	private HashMap<String, String> stateInformations;
	private HashMap<String, ArrayList<String[]>> parseInformations;
	private DecimalFormat dfValue = new DecimalFormat("#,##0.00");
	private DecimalFormat dfPopulation = new DecimalFormat("#,###");
	private DecimalFormat dfPercentage = new DecimalFormat("#.##");

	public StateConroller(Context contextActivity) {
		this.context = contextActivity;
		this.stateInformations = new HashMap<String, String>();
		this.parseInformations = new HashMap<String, ArrayList<String[]>>();
	}

	public static StateConroller getInstance(Context contextActivity) {
		if (instance == null)
			instance = new StateConroller(contextActivity);
		return instance;
	}

	public State grabState(int position) throws IOException {
		parseInformations = ParseController.getInstance(context).getInformations(
				position);

		String nomeSigla[] = parseInformations.get("nome_e_sigla").get(0);
		State state = new State(nomeSigla[0], nomeSigla[1], parseInformations);

		writeStateWithAllTheInformations(state);

		return state;

	}
	
	public HashMap<String, String> readState(int position) throws IOException {
		parseInformations = ParseController.getInstance(context).getInformations(
				position);

		String nomeSigla[] = parseInformations.get("nome_e_sigla").get(0);
		State state = new State(nomeSigla[0], nomeSigla[1], parseInformations);

		writeState(state);

		return this.stateInformations;

	}

	public HashMap<String, String> readCompleteState(int position)
			throws IOException {
		parseInformations = ParseController.getInstance(context).getInformations(
				position);

		String nomeSigla[] = parseInformations.get("nome_e_sigla").get(0);
		State state = new State(nomeSigla[0], nomeSigla[1], parseInformations);

		writeStateWithAllTheInformations(state);

		return this.stateInformations;

	}

	private void writeState(State state) {

		FillNameAbbreviationAndPopulation(state);

		this.stateInformations
				.put("percentual_participacao_pib",
						dfPercentage.format(state
								.getPercentageCollaborationWithPIB()[state
								.getPercentageCollaborationWithPIB().length - 1])
								+ "%");
		this.stateInformations.put(
				"projetos_ciencia_tecnologia",
				"Quantidade: "
						+ state.getScienceAndThecnologyProjects()[state
						.getScienceAndThecnologyProjects().length - 1]
						.getProjectAmount() + " projetos");
		this.stateInformations
				.put("valor_ciencia_tecnologia",
						"Valor investido: R$ "
								+ dfValue.format(state
								.getScienceAndThecnologyProjects()[state
								.getScienceAndThecnologyProjects().length - 1]
								.getProjectValue()) + " (em mil)");
		this.stateInformations.put(
				"ideb_elementary_final",
				"Ensino Fundamental (series finais): "
						+ dfPercentage.format(state.getIdebs()[state
								.getIdebs().length - 1].getElementarySchool()));
		this.stateInformations.put(
				"ideb_ensino_high_school",
				"Ensino Medio: "
						+ dfPercentage.format(state.getIdebs()[state
								.getIdebs().length - 1].getHighSchool()) + "");
		this.stateInformations.put(
				"ideb_elementary_inicial",
				"Ensino Fundamental (Series iniciais): "
						+ dfPercentage.format(state.getIdebs()[state
								.getIdebs().length - 1].getInitialGrades())
						+ "");
		this.stateInformations.put(
				"quantidade_primeiros_projetos",
				"Quantidade: "
						+ state.getFirstProjects()[state
								.getFirstProjects().length - 1]
								.getProjectAmount() + " projetos");
		this.stateInformations.put(
				"valor_primeiros_projetos",
				"Valor investido: R$ "
						+ dfValue.format(state.getFirstProjects()[state
								.getFirstProjects().length - 1].getProjectValue())
						+ " (em mil)");
		this.stateInformations.put(
				"quantidade_projeto_cnpq",
				"Quantidade: "
						+ state.getApoioCnpqProject()[state
								.getApoioCnpqProject().length - 1]
								.getProjectAmount() + " projetos");
		this.stateInformations.put(
				"valor_projetos_cnpq",
				"Valor investido: R$ "
						+ dfValue.format(state.getApoioCnpqProject()[state
								.getApoioCnpqProject().length - 1].getProjectValue())
						+ " (em mil)");
		this.stateInformations.put(
				"quantidade_projeto_jovens_pesquisadores",
				"Quantidade: "
						+ state.getJovensPesquisadoresProject()[state
								.getJovensPesquisadoresProject().length - 1]
								.getProjectAmount() + " projetos");
		this.stateInformations
				.put("valor_projetos_jovens_pesquisadores",
						"Valor investido: R$ "
								+ dfValue.format(state
										.getJovensPesquisadoresProject()[state
										.getJovensPesquisadoresProject().length - 1]
										.getProjectValue()) + " (em mil)");
		this.stateInformations
				.put("quantidade_projetos_inct",
						"Quantidade: "
								+ state.getProjectsInct()[state
										.getProjectsInct().length - 1]
										.getProjectAmount() + " projetos");
		this.stateInformations.put(
				"valor_projetos_inct",
				"Valor investido: R$ "
						+ dfValue.format(state.getProjectsInct()[state
								.getProjectsInct().length - 1].getProjectValue())
						+ " (em mil)");

		this.stateInformations.put(
				"alunos_por_turma_ensino_elementary",
				"Quantidade media de alunos por turma (Fundamental): "
						+ dfValue.format(state.getStudentGradesPerClass()[state
								.getStudentGradesPerClass().length - 1]
								.getElementarySchoolGrade()));
		this.stateInformations.put(
				"alunos_por_turma_ensino_high_school",
				"Quantidade media de alunos por turma (Medio): "
						+ dfValue.format(state.getStudentGradesPerClass()[state
								.getStudentGradesPerClass().length - 1]
								.getHighSchoolGrade()));
		this.stateInformations.put(
				"horas_aula_ensino_elementary",
				"Quantidade media de horas de aula(Fundamental): "
						+ dfValue.format(state.getGradeClassHours()[state
								.getGradeClassHours().length - 1]
								.getElementarySchoolGrade()));
		this.stateInformations.put(
				"horas_aula_ensino_high_school",
				"Quantidade media de horas de aula (Medio): "
						+ dfValue.format(state.getGradeClassHours()[state
								.getGradeClassHours().length - 1]
								.getHighSchoolGrade()));
		this.stateInformations.put(
				"distortion_rate_elementary",
				"Quantidade de Distoreeo da Idade(Fundamental): "
						+ dfPercentage.format(state
								.getAgeGradeDistortionRate()[state
								.getAgeGradeDistortionRate().length - 1]
								.getElementarySchoolGrade()));
		this.stateInformations.put(
				"distortion_rate_high_school",
				"Quantidade de Distoreeo da Idade (Medio): "
						+ dfPercentage.format(state
								.getAgeGradeDistortionRate()[state
								.getAgeGradeDistortionRate().length - 1]
								.getHighSchoolGrade()));
		this.stateInformations
				.put("taxa_aprovacao_elementary",
						"Taxa de Aprovaeeo (Fundamental): "
								+ dfPercentage.format(state
										.getEducationalAchievementRate()[state
										.getEducationalAchievementRate().length - 1]
										.getElementarySchoolGrade()));
		this.stateInformations
				.put("taxa_aprovacao_high_school",
						"Taxa de Aprovaeeo (Medio): "
								+ dfPercentage.format(state
										.getEducationalAchievementRate()[state
										.getEducationalAchievementRate().length - 1]
										.getHighSchoolGrade()));
		this.stateInformations
				.put("taxa_abandono_elementary",
						"Taxa de Abandono (Fundamental): "
								+ dfPercentage.format(state
										.getSchoolDropoutRate()[state
										.getSchoolDropoutRate().length - 1]
										.getElementarySchoolGrade()));
		this.stateInformations
				.put("taxa_abandono_high_school",
						"Taxa de Abandono (Medio): "
								+ dfPercentage.format(state
										.getSchoolDropoutRate()[state
										.getSchoolDropoutRate().length - 1]
										.getHighSchoolGrade()));
		this.stateInformations.put(
				"censo_anos_iniciais_elementary",
				"Censo Anos Iniciais (Fundamental): "
						+ dfPercentage.format(state.getCensus()[state
								.getCensus().length - 1]
								.getInitialElementarySchoolYears()));
		this.stateInformations.put(
				"censo_anos_finais_elementary",
				"Censo Anos Finais (Fundamental): "
						+ dfPercentage.format(state.getCensus()[state
								.getCensus().length - 1]
								.getInitialElementarySchoolYears()));
		this.stateInformations.put(
				"censo_ensino_high_school",
				"Censo Ensino Medio: "
						+ dfPercentage.format(state.getCensus()[state
								.getCensus().length - 1].getHighSchool()));
		this.stateInformations.put(
				"censo_eja_elementary",
				"Censo EJA (Fundamental): "
						+ dfPercentage.format(state.getCensus()[state
								.getCensus().length - 1].getElementarySchoolEJA()));
		this.stateInformations.put(
				"censo_eja_high_school",
				"Censo EJA (Medio): "
						+ dfPercentage.format(state.getCensus()[state
								.getCensus().length - 1].getHighSchoolEJA()));

	}

	private void writeStateWithAllTheInformations(State state) {
		String temp = "";

		FillNameAbbreviationAndPopulation(state);

		for (int i = 0, ano = 1995; i < state.getPercentageCollaborationWithPIB().length; i++, ano++)
			temp += ano
					+ ": "
					+ dfPercentage.format(state
							.getPercentageCollaborationWithPIB()[i]) + "%\n";
		this.stateInformations.put("percentual_participacao_pib", temp);
		temp = "";

		for (int i = 0, ano = 2003; i < state.getScienceAndThecnologyProjects().length-1; i++, ano++) {
			temp += ano
					+ ": "
					+ "Quantidade: "
					+ state.getScienceAndThecnologyProjects()[i].getProjectAmount()
					+ " projetos\n"
					+ "\t\t "
					+ "  Valor investido: R$ "
					+ dfValue.format(state.getScienceAndThecnologyProjects()[i]
							.getProjectValue()) + " (em mil)\n\n";
		}
		this.stateInformations.put("projetos_ciencia_tecnologia", temp);
		temp = "";

		for (int i = 0, ano = 2005; i < state.getIdebs().length; i++, ano += 2) {
			temp += ano
					+ ": "
					+ "Ensino Fundamental (series finais): "
					+ dfPercentage.format(state.getIdebs()[i]
							.getElementarySchool())
					+ "\n"
					+ "\t\t  "
					+ "Ensino Medio: "
					+ dfPercentage.format(state.getIdebs()[i].getHighSchool())
					+ "\n"
					+ "\t\t  "
					+ "Ensino Fundamental (Series iniciais): "
					+ dfPercentage.format(state.getIdebs()[i]
							.getInitialGrades()) + "\n\n";

		}
		this.stateInformations.put("ideb", temp);
		temp = "";

		for (int i = 0, ano = 2007; i < state.getFirstProjects().length-1; i++, ano++) {
			temp += ano
					+ ": "
					+ "Quantidade: "
					+ state.getFirstProjects()[i].getProjectAmount()
					+ " projetos\n"
					+ "\t\t  "
					+ "Valor investido: R$ "
					+ dfValue.format(state.getFirstProjects()[state
							.getFirstProjects().length - 1].getProjectValue())
					+ " (em mil)\n\n";
		}
		this.stateInformations.put("primeiros_projetos", temp);
		temp = "";

		for (int i = 0, ano = 2001; i < state.getApoioCnpqProject().length-1; i++, ano++) {
			temp += ano
					+ ": "
					+ "Quantidade: "
					+ state.getApoioCnpqProject()[i].getProjectAmount()
					+ " projetos\n"
					+ "\t\t  "
					+ "Valor investido: R$ "
					+ dfValue.format(state.getApoioCnpqProject()[i]
							.getProjectValue()) + " (em mil)\n\n";
		}
		this.stateInformations.put("cnpq", temp);
		temp = "";

		for (int i = 0, ano = 2005; i < state.getJovensPesquisadoresProject().length-1; i++, ano++) {
			temp += ano
					+ ": "
					+ "Quantidade: "
					+ state.getJovensPesquisadoresProject()[i].getProjectAmount()
					+ " projetos\n"
					+ "\t\t  "
					+ "Valor investido: R$ "
					+ dfValue.format(state.getJovensPesquisadoresProject()[i]
							.getProjectValue()) + " (em mil)\n\n";
		}
		this.stateInformations.put("jovens_pesquisadores", temp);
		temp = "";

		for (int i = 0, ano = 2008; i < state.getProjectsInct().length-1; i++, ano++) {
			temp += ano + ": " + "Quantidade: "
					+ state.getProjectsInct()[i].getProjectAmount()
					+ " projetos\n" + "\t\t  " + "Valor investido: R$ "
					+ dfValue.format(state.getProjectsInct()[i].getProjectValue())
					+ " (em mil)\n\n";
		}
		this.stateInformations.put("projetos_inct", temp);
		temp = "";

		for (int i = 0, ano = 2007; i < state.getStudentGradesPerClass().length; i++, ano++) {
			temp += ano
					+ ": "
					+ "Quantidade media de alunos por turma (Fundamental): "
					+ dfValue.format(state.getStudentGradesPerClass()[i]
							.getElementarySchoolGrade())
					+ "\n"
					+ "Quantidade media de alunos por turma (Medio): "
					+ dfValue.format(state.getStudentGradesPerClass()[i]
							.getHighSchoolGrade()) + "\n\n";

		}
		this.stateInformations.put("alunos_por_turma_ensino_high_school", temp);
		temp = "";

		for (int i = 0, ano = 2007; i < state.getStudentGradesPerClass().length; i++, ano++) {
			temp += ano
					+ ": "
					+ "Quantidade media de horas de aula(Fundamental): "
					+ dfValue.format(state.getGradeClassHours()[state
							.getGradeClassHours().length - 1]
							.getElementarySchoolGrade())
					+ "\n"
					+ "Quantidade media de horas de aula (Medio): "
					+ dfValue.format(state.getGradeClassHours()[state
							.getGradeClassHours().length - 1].getHighSchoolGrade())
					+ "\n\n";
		}
		this.stateInformations.put("horas_aula_ensino_high_school", temp);
		temp = "";

		for (int i = 0, ano = 2006; i < state.getAgeGradeDistortionRate().length; i++, ano++) {
			temp += ano
					+ ": "
					+ "Quantidade de Distoreeo da Idade(Fundamental): "
					+ dfPercentage
							.format(state.getAgeGradeDistortionRate()[i]
									.getElementarySchoolGrade())
					+ "\n"
					+ "Quantidade de Distoreeo da Idade (Medio): "
					+ dfPercentage
							.format(state.getAgeGradeDistortionRate()[i]
									.getHighSchoolGrade()) + "\n\n";
		}
		this.stateInformations.put("distortion_rate", temp);
		temp = "";

		for (int i = 0, ano = 2007; i < state.getEducationalAchievementRate().length; i++, ano++) {
			temp += ano
					+ ": "
					+ "Taxa de Aprovaeeo (Fundamental): "
					+ dfPercentage.format(state.getEducationalAchievementRate()[i]
							.getElementarySchoolGrade())
					+ "\n"
					+ "\t\t  "
					+ "Taxa de Aprovaeeo (Medio): "
					+ dfPercentage.format(state.getEducationalAchievementRate()[i]
							.getHighSchoolGrade()) + "\n\n";
		}
		this.stateInformations.put("taxa_aprovacao", temp);
		temp = "";

		for (int i = 0, ano = 2007; i < state.getSchoolDropoutRate().length; ano++, i++) {
			temp += ano
					+ ": "
					+ "Taxa de Abandono (Fundamental): "
					+ dfPercentage.format(state.getSchoolDropoutRate()[i]
							.getElementarySchoolGrade())
					+ "\n"
					+ "\t\t  "
					+ "Taxa de Abandono (Medio): "
					+ dfPercentage.format(state.getSchoolDropoutRate()[i]
							.getHighSchoolGrade()) + "\n\n";
		}
		this.stateInformations.put("taxa_abandono", temp);
		temp = "";

		for (int i = 0, ano = 2010; i < state.getCensus().length; ano++, i++) {
			temp += ano
					+ ": "
					+ "Censo Anos Iniciais (Fundamental): "
					+ dfPercentage.format(state.getCensus()[i]
							.getInitialElementarySchoolYears())
					+ "\n"
					+ "\t\t  "
					+ "Censo Anos Finais (Fundamental): "
					+ dfPercentage.format(state.getCensus()[i]
							.getInitialElementarySchoolYears())
					+ "\n"
					+ "\t\t  "
					+ "Censo Ensino Medio: "
					+ dfPercentage.format(state.getCensus()[i]
							.getHighSchool())
					+ "\n"
					+ "\t\t  "
					+ "Censo EJA (Fundamental): "
					+ dfPercentage.format(state.getCensus()[i]
							.getElementarySchoolEJA())
					+ "\n"
					+ "\t\t  "
					+ "Censo EJA (Medio): "
					+ dfPercentage.format(state.getCensus()[state
							.getCensus().length - 1].getHighSchoolEJA()) + "\n\n";
		}
		this.stateInformations.put("censo", temp);

	}

	private void FillNameAbbreviationAndPopulation(State state) {
		this.stateInformations.clear();

		this.stateInformations.put("sigla", state.getStateAbbreviation());
		this.stateInformations.put("nome", state.getStateName());
		;
		this.stateInformations.put("populacao",
				dfPopulation.format(state.getStatePopulation()) + " habitantes");
	}

}
