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

public class ScreenLineGraphIndicative extends Activity{
	
	private State state;
	private ArrayList<Float> history = new ArrayList<Float>();

	private String title, indicative;
	private int historyPosition;
	private Intent receivedIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_indicative_graph);
		
		receivedIntent = getIntent();
		historyPosition = receivedIntent.getIntExtra("ESTADO", 0);

		state = catchStateInformation();
		Log.i("positionIndicativeGraph", historyPosition+"");
		
		// population comeea selecionada
		title = "Populaeeo";
		indicative = "population";
		history.clear();
		history.add((float) state.getStatePopulation());
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
		Intent intent = new Intent(this, ScreenAboutIndicativeChoiceComparisonGraphic.class);
    	startActivity(intent);
	}	

	public void onRadioButtonClicked(View view) {

		int max, size;
		
		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investment:
			title = "Projetos de Pesquisa Apoio CNPq (R$)";
			indicative = "cnpq";
			history.clear();
			size = state.getApoioCnpqProject().length;
			max = size == 1 ? size : (size - 1); 
			for (int i = 0; i < max; i++)
				history.add((float) state.getApoioCnpqProject()[i].getProjectValue());
			break;
			
		case R.id.radio_apoio_cnpq_amount:
			title = "Projetos de Pesquisa Apoio CNPq (Qtd.)";
			indicative = "cnpq";
			history.clear();
			size = state.getApoioCnpqProject().length;
			max = size == 1 ? size : (size - 1); 
			for (int i = 0; i < max; i++)
				history.add((float) state.getApoioCnpqProject()[i]
						.getProjectQuantity());
			break;
			
		case R.id.radio_technological_diffusion_investment:
			title = "Projeto de Difuseo Tecnolegica (R$)";
			indicative = "projetos_ciencia_tecnologia";
			history.clear();
			size = state.getScienceAndThecnologyProjects().length;
			max = size == 1 ? size : (size - 1); 
			for (int i = 0; i < max; i++)
				history.add((float) state.getScienceAndThecnologyProjects()[i]
						.getProjectValue());
			break;
			
		case R.id.radio_technological_diffusion_amount:
			title = "Projeto de Difuseo Tecnolegica (Qtd.)";
			indicative = "projetos_ciencia_tecnologia";
			history.clear();
			size = state.getScienceAndThecnologyProjects().length;
			max = size == 1 ? size : (size - 1); 
			for (int i = 0; i < max; i++)
				history.add((float) state.getScienceAndThecnologyProjects()[i]
						.getProjectQuantity());
			break;
			
		case R.id.radio_ideb_elementary_finals:
			title = "IDEB do Ensino Fundamental (Series Finais)";
			indicative = "ideb";
			history.clear();
			for (int i = 0; i < state.getIdebs().length; i++)
				history.add((float) state.getIdebs()[i].getElementary());
			break;
			
		case R.id.radio_ideb_elementary_inicials:
			title = "IDEB do Ensino Fundamental (Series Iniciais)";
			indicative = "ideb";
			history.clear();
			for (int i = 0; i < state.getIdebs().length; i++)
				history.add((float) state.getIdebs()[i].getInitialGrades());
			break;
			
		case R.id.radio_ideb_high_school:
			title = "IDEB do Ensino Medio";
			indicative = "ideb";
			history.clear();
			for (int i = 0; i < state.getIdebs().length; i++)
				history.add((float) state.getIdebs()[i].getHighSchool());
			break;
			
		case R.id.radio_teen_searchers_investment:
			title = "Jovens pesquisadores (R$)";
			indicative = "teen_searchers";
			history.clear();
			size = state.getJovensPesquisadoresProject().length;
			max = size == 1 ? size : (size - 1); 
			for (int i = 0; i < max; i++)
				history.add((float) state.getJovensPesquisadoresProject()[i]
						.getProjectValue());
			break;

		case R.id.radio_teen_searchers_amount:
			title = "Jovens pesquisadores (Qtd.)";
			indicative = "teen_searchers";
			history.clear();
			size = state.getJovensPesquisadoresProject().length;
			max = size == 1 ? size : (size - 1); 
			for (int i = 0; i < max; i++)
				history.add((float) state.getJovensPesquisadoresProject()[i]
						.getProjectQuantity());
			break;

		case R.id.radio_pib:
			title = "Participaeeo Estadual no PIB (%)";
			indicative = "percentual_pib_participation";
			history.clear();
			for (int i = 0; i < state.getPercentageCollaborationWithPIB().length; i++)
				history.add((float) state.getPercentageCollaborationWithPIB()[i]);
			break;

		case R.id.radio_population:
			title = "Populaeeo";
			indicative = "population";
			history.clear();
			history.add((float) state.getStatePopulation());
			Log.i("size hsitorico", ""+history.size());
			break;

		case R.id.radio_primeiros_projetos_investment:
			title = "Programa Primeiros Projetos (R$)";
			indicative = "primeiros_projetos";
			history.clear();
			size = state.getPrimeirosProjetos().length;
			max = size == 1 ? size : (size - 1); 
			for (int i = 0; i < max; i++)
				history.add((float) state.getPrimeirosProjetos()[i]
						.getProjectValue());
			break;

		case R.id.radio_primeiros_projetos_amount:
			title = "Programa Primeiros Projetos (Qtd.)";
			indicative = "primeiros_projetos";
			history.clear();
			size = state.getPrimeirosProjetos().length;
			max = size == 1 ? size : (size - 1); 
			for (int i = 0; i < max; i++)
				history.add((float) state.getPrimeirosProjetos()[i]
						.getProjectQuantity());
			break;

		case R.id.radio_inct_projects_investment:
			title = "Projetos INCT (R$)";
			indicative = "projetos_inct";
			history.clear();
			size = state.getProjectsInct().length;
			max = size == 1 ? size : (size - 1); 
			for (int i = 0; i < max; i++)
				history.add((float) state.getProjectsInct()[i].getProjectValue());
			break;

		case R.id.radio_inct_projects_amount:
			title = "Projetos INCT (Qtd.)";
			indicative = "projetos_inct";
			history.clear();
			size = state.getProjectsInct().length;
			max = size == 1 ? size : (size - 1); 
			for (int i = 0; i < max; i++)
				history.add((float) state.getProjectsInct()[i]
						.getProjectQuantity());
			break;

		case R.id.radio_students_per_class_elementary:
			title = "Media de Alunos por Turma do Ensino Fundamental (Qtd.)";
			indicative = "alunos_por_turma_ensino_high_school";
			history.clear();
			for (int i = 0; i < state.getStudentGradesPerClass().length; i++)
				history.add((float) state.getStudentGradesPerClass()[i]
						.getElementaryGrade());
			break;

		case R.id.radio_students_per_class_high_school:
			title = "Media de Alunos por Turma do Ensino Medio (Qtd.)";
			indicative = "alunos_por_turma_ensino_high_school";
			history.clear();
			for (int i = 0; i < state.getStudentGradesPerClass().length; i++)
				history.add((float) state.getStudentGradesPerClass()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_class_hours_elementary:
			title = "Media de horas aula dierias do Ensino Fundamental";
			indicative = "daily_class_hours_average_high_school";
			history.clear();
			for (int i = 0; i < state.getGradeClassHours().length; i++)
				history.add((float) state.getGradeClassHours()[i]
						.getElementaryGrade());
			break;

		case R.id.radio_class_hours_high_school:
			title = "Media de horas aula dierias do Ensino Medio";
			indicative = "daily_class_hours_average_high_school";
			history.clear();
			for (int i = 0; i < state.getGradeClassHours().length; i++)
				history.add((float) state.getGradeClassHours()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_distortion_rate_elementary:
			title = "Taxa de Distoreeo Idade/Serie do Ensino Fundamental (%)";
			indicative = "distortion_rate";
			history.clear();
			for (int i = 0; i < state.getAgeGradeDistortionRate().length; i++)
				history.add((float) state.getAgeGradeDistortionRate()[i]
						.getElementaryGrade());
			break;

		case R.id.radio_distortion_rate_high_school:
			title = "Taxa de Distoreeo Idade/Serie do Ensino Medio (%)";
			indicative = "distortion_rate";
			history.clear();
			for (int i = 0; i < state.getAgeGradeDistortionRate().length; i++)
				history.add((float) state.getAgeGradeDistortionRate()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_approval_rate_elementary:
			title = "Taxa de Aproveitamento do Ensino Fundamental (%)";
			indicative = "utilization_rate";
			history.clear();
			for (int i = 0; i < state.getEducationalAchievementRate().length; i++)
				history.add((float) state.getEducationalAchievementRate()[i]
						.getElementaryGrade());
			break;

		case R.id.radio_approval_rate_high_school:
			title = "Taxa de Aproveitamento do Ensino Medio (%)";
			indicative = "utilization_rate";
			history.clear();
			for (int i = 0; i < state.getEducationalAchievementRate().length; i++)
				history.add((float) state.getEducationalAchievementRate()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_dropout_rate_elementary:
			title = "Taxa de Abandono do Ensino Fundamental (%)";
			indicative = "dropout_rate";
			history.clear();
			for (int i = 0; i < state.getSchoolDropoutRate().length; i++)
				history.add((float) state.getSchoolDropoutRate()[i]
						.getElementaryGrade());
			break;

		case R.id.radio_dropout_rate_high_school:
			title = "Taxa de Abandono do Ensino Medio (%)";
			indicative = "dropout_rate";
			history.clear();
			for (int i = 0; i < state.getSchoolDropoutRate().length; i++)
				history.add((float) state.getSchoolDropoutRate()[i]
						.getHighSchoolGrade());
			break;

		case R.id.radio_initial_census_elementary:
			title = "census Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)";
			indicative = "census";
			history.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				history.add((float) state.getCensus()[i]
						.getInitialElementaryYears());
			break;

		case R.id.radio_final_census_elementary:
			title = "census Escolar dos Anos Finais do Ensino Fundamental (Matriculados)";
			indicative = "census";
			history.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				history.add((float) state.getCensus()[i]
						.getInitialElementaryYears());
			break;

		case R.id.radio_census_high_school:
			title = "census Escolar do Ensino Medio (Matriculados)";
			indicative = "census";
			history.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				history.add((float) state.getCensus()[i].getHighSchool());
			break;

		case R.id.radio_census_eja_elementary:
			title = "census Escolar do EJA - Fundamental (Matriculados)";
			indicative = "census";
			history.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				history
						.add((float) state.getCensus()[i].getElementaryEJA());
			break;

		case R.id.radio_census_high_school_eja:
			title = "census Escolar do EJA - Medio (Matriculados)";
			indicative = "census";
			history.clear();
			for (int i = 0; i < state.getCensus().length; i++)
				history.add((float) state.getCensus()[i].getHighSchoolEJA());
			break;

		}
	}


	private State catchStateInformation() {
		State state = null;
		
		int position = historyPosition;
		
		try {
			state = (State) StateConroller.getInstance(this).grabState(position);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return state;
	}


	public void clickButtonNext(View view) {
		Intent intent = new Intent(this, ScreenLineGraph.class);
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int i=0; i<history.size(); i++)
			temp.add(history.get(i)+"");
		
		intent.putStringArrayListExtra("HISTORICO", temp);
		intent.putExtra("TITULO", title);
		intent.putExtra("POSICAO_ESTADO", historyPosition);
		intent.putExtra("INDICATIVO_GRAFICO", indicative);
		startActivity(intent);
	}
		
}
