package com.mdsgpp.eef.model;

import java.util.ArrayList;
import java.util.HashMap;


public class State {

	private String stateName; 													//done
	private String stateAbbreviation; 											//done
	private double percentualCollaborationWithPIB[]; 							//done
	private int statePopulation; 												//done
	private Census census[];//controle;xml;declarados;inicializado; 			//done
	private Ideb idebs[]; //Índice de Desenvolvimento de Educação Básica		//done
	private Grade studentGradesPerClass[];//controle;xml;declarados;inicializado; //done
	private Grade mediaHorasAula[];//controle;xml;declarados;inicializado;
	private Projeto projetosCienciaTecnologia[];
	private Projeto primeirosProjetos[];
	private Projeto projetoInct[];
	private Projeto projetosApoioCnpq[];
	private Projeto projetoJovensPesquisadores[];
	private Grade taxaDistorcaoIdadeSerie[]; //controle;xml;declarados;inicializado;
	private Grade taxaDeAproveitamento[]; //controle;duvida: aprovaeao ou aproveitamento?;xml;declarados;inicializado;
	private Grade taxaDeAbandono[];//controle;xml;declaradoa;inicializado;

	public State(){
	}

	public State(String stateName, String stateAbbreviation, HashMap<String, ArrayList<String[]>> informacoes){
		this.stateName = stateName;
		this.stateAbbreviation = stateAbbreviation;

		preencheDados(informacoes);
	}

	public Census[] getCensuss() {
		return census;
	}

	public void setCensuss(HashMap<String, ArrayList<String[]>> informacoes) {
		ArrayList<String[]> dadosFundamentalFinais;
		ArrayList<String[]> dadosFundamentalIniciais;
		ArrayList<String[]> dadosMedio;
		ArrayList<String[]> dadosEjaMedio;
		ArrayList<String[]> dadosEjaFundamental;
		Census census[] = null;

		dadosFundamentalFinais = informacoes.get("census_anos_finais");
		dadosFundamentalIniciais = informacoes.get("census_anos_iniciais");
		dadosMedio = informacoes.get("census_ensino_medio");
		dadosEjaMedio = informacoes.get("census_eja_medio");
		dadosEjaFundamental = informacoes.get("census_eja_fundamental");

		census = new Census[dadosMedio.size()];
		for (int i=0; i<census.length; i++) {
			census[i] = new Census();
			census[i].setState(this);
			census[i].setAno(Integer.parseInt(dadosMedio.get(i)[0]));
			census[i].setAnosFinaisFundamental(Double.parseDouble(dadosFundamentalFinais.get(i)[1].replaceAll("\\.", "")));
			census[i].setEnsinoMedio(Double.parseDouble(dadosMedio.get(i)[1].replaceAll("\\.", "")));
			census[i].setAnosIniciaisFundamental(Double.parseDouble(dadosFundamentalIniciais.get(i)[1].replaceAll("\\.", "")));
			census[i].setMedioEJA(Double.parseDouble(dadosEjaMedio.get(i)[1].replaceAll("\\.", "")));
			census[i].setFundamentalEJA(Double.parseDouble(dadosEjaFundamental.get(i)[1].replaceAll("\\.", "")));
		}

		this.census = census;
	}

	public double[] getPercentualCollaborationWithPIB() {
		if (percentualCollaborationWithPIB == null) {
			double[] vazio = {0};
			return vazio;
		}

		return percentualCollaborationWithPIB;
	}

	public void setPercentualCollaborationWithPIB(HashMap<String, ArrayList<String[]>> informacoes) {

		double percentualCollaborationWithPIB[];
		ArrayList<String[]> dados = informacoes.get("participacao_estadual_pib");

		percentualCollaborationWithPIB = new double[dados.size()];
		for (int i=0; i<dados.size(); i++) {
			percentualCollaborationWithPIB[i] = Double.parseDouble(dados.get(i)[1].replaceAll(",", "."));
		}

		this.percentualCollaborationWithPIB = percentualCollaborationWithPIB;
	}

	public int getstatePopulation() {
		return statePopulation;
	}

	public void setStatePopulation(HashMap<String, ArrayList<String[]>> informacoes) {

		ArrayList<String[]> dados = informacoes.get("populacao");
		this.statePopulation = Integer.parseInt(dados.get(0)[1].replaceAll(",", "."));

	}

	public Ideb[] getIdebs() {
		if (idebs == null) {
			Ideb vazio[] = { new Ideb(0,0,0) }; //move initialization to constructor
			return vazio;
		}

		return idebs;
	}

	public void setIdebs(HashMap<String, ArrayList<String[]>> informacoes) {
		ArrayList<String[]> dadosFundamentalFinais;
		ArrayList<String[]> dadosFundamentalIniciais;
		ArrayList<String[]> dadosMedio;
		Ideb ideb[] = null;

		dadosFundamentalFinais = informacoes.get("5a_8a");
		dadosFundamentalIniciais = informacoes.get("series_iniciais");
		dadosMedio = informacoes.get("ensino_medio");

		ideb = new Ideb[dadosMedio.size()];
		for (int i=0; i<ideb.length; i++) {
			ideb[i] = new Ideb();
			ideb[i].setState(this);
			if(i<ideb.length-1){
				ideb[i].setAno(Integer.parseInt(dadosMedio.get(i)[0]));
			}
			ideb[i].setFundamental(Double.parseDouble(dadosFundamentalFinais.get(i)[1].replaceAll(",", ".")));
			ideb[i].setMedio(Double.parseDouble(dadosMedio.get(i)[1].replaceAll(",", ".")));
			ideb[i].setSeriesIniciais(Double.parseDouble(dadosFundamentalIniciais.get(i)[1].replaceAll(",", ".")));
		}

		this.idebs = ideb;
	}

	public Grade[] retornaMediaVazia() {
		Grade vazio[] = { new Grade(0,0) };
		vazio[0].setAno(0);

		return vazio;
	}

	public Grade[] setMedia(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		ArrayList<String[]> dadosFundamental;
		ArrayList<String[]> dadosMedio;
		Grade mediaLida[] = null;

		dadosFundamental = informacoes.get(nomesIndicativo[0]);
		dadosMedio = informacoes.get(nomesIndicativo[1]);

		mediaLida = new Grade[dadosMedio.size()];
		for (int i=0; i<mediaLida.length; i++) {
			mediaLida[i] = new Grade();
			mediaLida[i].setState(this);
			mediaLida[i].setAno(Integer.parseInt(dadosMedio.get(i)[0]));
			mediaLida[i].setEnsinoFundamental(Double.parseDouble(dadosFundamental.get(i)[1].replaceAll(",", ".")));
			mediaLida[i].setEnsinoMedio(Double.parseDouble(dadosMedio.get(i)[1].replaceAll(",", ".")));
		}

		return mediaLida;
	}

	public Grade[] getStudentGradesPerClass() {
		if (studentGradesPerClass == null) {
			return retornaMediaVazia();
		}

		return studentGradesPerClass;
	}

	public void setStudentGradesPerClass(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.studentGradesPerClass = this.setMedia(informacoes, nomesIndicativo);
	}

	public Grade[] getMediaHorasAula() {
		if (mediaHorasAula == null) {
			return retornaMediaVazia();
		}

		return mediaHorasAula;
	}

	public void setMediaHorasAula(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.mediaHorasAula = this.setMedia(informacoes, nomesIndicativo);
	}

	public Grade[] getTaxaDistorcaoIdadeSerie() {
		if (taxaDistorcaoIdadeSerie == null) {
			return retornaMediaVazia();
		}

		return taxaDistorcaoIdadeSerie;
	}

	public void setTaxaDistorcaoIdadeSerie(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.taxaDistorcaoIdadeSerie = this.setMedia(informacoes, nomesIndicativo);
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

	public Projeto[] retornaProjetoVazio() {
		Projeto vazio[] = { new Projeto() };
		vazio[0].setQuantidade(0);
		vazio[0].setValor(0);
		vazio[0].setAno(0);

		return vazio;
	}

	public Projeto[] setProjetos(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		ArrayList<String[]> dadosValoresInvestidos = null;
		ArrayList<String[]> dadosQtdProjetos = null;
		Projeto projetosLido[] = null;

		if(informacoes.containsKey(nomesIndicativo[0])){
			dadosQtdProjetos = informacoes.get(nomesIndicativo[0]);
			projetosLido = new Projeto[dadosQtdProjetos.size()];
			dadosValoresInvestidos = informacoes.get(nomesIndicativo[1]);

		}

		for (int i=0; projetosLido!=null && i<projetosLido.length; i++) {
			projetosLido[i] = new Projeto();
			projetosLido[i].setState(this);
			if(i<projetosLido.length-1){
				projetosLido[i].setAno(Integer.parseInt(dadosQtdProjetos.get(i)[0]));
			}
			projetosLido[i].setQuantidade(Integer.parseInt(dadosQtdProjetos.get(i)[1].replaceAll(",", ".")));
			projetosLido[i].setValor(Double.parseDouble(dadosValoresInvestidos.get(i)[1].replaceAll(",", ".")));
		}

		return projetosLido;
	}

	public Projeto[] getProjetosCienciaTecnologia() {
		if(projetosCienciaTecnologia == null){
			return retornaProjetoVazio();
		}

		return projetosCienciaTecnologia;
	}

	public void setProjetosCienciaTecnologia(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.projetosCienciaTecnologia = this.setProjetos(informacoes, nomesIndicativo);
	}

	public Projeto[] getPrimeirosProjetos() {
		if (primeirosProjetos == null) {
			return retornaProjetoVazio();
		}

		return primeirosProjetos;
	}

	public void setPrimeirosProjetos(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.primeirosProjetos = this.setProjetos(informacoes, nomesIndicativo);
	}

	public Projeto[] getProjetosInct() {
		if (projetoInct == null) {
			return retornaProjetoVazio();
		}

		return projetoInct;
	}

	public void setProjetosInct(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.projetoInct = this.setProjetos(informacoes, nomesIndicativo);
	}

	public Projeto[] getProjetosApoioCnpq() {
		if (projetosApoioCnpq == null) {
			return retornaProjetoVazio();
		}

		return projetosApoioCnpq;
	}

	public void setProjetosApoioCnpq(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.projetosApoioCnpq = this.setProjetos(informacoes, nomesIndicativo);
	}

	public Projeto[] getProjetoJovensPesquisadores() {
		if (projetoJovensPesquisadores == null) {
			return retornaProjetoVazio();
		}

		return projetoJovensPesquisadores;
	}

	public void setProjetoJovensPesquisadores(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.projetoJovensPesquisadores = this.setProjetos(informacoes, nomesIndicativo);
	}

	public Grade[] getTaxaDeAproveitamento() {
		if (taxaDeAproveitamento == null) {
			return retornaMediaVazia();
		}

		return taxaDeAproveitamento;
	}

	public void setTaxaDeAproveitamento(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.taxaDeAproveitamento = this.setMedia(informacoes, nomesIndicativo);
	}

	public Grade[] getTaxaDeAbandono() {
		if (taxaDeAbandono == null) {
			return retornaMediaVazia();
		}

		return taxaDeAbandono;
	}

	public void setTaxaDeAbandono(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.taxaDeAbandono = this.setMedia(informacoes, nomesIndicativo);
	}

	public void preencheDados(HashMap<String, ArrayList<String[]>> informacoes) {
		String[] indicativosMediaHorasAula = { "horas_aula_ensino_fundamental", "horas_aula_ensino_medio" };
		String[] indicativosMediaAlunosPorTurma = { "alunos_por_turma_ensino_fundamental", "alunos_por_turma_ensino_medio" };
		String[] indicativosProjetosCienciaTecnologia = { "numero_projetos", "valor_investido" };
		String[] indicativosPrimeirosProjetos = { "programa_primeiros_projetos", "valores_programa_primeiros_projetos" };
		String[] indicativosApoioCnpq = { "projetos_apoio_pesquisa_cnpq", "valores_projetos_apoio_pesquisa_cnpq" };
		String[] indicativosJovensPesquisadores = { "jovens_pesquisadores", "valores_jovens_pesquisadores" };
		String[] indicativosProjetosInct = { "projetos_inct", "valores_projetos_inct" };
		String[] taxaDistorcaoIdadeSerie = { "taxa_distorcao_fundamental", "taxa_distorcao_ensino_medio" };
		String[] taxaDeAproveitamento = { "taxa_aprovacao_fundamental", "taxa_aprovacao_medio" };
		String[] taxaDeAbandono = { "taxa_abandono_fundamental", "taxa_abandono_medio" };

		this.setStatePopulation(informacoes);
		this.setCensuss(informacoes);
		this.setIdebs(informacoes);
		this.setPercentualCollaborationWithPIB(informacoes);

		this.setProjetosInct(informacoes, indicativosProjetosInct);
		this.setProjetoJovensPesquisadores(informacoes, indicativosJovensPesquisadores);
		this.setProjetosApoioCnpq(informacoes, indicativosApoioCnpq);
		this.setPrimeirosProjetos(informacoes, indicativosPrimeirosProjetos);
		this.setProjetosCienciaTecnologia(informacoes, indicativosProjetosCienciaTecnologia);

		this.setStudentGradesPerClass(informacoes, indicativosMediaAlunosPorTurma);
		this.setMediaHorasAula(informacoes, indicativosMediaHorasAula);
		this.setTaxaDistorcaoIdadeSerie(informacoes, taxaDistorcaoIdadeSerie);
		this.setTaxaDeAproveitamento(informacoes, taxaDeAproveitamento);
		this.setTaxaDeAbandono(informacoes, taxaDeAbandono);

	}

}
