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

public class TelaResultadoConsulta extends Activity {

	private TextView textViewSigla1;
	private TextView textViewNome1;
	private TextView textViewPopulacao1;
	private TextView textViewPopulacaoValor1;
	private TextView textViewParticipacaoEstadualPib1;
	private TextView textViewParticipacaoPib1;
	private TextView textViewNumeroProjetos1;
	private TextView textViewQuantidadeProjetosCienciaTecnologia1;
	private TextView textViewValorProjetosCienciaTecnologia1;
	private TextView textViewIdeb1;
	private TextView textViewFundamentalIdeb1;
	private TextView textViewEnsinoMedioIdeb1;
	private TextView textViewIniciaisIdeb1;
	private TextView textViewProgramaPrimeirosProjetos1;
	private TextView textViewQuantidadePrimeirosProjetos1;
	private TextView textViewValorPrimeirosProjetos1;
	private TextView textViewProjetosPesquisa1;
	private TextView textViewQuantidadePesquisa1;
	private TextView textViewJovensPesquisadores1;
	private TextView textViewQuantidadeJovensPesquisadores1;
	private TextView textViewValoresPesquisa1;
	private TextView textViewValorJovensPesquisadores1;
	private TextView textViewProjetosIniciacao1;
	private TextView textViewQuantidadeProjetosIniciacao1;
	private TextView textViewValorProjetosIniciacao1;
	private TextView textViewCenso1;
	private TextView textViewCensoIniciaisFundamental1;
	private TextView textViewCensoFinaisFundamental1;
	private TextView textViewCensoMedio1;
	private TextView textViewCensoEjaFundamental1;
	private TextView textViewCensoEjaMedio1;
	private TextView textViewMediaAlunosPorTurma1;
	private TextView textViewMediaAlunosPorTurmaFundamental1;
	private TextView textViewMediaAlunosPorTurmaMedio1;
	private TextView textViewMediaHorasAula1;
	private TextView textViewMediaHorasAulaFundamental1;
	private TextView textViewMediaHorasAulaMedio1;
	private TextView textViewTaxaDistorcao1;
	private TextView textViewTaxaDistorcaoIdadeSerieFundamental1;
	private TextView textViewTaxaDistorcaoIdadeSerieMedio1;
	private TextView textViewTaxaDeAproveitamento1;
	private TextView textViewTaxaDeAproveitamentoFundamental1;
	private TextView textViewTaxaDeAproveitamentoMedio1;
	private TextView textViewTaxaDeAbandono1;
	private TextView textViewTaxaDeAbandonoFundamental1;
	private TextView textViewTaxaDeAbandonoMedio1;
	
	private TextView textViewSigla2;
	private TextView textViewNome2;
	private TextView textViewPopulacao2;
	private TextView textViewPopulacaoValor2;
	private TextView textViewParticipacaoEstadualPib2;
	private TextView textViewParticipacaoPib2;
	private TextView textViewNumeroProjetos2;
	private TextView textViewQuantidadeProjetosCienciaTecnologia2;
	private TextView textViewValorProjetosCienciaTecnologia2;
	private TextView textViewIdeb2;
	private TextView textViewFundamentalIdeb2;
	private TextView textViewEnsinoMedioIdeb2;
	private TextView textViewIniciaisIdeb2;
	private TextView textViewProgramaPrimeirosProjetos2;
	private TextView textViewQuantidadePrimeirosProjetos2;
	private TextView textViewValorPrimeirosProjetos2;
	private TextView textViewProjetosPesquisa2;
	private TextView textViewQuantidadePesquisa2;
	private TextView textViewJovensPesquisadores2;
	private TextView textViewQuantidadeJovensPesquisadores2;
	private TextView textViewValoresPesquisa2;
	private TextView textViewValorJovensPesquisadores2;
	private TextView textViewProjetosIniciacao2;
	private TextView textViewQuantidadeProjetosIniciacao2;
	private TextView textViewValorProjetosIniciacao2;
	private TextView textViewCenso2;
	private TextView textViewCensoIniciaisFundamental2;
	private TextView textViewCensoFinaisFundamental2;
	private TextView textViewCensoMedio2;
	private TextView textViewCensoEjaFundamental2;
	private TextView textViewCensoEjaMedio2;
	private TextView textViewMediaAlunosPorTurma2;
	private TextView textViewMediaAlunosPorTurmaFundamental2;
	private TextView textViewMediaAlunosPorTurmaMedio2;
	private TextView textViewMediaHorasAula2;
	private TextView textViewMediaHorasAulaFundamental2;
	private TextView textViewMediaHorasAulaMedio2;
	private TextView textViewTaxaDistorcao2;
	private TextView textViewTaxaDistorcaoIdadeSerieFundamental2;
	private TextView textViewTaxaDistorcaoIdadeSerieMedio2;
	private TextView textViewTaxaDeAproveitamento2;
	private TextView textViewTaxaDeAproveitamentoFundamental2;
	private TextView textViewTaxaDeAproveitamentoMedio2;
	private TextView textViewTaxaDeAbandono2;
	private TextView textViewTaxaDeAbandonoFundamental2;
	private TextView textViewTaxaDeAbandonoMedio2;
	
	private boolean  censusView, studentsClassView, hoursPerClassView, distortionRateView, schoolDropoutRateView,
			approvalView, idebView, pibView, populationView, firstProjectsView, cnpqProjectsView,
			projectDiffusionView, initiationProjectsView, jovensProjectsView;
	
	private ImageView imageViewBandeira01; 
	private ImageView imageViewBandeira02; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_compara_estados);
		
		InicializaCamposTexto();
		catchInformation();
		escondeCamposDeTexto();
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
		Intent intent = new Intent(this, TelaSobreComparacaoDeEstados.class);
    	startActivity(intent);
		
	}
	
	@SuppressWarnings("unchecked")
	private void catchInformation() {
		
		// Captura o intent que abriu a activity
		Intent intent = getIntent();
		// Captura o valor transferido atraves da intent
		
		int position1 = intent.getIntExtra("INDEX_ESTADO1_ESCOLHIDO",5);
		int position2 = intent.getIntExtra("INDEX_ESTADO2_ESCOLHIDO",0);
		
		capturaBandeiras(position1, position2);
		
		idebView = intent.getBooleanExtra("CB_IDEB", false);
		pibView = intent.getBooleanExtra("CB_PIB", false);
		populationView = intent.getBooleanExtra("CB_POPULACAO", false);
		firstProjectsView = intent.getBooleanExtra("CB_PRIMEIROS_PROJETOS", false);
		cnpqProjectsView = intent.getBooleanExtra("CB_PROJETOS_CNPQ", false);
		projectDiffusionView = intent.getBooleanExtra("CB_PROJETOS_DIFUSAO", false);
		initiationProjectsView = intent.getBooleanExtra("CB_PROJETOS_INICIACAO", false);
		jovensProjectsView = intent.getBooleanExtra("CB_PROJETOS_JOVENS", false);
		censusView = intent.getBooleanExtra("CB_CENSO", false);
		studentsClassView = intent.getBooleanExtra("CB_ALUNOS_TURMA", false);
		hoursPerClassView = intent.getBooleanExtra("CB_HORAS_AULA", false);
		distortionRateView = intent.getBooleanExtra("CB_TAXA_DISTORCAO", false);
		schoolDropoutRateView = intent.getBooleanExtra("CB_TAXA_ABANDONO", false);
		approvalView = intent.getBooleanExtra("CB_APROVACAO", false);

		HashMap<String, String> stateInformations1 = new HashMap<String, String>();
		HashMap<String, String> stateInformations2 = new HashMap<String, String>();

		try {
			stateInformations1 = (HashMap<String, String>) StateConroller
					.getInstance(this).lerEstado(position1).clone();
			stateInformations2 = (HashMap<String, String>) StateConroller
					.getInstance(this).lerEstado(position2).clone();

			preencheCamposTexto(stateInformations1, stateInformations2);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso es informaeees.", Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaComparaEstados",e.toString());
		}
	}

	private void preencheCamposTexto(HashMap<String, String> informacoes1,
			HashMap<String, String> informacoes2) {

		textViewSigla1.setText(informacoes1.get("sigla"));
		if (textViewNome1 != null)
			textViewNome1.setText(informacoes1.get("nome"));

		textViewPopulacaoValor1.setText(informacoes1.get("populacao"));			
		textViewParticipacaoPib1.setText(informacoes1.get("percentual_participacao_pib"));
		textViewQuantidadeProjetosCienciaTecnologia1.setText(informacoes1.get("projetos_ciencia_tecnologia"));
		textViewValorProjetosCienciaTecnologia1.setText(informacoes1.get("valor_ciencia_tecnologia"));
		textViewFundamentalIdeb1.setText(informacoes1.get("ideb_fundamental_final"));
		textViewEnsinoMedioIdeb1.setText(informacoes1.get("ideb_ensino_medio"));
		textViewIniciaisIdeb1.setText(informacoes1.get("ideb_fundamental_inicial"));
		textViewQuantidadePrimeirosProjetos1.setText(informacoes1.get("quantidade_primeiros_projetos"));
		textViewValorPrimeirosProjetos1.setText(informacoes1.get("valor_primeiros_projetos"));
		textViewQuantidadePesquisa1.setText(informacoes1.get("quantidade_projeto_cnpq"));
		textViewValoresPesquisa1.setText(informacoes1.get("valor_projetos_cnpq"));
		textViewQuantidadeJovensPesquisadores1.setText(informacoes1.get("quantidade_projeto_jovens_pesquisadores"));
		textViewValorJovensPesquisadores1.setText(informacoes1.get("valor_projetos_jovens_pesquisadores"));
		textViewQuantidadeProjetosIniciacao1.setText(informacoes1.get("quantidade_projetos_inct"));
		textViewValorProjetosIniciacao1.setText(informacoes1.get("valor_projetos_inct"));
		textViewCensoIniciaisFundamental1.setText(informacoes1.get("censo_anos_iniciais_fundamental"));
		textViewCensoFinaisFundamental1.setText(informacoes1.get("censo_anos_finais_fundamental"));
		textViewCensoMedio1.setText(informacoes1.get("censo_ensino_medio"));
		textViewCensoEjaFundamental1.setText(informacoes1.get("censo_eja_fundamental"));
		textViewCensoEjaMedio1.setText(informacoes1.get("censo_eja_medio"));
		textViewMediaAlunosPorTurmaFundamental1.setText(informacoes1.get("alunos_por_turma_ensino_fundamental"));
		textViewMediaAlunosPorTurmaMedio1.setText(informacoes1.get("alunos_por_turma_ensino_medio"));
		textViewMediaHorasAulaFundamental1.setText(informacoes1.get("horas_aula_ensino_fundamental"));
		textViewMediaHorasAulaMedio1.setText(informacoes1.get("horas_aula_ensino_medio"));
		textViewTaxaDistorcaoIdadeSerieFundamental1.setText(informacoes1.get("taxa_distorcao_fundamental"));
		textViewTaxaDistorcaoIdadeSerieMedio1.setText(informacoes1.get("taxa_distorcao_medio"));
		textViewTaxaDeAproveitamentoFundamental1.setText(informacoes1.get("taxa_aprovacao_fundamental"));
		textViewTaxaDeAproveitamentoMedio1.setText(informacoes1.get("taxa_aprovacao_medio"));
		textViewTaxaDeAbandonoFundamental1.setText(informacoes1.get("taxa_aprovacao_fundamental"));
		textViewTaxaDeAbandonoMedio1.setText(informacoes1.get("taxa_aprovacao_medio"));

		textViewSigla2.setText(informacoes2.get("sigla"));
		if (textViewNome2 != null)
			textViewNome2.setText(informacoes2.get("nome"));

		textViewPopulacaoValor2.setText(informacoes2.get("populacao"));
		textViewParticipacaoPib2.setText(informacoes2.get("percentual_participacao_pib"));
		textViewQuantidadeProjetosCienciaTecnologia2.setText(informacoes2.get("projetos_ciencia_tecnologia").split(":")[1]);
		textViewValorProjetosCienciaTecnologia2.setText(informacoes2.get("valor_ciencia_tecnologia").split(":")[1]);
		textViewFundamentalIdeb2.setText(informacoes2.get("ideb_fundamental_final").split(":")[1]);
		textViewEnsinoMedioIdeb2.setText(informacoes2.get("ideb_ensino_medio").split(":")[1]);
		textViewIniciaisIdeb2.setText(informacoes2.get("ideb_fundamental_inicial").split(":")[1]);
		textViewQuantidadePrimeirosProjetos2.setText(informacoes2.get("quantidade_primeiros_projetos").split(":")[1]);
		textViewValorPrimeirosProjetos2.setText(informacoes2.get("valor_primeiros_projetos").split(":")[1]);
		textViewQuantidadePesquisa2.setText(informacoes2.get("quantidade_projeto_cnpq").split(":")[1]);
		textViewValoresPesquisa2.setText(informacoes2.get("valor_projetos_cnpq").split(":")[1]);
		textViewQuantidadeJovensPesquisadores2.setText(informacoes2.get("quantidade_projeto_jovens_pesquisadores").split(":")[1]);
		textViewValorJovensPesquisadores2.setText(informacoes2.get("valor_projetos_jovens_pesquisadores").split(":")[1]);
		textViewQuantidadeProjetosIniciacao2.setText(informacoes2.get("quantidade_projetos_inct").split(":")[1]);
		textViewValorProjetosIniciacao2.setText(informacoes2.get("valor_projetos_inct").split(":")[1]);
		textViewCensoIniciaisFundamental2.setText(informacoes2.get("censo_anos_iniciais_fundamental").split(":")[1]);
		textViewCensoFinaisFundamental2.setText(informacoes2.get("censo_anos_finais_fundamental").split(":")[1]);
		textViewCensoMedio2.setText(informacoes2.get("censo_ensino_medio").split(":")[1]);
		textViewCensoEjaFundamental2.setText(informacoes2.get("censo_eja_fundamental").split(":")[1]);
		textViewCensoEjaMedio2.setText(informacoes2.get("censo_eja_medio").split(":")[1]);
		textViewMediaAlunosPorTurmaFundamental2.setText(informacoes2.get("alunos_por_turma_ensino_fundamental").split(":")[1]);
		textViewMediaAlunosPorTurmaMedio2.setText(informacoes2.get("alunos_por_turma_ensino_medio").split(":")[1]);
		textViewMediaHorasAulaFundamental2.setText(informacoes2.get("horas_aula_ensino_fundamental").split(":")[1]);
		textViewMediaHorasAulaMedio2.setText(informacoes2.get("horas_aula_ensino_medio").split(":")[1]);
		textViewTaxaDistorcaoIdadeSerieFundamental2.setText(informacoes2.get("taxa_distorcao_fundamental").split(":")[1]);
		textViewTaxaDistorcaoIdadeSerieMedio2.setText(informacoes2.get("taxa_distorcao_medio").split(":")[1]);
		textViewTaxaDeAproveitamentoFundamental2.setText(informacoes2.get("taxa_aprovacao_fundamental").split(":")[1]);
		textViewTaxaDeAproveitamentoMedio2.setText(informacoes2.get("taxa_aprovacao_medio").split(":")[1]);
		textViewTaxaDeAbandonoFundamental2.setText(informacoes2.get("taxa_aprovacao_fundamental").split(":")[1]);
		textViewTaxaDeAbandonoMedio2.setText(informacoes2.get("taxa_aprovacao_medio").split(":")[1]);

	}

	private void InicializaCamposTexto() {

		textViewSigla1 = (TextView) findViewById(R.id.textView_sigla1);
		textViewNome1 = (TextView) findViewById(R.id.textView_nome_estado1);		
		textViewPopulacaoValor1 = (TextView) findViewById(R.id.textView_populacao_valor1);
		textViewPopulacao1 = (TextView) findViewById(R.id.textView_populacao1);
		textViewParticipacaoEstadualPib1 = (TextView) findViewById(R.id.textView_participacao_estadual_pib1);
		textViewParticipacaoPib1 = (TextView) findViewById(R.id.textView_participacao_pib_valor1);
		textViewNumeroProjetos1 =  (TextView) findViewById(R.id.textView_numero_projetos1);
		textViewQuantidadeProjetosCienciaTecnologia1 = (TextView) findViewById(R.id.textView_numero_projetos_quantidade1);
		textViewValorProjetosCienciaTecnologia1 = (TextView) findViewById(R.id.textView_valor_investido_projetos1);
		textViewIdeb1 = (TextView) findViewById(R.id.textView_ideb1);
		textViewFundamentalIdeb1 = (TextView) findViewById(R.id.textView_ideb_fundamental1);
		textViewEnsinoMedioIdeb1 = (TextView) findViewById(R.id.textView_ideb_ensinomedio1);
		textViewIniciaisIdeb1 = (TextView) findViewById(R.id.textView_ideb_iniciais1);
		textViewProgramaPrimeirosProjetos1 = (TextView) findViewById(R.id.textView_programa_primeiros_projetos1);
		textViewQuantidadePrimeirosProjetos1 = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade1);
		textViewValorPrimeirosProjetos1 = (TextView) findViewById(R.id.textView_programa_primeiros_projetos_valor1);
		textViewProjetosPesquisa1 = (TextView) findViewById(R.id.textView_projetos_pesquisa1);
		textViewQuantidadePesquisa1 = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade1);
		textViewValoresPesquisa1 = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa1);
		textViewQuantidadeJovensPesquisadores1 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade1);
		textViewJovensPesquisadores1 = (TextView) findViewById(R.id.textView_jovens_pesquisadores1);
		textViewValorJovensPesquisadores1 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor1);
		textViewProjetosIniciacao1 = (TextView) findViewById(R.id.textView_projetos_iniciacao1);
		textViewQuantidadeProjetosIniciacao1 = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade1);
		textViewValorProjetosIniciacao1 = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor1);
		textViewTaxaDeAbandono1 = (TextView) findViewById(R.id.textView_taxa_abandono1);
		textViewTaxaDeAproveitamento1  = (TextView) findViewById(R.id.textView_taxa_aprovacao1); 
		textViewCenso1  = (TextView) findViewById(R.id.textView_censo1);
		textViewMediaAlunosPorTurma1  = (TextView) findViewById(R.id.textView_media_alunos_por_turma1);
		textViewMediaHorasAula1 = (TextView) findViewById(R.id.textView_horas_aula_ensino1);
		textViewTaxaDistorcao1 = (TextView) findViewById(R.id.textView_taxa_distorcao1);
		textViewCensoIniciaisFundamental1 = (TextView) findViewById(R.id.textView_censo_iniciais_fundamental1);
		textViewCensoFinaisFundamental1 = (TextView) findViewById(R.id.textView_censo_finais_fundamental1);
		textViewCensoMedio1 = (TextView) findViewById(R.id.textView_censo_medio1);
		textViewCensoEjaFundamental1 = (TextView) findViewById(R.id.textView_censo_fundamental_eja1);
		textViewCensoEjaMedio1 = (TextView) findViewById(R.id.textView_censo_medio_eja1);
		textViewMediaAlunosPorTurmaFundamental1 = (TextView) findViewById(R.id.textView_media_alunos_por_turma_fundamental1);
		textViewMediaAlunosPorTurmaMedio1 = (TextView) findViewById(R.id.textView_media_alunos_por_turma_medio1);
		textViewMediaHorasAulaFundamental1 = (TextView) findViewById(R.id.textView_horas_aula_ensino_fundamental1);
		textViewMediaHorasAulaMedio1 = (TextView) findViewById(R.id.textView_horas_aula_ensino_medio1);
		textViewTaxaDistorcaoIdadeSerieFundamental1 = (TextView) findViewById(R.id.textView_taxa_distorcao_fundamental1);
		textViewTaxaDistorcaoIdadeSerieMedio1 = (TextView) findViewById(R.id.textView_taxa_distorcao_medio1);
		textViewTaxaDeAproveitamentoFundamental1 = (TextView) findViewById(R.id.textView_taxa_aprovacao_fundamental1);
		textViewTaxaDeAproveitamentoMedio1 = (TextView) findViewById(R.id.textView_taxa_aprovacao_medio1);
		textViewTaxaDeAbandonoFundamental1 = (TextView) findViewById(R.id.textView_taxa_abandono_fundamental1);
		textViewTaxaDeAbandonoMedio1 = (TextView) findViewById(R.id.textView_taxa_abandono_medio1);
	
		textViewSigla2 = (TextView) findViewById(R.id.textView_sigla2);
		textViewNome2 = (TextView) findViewById(R.id.textView_nome_estado2);		
		textViewPopulacaoValor2 = (TextView) findViewById(R.id.textView_populacao_valor2);
		textViewPopulacao2 = (TextView) findViewById(R.id.textView_populacao2);
		textViewParticipacaoEstadualPib2 = (TextView) findViewById(R.id.textView_participacao_estadual_pib2);
		textViewParticipacaoPib2 = (TextView) findViewById(R.id.textView_participacao_pib_valor2);
		textViewNumeroProjetos2 =  (TextView) findViewById(R.id.textView_numero_projetos2);
		textViewQuantidadeProjetosCienciaTecnologia2 = (TextView) findViewById(R.id.textView_numero_projetos_quantidade2);
		textViewValorProjetosCienciaTecnologia2 = (TextView) findViewById(R.id.textView_valor_investido_projetos2);
		textViewIdeb2 = (TextView) findViewById(R.id.textView_ideb2);
		textViewFundamentalIdeb2 = (TextView) findViewById(R.id.textView_ideb_fundamental2);
		textViewEnsinoMedioIdeb2 = (TextView) findViewById(R.id.textView_ideb_ensinomedio2);
		textViewIniciaisIdeb2 = (TextView) findViewById(R.id.textView_ideb_iniciais2);
		textViewProgramaPrimeirosProjetos2 = (TextView) findViewById(R.id.textView_programa_primeiros_projetos2);
		textViewQuantidadePrimeirosProjetos2 = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade2);
		textViewValorPrimeirosProjetos2 = (TextView) findViewById(R.id.textView_programa_primeiros_projetos_valor2);
		textViewProjetosPesquisa2 = (TextView) findViewById(R.id.textView_projetos_pesquisa2);
		textViewQuantidadePesquisa2 = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade2);
		textViewValoresPesquisa2 = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa2);
		textViewJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores2);
		textViewQuantidadeJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade2);
		textViewValorJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor2);
		textViewProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao2);
		textViewQuantidadeProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade2);
		textViewValorProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor2);
		
		textViewTaxaDeAbandono2 = (TextView) findViewById(R.id.textView_taxa_abandono2);
		textViewTaxaDeAproveitamento2  = (TextView) findViewById(R.id.textView_taxa_aprovacao2); 
		textViewCenso2  = (TextView) findViewById(R.id.textView_censo2);
		textViewMediaAlunosPorTurma2  = (TextView) findViewById(R.id.textView_media_alunos_por_turma2);
		textViewMediaHorasAula2 = (TextView) findViewById(R.id.textView_horas_aula_ensino2);
		textViewTaxaDistorcao2 = (TextView) findViewById(R.id.textView_taxa_distorcao2);

		textViewCensoIniciaisFundamental2 = (TextView) findViewById(R.id.textView_censo_iniciais_fundamental2);
		textViewCensoFinaisFundamental2 = (TextView) findViewById(R.id.textView_censo_finais_fundamental2);
		textViewCensoMedio2 = (TextView) findViewById(R.id.textView_censo_medio2);
		textViewCensoEjaFundamental2 = (TextView) findViewById(R.id.textView_censo_fundamental_eja2);
		textViewCensoEjaMedio2 = (TextView) findViewById(R.id.textView_censo_medio_eja2);
		textViewMediaAlunosPorTurmaFundamental2 = (TextView) findViewById(R.id.textView_media_alunos_por_turma_fundamental2);
		textViewMediaAlunosPorTurmaMedio2 = (TextView) findViewById(R.id.textView_media_alunos_por_turma_medio2);
		textViewMediaHorasAulaFundamental2 = (TextView) findViewById(R.id.textView_horas_aula_ensino_fundamental2);
		textViewMediaHorasAulaMedio2 = (TextView) findViewById(R.id.textView_horas_aula_ensino_medio2);
		textViewTaxaDistorcaoIdadeSerieFundamental2 = (TextView) findViewById(R.id.textView_taxa_distorcao_fundamental2);
		textViewTaxaDistorcaoIdadeSerieMedio2 = (TextView) findViewById(R.id.textView_taxa_distorcao_medio2);
		textViewTaxaDeAproveitamentoFundamental2 = (TextView) findViewById(R.id.textView_taxa_aprovacao_fundamental2);
		textViewTaxaDeAproveitamentoMedio2 = (TextView) findViewById(R.id.textView_taxa_aprovacao_medio2);
		textViewTaxaDeAbandonoFundamental2 = (TextView) findViewById(R.id.textView_taxa_abandono_fundamental2);
		textViewTaxaDeAbandonoMedio2 = (TextView) findViewById(R.id.textView_taxa_abandono_medio2);
	}
	
	public void setVisibility(TextView txtView, boolean visibility) {
		int visibilityValue = (visibility) ? View.VISIBLE : View.GONE;
		txtView.setVisibility(visibilityValue);
	}
	
	public void escondeCamposDeTexto() {
		setVisibility(textViewPopulacao1, populationView);
		setVisibility(textViewPopulacaoValor1, populationView);
		setVisibility(textViewPopulacaoValor2, populationView);
		
		setVisibility(textViewIdeb1, idebView);
		setVisibility(textViewFundamentalIdeb1, idebView);
		setVisibility(textViewEnsinoMedioIdeb1, idebView);
		setVisibility(textViewIniciaisIdeb1, idebView);
		setVisibility(textViewFundamentalIdeb2, idebView);
		setVisibility(textViewEnsinoMedioIdeb2, idebView);
		setVisibility(textViewIniciaisIdeb2, idebView);

		setVisibility(textViewParticipacaoEstadualPib1, pibView);
		setVisibility(textViewParticipacaoPib1, pibView);
		setVisibility(textViewParticipacaoPib2, pibView);
		
		setVisibility(textViewProgramaPrimeirosProjetos1, firstProjectsView);
		setVisibility(textViewQuantidadePrimeirosProjetos1, firstProjectsView);
		setVisibility(textViewValorPrimeirosProjetos1, firstProjectsView);
		setVisibility(textViewQuantidadePrimeirosProjetos2, firstProjectsView);
		setVisibility(textViewValorPrimeirosProjetos2, firstProjectsView);
		
		setVisibility(textViewProjetosPesquisa1, cnpqProjectsView);
		setVisibility(textViewQuantidadePesquisa1, cnpqProjectsView);
		setVisibility(textViewValoresPesquisa1, cnpqProjectsView);
		setVisibility(textViewQuantidadePesquisa2, cnpqProjectsView);
		setVisibility(textViewValoresPesquisa2, cnpqProjectsView);

		setVisibility(textViewJovensPesquisadores1, jovensProjectsView);
		setVisibility(textViewQuantidadeJovensPesquisadores1, jovensProjectsView);
		setVisibility(textViewValorJovensPesquisadores1, jovensProjectsView);
		setVisibility(textViewQuantidadeJovensPesquisadores2, jovensProjectsView);
		setVisibility(textViewValorJovensPesquisadores2, jovensProjectsView);

		setVisibility(textViewProjetosIniciacao1, initiationProjectsView);
		setVisibility(textViewQuantidadeProjetosIniciacao1, initiationProjectsView);
		setVisibility(textViewValorProjetosIniciacao1, initiationProjectsView);
		setVisibility(textViewQuantidadeProjetosIniciacao2, initiationProjectsView);
		setVisibility(textViewValorProjetosIniciacao2, initiationProjectsView);

		setVisibility(textViewNumeroProjetos1, projectDiffusionView);
		setVisibility(textViewQuantidadeProjetosCienciaTecnologia1, projectDiffusionView);
		setVisibility(textViewValorProjetosCienciaTecnologia1, projectDiffusionView);
		setVisibility(textViewQuantidadeProjetosCienciaTecnologia2, projectDiffusionView);
		setVisibility(textViewValorProjetosCienciaTecnologia2, projectDiffusionView);
		
		setVisibility(textViewCenso1, censusView);
		setVisibility(textViewCensoEjaFundamental1, censusView);
		setVisibility(textViewCensoEjaMedio1, censusView);
		setVisibility(textViewCensoFinaisFundamental1, censusView);
		setVisibility(textViewCensoIniciaisFundamental1, censusView);
		setVisibility(textViewCensoMedio1, censusView);
		setVisibility(textViewCensoEjaFundamental2, censusView);
		setVisibility(textViewCensoEjaMedio2, censusView);
		setVisibility(textViewCensoFinaisFundamental2, censusView);
		setVisibility(textViewCensoIniciaisFundamental2, censusView);
		setVisibility(textViewCensoMedio2, censusView);
		
		setVisibility(textViewMediaAlunosPorTurma1, studentsClassView);
		setVisibility(textViewMediaAlunosPorTurmaFundamental1, studentsClassView);
		setVisibility(textViewMediaAlunosPorTurmaMedio1, studentsClassView);
		setVisibility(textViewMediaAlunosPorTurmaFundamental2, studentsClassView);
		setVisibility(textViewMediaAlunosPorTurmaMedio2, studentsClassView);
		
		setVisibility(textViewMediaHorasAula1, hoursPerClassView);
		setVisibility(textViewMediaHorasAulaFundamental1, hoursPerClassView);
		setVisibility(textViewMediaHorasAulaMedio1, hoursPerClassView);
		setVisibility(textViewMediaHorasAulaFundamental2, hoursPerClassView);
		setVisibility(textViewMediaHorasAulaMedio2, hoursPerClassView);
		
		setVisibility(textViewTaxaDistorcao1, distortionRateView);
		setVisibility(textViewTaxaDistorcaoIdadeSerieFundamental1, distortionRateView);
		setVisibility(textViewTaxaDistorcaoIdadeSerieMedio1, distortionRateView);
		setVisibility(textViewTaxaDistorcaoIdadeSerieFundamental2, distortionRateView);
		setVisibility(textViewTaxaDistorcaoIdadeSerieMedio2, distortionRateView);
		
		setVisibility(textViewTaxaDeAbandono1, schoolDropoutRateView);
		setVisibility(textViewTaxaDeAbandonoFundamental1, schoolDropoutRateView);
		setVisibility(textViewTaxaDeAbandonoMedio1, schoolDropoutRateView);
		setVisibility(textViewTaxaDeAbandonoFundamental2, schoolDropoutRateView);
		setVisibility(textViewTaxaDeAbandonoMedio2, schoolDropoutRateView);
		
		setVisibility(textViewTaxaDeAproveitamento1, approvalView);
		setVisibility(textViewTaxaDeAproveitamentoFundamental1, approvalView);
		setVisibility(textViewTaxaDeAproveitamentoMedio1, approvalView);
		setVisibility(textViewTaxaDeAproveitamentoFundamental2, approvalView);
		setVisibility(textViewTaxaDeAproveitamentoMedio2, approvalView);
		
		try {
			Log.i("teste visibility", "populacao");
			setVisibility(textViewPopulacao2, populationView);
			Log.i("teste visibility", "ideb");
			setVisibility(textViewIdeb2, idebView);
			Log.i("teste visibility", "participacao");
			setVisibility(textViewParticipacaoEstadualPib2, pibView);
			Log.i("teste visibility", "primeiros projetos");
			setVisibility(textViewProgramaPrimeirosProjetos2, firstProjectsView);
			Log.i("teste visibility", "cnpq");
			setVisibility(textViewProjetosPesquisa2, cnpqProjectsView);
			Log.i("teste visibility", "jovens");
			setVisibility(textViewJovensPesquisadores2, jovensProjectsView);
			Log.i("teste visibility", "inct");
			setVisibility(textViewProjetosIniciacao2, initiationProjectsView);
			setVisibility(textViewNumeroProjetos2, projectDiffusionView);
			setVisibility(textViewCenso2, censusView);
			setVisibility(textViewMediaAlunosPorTurma2, studentsClassView);
			setVisibility(textViewMediaHorasAula2, hoursPerClassView);
			setVisibility(textViewTaxaDistorcao2, distortionRateView);
			setVisibility(textViewTaxaDeAbandono2, schoolDropoutRateView);
			setVisibility(textViewTaxaDeAproveitamento2, approvalView);
		} catch(NullPointerException npe) {
			Log.i("NullPointerException - layout portrait não possui estes id's",npe.toString());
		}
						
	}
	
	public void clickBotaoGeraGrafico(View view) {
		Intent intent = new Intent(this, ChooseIndicativeWithCompareGraphScreen.class);
		Intent intent1 = getIntent();

		int position1 = intent1.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		int position2 = intent1.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);

		intent.putExtra("CB_IDEB", idebView);
		intent.putExtra("CB_PIB", pibView);
		intent.putExtra("CB_POPULACAO", populationView);
		intent.putExtra("CB_PRIMEIROS_PROJETOS", firstProjectsView);
		intent.putExtra("CB_PROJETOS_CNPQ", cnpqProjectsView);
		intent.putExtra("CB_PROJETOS_DIFUSAO", projectDiffusionView);
		intent.putExtra("CB_PROJETOS_INICIACAO", initiationProjectsView);
		intent.putExtra("CB_PROJETOS_JOVENS", jovensProjectsView);
		intent.putExtra("CB_ALUNOS_TURMA", studentsClassView);
		intent.putExtra("CB_APROVACAO", approvalView);
		intent.putExtra("CB_CENSO", censusView);
		intent.putExtra("CB_HORAS_AULA", hoursPerClassView);
		intent.putExtra("CB_TAXA_ABANDONO", schoolDropoutRateView);
		intent.putExtra("CB_TAXA_DISTORCAO", distortionRateView);
		
		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", position1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", position2);

		startActivity(intent);
	}
	
	public void capturaBandeiras(int positionEstado1, int positionEstado2){
		String bandeiras[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", 
				"ceara", "distritofederal", "espiritosanto", "goias", "maranhao",
				"matogrosso", "matogrossodosul", "minasgerais", "para", "paraiba",
				"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
				"riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo",
				"sergipe", "tocantins"};	
		
		imageViewBandeira01 = (ImageView) findViewById(R.id.imageView_bandeiras1);
		int idBandeira01 = getResources().getIdentifier(bandeiras[positionEstado1], "drawable", getPackageName());
		imageViewBandeira01.setImageResource(idBandeira01);
	
		imageViewBandeira02 = (ImageView) findViewById(R.id.imageView_bandeiras2);
		int idBandeira02 = getResources().getIdentifier(bandeiras[positionEstado2], "drawable", getPackageName());
		imageViewBandeira02.setImageResource(idBandeira02);
	
		
		
	}
}

