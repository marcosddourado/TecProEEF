package com.mdsgpp.eef.views;

import java.io.IOException;
import java.util.HashMap;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateConroller;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ScreenQueryResult extends Activity {

	private TextView textViewInitials1;
	private TextView textViewPopulation1;
	private TextView textViewPopulationValue1;
	private TextView textViewPibStateParticipation1;
	private TextView textViewPibParticipation1;
	private TextView textViewProjectNumber1;
	private TextView textViewScienceTechnologyProjectCount1;
	private TextView textViewValorScienceTechnologyProjects1;
	private TextView textViewIdeb1;
	private TextView textViewElementaryIdeb1;
	private TextView textViewHighSchoolIdeb1;
	private TextView textViewInitialSeriesIdeb1;
	private TextView textViewFirstProjectsProgram1;
	private TextView textViewFirstProjectsCount1;
	private TextView textViewFirstProjectsValue1;
	private TextView textViewResearchProjects1;
	private TextView textViewResearchCount1;
	private TextView textViewYoungResearchers1;
	private TextView textViewYoungResearchersCount1;
	private TextView textViewResearchValue1;
	private TextView textViewYoungResearchersValue1;
	private TextView textViewInitiationProjects1;
	private TextView textViewInitiationProjectCount1;
	private TextView textViewInitiationProjectValue1;
	private TextView textViewCensus1;
	private TextView textViewInitialSeriesCensus1;
	private TextView textViewElementaryCensus1;
	private TextView textViewHighSchoolCensus1;
	private TextView textViewElementaryEjaCensus1;
	private TextView textViewHighSchoolEjaCensus1;
	private TextView textViewStudentsPerClass1;
	private TextView textViewStudentsPerClassElementary1;
	private TextView textViewStudentsPerClassHighSchool1;
	private TextView textViewAverageClassTime1;
	private TextView textViewClassTimeElementary1;
	private TextView textViewClassTimeHighSchool1;
	private TextView textViewDistortionRate1;
	private TextView textViewDistortionRateElementary1;
	private TextView textViewDistortionRateHighSchool1;
	private TextView textViewUtilizationRate1;
	private TextView textViewUtilizationRateElementary1;
	private TextView textViewUtilizationRateHighSchool1;
	private TextView textViewAbandonRate1;
	private TextView textViewAbandonRateElementary1;
	private TextView textViewAbandonRateHighSchool1;

	private TextView textViewInitials2;
	private TextView textViewPopulationValue2;
	private TextView textViewPibParticipation2;
	private TextView textViewScienceTechnologyProjectCount2;
	private TextView textViewValorScienceTechnologyProjects2;
	private TextView textViewElementaryIdeb2;
	private TextView textViewHighSchoolIdeb2;
	private TextView textViewInitialSeriesIdeb2;
	private TextView textViewFirstProjectsCount2;
	private TextView textViewFirstProjectsValue2;
	private TextView textViewResearchCount2;
	private TextView textViewYoungResearchersCount2;
	private TextView textViewResearchValue2;
	private TextView textViewYoungResearchersValue2;
	private TextView textViewInitiationProjects2;
	private TextView textViewInitiationProjectCount2;
	private TextView textViewInitiationProjectValue2;
	private TextView textViewInitialSeriesCensus2;
	private TextView textViewElementaryCensus2;
	private TextView textViewHighSchoolCensus2;
	private TextView textViewElementaryEjaCensus2;
	private TextView textViewHighSchoolEjaCensus2;
	private TextView textViewStudentsPerClassElementary2;
	private TextView textViewStudentsPerClassHighSchool2;
	private TextView textViewClassTimeElementary2;
	private TextView textViewClassTimeHighSchool2;
	private TextView textViewDistortionRateElementary2;
	private TextView textViewDistortionRateHighSchool2;
	private TextView textViewUtilizationRateElementary2;
	private TextView textViewUtilizationRateHighSchool2;
	private TextView textViewAbandonRateElementary2;
	private TextView textViewAbandonRateHighSchool2;

	private boolean bCensus;
	private boolean bClassStudents;
	private boolean bClassTime;
	private boolean bDistortionRate;
	private boolean bAbandonRate;
	private boolean bApproval;
	private boolean bIdeb;
	private boolean bPib;
	private boolean bPopulation;
	private boolean bFirstProjects;
	private boolean bCnpqProjects;
	private boolean bDiffusionProjects;
	private boolean bInitiation;
	private boolean bYoungProjects;

	private ImageView imageViewFlag01;
	private ImageView imageViewFlag02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_compare_states);

		initializeTextViews();
		captureInformation();
		hideTextFields();
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
		Intent intent = new Intent(this, ScreenAboutStateComparison.class);
    	startActivity(intent);

	}

	@SuppressWarnings("unchecked")
	private void captureInformation() {

		// Captura o intent que abriu a activity
		Intent intent = getIntent();
		// Captura o valor transferido atraves da intent

		int position1 = intent.getIntExtra("INDEX_CHOOSED_STATE1",5);
		int position2 = intent.getIntExtra("INDEX_CHOOSED_STATE2",0);

		captureFlags(position1, position2);

		bIdeb = intent.getBooleanExtra("CB_IDEB", false);
		bPib = intent.getBooleanExtra("CB_PIB", false);
		bPopulation = intent.getBooleanExtra("CB_population", false);
		bFirstProjects = intent.getBooleanExtra("CB_PRIMEIROS_PROJETOS", false);
		bCnpqProjects = intent.getBooleanExtra("CB_PROJETOS_CNPQ", false);
		bDiffusionProjects = intent.getBooleanExtra("CB_PROJETOS_DIFUSAO", false);
		bInitiation = intent.getBooleanExtra("CB_PROJETOS_INICIACAO", false);
		bYoungProjects = intent.getBooleanExtra("CB_PROJETOS_JOVENS", false);
		bCensus = intent.getBooleanExtra("CB_census", false);
		bClassStudents = intent.getBooleanExtra("CB_ALUNOS_TURMA", false);
		bClassTime = intent.getBooleanExtra("CB_HORAS_AULA", false);
		bDistortionRate = intent.getBooleanExtra("CB_TAXA_DISTORCAO", false);
		bAbandonRate = intent.getBooleanExtra("CB_dropout_rate", false);
		bApproval = intent.getBooleanExtra("CB_APROVACAO", false);

		HashMap<String, String> stateInformations1 = new HashMap<String, String>();
		HashMap<String, String> stateInformations2 = new HashMap<String, String>();

		try {
			stateInformations1 = (HashMap<String, String>) StateConroller
					.getInstance(this).readState(position1).clone();
			stateInformations2 = (HashMap<String, String>) StateConroller
					.getInstance(this).readState(position2).clone();

			fiilTextViews(stateInformations1, stateInformations2);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso es informaeees.", Toast.LENGTH_SHORT).show();
		}
	}

	private void fiilTextViews(HashMap<String, String> informations1,
							   HashMap<String, String> informations2) {

		textViewInitials1.setText(informations1.get("sigla"));
		textViewPopulationValue1.setText(informations1.get("population"));
		textViewPibParticipation1.setText(informations1.get("percentual_pib_participation"));
		textViewScienceTechnologyProjectCount1.setText(informations1.get("projetos_ciencia_tecnologia"));
		textViewValorScienceTechnologyProjects1.setText(informations1.get("valor_ciencia_tecnologia"));
		textViewElementaryIdeb1.setText(informations1.get("ideb_elementary_final"));
		textViewHighSchoolIdeb1.setText(informations1.get("ideb_ensino_high_school"));
		textViewInitialSeriesIdeb1.setText(informations1.get("ideb_elementary_inicial"));
		textViewFirstProjectsCount1.setText(informations1.get("quantidade_primeiros_projetos"));
		textViewFirstProjectsValue1.setText(informations1.get("valor_primeiros_projetos"));
		textViewResearchCount1.setText(informations1.get("quantidade_projeto_cnpq"));
		textViewResearchValue1.setText(informations1.get("valor_projetos_cnpq"));
		textViewYoungResearchersCount1.setText(informations1.get("quantidade_projeto_teen_searchers"));
		textViewYoungResearchersValue1.setText(informations1.get("valor_projetos_teen_searchers"));
		textViewInitiationProjectCount1.setText(informations1.get("quantidade_projetos_inct"));
		textViewInitiationProjectValue1.setText(informations1.get("valor_projetos_inct"));
		textViewInitialSeriesCensus1.setText(informations1.get("census_initial_years_elemetary"));
		textViewElementaryCensus1.setText(informations1.get("census_final_years_elemetary"));
		textViewHighSchoolCensus1.setText(informations1.get("census_high_school"));
		textViewElementaryEjaCensus1.setText(informations1.get("census_eja_elementary"));
		textViewHighSchoolEjaCensus1.setText(informations1.get("census_high_school_eja"));
		textViewStudentsPerClassElementary1.setText(informations1.get("alunos_por_turma_ensino_elementary"));
		textViewStudentsPerClassHighSchool1.setText(informations1.get("alunos_por_turma_ensino_high_school"));
		textViewClassTimeElementary1.setText(informations1.get("daily_class_hours_average_elementary"));
		textViewClassTimeHighSchool1.setText(informations1.get("daily_class_hours_average_high_school"));
		textViewDistortionRateElementary1.setText(informations1.get("distortion_rate_elementary"));
		textViewDistortionRateHighSchool1.setText(informations1.get("distortion_rate_high_school"));
		textViewUtilizationRateElementary1.setText(informations1.get("utilization_rate_elementary"));
		textViewUtilizationRateHighSchool1.setText(informations1.get("utilization_rate_high_school"));
		textViewAbandonRateElementary1.setText(informations1.get("utilization_rate_elementary"));
		textViewAbandonRateHighSchool1.setText(informations1.get("utilization_rate_high_school"));

		textViewInitials2.setText(informations2.get("sigla"));
		textViewPopulationValue2.setText(informations2.get("population"));
		textViewPibParticipation2.setText(informations2.get("percentual_pib_participation"));
		textViewScienceTechnologyProjectCount2.setText(informations2.get("projetos_ciencia_tecnologia").split(":")[1]);
		textViewValorScienceTechnologyProjects2.setText(informations2.get("valor_ciencia_tecnologia").split(":")[1]);
		textViewElementaryIdeb2.setText(informations2.get("ideb_elementary_final").split(":")[1]);
		textViewHighSchoolIdeb2.setText(informations2.get("ideb_ensino_high_school").split(":")[1]);
		textViewInitialSeriesIdeb2.setText(informations2.get("ideb_elementary_inicial").split(":")[1]);
		textViewFirstProjectsCount2.setText(informations2.get("quantidade_primeiros_projetos").split(":")[1]);
		textViewFirstProjectsValue2.setText(informations2.get("valor_primeiros_projetos").split(":")[1]);
		textViewResearchCount2.setText(informations2.get("quantidade_projeto_cnpq").split(":")[1]);
		textViewResearchValue2.setText(informations2.get("valor_projetos_cnpq").split(":")[1]);
		textViewYoungResearchersCount2.setText(informations2.get("quantidade_projeto_teen_searchers").split(":")[1]);
		textViewYoungResearchersValue2.setText(informations2.get("valor_projetos_teen_searchers").split(":")[1]);
		textViewInitiationProjectCount2.setText(informations2.get("quantidade_projetos_inct").split(":")[1]);
		textViewInitiationProjectValue2.setText(informations2.get("valor_projetos_inct").split(":")[1]);
		textViewInitialSeriesCensus2.setText(informations2.get("census_initial_years_elemetary").split(":")[1]);
		textViewElementaryCensus2.setText(informations2.get("census_final_years_elemetary").split(":")[1]);
		textViewHighSchoolCensus2.setText(informations2.get("census_high_school").split(":")[1]);
		textViewElementaryEjaCensus2.setText(informations2.get("census_eja_elementary").split(":")[1]);
		textViewHighSchoolEjaCensus2.setText(informations2.get("census_high_school_eja").split(":")[1]);
		textViewStudentsPerClassElementary2.setText(informations2.get("alunos_por_turma_ensino_elementary").split(":")[1]);
		textViewStudentsPerClassHighSchool2.setText(informations2.get("alunos_por_turma_ensino_high_school").split(":")[1]);
		textViewClassTimeElementary2.setText(informations2.get("daily_class_hours_average_elementary").split(":")[1]);
		textViewClassTimeHighSchool2.setText(informations2.get("daily_class_hours_average_high_school").split(":")[1]);
		textViewDistortionRateElementary2.setText(informations2.get("distortion_rate_elementary").split(":")[1]);
		textViewDistortionRateHighSchool2.setText(informations2.get("distortion_rate_high_school").split(":")[1]);
		textViewUtilizationRateElementary2.setText(informations2.get("utilization_rate_elementary").split(":")[1]);
		textViewUtilizationRateHighSchool2.setText(informations2.get("utilization_rate_high_school").split(":")[1]);
		textViewAbandonRateElementary2.setText(informations2.get("utilization_rate_elementary").split(":")[1]);
		textViewAbandonRateHighSchool2.setText(informations2.get("utilization_rate_high_school").split(":")[1]);

	}

	private void initializeTextViews() {

		textViewInitials1 = (TextView) findViewById(R.id.textView_sigla1);
		textViewPopulation1 = (TextView) findViewById(R.id.textView_population1);
		textViewPopulationValue1 = (TextView) findViewById(R.id.textView_population_valor1);
		textViewPibStateParticipation1 = (TextView) findViewById(R.id.textView_participacao_estadual_pib1);
		textViewPibParticipation1 = (TextView) findViewById(R.id.textView_pib_participation_valor1);
		textViewProjectNumber1 =  (TextView) findViewById(R.id.textView_project_numbers1);
		textViewScienceTechnologyProjectCount1 = (TextView) findViewById(R.id.textView_project_numbers_quantidade1);
		textViewValorScienceTechnologyProjects1 = (TextView) findViewById(R.id.textView_valor_investido_projetos1);
		textViewIdeb1 = (TextView) findViewById(R.id.textView_ideb1);
		textViewElementaryIdeb1 = (TextView) findViewById(R.id.textView_ideb_elementary1);
		textViewHighSchoolIdeb1 = (TextView) findViewById(R.id.textView_ideb_ensinomedio1);
		textViewInitialSeriesIdeb1 = (TextView) findViewById(R.id.textView_ideb_iniciais1);
		textViewFirstProjectsProgram1 = (TextView) findViewById(R.id.textView_first_program_projects1);
		textViewFirstProjectsCount1 = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade1);
		textViewFirstProjectsValue1 = (TextView) findViewById(R.id.textView_first_program_projects_valor1);
		textViewResearchProjects1 = (TextView) findViewById(R.id.textView_projetos_pesquisa1);
		textViewResearchCount1 = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade1);
		textViewResearchValue1 = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa1);
		textViewYoungResearchersCount1 = (TextView) findViewById(R.id.textView_teen_searchers_quantidade1);
		textViewYoungResearchers1 = (TextView) findViewById(R.id.textView_teen_searchers1);
		textViewYoungResearchersValue1 = (TextView) findViewById(R.id.textView_teen_searchers_valor1);
		textViewInitiationProjects1 = (TextView) findViewById(R.id.textView_projetos_iniciacao1);
		textViewInitiationProjectCount1 = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade1);
		textViewInitiationProjectValue1 = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor1);
		textViewAbandonRate1 = (TextView) findViewById(R.id.textView_dropout_rate1);
		textViewUtilizationRate1 = (TextView) findViewById(R.id.textView_utilization_rate1);
		textViewCensus1 = (TextView) findViewById(R.id.textView_census1);
		textViewStudentsPerClass1 = (TextView) findViewById(R.id.textView_students_average_per_class1);
		textViewAverageClassTime1 = (TextView) findViewById(R.id.textView_daily_class_hours_average1);
		textViewDistortionRate1 = (TextView) findViewById(R.id.textView_distortion_rate1);
		textViewInitialSeriesCensus1 = (TextView) findViewById(R.id.textView_initial_census_elementary1);
		textViewElementaryCensus1 = (TextView) findViewById(R.id.textView_final_census_elementary1);
		textViewHighSchoolCensus1 = (TextView) findViewById(R.id.textView_census_high_school1);
		textViewElementaryEjaCensus1 = (TextView) findViewById(R.id.textView_census_elementary_eja1);
		textViewHighSchoolEjaCensus1 = (TextView) findViewById(R.id.textView_census_high_school_eja1);
		textViewStudentsPerClassElementary1 = (TextView) findViewById(R.id.textView_students_average_per_class_elementary1);
		textViewStudentsPerClassHighSchool1 = (TextView) findViewById(R.id.textView_students_average_per_class_high_school1);
		textViewClassTimeElementary1 = (TextView) findViewById(R.id.textView_daily_class_hours_average_elementary1);
		textViewClassTimeHighSchool1 = (TextView) findViewById(R.id.textView_daily_class_hours_average_high_school1);
		textViewDistortionRateElementary1 = (TextView) findViewById(R.id.textView_distortion_rate_elementary1);
		textViewDistortionRateHighSchool1 = (TextView) findViewById(R.id.textView_distortion_rate_high_school1);
		textViewUtilizationRateElementary1 = (TextView) findViewById(R.id.textView_approval_rate_elementary1);
		textViewUtilizationRateHighSchool1 = (TextView) findViewById(R.id.textView_approval_rate_high_school1);
		textViewAbandonRateElementary1 = (TextView) findViewById(R.id.textView_dropout_rate_elementary1);
		textViewAbandonRateHighSchool1 = (TextView) findViewById(R.id.textView_dropout_rate_high_school1);

		textViewInitials2 = (TextView) findViewById(R.id.textView_sigla2);
		textViewPopulationValue2 = (TextView) findViewById(R.id.textView_population_valor2);
		textViewPibParticipation2 = (TextView) findViewById(R.id.textView_pib_participation_valor2);
		textViewScienceTechnologyProjectCount2 = (TextView) findViewById(R.id.textView_project_numbers_quantidade2);
		textViewValorScienceTechnologyProjects2 = (TextView) findViewById(R.id.textView_valor_investido_projetos2);
		textViewElementaryIdeb2 = (TextView) findViewById(R.id.textView_ideb_elementary2);
		textViewHighSchoolIdeb2 = (TextView) findViewById(R.id.textView_ideb_ensinomedio2);
		textViewInitialSeriesIdeb2 = (TextView) findViewById(R.id.textView_ideb_iniciais2);
		textViewFirstProjectsCount2 = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade2);
		textViewFirstProjectsValue2 = (TextView) findViewById(R.id.textView_first_program_projects_valor2);
		textViewResearchCount2 = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade2);
		textViewResearchValue2 = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa2);
		textViewYoungResearchersCount2 = (TextView) findViewById(R.id.textView_teen_searchers_quantidade2);
		textViewYoungResearchersValue2 = (TextView) findViewById(R.id.textView_teen_searchers_valor2);
		textViewInitiationProjectCount2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade2);
		textViewInitiationProjectValue2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor2);

		textViewInitialSeriesCensus2 = (TextView) findViewById(R.id.textView_initial_census_elementary2);
		textViewElementaryCensus2 = (TextView) findViewById(R.id.textView_final_census_elementary2);
		textViewHighSchoolCensus2 = (TextView) findViewById(R.id.textView_census_high_school2);
		textViewElementaryEjaCensus2 = (TextView) findViewById(R.id.textView_census_elementary_eja2);
		textViewHighSchoolEjaCensus2 = (TextView) findViewById(R.id.textView_census_high_school_eja2);
		textViewStudentsPerClassElementary2 = (TextView) findViewById(R.id.textView_students_average_per_class_elementary2);
		textViewStudentsPerClassHighSchool2 = (TextView) findViewById(R.id.textView_students_average_per_class_high_school2);
		textViewClassTimeElementary2 = (TextView) findViewById(R.id.textView_daily_class_hours_average_elementary2);
		textViewClassTimeHighSchool2 = (TextView) findViewById(R.id.textView_daily_class_hours_average_high_school2);
		textViewDistortionRateElementary2 = (TextView) findViewById(R.id.textView_distortion_rate_elementary2);
		textViewDistortionRateHighSchool2 = (TextView) findViewById(R.id.textView_distortion_rate_high_school2);
		textViewUtilizationRateElementary2 = (TextView) findViewById(R.id.textView_approval_rate_elementary2);
		textViewUtilizationRateHighSchool2 = (TextView) findViewById(R.id.textView_approval_rate_high_school2);
		textViewAbandonRateElementary2 = (TextView) findViewById(R.id.textView_dropout_rate_elementary2);
		textViewAbandonRateHighSchool2 = (TextView) findViewById(R.id.textView_dropout_rate_high_school2);
	}

	public void setVisibility(TextView textView, boolean visibility) {
		int valorVisibilidade = (visibility) ? View.VISIBLE : View.GONE;
		textView.setVisibility(valorVisibilidade);
	}

	public void hideTextFields() {
		setVisibility(textViewPopulation1, bPopulation);
		setVisibility(textViewPopulationValue1, bPopulation);
		setVisibility(textViewPopulationValue2, bPopulation);

		setVisibility(textViewIdeb1, bIdeb);
		setVisibility(textViewElementaryIdeb1, bIdeb);
		setVisibility(textViewHighSchoolIdeb1, bIdeb);
		setVisibility(textViewInitialSeriesIdeb1, bIdeb);
		setVisibility(textViewElementaryIdeb2, bIdeb);
		setVisibility(textViewHighSchoolIdeb2, bIdeb);
		setVisibility(textViewInitialSeriesIdeb2, bIdeb);

		setVisibility(textViewPibStateParticipation1, bPib);
		setVisibility(textViewPibParticipation1, bPib);
		setVisibility(textViewPibParticipation2, bPib);

		setVisibility(textViewFirstProjectsProgram1, bFirstProjects);
		setVisibility(textViewFirstProjectsCount1, bFirstProjects);
		setVisibility(textViewFirstProjectsValue1, bFirstProjects);
		setVisibility(textViewFirstProjectsCount2, bFirstProjects);
		setVisibility(textViewFirstProjectsValue2, bFirstProjects);

		setVisibility(textViewResearchProjects1, bCnpqProjects);
		setVisibility(textViewResearchCount1, bCnpqProjects);
		setVisibility(textViewResearchValue1, bCnpqProjects);
		setVisibility(textViewResearchCount2, bCnpqProjects);
		setVisibility(textViewResearchValue2, bCnpqProjects);

		setVisibility(textViewYoungResearchers1, bYoungProjects);
		setVisibility(textViewYoungResearchersCount1, bYoungProjects);
		setVisibility(textViewYoungResearchersValue1, bYoungProjects);
		setVisibility(textViewYoungResearchersCount2, bYoungProjects);
		setVisibility(textViewYoungResearchersValue2, bYoungProjects);

		setVisibility(textViewInitiationProjects1, bInitiation);
		setVisibility(textViewInitiationProjectCount1, bInitiation);
		setVisibility(textViewInitiationProjectValue1, bInitiation);
		setVisibility(textViewInitiationProjectCount2, bInitiation);
		setVisibility(textViewInitiationProjectValue2, bInitiation);

		setVisibility(textViewProjectNumber1, bDiffusionProjects);
		setVisibility(textViewScienceTechnologyProjectCount1, bDiffusionProjects);
		setVisibility(textViewValorScienceTechnologyProjects1, bDiffusionProjects);
		setVisibility(textViewScienceTechnologyProjectCount2, bDiffusionProjects);
		setVisibility(textViewValorScienceTechnologyProjects2, bDiffusionProjects);

		setVisibility(textViewCensus1, bCensus);
		setVisibility(textViewElementaryEjaCensus1, bCensus);
		setVisibility(textViewHighSchoolEjaCensus1, bCensus);
		setVisibility(textViewElementaryCensus1, bCensus);
		setVisibility(textViewInitialSeriesCensus1, bCensus);
		setVisibility(textViewHighSchoolCensus1, bCensus);
		setVisibility(textViewElementaryEjaCensus2, bCensus);
		setVisibility(textViewHighSchoolEjaCensus2, bCensus);
		setVisibility(textViewElementaryCensus2, bCensus);
		setVisibility(textViewInitialSeriesCensus2, bCensus);
		setVisibility(textViewHighSchoolCensus2, bCensus);

		setVisibility(textViewStudentsPerClass1, bClassStudents);
		setVisibility(textViewStudentsPerClassElementary1, bClassStudents);
		setVisibility(textViewStudentsPerClassHighSchool1, bClassStudents);
		setVisibility(textViewStudentsPerClassElementary2, bClassStudents);
		setVisibility(textViewStudentsPerClassHighSchool2, bClassStudents);

		setVisibility(textViewAverageClassTime1, bClassTime);
		setVisibility(textViewClassTimeElementary1, bClassTime);
		setVisibility(textViewClassTimeHighSchool1, bClassTime);
		setVisibility(textViewClassTimeElementary2, bClassTime);
		setVisibility(textViewClassTimeHighSchool2, bClassTime);

		setVisibility(textViewDistortionRate1, bDistortionRate);
		setVisibility(textViewDistortionRateElementary1, bDistortionRate);
		setVisibility(textViewDistortionRateHighSchool1, bDistortionRate);
		setVisibility(textViewDistortionRateElementary2, bDistortionRate);
		setVisibility(textViewDistortionRateHighSchool2, bDistortionRate);

		setVisibility(textViewAbandonRate1, bAbandonRate);
		setVisibility(textViewAbandonRateElementary1, bAbandonRate);
		setVisibility(textViewAbandonRateHighSchool1, bAbandonRate);
		setVisibility(textViewAbandonRateElementary2, bAbandonRate);
		setVisibility(textViewAbandonRateHighSchool2, bAbandonRate);

		setVisibility(textViewUtilizationRate1, bApproval);
		setVisibility(textViewUtilizationRateElementary1, bApproval);
		setVisibility(textViewUtilizationRateHighSchool1, bApproval);
		setVisibility(textViewUtilizationRateElementary2, bApproval);
		setVisibility(textViewUtilizationRateHighSchool2, bApproval);

		try {
			setVisibility(textViewInitiationProjects2, bInitiation);
		} catch(NullPointerException npe) {
			Log.e("layout portrait não possui estes ids",npe.toString());
		}

	}

	public void generateGraphicButtonTouch(View view) {
		Intent intent = new Intent(this, ScreenCompareGraphIndicative.class);
		Intent intent1 = getIntent();

		int position1 = intent1.getIntExtra("INDEX_CHOOSED_STATE1", 0);
		int position2 = intent1.getIntExtra("INDEX_CHOOSED_STATE2", 0);

		intent.putExtra("CB_IDEB", bIdeb);
		intent.putExtra("CB_PIB", bPib);
		intent.putExtra("CB_population", bPopulation);
		intent.putExtra("CB_PRIMEIROS_PROJETOS", bFirstProjects);
		intent.putExtra("CB_PROJETOS_CNPQ", bCnpqProjects);
		intent.putExtra("CB_PROJETOS_DIFUSAO", bDiffusionProjects);
		intent.putExtra("CB_PROJETOS_INICIACAO", bInitiation);
		intent.putExtra("CB_PROJETOS_JOVENS", bYoungProjects);
		intent.putExtra("CB_ALUNOS_TURMA", bClassStudents);
		intent.putExtra("CB_APROVACAO", bApproval);
		intent.putExtra("CB_census", bCensus);
		intent.putExtra("CB_HORAS_AULA", bClassTime);
		intent.putExtra("CB_dropout_rate", bAbandonRate);
		intent.putExtra("CB_TAXA_DISTORCAO", bDistortionRate);

		intent.putExtra("INDEX_CHOOSED_STATE1", position1);
		intent.putExtra("INDEX_CHOOSED_STATE2", position2);

		startActivity(intent);
	}

	public void captureFlags(int statePosition1, int statePosition2){
		String flags[] = {"acre", "alagoas", "amapa", "amazonas", "bahia",
				"ceara", "distritofederal", "espiritosanto", "goias", "maranhao",
				"matogrosso", "matogrossodosul", "minasgerais", "para", "paraiba",
				"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
				"riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo",
				"sergipe", "tocantins"};

		imageViewFlag01 = (ImageView) findViewById(R.id.imageView_flags1);
		int idFlag01 = getResources().getIdentifier(flags[statePosition1], "drawable", getPackageName());
		imageViewFlag01.setImageResource(idFlag01);

		imageViewFlag02 = (ImageView) findViewById(R.id.imageView_flags2);
		int idFlag02 = getResources().getIdentifier(flags[statePosition2], "drawable", getPackageName());
		imageViewFlag02.setImageResource(idFlag02);



	}
}
