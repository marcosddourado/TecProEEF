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
	
	private State state = null;
	private ArrayList<Float> historico = new ArrayList<Float>();

	private String titulo = "";
	private String indicativo = "";
	private int positionHistorico = 0;
	private Intent receivedIntent = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_indicative_graph);
		
		receivedIntent = getIntent();
		positionHistorico = receivedIntent.getIntExtra("ESTADO", 0);

		state = capturaInformacoesEstado();

		titulo = "Populaeeo";
		indicativo = "populacao";
		historico.clear();
		historico.add((float) state.getStatePopulation());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_screens, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.about:
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
		Intent intent = new Intent(this, ScreenOverIndicativeChoiceComparisonGraphic.class);
    	startActivity(intent);
	}	

	public void onRadioButtonClicked(View view) {

		int max, tamanho;
		
		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investment:
			titulo = "Projetos de Pesquisa Apoio CNPq (R$)";
			indicativo = "cnpq";
			historico.clear();
			tamanho = state.getApoioCnpqProject().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getApoioCnpqProject()[i].getProjectValue());
			break;
			
		case R.id.radio_apoio_cnpq_amount:
			titulo = "Projetos de Pesquisa Apoio CNPq (Qtd.)";
			indicativo = "cnpq";
			historico.clear();
			tamanho = state.getApoioCnpqProject().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getApoioCnpqProject()[i]
						.getProjectQuantity());
			break;
			
		case R.id.radio_technological_diffusion_investment:
			titulo = "Projeto de Difuseo Tecnolegica (R$)";
			indicativo = "projetos_ciencia_tecnologia";
			historico.clear();
			tamanho = state.getScienceAndThecnologyProjects().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getScienceAndThecnologyProjects()[i]
						.getProjectValue());
			break;
			
		case R.id.radio_technological_diffusion_amount:
			titulo = "Projeto de Difuseo Tecnolegica (Qtd.)";
			indicativo = "projetos_ciencia_tecnologia";
			historico.clear();
			tamanho = state.getScienceAndThecnologyProjects().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getScienceAndThecnologyProjects()[i]
						.getProjectQuantity());
			break;
			
		case R.id.radio_ideb_elementary_finals:
			titulo = "IDEB do Ensino Fundamental (Series Finais)";
			indicativo = "ideb";
			historico.clear();
			for (int i = 0; i < state.getIdebs().length; i++)
				historico.add((float) state.getIdebs()[i].getElementary());
			break;
			
		case R.id.radio_ideb_elementary_inicials:
			titulo = "IDEB do Ensino Fundamental (Series Iniciais)";
			indicativo = "ideb";
			historico.clear();
			for (int i = 0; i < state.getIdebs().length; i++)
				historico.add((float) state.getIdebs()[i].getInitialGrades());
			break;
			
		case R.id.radio_ideb_high_school:
			titulo = "IDEB do Ensino Medio";
			indicativo = "ideb";
			historico.clear();
			for (int i = 0; i < state.getIdebs().length; i++)
				historico.add((float) state.getIdebs()[i].getHighSchool());
			break;
			
		case R.id.radio_jovens_pesquisadores_investment:
			titulo = "Jovens pesquisadores (R$)";
			indicativo = "jovens_pesquisadores";
			historico.clear();
			tamanho = state.getJovensPesquisadoresProject().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getJovensPesquisadoresProject()[i]
						.getProjectValue());
			break;

		case R.id.radio_jovens_pesquisadores_amount:
			titulo = "Jovens pesquisadores (Qtd.)";
			indicativo = "jovens_pesquisadores";
			historico.clear();
			tamanho = state.getJovensPesquisadoresProject().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getJovensPesquisadoresProject()[i]
						.getProjectQuantity());
			break;

		case R.id.radio_pib:
			titulo = "Participaeeo Estadual no PIB (%)";
			indicativo = "percentual_participacao_pib";
			historico.clear();
			for (int i = 0; i < state.getPercentageCollaborationWithPIB().length; i++)
				historico.add((float) state.getPercentageCollaborationWithPIB()[i]);
			break;

		case R.id.radio_population:
			titulo = "Populaeeo";
			indicativo = "populacao";
			historico.clear();
			historico.add((float) state.getStatePopulation());
			Log.i("tamanho hsitorico", ""+historico.size());
			break;

		case R.id.radio_primeiros_projetos_investment:
			titulo = "Programa Primeiros Projetos (R$)";
			indicativo = "primeiros_projetos";
			historico.clear();
			tamanho = state.getPrimeirosProjetos().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getPrimeirosProjetos()[i]
						.getProjectValue());
			break;

		case R.id.radio_primeiros_projetos_amount:
			titulo = "Programa Primeiros Projetos (Qtd.)";
			indicativo = "primeiros_projetos";
			historico.clear();
			tamanho = state.getPrimeirosProjetos().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getPrimeirosProjetos()[i]
						.getProjectQuantity());
			break;

		case R.id.radio_inct_projects_investment:
			titulo = "Projetos INCT (R$)";
			indicativo = "projetos_inct";
			historico.clear();
			tamanho = state.getProjectsInct().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getProjectsInct()[i].getProjectValue());
			break;

		case R.id.radio_inct_projects_amount:
			titulo = "Projetos INCT (Qtd.)";
			indicativo = "projetos_inct";
			historico.clear();
			tamanho = state.getProjectsInct().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) state.getProjectsInct()[i]
						.getProjectQuantity());
			break;

		case R.id.radio_students_per_class_elementary:
			titulo = "Media de Alunos por Turma do Ensino Fundamental (Qtd.)";
			indicativo = "alunos_por_turma_ensino_medio";
			historico.clear();
			for (int i = 0; i < state.getStudentGradesPerClass().length; i++)
				historico.add((float) state.getStudentGradesPerClass()[i]
						.getElementaryGrade());
			break;

		case R.id.radio_students_per_class_high_school:
			titulo = "Media de Alunos por Turma do Ensino Medio (Qtd.)";
			indicativo = "alunos_por_turma_ensino_medio";
			historico.clear();
			for (int i = 0; i < state.getStudentGradesPerClass().length; i++)
				historico.add((float) state.getStudentGradesPerClass()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_class_hours_elementary:
			titulo = "Media de horas aula dierias do Ensino Fundamental";
			indicativo = "horas_aula_ensino_medio";
			historico.clear();
			for (int i = 0; i < state.getGradeClassHours().length; i++)
				historico.add((float) state.getGradeClassHours()[i]
						.getElementaryGrade());
			break;

		case R.id.radio_class_hours_high_school:
			titulo = "Media de horas aula dierias do Ensino Medio";
			indicativo = "horas_aula_ensino_medio";
			historico.clear();
			for (int i = 0; i < state.getGradeClassHours().length; i++)
				historico.add((float) state.getGradeClassHours()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_distortion_rate_elementary:
			titulo = "Taxa de Distoreeo Idade/Serie do Ensino Fundamental (%)";
			indicativo = "taxa_distorcao";
			historico.clear();
			for (int i = 0; i < state.getAgeGradeDistortionRate().length; i++)
				historico.add((float) state.getAgeGradeDistortionRate()[i]
						.getElementaryGrade());
			break;

		case R.id.radio_distortion_rate_high_school:
			titulo = "Taxa de Distoreeo Idade/Serie do Ensino Medio (%)";
			indicativo = "taxa_distorcao";
			historico.clear();
			for (int i = 0; i < state.getAgeGradeDistortionRate().length; i++)
				historico.add((float) state.getAgeGradeDistortionRate()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_approval_rate_elementary:
			titulo = "Taxa de Aproveitamento do Ensino Fundamental (%)";
			indicativo = "taxa_aprovacao";
			historico.clear();
			for (int i = 0; i < state.getEducationalAchievementRate().length; i++)
				historico.add((float) state.getEducationalAchievementRate()[i]
						.getElementaryGrade());
			break;

		case R.id.radio_approval_rate_high_school:
			titulo = "Taxa de Aproveitamento do Ensino Medio (%)";
			indicativo = "taxa_aprovacao";
			historico.clear();
			for (int i = 0; i < state.getEducationalAchievementRate().length; i++)
				historico.add((float) state.getEducationalAchievementRate()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_dropout_rate_elementary:
			titulo = "Taxa de Abandono do Ensino Fundamental (%)";
			indicativo = "taxa_abandono";
			historico.clear();
			for (int i = 0; i < state.getSchoolDropoutRate().length; i++)
				historico.add((float) state.getSchoolDropoutRate()[i]
						.getElementaryGrade());
			break;

		case R.id.radio_dropout_rate_high_school:
			titulo = "Taxa de Abandono do Ensino Medio (%)";
			indicativo = "taxa_abandono";
			historico.clear();
			for (int i = 0; i < state.getSchoolDropoutRate().length; i++)
				historico.add((float) state.getSchoolDropoutRate()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_initial_census_elementary:
			titulo = "Censo Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)";
			indicativo = "censo";
			historico.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				historico.add((float) state.getCensus()[i]
						.getInitialElementaryYears());
			break;

		case R.id.radio_final_census_elementary:
			titulo = "Censo Escolar dos Anos Finais do Ensino Fundamental (Matriculados)";
			indicativo = "censo";
			historico.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				historico.add((float) state.getCensus()[i]
						.getInitialElementaryYears());
			break;

		case R.id.radio_census_high_school:
			titulo = "Censo Escolar do Ensino Medio (Matriculados)";
			indicativo = "censo";
			historico.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				historico.add((float) state.getCensus()[i].getHighSchool());
			break;

		case R.id.radio_census_eja_elementary:
			titulo = "Censo Escolar do EJA - Fundamental (Matriculados)";
			indicativo = "censo";
			historico.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				historico
						.add((float) state.getCensus()[i].getElementaryEJA());
			break;

		case R.id.radio_census_eja_high_school:
			titulo = "Censo Escolar do EJA - Medio (Matriculados)";
			indicativo = "censo";
			historico.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				historico.add((float) state.getCensus()[i].getHighSchoolEJA());
			break;

		}
	}


	private State capturaInformacoesEstado() {
		State estado1 = null;
		
		int position = positionHistorico;
		
		try {
			estado1 = (State) StateConroller.getInstance(this).grabState(position);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return estado1;
	}


	public void clickButtonNext(View view) {
		Intent intent = new Intent(this, ScreenLineGraph.class);
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
