package com.mdsgpp.eef.views;

import java.io.IOException;
import java.util.ArrayList;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateConroller;
import com.mdsgpp.eef.model.State;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ChooseIndicativeWithLineGraphScreen extends Activity{
	
	private State state;
	private ArrayList<Float> historico = new ArrayList<Float>();

	private String titulo, indicativo;
	private int positionHistorico;
	private Intent receivedIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
		
		receivedIntent = getIntent();
		positionHistorico = receivedIntent.getIntExtra("ESTADO", 0);

		state = capturaInformacoesEstado();
		Log.i("position tela escolhe indicativo grafico", positionHistorico+"");
		
		// Populacao comeea selecionada
		titulo = "Populaeeo";
		indicativo = "populacao";
		historico.clear();
		historico.add((float) state.getStatePopulation());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.sobre:
			loadAboutScreen();
			break;
		case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        break;
		default:
			break;
		}
		
    	return true;
	}
	
	public void loadAboutScreen() {
		Intent intent = new Intent(this, ChooseIndicativeWithCompareGraphAboutScreen.class);
    	startActivity(intent);
	}	

	public void onRadioButtonClicked(View view) {

		int max, tamanho;
		
		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investimento:
			titulo = "Projetos de Pesquisa Apoio CNPq (R$)";
			indicativo = "cnpq";
			historico.clear();
			tamanho = state.getApoioCnpqProject().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getApoioCnpqProject()[i].getProjectValue());
			break;
			
		case R.id.radio_apoio_cnpq_qtd:
			titulo = "Projetos de Pesquisa Apoio CNPq (Qtd.)";
			indicativo = "cnpq";
			historico.clear();
			tamanho = state.getApoioCnpqProject().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getApoioCnpqProject()[i]
						.getQuantidade());
			break;
			
		case R.id.radio_difusao_tecnologica_investimento:
			titulo = "Projeto de Difuseo Tecnolegica (R$)";
			indicativo = "projetos_ciencia_tecnologia";
			historico.clear();
			tamanho = state.getScienceAndThecnologyProjects().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getScienceAndThecnologyProjects()[i]
						.getProjectValue());
			break;
			
		case R.id.radio_difusao_tecnologica_qtd:
			titulo = "Projeto de Difuseo Tecnolegica (Qtd.)";
			indicativo = "projetos_ciencia_tecnologia";
			historico.clear();
			tamanho = state.getScienceAndThecnologyProjects().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getScienceAndThecnologyProjects()[i]
						.getQuantidade());
			break;
			
		case R.id.radio_ideb_fundamental_finais:
			titulo = "IDEB do Ensino Fundamental (Series Finais)";
			indicativo = "ideb";
			historico.clear();
			for (int i = 0; i < state.getIdebs().length; i++)
				historico.add((float) state.getIdebs()[i].getFundamental());
			break;
			
		case R.id.radio_ideb_fundamental_iniciai:
			titulo = "IDEB do Ensino Fundamental (Series Iniciais)";
			indicativo = "ideb";
			historico.clear();
			for (int i = 0; i < state.getIdebs().length; i++)
				historico.add((float) state.getIdebs()[i].getSeriesIniciais());
			break;
			
		case R.id.radio_ideb_medio:
			titulo = "IDEB do Ensino Medio";
			indicativo = "ideb";
			historico.clear();
			for (int i = 0; i < state.getIdebs().length; i++)
				historico.add((float) state.getIdebs()[i].getMedio());
			break;
			
		case R.id.radio_jovens_pesquisadores_investimento:
			titulo = "Jovens pesquisadores (R$)";
			indicativo = "jovens_pesquisadores";
			historico.clear();
			tamanho = state.getJovensPesquisadoresProject().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getJovensPesquisadoresProject()[i]
						.getProjectValue());
			break;

		case R.id.radio_jovens_pesquisadores_qtd:
			titulo = "Jovens pesquisadores (Qtd.)";
			indicativo = "jovens_pesquisadores";
			historico.clear();
			tamanho = state.getJovensPesquisadoresProject().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getJovensPesquisadoresProject()[i]
						.getQuantidade());
			break;

		case R.id.radio_pib:
			titulo = "Participaeeo Estadual no PIB (%)";
			indicativo = "percentual_participacao_pib";
			historico.clear();
			for (int i = 0; i < state.getPercentageCollaborationWithPIB().length; i++)
				historico.add((float) state.getPercentageCollaborationWithPIB()[i]);
			break;

		case R.id.radio_populacao:
			titulo = "Populaeeo";
			indicativo = "populacao";
			historico.clear();
			historico.add((float) state.getStatePopulation());
			Log.i("tamanho hsitorico", ""+historico.size());
			break;

		case R.id.radio_primeiros_projetos_investimento:
			titulo = "Programa Primeiros Projetos (R$)";
			indicativo = "primeiros_projetos";
			historico.clear();
			tamanho = state.getFirstProjects().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getFirstProjects()[i]
						.getProjectValue());
			break;

		case R.id.radio_primeiros_projetos_qtd:
			titulo = "Programa Primeiros Projetos (Qtd.)";
			indicativo = "primeiros_projetos";
			historico.clear();
			tamanho = state.getFirstProjects().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getFirstProjects()[i]
						.getQuantidade());
			break;

		case R.id.radio_projetos_inct_investimento:
			titulo = "Projetos INCT (R$)";
			indicativo = "projetos_inct";
			historico.clear();
			tamanho = state.getProjectsInct().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getProjectsInct()[i].getProjectValue());
			break;

		case R.id.radio_projetos_inct_qtd:
			titulo = "Projetos INCT (Qtd.)";
			indicativo = "projetos_inct";
			historico.clear();
			tamanho = state.getProjectsInct().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getProjectsInct()[i]
						.getQuantidade());
			break;

		case R.id.radio_alunos_por_turma_fundamental:
			titulo = "Media de Alunos por Turma do Ensino Fundamental (Qtd.)";
			indicativo = "alunos_por_turma_ensino_medio";
			historico.clear();
			for (int i = 0; i < state.getStudentGradesPerClass().length; i++)
				historico.add((float) state.getStudentGradesPerClass()[i]
						.getElementarySchoolGrade());
			break;

		case R.id.radio_alunos_por_turma_medio:
			titulo = "Media de Alunos por Turma do Ensino Medio (Qtd.)";
			indicativo = "alunos_por_turma_ensino_medio";
			historico.clear();
			for (int i = 0; i < state.getStudentGradesPerClass().length; i++)
				historico.add((float) state.getStudentGradesPerClass()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_horas_aula_fundamental:
			titulo = "Media de horas aula dierias do Ensino Fundamental";
			indicativo = "horas_aula_ensino_medio";
			historico.clear();
			for (int i = 0; i < state.getGradeClassHours().length; i++)
				historico.add((float) state.getGradeClassHours()[i]
						.getElementarySchoolGrade());
			break;

		case R.id.radio_horas_aula_medio:
			titulo = "Media de horas aula dierias do Ensino Medio";
			indicativo = "horas_aula_ensino_medio";
			historico.clear();
			for (int i = 0; i < state.getGradeClassHours().length; i++)
				historico.add((float) state.getGradeClassHours()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_taxa_distorcao_fundamental:
			titulo = "Taxa de Distoreeo Idade/Serie do Ensino Fundamental (%)";
			indicativo = "taxa_distorcao";
			historico.clear();
			for (int i = 0; i < state.getAgeGradeDistortionRate().length; i++)
				historico.add((float) state.getAgeGradeDistortionRate()[i]
						.getElementarySchoolGrade());
			break;

		case R.id.radio_taxa_distorcao_medio:
			titulo = "Taxa de Distoreeo Idade/Serie do Ensino Medio (%)";
			indicativo = "taxa_distorcao";
			historico.clear();
			for (int i = 0; i < state.getAgeGradeDistortionRate().length; i++)
				historico.add((float) state.getAgeGradeDistortionRate()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_taxa_aprovacao_fundamental:
			titulo = "Taxa de Aproveitamento do Ensino Fundamental (%)";
			indicativo = "taxa_aprovacao";
			historico.clear();
			for (int i = 0; i < state.getEducationalAchievementRate().length; i++)
				historico.add((float) state.getEducationalAchievementRate()[i]
						.getElementarySchoolGrade());
			break;

		case R.id.radio_taxa_aprovacao_medio:
			titulo = "Taxa de Aproveitamento do Ensino Medio (%)";
			indicativo = "taxa_aprovacao";
			historico.clear();
			for (int i = 0; i < state.getEducationalAchievementRate().length; i++)
				historico.add((float) state.getEducationalAchievementRate()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_taxa_abandono_fundamental:
			titulo = "Taxa de Abandono do Ensino Fundamental (%)";
			indicativo = "taxa_abandono";
			historico.clear();
			for (int i = 0; i < state.getSchoolDropoutRate().length; i++)
				historico.add((float) state.getSchoolDropoutRate()[i]
						.getElementarySchoolGrade());
			break;

		case R.id.radio_taxa_abandono_medio:
			titulo = "Taxa de Abandono do Ensino Medio (%)";
			indicativo = "taxa_abandono";
			historico.clear();
			for (int i = 0; i < state.getSchoolDropoutRate().length; i++)
				historico.add((float) state.getSchoolDropoutRate()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_censo_iniciais_fundamental:
			titulo = "Censo Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)";
			indicativo = "censo";
			historico.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				historico.add((float) state.getCensus()[i]
						.getAnosIniciaisFundamental());
			break;

		case R.id.radio_censo_finais_fundamental:
			titulo = "Censo Escolar dos Anos Finais do Ensino Fundamental (Matriculados)";
			indicativo = "censo";
			historico.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				historico.add((float) state.getCensus()[i]
						.getInitialElementarySchoolYears());
			break;

		case R.id.radio_censo_ensino_medio:
			titulo = "Censo Escolar do Ensino Medio (Matriculados)";
			indicativo = "censo";
			historico.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				historico.add((float) state.getCensus()[i].getHighSchoolGrade());
			break;

		case R.id.radio_censo_eja_fundamental:
			titulo = "Censo Escolar do EJA - Fundamental (Matriculados)";
			indicativo = "censo";
			historico.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				historico
						.add((float) state.getCensus()[i].getFundamentalEJA());
			break;

		case R.id.radio_censo_eja_medio:
			titulo = "Censo Escolar do EJA - Medio (Matriculados)";
			indicativo = "censo";
			historico.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				historico.add((float) state.getCensus()[i].getMedioEJA());
			break;

		}
	}


	private State capturaInformacoesEstado() {
		State estado1 = null;
		
		int position = positionHistorico;
		
		try {
			estado1 = (State) StateConroller.getInstance(this).obterEstado(position);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return estado1;
	}


	public void clickAdvanceButton(View view) {
		Intent intent = new Intent(this, TelaGraficoLinha.class);
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int i=0; i<historico.size(); i++)
			temp.add(historico.get(i)+"");
		
		intent.putStringArrayListExtra("HISTORICO", temp);
		intent.putExtra("TITULO", titulo);
		intent.putExtra("POSICAO_ESTADO", positionHistorico);
		intent.putExtra("INDICATIVO_GRAFICO", indicativo);
		startActivity(intent);
	}
		
}
