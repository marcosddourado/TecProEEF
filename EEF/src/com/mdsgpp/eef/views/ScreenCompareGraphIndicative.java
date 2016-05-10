package com.mdsgpp.eef.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.mdsgpp.eef.R;

public class ScreenCompareGraphIndicative extends ChooseIndicative {
	
	private int position1, position2;
	
	private boolean bCenso, bAlunosTurma, bHorasAula, bTaxaDistorcao,
			bTaxaAbandono, bAprovacao, bIdeb, bPib, bPopulacao,
			bPrimeirosProjetos, bProjetosCnpq, bProjetosDifusao,
			bProjetosIniciacao, bProjetosJovens;

	private RadioButton rbIdebIniciais, rbIdebFinais, rbIdebMedio, rbPib, rbPopulacao, 
			rbPrimeirosProjetosQuantidade, rbPrimeirosProjetosValores,
			rbProjetosCnpqQuantidade, rbProjetosCnpqValores, rbProjetosDifusaoQuantidade, 
			rbProjetosDifusaoValores, rbProjetosIniciacaoQuantidade, rbProjetosIniciacaoValores, 
			rbProjetosJovensQuantidade, rbProjetosJovensValores, rbAlunosTurmaFundamental, rbAlunosTurmaMedio,
			rbHorasAulaFundamental, rbHorasAulaMedio, rbTaxaDeDistorcaoFundamental, rbTaxaDeDistorcaoMedio,
			rbTaxaDeAprocaoFundamental, rbTaxaDeAprovacaoMedio, rbTaxaDeAbandonoFundamental, rbTaxaDeAbandonoMedio,
			rbCensoAnosIniciaisFundamental, rbCensoAnosFinaisFundamental, rbCensoEsninoMedio, rbCensoEJAFundamental, rbCensoEJAMedio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_indicative_graph);
		
		inicializaRadioButtons();
		capturaInformacoes();
		escondeRadioButtons();
	}
	
	public void capturaInformacoes() {
		Intent intentRecebida = getIntent();
		
		position1 = intentRecebida.getIntExtra("INDEX_CHOOSED_STATE1", 0);
		position2 = intentRecebida.getIntExtra("INDEX_CHOOSED_STATE2", 0);

		bIdeb = intentRecebida.getBooleanExtra("CB_IDEB", false);
		bPib = intentRecebida.getBooleanExtra("CB_PIB", false);
		bPopulacao = intentRecebida.getBooleanExtra("CB_POPULACAO", false);
		bPrimeirosProjetos = intentRecebida.getBooleanExtra("CB_PRIMEIROS_PROJETOS", false);
		bProjetosCnpq = intentRecebida.getBooleanExtra("CB_PROJETOS_CNPQ", false);
		bProjetosDifusao = intentRecebida.getBooleanExtra("CB_PROJETOS_DIFUSAO", false);
		bProjetosIniciacao = intentRecebida.getBooleanExtra("CB_PROJETOS_INICIACAO", false);
		bProjetosJovens = intentRecebida.getBooleanExtra("CB_PROJETOS_JOVENS", false);
		bCenso = intentRecebida.getBooleanExtra("CB_CENSO", false);
		bAlunosTurma = intentRecebida.getBooleanExtra("CB_ALUNOS_TURMA", false);
		bHorasAula = intentRecebida.getBooleanExtra("CB_HORAS_AULA", false);
		bTaxaDistorcao = intentRecebida.getBooleanExtra("CB_TAXA_DISTORCAO", false);
		bTaxaAbandono = intentRecebida.getBooleanExtra("CB_TAXA_ABANDONO", false);
		bAprovacao = intentRecebida.getBooleanExtra("CB_APROVACAO", false);
		
	}
	
	public void inicializaRadioButtons() {
		rbIdebIniciais = (RadioButton) findViewById(R.id.radio_ideb_elementary_inicials);
		rbIdebFinais = (RadioButton) findViewById(R.id.radio_ideb_elementary_finals);
		rbIdebMedio = (RadioButton) findViewById(R.id.radio_ideb_high_school);
		rbPib = (RadioButton) findViewById(R.id.radio_pib);
		rbPopulacao = (RadioButton) findViewById(R.id.radio_population);
		rbPrimeirosProjetosQuantidade = (RadioButton) findViewById(R.id.radio_primeiros_projetos_amount);
		rbPrimeirosProjetosValores = (RadioButton) findViewById(R.id.radio_primeiros_projetos_investment);
		rbProjetosCnpqQuantidade = (RadioButton) findViewById(R.id.radio_apoio_cnpq_amount);
		rbProjetosCnpqValores = (RadioButton) findViewById(R.id.radio_apoio_cnpq_investment);
		rbProjetosDifusaoQuantidade = (RadioButton) findViewById(R.id.radio_technological_diffusion_amount);
		rbProjetosDifusaoValores = (RadioButton) findViewById(R.id.radio_technological_diffusion_investment);
		rbProjetosIniciacaoQuantidade = (RadioButton) findViewById(R.id.radio_inct_projects_amount);
		rbProjetosIniciacaoValores = (RadioButton) findViewById(R.id.radio_inct_projects_investment);
		rbProjetosJovensQuantidade = (RadioButton) findViewById(R.id.radio_jovens_pesquisadores_amount);
		rbProjetosJovensValores = (RadioButton) findViewById(R.id.radio_jovens_pesquisadores_investment);
		rbAlunosTurmaFundamental = (RadioButton) findViewById(R.id.radio_students_per_class_elementary);
		rbAlunosTurmaMedio = (RadioButton) findViewById(R.id.radio_students_per_class_high_school);
		rbHorasAulaFundamental = (RadioButton) findViewById(R.id.radio_class_hours_elementary);
		rbHorasAulaMedio = (RadioButton) findViewById(R.id.radio_class_hours_high_school);
		rbTaxaDeDistorcaoFundamental = (RadioButton) findViewById(R.id.radio_distortion_rate_elementary);
		rbTaxaDeDistorcaoMedio = (RadioButton) findViewById(R.id.radio_distortion_rate_high_school);
		rbTaxaDeAprocaoFundamental = (RadioButton) findViewById(R.id.radio_approval_rate_elementary);
		rbTaxaDeAprovacaoMedio = (RadioButton) findViewById(R.id.radio_approval_rate_high_school);
		rbTaxaDeAbandonoFundamental = (RadioButton) findViewById(R.id.radio_dropout_rate_elementary);
		rbTaxaDeAbandonoMedio = (RadioButton) findViewById(R.id.radio_dropout_rate_high_school);
		rbCensoAnosIniciaisFundamental = (RadioButton) findViewById(R.id.radio_initial_census_elementary);
		rbCensoAnosFinaisFundamental = (RadioButton) findViewById(R.id.radio_final_census_elementary);
		rbCensoEsninoMedio = (RadioButton) findViewById(R.id.radio_census_high_school);
		rbCensoEJAFundamental = (RadioButton) findViewById(R.id.radio_census_eja_elementary);
		rbCensoEJAMedio = (RadioButton) findViewById(R.id.radio_census_eja_high_school);
		
	}
	
	public void setVisibility(RadioButton radioButton, boolean visibilidade) {
		int valorVisibilidade = (visibilidade) ? View.VISIBLE : View.GONE;
		radioButton.setVisibility(valorVisibilidade);
	}
	
	public void escondeRadioButtons() {
		setVisibility(rbIdebIniciais, bIdeb);
		setVisibility(rbIdebFinais, bIdeb);
		setVisibility(rbIdebMedio, bIdeb);
		setVisibility(rbPib, bPib);
		setVisibility(rbPopulacao, bPopulacao);
		setVisibility(rbPrimeirosProjetosQuantidade, bPrimeirosProjetos);
		setVisibility(rbPrimeirosProjetosValores, bPrimeirosProjetos);
		setVisibility(rbProjetosCnpqQuantidade, bProjetosCnpq);
		setVisibility(rbProjetosCnpqValores, bProjetosCnpq);
		setVisibility(rbProjetosDifusaoQuantidade, bProjetosDifusao);
		setVisibility(rbProjetosDifusaoValores, bProjetosDifusao);
		setVisibility(rbProjetosIniciacaoQuantidade, bProjetosIniciacao);
		setVisibility(rbProjetosIniciacaoValores, bProjetosIniciacao);
		setVisibility(rbProjetosJovensQuantidade, bProjetosJovens);
		setVisibility(rbProjetosJovensValores, bProjetosJovens);
		setVisibility(rbAlunosTurmaFundamental, bAlunosTurma);
		setVisibility(rbAlunosTurmaMedio, bAlunosTurma);
		setVisibility(rbHorasAulaFundamental, bHorasAula);
		setVisibility(rbHorasAulaMedio, bHorasAula);
		setVisibility(rbTaxaDeDistorcaoFundamental, bTaxaDistorcao);
		setVisibility(rbTaxaDeDistorcaoMedio, bTaxaDistorcao);
		setVisibility(rbTaxaDeAprocaoFundamental, bAprovacao);
		setVisibility(rbTaxaDeAprovacaoMedio, bAprovacao);
		setVisibility(rbTaxaDeAbandonoFundamental, bTaxaAbandono);
		setVisibility(rbTaxaDeAbandonoMedio, bTaxaAbandono);
		setVisibility(rbCensoAnosIniciaisFundamental, bCenso);
		setVisibility(rbCensoAnosFinaisFundamental, bCenso);
		setVisibility(rbCensoEsninoMedio, bCenso);
		setVisibility(rbCensoEJAFundamental, bCenso);
		setVisibility(rbCensoEJAMedio, bCenso);
	}
	
	public void clickButtonNext(View view) {
		Intent intent = new Intent(this, ScreenGraph.class);
		
		intent.putExtra("INDEX_CHOOSED_STATE1", position1);
		intent.putExtra("INDEX_CHOOSED_STATE2", position2);
		intent.putExtra("INDICATIVO", getIndicative());
		intent.putExtra("TITULO", getTittle());

		startActivity(intent);		
	}
    
    public void openAboutScreen() {
    	Intent intent = new Intent(this, TelaSobreEscolheIndicativoGraficoComparacao.class);
    	startActivity(intent);
    }
}
