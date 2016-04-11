package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public abstract class EscolheIndicativo extends Activity {

	private String indicativo = "populacao";
	private String titulo = "Populaeeo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
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
	
	public abstract void loadAboutScreen();
	
	public void onRadioButtonClicked(View view) {

		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investimento:
			setValues("valor_projetos_cnpq", "Projetos de Pesquisa Apoio CNPq (R$)");
			break;
		case R.id.radio_apoio_cnpq_qtd:
			setValues("quantidade_projeto_cnpq", "rojetos de Pesquisa Apoio CNPq (Qtd.)");
			break;
		case R.id.radio_difusao_tecnologica_investimento:
			setValues("valor_ciencia_tecnologia", "Projeto de Difuseo Tecnolegica (R$)");
			break;
		case R.id.radio_difusao_tecnologica_qtd:
			setValues("projetos_ciencia_tecnologia", "Projeto de Difuseoo Tecnolegica (Qtd.)");
			break;
		case R.id.radio_ideb_fundamental_finais:
			setValues("ideb_fundamental_final", "IDEB do Ensino Fundamental (Series Finais)");
			break;
		case R.id.radio_ideb_fundamental_iniciai:
			setValues("ideb_fundamental_inicial", "IDEB do Ensino Fundamental (Series Iniciais)");
			break;
		case R.id.radio_ideb_medio:
			setValues("ideb_ensino_medio", "IDEB do Ensino Medio");
			break;
		case R.id.radio_jovens_pesquisadores_investimento:
			setValues("valor_projetos_jovens_pesquisadores", "Jovens pesquisadores (R$)");
			break;
		case R.id.radio_jovens_pesquisadores_qtd:
			setValues("quantidade_projeto_jovens_pesquisadores", "Jovens pesquisadores (Qtd.)");
			break;
		case R.id.radio_pib:
			setValues("percentual_participacao_pib", "Participaeeo Estadual no PIB (%)");
			break;
		case R.id.radio_populacao:
			setValues("populacao", "Populaeeo");
			break;
		case R.id.radio_primeiros_projetos_investimento:
			setValues("valor_primeiros_projetos", "Programa Primeiros Projetos (R$)");
			break;
		case R.id.radio_primeiros_projetos_qtd:
			setValues("quantidade_primeiros_projetos", "Programa Primeiros Projetos (Qtd.)");
			break;
		case R.id.radio_projetos_inct_investimento:
			setValues("valor_projetos_inct", "Projetos INCT (R$)");
			break;
		case R.id.radio_projetos_inct_qtd:
			setValues("quantidade_projetos_inct", "Projetos INCT (Qtd.)");
			break;
		case R.id.radio_alunos_por_turma_fundamental:
			setValues("alunos_por_turma_ensino_fundamental", "Media de Alunos por Turma do Ensino Fundamental (Qtd.)");
			break;
		case R.id.radio_alunos_por_turma_medio:
			setValues("alunos_por_turma_ensino_medio", "Media de Alunos por Turma do Ensino Medio (Qtd.)");
			break;
		case R.id.radio_horas_aula_fundamental:
			setValues("horas_aula_ensino_fundamental", "Media de horas aula dierias do Ensino Fundamental");
			break;
		case R.id.radio_horas_aula_medio:
			setValues("horas_aula_ensino_medio", "Media de horas aula dierias do Ensino Medio");
			break;
		case R.id.radio_taxa_distorcao_fundamental:
			setValues("taxa_distorcao_fundamental", "Taxa de Distoreeo Idade/Serie do Ensino Fundamental (%)");
			break;
		case R.id.radio_taxa_distorcao_medio:
			setValues("taxa_distorcao_medio", "Taxa de Distoreeo Idade/Serie do Ensino Medio (%)");
			break;
		case R.id.radio_taxa_aprovacao_fundamental:
			setValues("taxa_aprovacao_fundamental", "Taxa de Aproveitamento do Ensino Fundamental (%)");
			break;
		case R.id.radio_taxa_aprovacao_medio:
			setValues("taxa_aprovacao_medio", "Taxa de Aproveitamento do Ensino Medio (%)");
			break;
		case R.id.radio_taxa_abandono_fundamental:
			setValues("taxa_abandono_fundamental", "Taxa de Abandono do Ensino Fundamental (%)");
			break;
		case R.id.radio_taxa_abandono_medio:
			setValues("taxa_abandono_medio", "Taxa de Abandono do Ensino Medio (%)");
			break;
		case R.id.radio_censo_iniciais_fundamental:
			setValues("censo_anos_iniciais_fundamental", "Censo Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)");
			break;
		case R.id.radio_censo_finais_fundamental:
			setValues("censo_anos_finais_fundamental", "Censo Escolar dos Anos Finais do Ensino Fundamental (Matriculados)");
			break;
		case R.id.radio_censo_ensino_medio:
			setValues("censo_ensino_medio", "Censo Escolar do Ensino Medio (Matriculados)");
			break;
		case R.id.radio_censo_eja_fundamental:
			setValues("censo_eja_fundamental", "Censo Escolar do EJA - Fundamental (Matriculados)");
			break;
		case R.id.radio_censo_eja_medio:
			setValues("censo_eja_medio", "Censo Escolar do EJA - Medio (Matriculados)");
			break;
		}
	}

	public void setValues(String indivativo, String titulo) {
		setIndicativo(indivativo);
		setTitulo(titulo);
	}

	public abstract void clickAdvanceButton(View view);

	public String getIndicative() {
		return indicativo;
	}

	public void setIndicativo(String indicativo) {
		this.indicativo = indicativo;
	}

	public String getTitle() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
