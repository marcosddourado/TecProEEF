package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public abstract class ChooseIndicative extends Activity {
	
	private String indicative = "population";
	private String tittle = "population";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_indicative_graph);
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
	
	public abstract void loadAboutScreen();
	
	public void onRadioButtonClicked(View view) {

		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investment:
			setValues("valor_projetos_cnpq", "Projetos de Pesquisa Apoio CNPq (R$)");
			break;
		case R.id.radio_apoio_cnpq_amount:
			setValues("quantidade_projeto_cnpq", "rojetos de Pesquisa Apoio CNPq (Qtd.)");
			break;
		case R.id.radio_technological_diffusion_investment:
			setValues("valor_ciencia_tecnologia", "Projeto de Difuseo Tecnolegica (R$)");
			break;
		case R.id.radio_technological_diffusion_amount:
			setValues("projetos_ciencia_tecnologia", "Projeto de Difuseoo Tecnolegica (Qtd.)");
			break;
		case R.id.radio_ideb_elementary_finals:
			setValues("ideb_elementary_final", "IDEB do Ensino Fundamental (Series Finais)");
			break;
		case R.id.radio_ideb_elementary_inicials:
			setValues("ideb_elementary_inicial", "IDEB do Ensino Fundamental (Series Iniciais)");
			break;
		case R.id.radio_ideb_high_school:
			setValues("ideb_ensino_high_school", "IDEB do Ensino Medio");
			break;
		case R.id.radio_teen_searchers_investment:
			setValues("valor_projetos_teen_searchers", "Jovens pesquisadores (R$)");
			break;
		case R.id.radio_teen_searchers_amount:
			setValues("quantidade_projeto_teen_searchers", "Jovens pesquisadores (Qtd.)");
			break;
		case R.id.radio_pib:
			setValues("percentual_pib_participation", "Participaeeo Estadual no PIB (%)");
			break;
		case R.id.radio_population:
			setValues("population", "Populaeeo");
			break;
		case R.id.radio_primeiros_projetos_investment:
			setValues("valor_primeiros_projetos", "Programa Primeiros Projetos (R$)");
			break;
		case R.id.radio_primeiros_projetos_amount:
			setValues("quantidade_primeiros_projetos", "Programa Primeiros Projetos (Qtd.)");
			break;
		case R.id.radio_inct_projects_investment:
			setValues("valor_projetos_inct", "Projetos INCT (R$)");
			break;
		case R.id.radio_inct_projects_amount:
			setValues("quantidade_projetos_inct", "Projetos INCT (Qtd.)");
			break;
		case R.id.radio_students_per_class_elementary:
			setValues("alunos_por_turma_ensino_elementary", "Media de Alunos por Turma do Ensino Fundamental (Qtd.)");
			break;
		case R.id.radio_students_per_class_high_school:
			setValues("alunos_por_turma_ensino_high_school", "Media de Alunos por Turma do Ensino Medio (Qtd.)");
			break;
		case R.id.radio_class_hours_elementary:
			setValues("daily_class_hours_average_elementary", "Media de horas aula dierias do Ensino Fundamental");
			break;
		case R.id.radio_class_hours_high_school:
			setValues("daily_class_hours_average_high_school", "Media de horas aula dierias do Ensino Medio");
			break;
		case R.id.radio_distortion_rate_elementary:
			setValues("distortion_rate_elementary", "Taxa de Distoreeo Idade/Serie do Ensino Fundamental (%)");
			break;
		case R.id.radio_distortion_rate_high_school:
			setValues("distortion_rate_high_school", "Taxa de Distoreeo Idade/Serie do Ensino Medio (%)");
			break;
		case R.id.radio_approval_rate_elementary:
			setValues("utilization_rate_elementary", "Taxa de Aproveitamento do Ensino Fundamental (%)");
			break;
		case R.id.radio_approval_rate_high_school:
			setValues("utilization_rate_high_school", "Taxa de Aproveitamento do Ensino Medio (%)");
			break;
		case R.id.radio_dropout_rate_elementary:
			setValues("dropout_rate_elementary", "Taxa de Abandono do Ensino Fundamental (%)");
			break;
		case R.id.radio_dropout_rate_high_school:
			setValues("dropout_rate_high_school", "Taxa de Abandono do Ensino Medio (%)");
			break;
		case R.id.radio_initial_census_elementary:
			setValues("census_initial_years_elemetary", "census Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)");
			break;
		case R.id.radio_final_census_elementary:
			setValues("census_final_years_elemetary", "census Escolar dos Anos Finais do Ensino Fundamental (Matriculados)");
			break;
		case R.id.radio_census_high_school:
			setValues("census_high_school", "census Escolar do Ensino Medio (Matriculados)");
			break;
		case R.id.radio_census_eja_elementary:
			setValues("census_eja_elementary", "census Escolar do EJA - Fundamental (Matriculados)");
			break;
		case R.id.radio_census_high_school_eja:
			setValues("census_high_school_eja", "census Escolar do EJA - Medio (Matriculados)");
			break;
		}
	}

	public void setValues(String indivative, String tittle) {
		setIndicative(indivative);
		setTittle(tittle);
	}

	public abstract void clickButtonNext(View view);

	public String getIndicative() {
		return indicative;
	}

	public void setIndicative(String indicative) {
		this.indicative = indicative;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	
}
