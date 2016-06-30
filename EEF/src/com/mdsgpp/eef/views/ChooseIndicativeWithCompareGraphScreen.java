package com.mdsgpp.eef.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.mdsgpp.eef.R;

public class ChooseIndicativeWithCompareGraphScreen extends ChooseIndicative {
	
	private int position1, position2;
	
	private boolean censusView, studentsClassView, hoursPerClassView, distortionRateView,
			schoolDropoutRateView, approvalView, idebView, pibView, populationView,
			firstProjectsView, cnpqProjectsView, projectDiffusionView,
			initiationProjectsView, jovensProjectsView;

	private RadioButton rbInitialIdebView, rbFinalIdebView, rbMediumIdebView, rbPib, rbPopulation,
			rbFirstProjectsAmount, rbFirstProjectsValues,
			rbCnpqProjectsAmount, rbCnpqProjectsValues, rbDiffusionProjectsAmount,
			rbDiffusionProjectsValue, rbInitiationProjectsAmount, rbInitiationProjectsValues,
			rbJovensProjectsAmount, rbJovensProjectsValues, rbElementarySchoolClassStudents, rbHighSchoolClassStudents,
			rbElementarySchoolHoursPerClass, rbHighSchoolHoursPerClass, rbElementaryDistortionRate, rbHighSchoolDistortionRate,
			rbElementaryApprovalRate, rbHighSchoolApprovalRate, rbElementaryDropoutRate, rbHighSchoolDropoutRate,
			rbInitialYearsElementaryCensus, rbFinalYearsElementaryCensus, rbHighSchoolCensus, rbEJAFElementaryCensus, rbEJAMHighSchoolCensus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_indicative_graph);
		
		InitializeRadioButtons();
		catchInformation();
		hideRadioButtons();
	}
	
	public void catchInformation() {
		Intent receivedIntent = getIntent();
		
		position1 = receivedIntent.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		position2 = receivedIntent.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);

		idebView = receivedIntent.getBooleanExtra("CB_IDEB", false);
		pibView = receivedIntent.getBooleanExtra("CB_PIB", false);
		populationView = receivedIntent.getBooleanExtra("CB_population", false);
		firstProjectsView = receivedIntent.getBooleanExtra("CB_PRIMEIROS_PROJETOS", false);
		cnpqProjectsView = receivedIntent.getBooleanExtra("CB_PROJETOS_CNPQ", false);
		projectDiffusionView = receivedIntent.getBooleanExtra("CB_PROJETOS_DIFUSAO", false);
		initiationProjectsView = receivedIntent.getBooleanExtra("CB_PROJETOS_INICIACAO", false);
		jovensProjectsView = receivedIntent.getBooleanExtra("CB_PROJETOS_JOVENS", false);
		censusView = receivedIntent.getBooleanExtra("CB_census", false);
		studentsClassView = receivedIntent.getBooleanExtra("CB_ALUNOS_TURMA", false);
		hoursPerClassView = receivedIntent.getBooleanExtra("CB_HORAS_AULA", false);
		distortionRateView = receivedIntent.getBooleanExtra("CB_TAXA_DISTORCAO", false);
		schoolDropoutRateView = receivedIntent.getBooleanExtra("CB_dropout_rate", false);
		approvalView = receivedIntent.getBooleanExtra("CB_APROVACAO", false);
		
	}
	
	public void InitializeRadioButtons() {
		rbInitialIdebView = (RadioButton) findViewById(R.id.radio_ideb_elementary_inicials);
		rbFinalIdebView = (RadioButton) findViewById(R.id.radio_ideb_elementary_finals);
		rbMediumIdebView = (RadioButton) findViewById(R.id.radio_ideb_high_school);
		rbPib = (RadioButton) findViewById(R.id.radio_pib);
		rbPopulation = (RadioButton) findViewById(R.id.radio_population);
		rbFirstProjectsAmount = (RadioButton) findViewById(R.id.radio_primeiros_projetos_amount);
		rbFirstProjectsValues = (RadioButton) findViewById(R.id.radio_primeiros_projetos_investment);
		rbCnpqProjectsAmount = (RadioButton) findViewById(R.id.radio_apoio_cnpq_amount);
		rbCnpqProjectsValues = (RadioButton) findViewById(R.id.radio_apoio_cnpq_investment);
		rbDiffusionProjectsAmount = (RadioButton) findViewById(R.id.radio_technological_diffusion_amount);
		rbDiffusionProjectsValue = (RadioButton) findViewById(R.id.radio_technological_diffusion_investment);
		rbInitiationProjectsAmount = (RadioButton) findViewById(R.id.radio_inct_projects_amount);
		rbInitiationProjectsValues = (RadioButton) findViewById(R.id.radio_inct_projects_investment);
		rbJovensProjectsAmount = (RadioButton) findViewById(R.id.radio_jovens_pesquisadores_amount);
		rbJovensProjectsValues = (RadioButton) findViewById(R.id.radio_jovens_pesquisadores_investment);
		rbElementarySchoolClassStudents = (RadioButton) findViewById(R.id.radio_students_per_class_elementary);
		rbHighSchoolClassStudents = (RadioButton) findViewById(R.id.radio_students_per_class_high_school);
		rbElementarySchoolHoursPerClass = (RadioButton) findViewById(R.id.radio_class_hours_elementary);
		rbHighSchoolHoursPerClass = (RadioButton) findViewById(R.id.radio_class_hours_high_school);
		rbElementaryDistortionRate = (RadioButton) findViewById(R.id.radio_distortion_rate_elementary);
		rbHighSchoolDistortionRate = (RadioButton) findViewById(R.id.radio_distortion_rate_high_school);
		rbElementaryApprovalRate = (RadioButton) findViewById(R.id.radio_approval_rate_elementary);
		rbHighSchoolApprovalRate = (RadioButton) findViewById(R.id.radio_approval_rate_high_school);
		rbElementaryDropoutRate = (RadioButton) findViewById(R.id.radio_dropout_rate_elementary);
		rbHighSchoolDropoutRate = (RadioButton) findViewById(R.id.radio_dropout_rate_high_school);
		rbInitialYearsElementaryCensus = (RadioButton) findViewById(R.id.radio_final_census_elementary);
		rbFinalYearsElementaryCensus = (RadioButton) findViewById(R.id.radio_initial_census_elementary);
		rbHighSchoolCensus = (RadioButton) findViewById(R.id.radio_census_high_school);
		rbEJAFElementaryCensus = (RadioButton) findViewById(R.id.radio_census_eja_elementary);
		rbEJAMHighSchoolCensus = (RadioButton) findViewById(R.id.radio_census_high_school_eja);
		
	}
	
	public void setVisibility(RadioButton radioButton, boolean visibility) {
		int visibilityValue = (visibility) ? View.VISIBLE : View.GONE;
		radioButton.setVisibility(visibilityValue);
	}
	
	public void hideRadioButtons() {
		setVisibility(rbInitialIdebView, idebView);
		setVisibility(rbFinalIdebView, idebView);
		setVisibility(rbMediumIdebView, idebView);
		setVisibility(rbPib, pibView);
		setVisibility(rbPopulation, populationView);
		setVisibility(rbFirstProjectsAmount, firstProjectsView);
		setVisibility(rbFirstProjectsValues, firstProjectsView);
		setVisibility(rbCnpqProjectsAmount, cnpqProjectsView);
		setVisibility(rbCnpqProjectsValues, cnpqProjectsView);
		setVisibility(rbDiffusionProjectsAmount, projectDiffusionView);
		setVisibility(rbDiffusionProjectsValue, projectDiffusionView);
		setVisibility(rbInitiationProjectsAmount, initiationProjectsView);
		setVisibility(rbInitiationProjectsValues, initiationProjectsView);
		setVisibility(rbJovensProjectsAmount, jovensProjectsView);
		setVisibility(rbJovensProjectsValues, jovensProjectsView);
		setVisibility(rbElementarySchoolClassStudents, studentsClassView);
		setVisibility(rbHighSchoolClassStudents, studentsClassView);
		setVisibility(rbElementarySchoolHoursPerClass, hoursPerClassView);
		setVisibility(rbHighSchoolHoursPerClass, hoursPerClassView);
		setVisibility(rbElementaryDistortionRate, distortionRateView);
		setVisibility(rbHighSchoolDistortionRate, distortionRateView);
		setVisibility(rbElementaryApprovalRate, approvalView);
		setVisibility(rbHighSchoolApprovalRate, approvalView);
		setVisibility(rbElementaryDropoutRate, schoolDropoutRateView);
		setVisibility(rbHighSchoolDropoutRate, schoolDropoutRateView);
		setVisibility(rbInitialYearsElementaryCensus, censusView);
		setVisibility(rbFinalYearsElementaryCensus, censusView);
		setVisibility(rbHighSchoolCensus, censusView);
		setVisibility(rbEJAFElementaryCensus, censusView);
		setVisibility(rbEJAMHighSchoolCensus, censusView);
	}
	
	public void clickButtonNext(View view) {
		Intent intent = new Intent(this, GraphScreen.class);

		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", position1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", position2);
		intent.putExtra("INDICATIVO", getIndicative());
		intent.putExtra("TITULO", getTitle());

		startActivity(intent);		
	}
    
    public void loadAboutScreen() {
    	Intent intent = new Intent(this, ScreenAboutIndicativeChoiceComparisonGraphic.class);
    	startActivity(intent);
    }
}
