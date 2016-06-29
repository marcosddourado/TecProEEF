package com.mdsgpp.eef.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.mdsgpp.eef.R;

public class ScreenCompareGraphIndicative extends ChooseIndicative {
	
	private int position1, position2;
	
	private boolean bCensus, bStudentsClass, bHoursClass, bDistortionRate,
			bDropoutRate, bApproval, bIdeb, bPib, bPopulation,
			bPrimeirosProjetos, bCnpqProjects, bDiffusionProjects,
			bInitiationProjects, bJovensProject;

	private RadioButton rbIdebIniciais, rbIdebFinals, rbAverageIdeb, rbPib, rbPopulation, 
			bPrimeirosProjetosQuantity, bPrimeirosProjetosValues,	
			rbCnpqProjectsQuantity, rbCnpqProjectsValues, rbDiffusionProjectsQuantity, 
			rbDiffusionProjectsValues, rbInitiationProjectsQuantity, rbInitiationProjectsValues, 
			rbJovensProjectQuantity, rbJovensProjectValues, rbStudentsClassElementary, rbStudentsClassHighSchool,
			rbHoursClassElementary, rbHoursClassHighSchool, rbDistortionRateElementary, rbDistortionRateHighSchool,
			rbApprovalRateElementary, rbApprovalRateHighSchool, rbDropoutRateElementary, rbDropoutRateHighSchool,
			rbCensusInitialYearsElementary, rbCensusFinallYearsElementary, rbCensusHighSchool, rbCensusEJAElementary, rbCensusEJAHighSchool;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_indicative_graph);
		
		initializeRadioButtons();
		getInformation();
		hideRadioButtons();
	}
	
	public void getInformation() {
		Intent intentRecebida = getIntent();
		
		position1 = intentRecebida.getIntExtra("INDEX_CHOOSED_STATE1", 0);
		position2 = intentRecebida.getIntExtra("INDEX_CHOOSED_STATE2", 0);

		bIdeb = intentRecebida.getBooleanExtra("CB_IDEB", false);
		bPib = intentRecebida.getBooleanExtra("CB_PIB", false);
		bPopulation = intentRecebida.getBooleanExtra("CB_population", false);
		bPrimeirosProjetos = intentRecebida.getBooleanExtra("CB_PRIMEIROS_PROJETOS", false);
		bCnpqProjects = intentRecebida.getBooleanExtra("CB_PROJETOS_CNPQ", false);
		bDiffusionProjects = intentRecebida.getBooleanExtra("CB_PROJETOS_DIFUSAO", false);
		bInitiationProjects = intentRecebida.getBooleanExtra("CB_PROJETOS_INICIACAO", false);
		bJovensProject = intentRecebida.getBooleanExtra("CB_PROJETOS_JOVENS", false);
		bCensus = intentRecebida.getBooleanExtra("CB_census", false);
		bStudentsClass = intentRecebida.getBooleanExtra("CB_ALUNOS_TURMA", false);
		bHoursClass = intentRecebida.getBooleanExtra("CB_HORAS_AULA", false);
		bDistortionRate = intentRecebida.getBooleanExtra("CB_TAXA_DISTORCAO", false);
		bDropoutRate = intentRecebida.getBooleanExtra("CB_dropout_rate", false);
		bApproval = intentRecebida.getBooleanExtra("CB_APROVACAO", false);
		
	}
	
	public void initializeRadioButtons() {
		rbIdebIniciais = (RadioButton) findViewById(R.id.radio_ideb_elementary_inicials);
		rbIdebFinals = (RadioButton) findViewById(R.id.radio_ideb_elementary_finals);
		rbAverageIdeb = (RadioButton) findViewById(R.id.radio_ideb_high_school);
		rbPib = (RadioButton) findViewById(R.id.radio_pib);
		rbPopulation = (RadioButton) findViewById(R.id.radio_population);
		bPrimeirosProjetosQuantity = (RadioButton) findViewById(R.id.radio_primeiros_projetos_amount);
		bPrimeirosProjetosValues = (RadioButton) findViewById(R.id.radio_primeiros_projetos_investment);
		rbCnpqProjectsQuantity = (RadioButton) findViewById(R.id.radio_apoio_cnpq_amount);
		rbCnpqProjectsValues = (RadioButton) findViewById(R.id.radio_apoio_cnpq_investment);
		rbDiffusionProjectsQuantity = (RadioButton) findViewById(R.id.radio_technological_diffusion_amount);
		rbDiffusionProjectsValues = (RadioButton) findViewById(R.id.radio_technological_diffusion_investment);
		rbInitiationProjectsQuantity = (RadioButton) findViewById(R.id.radio_inct_projects_amount);
		rbInitiationProjectsValues = (RadioButton) findViewById(R.id.radio_inct_projects_investment);
		rbJovensProjectQuantity = (RadioButton) findViewById(R.id.radio_jovens_pesquisadores_amount);
		rbJovensProjectValues = (RadioButton) findViewById(R.id.radio_jovens_pesquisadores_investment);
		rbStudentsClassElementary = (RadioButton) findViewById(R.id.radio_students_per_class_elementary);
		rbStudentsClassHighSchool = (RadioButton) findViewById(R.id.radio_students_per_class_high_school);
		rbHoursClassElementary = (RadioButton) findViewById(R.id.radio_class_hours_elementary);
		rbHoursClassHighSchool = (RadioButton) findViewById(R.id.radio_class_hours_high_school);
		rbDistortionRateElementary = (RadioButton) findViewById(R.id.radio_distortion_rate_elementary);
		rbDistortionRateHighSchool = (RadioButton) findViewById(R.id.radio_distortion_rate_high_school);
		rbApprovalRateElementary = (RadioButton) findViewById(R.id.radio_approval_rate_elementary);
		rbApprovalRateHighSchool = (RadioButton) findViewById(R.id.radio_approval_rate_high_school);
		rbDropoutRateElementary = (RadioButton) findViewById(R.id.radio_dropout_rate_elementary);
		rbDropoutRateHighSchool = (RadioButton) findViewById(R.id.radio_dropout_rate_high_school);
		rbCensusInitialYearsElementary = (RadioButton) findViewById(R.id.radio_initial_census_elementary);
		rbCensusFinallYearsElementary = (RadioButton) findViewById(R.id.radio_final_census_elementary);
		rbCensusHighSchool = (RadioButton) findViewById(R.id.radio_census_high_school);
		rbCensusEJAElementary = (RadioButton) findViewById(R.id.radio_census_eja_elementary);
		rbCensusEJAHighSchool = (RadioButton) findViewById(R.id.radio_census_high_school_eja);
		
	}
	
	public void setVisibility(RadioButton radioButton, boolean visibility) {
		int visibilityValue = (visibility) ? View.VISIBLE : View.GONE;
		radioButton.setVisibility(visibilityValue);
	}
	
	public void hideRadioButtons() {
		setVisibility(rbIdebIniciais, bIdeb);
		setVisibility(rbIdebFinals, bIdeb);
		setVisibility(rbAverageIdeb, bIdeb);
		setVisibility(rbPib, bPib);
		setVisibility(rbPopulation, bPopulation);
		setVisibility(bPrimeirosProjetosQuantity, bPrimeirosProjetos);
		setVisibility(bPrimeirosProjetosValues, bPrimeirosProjetos);
		setVisibility(rbCnpqProjectsQuantity, bCnpqProjects);
		setVisibility(rbCnpqProjectsValues, bCnpqProjects);
		setVisibility(rbDiffusionProjectsQuantity, bDiffusionProjects);
		setVisibility(rbDiffusionProjectsValues, bDiffusionProjects);
		setVisibility(rbInitiationProjectsQuantity, bInitiationProjects);
		setVisibility(rbInitiationProjectsValues, bInitiationProjects);
		setVisibility(rbJovensProjectQuantity, bJovensProject);
		setVisibility(rbJovensProjectValues, bJovensProject);
		setVisibility(rbStudentsClassElementary, bStudentsClass);
		setVisibility(rbStudentsClassHighSchool, bStudentsClass);
		setVisibility(rbHoursClassElementary, bHoursClass);
		setVisibility(rbHoursClassHighSchool, bHoursClass);
		setVisibility(rbDistortionRateElementary, bDistortionRate);
		setVisibility(rbDistortionRateHighSchool, bDistortionRate);
		setVisibility(rbApprovalRateElementary, bApproval);
		setVisibility(rbApprovalRateHighSchool, bApproval);
		setVisibility(rbDropoutRateElementary, bDropoutRate);
		setVisibility(rbDropoutRateHighSchool, bDropoutRate);
		setVisibility(rbCensusInitialYearsElementary, bCensus);
		setVisibility(rbCensusFinallYearsElementary, bCensus);
		setVisibility(rbCensusHighSchool, bCensus);
		setVisibility(rbCensusEJAElementary, bCensus);
		setVisibility(rbCensusEJAHighSchool, bCensus);
	}
	
	public void clickButtonNext(View view) {
		Intent intent = new Intent(this, ScreenGraph.class);
		
		intent.putExtra("INDEX_CHOOSED_STATE1", position1);
		intent.putExtra("INDEX_CHOOSED_STATE2", position2);
		intent.putExtra("INDICATIVO", getIndicative());
		intent.putExtra("TITULO", getTittle());

		startActivity(intent);		
	}
    
    public void loadAboutScreen() {
    	Intent intent = new Intent(this, ScreenAboutIndicativeChoiceComparisonGraphic.class);
    	startActivity(intent);
    }
}
