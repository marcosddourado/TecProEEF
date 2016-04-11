package com.mdsgpp.eef.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.mdsgpp.eef.R;

public class ChooseIndicativeWithCompareGraphScreen extends EscolheIndicativo {
	
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
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
		
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
		populationView = receivedIntent.getBooleanExtra("CB_POPULACAO", false);
		firstProjectsView = receivedIntent.getBooleanExtra("CB_PRIMEIROS_PROJETOS", false);
		cnpqProjectsView = receivedIntent.getBooleanExtra("CB_PROJETOS_CNPQ", false);
		projectDiffusionView = receivedIntent.getBooleanExtra("CB_PROJETOS_DIFUSAO", false);
		initiationProjectsView = receivedIntent.getBooleanExtra("CB_PROJETOS_INICIACAO", false);
		jovensProjectsView = receivedIntent.getBooleanExtra("CB_PROJETOS_JOVENS", false);
		censusView = receivedIntent.getBooleanExtra("CB_CENSO", false);
		studentsClassView = receivedIntent.getBooleanExtra("CB_ALUNOS_TURMA", false);
		hoursPerClassView = receivedIntent.getBooleanExtra("CB_HORAS_AULA", false);
		distortionRateView = receivedIntent.getBooleanExtra("CB_TAXA_DISTORCAO", false);
		schoolDropoutRateView = receivedIntent.getBooleanExtra("CB_TAXA_ABANDONO", false);
		approvalView = receivedIntent.getBooleanExtra("CB_APROVACAO", false);
		
	}
	
	public void InitializeRadioButtons() {
		rbInitialIdebView = (RadioButton) findViewById(R.id.radio_ideb_fundamental_iniciai);
		rbFinalIdebView = (RadioButton) findViewById(R.id.radio_ideb_fundamental_finais);
		rbMediumIdebView = (RadioButton) findViewById(R.id.radio_ideb_medio);
		rbPib = (RadioButton) findViewById(R.id.radio_pib);
		rbPopulation = (RadioButton) findViewById(R.id.radio_populacao);
		rbFirstProjectsAmount = (RadioButton) findViewById(R.id.radio_primeiros_projetos_qtd);
		rbFirstProjectsValues = (RadioButton) findViewById(R.id.radio_primeiros_projetos_investimento);
		rbCnpqProjectsAmount = (RadioButton) findViewById(R.id.radio_apoio_cnpq_qtd);
		rbCnpqProjectsValues = (RadioButton) findViewById(R.id.radio_apoio_cnpq_investimento);
		rbDiffusionProjectsAmount = (RadioButton) findViewById(R.id.radio_difusao_tecnologica_qtd);
		rbDiffusionProjectsValue = (RadioButton) findViewById(R.id.radio_difusao_tecnologica_investimento);
		rbInitiationProjectsAmount = (RadioButton) findViewById(R.id.radio_projetos_inct_qtd);
		rbInitiationProjectsValues = (RadioButton) findViewById(R.id.radio_projetos_inct_investimento);
		rbJovensProjectsAmount = (RadioButton) findViewById(R.id.radio_jovens_pesquisadores_qtd);
		rbJovensProjectsValues = (RadioButton) findViewById(R.id.radio_jovens_pesquisadores_investimento);
		rbElementarySchoolClassStudents = (RadioButton) findViewById(R.id.radio_alunos_por_turma_fundamental);
		rbHighSchoolClassStudents = (RadioButton) findViewById(R.id.radio_alunos_por_turma_medio);
		rbElementarySchoolHoursPerClass = (RadioButton) findViewById(R.id.radio_horas_aula_fundamental);
		rbHighSchoolHoursPerClass = (RadioButton) findViewById(R.id.radio_horas_aula_medio);
		rbElementaryDistortionRate = (RadioButton) findViewById(R.id.radio_taxa_distorcao_fundamental);
		rbHighSchoolDistortionRate = (RadioButton) findViewById(R.id.radio_taxa_distorcao_medio);
		rbElementaryApprovalRate = (RadioButton) findViewById(R.id.radio_taxa_aprovacao_fundamental);
		rbHighSchoolApprovalRate = (RadioButton) findViewById(R.id.radio_taxa_aprovacao_medio);
		rbElementaryDropoutRate = (RadioButton) findViewById(R.id.radio_taxa_abandono_fundamental);
		rbHighSchoolDropoutRate = (RadioButton) findViewById(R.id.radio_taxa_abandono_medio);
		rbInitialYearsElementaryCensus = (RadioButton) findViewById(R.id.radio_censo_iniciais_fundamental);
		rbFinalYearsElementaryCensus = (RadioButton) findViewById(R.id.radio_censo_finais_fundamental);
		rbHighSchoolCensus = (RadioButton) findViewById(R.id.radio_censo_ensino_medio);
		rbEJAFElementaryCensus = (RadioButton) findViewById(R.id.radio_censo_eja_fundamental);
		rbEJAMHighSchoolCensus = (RadioButton) findViewById(R.id.radio_censo_eja_medio);
		
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
	
	public void clickAdvanceButton(View view) {
		Intent intent = new Intent(this, GraphScreen.class);

		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", position1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", position2);
		intent.putExtra("INDICATIVO", getIndicative());
		intent.putExtra("TITULO", getTitle());

		startActivity(intent);		
	}
    
    public void loadAboutScreen() {
    	Intent intent = new Intent(this, ChooseIndicativeWithCompareGraphAboutScreen.class);
    	startActivity(intent);
    }
}
