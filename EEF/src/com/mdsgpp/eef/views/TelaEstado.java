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

public class TelaEstado extends Activity {

	private TextView textViewSigla;	
	private TextView textViewNome;
	private TextView textViewPopulacao;
	private TextView textViewParticipacaoPib;
	private TextView textViewQuantidadeProjetosCienciaTecnologia;
	private TextView textViewValorProjetosCienciaTecnologia;
	private TextView textViewFundamentalIdeb;
	private TextView textViewEnsinoMedioIdeb;
	private TextView textViewIniciaisIdeb;
	private	TextView textViewQuantidadePrimeirosProjetos;
	private TextView textViewValorPrimeirosProjetos;
	private TextView textViewQuantidadePesquisa;
	private TextView textViewQuantidadeJovensPesquisadores;
	private TextView textViewValoresPesquisa;
	private TextView textViewValorJovensPesquisadores;
	private TextView textViewQuantidadeProjetosIniciacao;
	private TextView textViewValorProjetosIniciacao;
	private ImageView imageViewBandeiras;	
	private TextView textViewCensoIniciaisFundamental;
	private TextView textViewCensoFinaisFundamental;
	private TextView textViewCensoMedio;
	private TextView textViewCensoEjaFundamental;
	private TextView textViewCensoEjaMedio;
	private TextView textViewMediaAlunosPorTurmaFundamental;
	private TextView textViewMediaAlunosPorTurmaMedio;
	private TextView textViewMediaHorasAulaFundamental;
	private TextView textViewMediaHorasAulaMedio;
	private TextView textViewTaxaDistorcaoIdadeSerieFundamental;
	private TextView textViewTaxaDistorcaoIdadeSerieMedio;
	private TextView textViewTaxaDeAproveitamentoFundamental;
	private TextView textViewTaxaDeAproveitamentoMedio;
	private TextView textViewTaxaDeAbandonoFundamental;
	private TextView textViewTaxaDeAbandonoMedio;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_estado);
		
		capturaInformacoes();
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
			case R.id.sobre:
				openAboutScreen();
				break;
			case android.R.id.home:
		        NavUtils.navigateUpFromSameTask(this);
		        break;
			default:
				break;
			}
			
	    	return true;
	    }
	    
	    public void openAboutScreen() {
	    	Intent intent = new Intent(this, TelaSobreEstado.class);
	    	startActivity(intent);
	    }
	
	private void capturaInformacoes() {
		Intent intent = getIntent();
		int position = intent.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);
		
		inicializaCamposTexto();
		
	    HashMap<String, String> informacoes = new HashMap <String, String>();
	    
	    try {
			informacoes = StateConroller.getInstance(this).lerEstado(position);
			preencheCamposTexto(informacoes);
			setImagem(position);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso es informaeees.", Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaEstado", e.toString());
		}
	}
	
	private void inicializaCamposTexto() {
		
		textViewSigla = (TextView) findViewById(R.id.textView_sigla);
		textViewNome = (TextView) findViewById(R.id.textView_nome_estado);
		textViewPopulacao = (TextView) findViewById(R.id.textView_populacao_valor);
		textViewParticipacaoPib = (TextView) findViewById(R.id.textView_participacao_pib_valor);
		textViewQuantidadeProjetosCienciaTecnologia = (TextView) findViewById(R.id.textView_numero_projetos_quantidade);
		textViewValorProjetosCienciaTecnologia = (TextView) findViewById(R.id.textView_valor_investido_projetos);
		textViewFundamentalIdeb = (TextView) findViewById(R.id.textView_ideb_elementary);
		textViewEnsinoMedioIdeb = (TextView) findViewById(R.id.textView_ideb_ensinomedio);
		textViewIniciaisIdeb = (TextView) findViewById(R.id.textView_ideb_iniciais);
		textViewQuantidadePrimeirosProjetos = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade);
		textViewValorPrimeirosProjetos = (TextView) findViewById(R.id.textView_programa_primeiros_projetos_valor);
		textViewQuantidadePesquisa = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade);
		textViewValoresPesquisa = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa);
		textViewQuantidadeJovensPesquisadores = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade);
		textViewValorJovensPesquisadores= (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor);
		textViewQuantidadeProjetosIniciacao = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade);
		textViewValorProjetosIniciacao = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor);
		
		textViewCensoIniciaisFundamental = (TextView) findViewById(R.id.textView_initial_census_elementary);
		textViewCensoFinaisFundamental = (TextView) findViewById(R.id.textView_final_census_elementary);
		textViewCensoMedio = (TextView) findViewById(R.id.textView_census_high_school);
		textViewCensoEjaFundamental = (TextView) findViewById(R.id.textView_census_elementary_eja);
		textViewCensoEjaMedio = (TextView) findViewById(R.id.textView_census_high_school_eja);
		textViewMediaAlunosPorTurmaFundamental = (TextView) findViewById(R.id.textView_media_alunos_por_turma_elementary);
		textViewMediaAlunosPorTurmaMedio = (TextView) findViewById(R.id.textView_media_alunos_por_turma_high_school);
		textViewMediaHorasAulaFundamental = (TextView) findViewById(R.id.textView_horas_aula_ensino_elementary);
		textViewMediaHorasAulaMedio = (TextView) findViewById(R.id.textView_horas_aula_ensino_high_school);
		textViewTaxaDistorcaoIdadeSerieFundamental = (TextView) findViewById(R.id.textView_distortion_rate_elementary);
		textViewTaxaDistorcaoIdadeSerieMedio = (TextView) findViewById(R.id.textView_distortion_rate_high_school);
		textViewTaxaDeAproveitamentoFundamental = (TextView) findViewById(R.id.textView_approval_rate_elementary);
		textViewTaxaDeAproveitamentoMedio = (TextView) findViewById(R.id.textView_approval_rate_high_school);
		textViewTaxaDeAbandonoFundamental = (TextView) findViewById(R.id.textView_dropout_rate_elementary);
		textViewTaxaDeAbandonoMedio = (TextView) findViewById(R.id.textView_dropout_rate_high_school);
	}
	
	private void preencheCamposTexto(HashMap<String, String> informacoes) {
		textViewSigla.setText(informacoes.get("sigla"));
		textViewNome.setText(informacoes.get("nome"));
		textViewPopulacao.setText(informacoes.get("populacao"));
		textViewParticipacaoPib.setText(informacoes.get("percentual_participacao_pib"));
		textViewQuantidadeProjetosCienciaTecnologia.setText(informacoes.get("projetos_ciencia_tecnologia"));
		textViewValorProjetosCienciaTecnologia.setText(informacoes.get("valor_ciencia_tecnologia"));
		textViewFundamentalIdeb.setText(informacoes.get("ideb_elementary_final"));
		textViewEnsinoMedioIdeb.setText(informacoes.get("ideb_ensino_high_school"));
		textViewIniciaisIdeb.setText(informacoes.get("ideb_elementary_inicial"));
		textViewQuantidadePrimeirosProjetos.setText(informacoes.get("quantidade_primeiros_projetos"));
		textViewValorPrimeirosProjetos.setText(informacoes.get("valor_primeiros_projetos"));
	    textViewQuantidadePesquisa.setText(informacoes.get("quantidade_projeto_cnpq"));
		textViewValoresPesquisa.setText(informacoes.get("valor_projetos_cnpq"));
		textViewQuantidadeJovensPesquisadores.setText(informacoes.get("quantidade_projeto_jovens_pesquisadores"));
		textViewValorJovensPesquisadores.setText(informacoes.get("valor_projetos_jovens_pesquisadores"));
		textViewQuantidadeProjetosIniciacao.setText(informacoes.get("quantidade_projetos_inct"));
		textViewValorProjetosIniciacao.setText(informacoes.get("valor_projetos_inct"));
		
		textViewCensoIniciaisFundamental.setText(informacoes.get("censo_anos_iniciais_elementary"));
		textViewCensoFinaisFundamental.setText(informacoes.get("censo_anos_finais_elementary"));
		textViewCensoMedio.setText(informacoes.get("censo_ensino_high_school"));
		textViewCensoEjaFundamental.setText(informacoes.get("censo_eja_elementary"));
		textViewCensoEjaMedio.setText(informacoes.get("censo_eja_high_school"));
		textViewMediaAlunosPorTurmaFundamental.setText(informacoes.get("alunos_por_turma_ensino_elementary"));
		textViewMediaAlunosPorTurmaMedio.setText(informacoes.get("alunos_por_turma_ensino_high_school"));
		textViewMediaHorasAulaFundamental.setText(informacoes.get("horas_aula_ensino_elementary"));
		textViewMediaHorasAulaMedio.setText(informacoes.get("horas_aula_ensino_high_school"));
		textViewTaxaDistorcaoIdadeSerieFundamental.setText(informacoes.get("distortion_rate_elementary"));
		textViewTaxaDistorcaoIdadeSerieMedio.setText(informacoes.get("distortion_rate_high_school"));
		textViewTaxaDeAproveitamentoFundamental.setText(informacoes.get("taxa_aprovacao_elementary"));
		textViewTaxaDeAproveitamentoMedio.setText(informacoes.get("taxa_aprovacao_high_school"));
		textViewTaxaDeAbandonoFundamental.setText(informacoes.get("taxa_aprovacao_elementary"));
		textViewTaxaDeAbandonoMedio.setText(informacoes.get("taxa_aprovacao_high_school"));
		
	}
	
	private void setImagem(int position) {
		String bandeiras[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", 
				"ceara", "distritofederal", "espiritosanto", "goias", "maranhao",
				"matogrosso", "matogrossodosul", "minasgerais", "para", "paraiba",
				"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
				"riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo",
				"sergipe", "tocantins"};	
		
		imageViewBandeiras = (ImageView) findViewById(R.id.imageView_bandeiras);
		int idBandeira = getResources().getIdentifier(bandeiras[position], "drawable", getPackageName());
		imageViewBandeiras.setImageResource(idBandeira);
	}
	
	public void clickBotaoHistoricoEstado(View view) {
		Intent intentAux = getIntent();
		int position = intentAux.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);
		Log.i("position tela estado", position+"");
		
		Intent intent = new Intent(this, TelaHistoricoEstado.class);
		intent.putExtra("ESTADO", position);
		
		startActivity(intent);
	}

}
