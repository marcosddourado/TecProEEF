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

public class ChooseIndicativeWithLineGraphScreen extends Activity{
	
	private State state = null;
	private ArrayList<Float> historico = new ArrayList<Float>();

	private String tittle = "";
	private String indicative = "";
	private int historicPosition = 0;
	private Intent receivedIntent = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_indicative_graph);
		
		receivedIntent = getIntent();
		historicPosition = receivedIntent.getIntExtra("ESTADO", 0);

		state = getStateInfo();

		tittle = "population";
		indicative = "population";
		historico.clear();
		historico.add((float) state.getStatePopulation());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_screens, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		//Loads a different screen according to user input.
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

	/**
	 * Loads the "About" screen.
	 */
	public void loadAboutScreen() {
		Intent intent = new Intent(this, ScreenAboutIndicativeChoiceComparisonGraphic.class);
    	startActivity(intent);
	}

	/**
	 * Sets graph size values according to user selection.
	 * @param max Graph maximum size.
	 * @param tamanho Graph current size.
     */
	private void setGraphInformations(int max, int tamanho) {

		//Sets up graph information, then adds items to history.
		this.historico.clear();
        tamanho = this.state.getApoioCnpqProject().length;

        if(tamanho == 1) {
            max = tamanho;
        } else {
            max = tamanho - 1;
        }

        for (int i = 0; i < max; i++) {
            this.historico.add((float) this.state.getApoioCnpqProject()[i].getProjectValue());
        }
	}

	/**
	 * Sets default behavior for when a radio button is clicked. In this case, reset graph size and
	 * reset graph info according to indicative.
	 * @param view The radio button generic reference.
     */
	public void onRadioButtonClicked(View view) {
		int max = 0;
		int tamanho = 0;


		//Sets parameters for graph generation.
		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investment:
            tittle = "Projetos de Pesquisa Apoio CNPq (R$)";
            indicative = "cnpq";

            setGraphInformations(max, tamanho);
			break;
			
		case R.id.radio_apoio_cnpq_amount:
			tittle = "Projetos de Pesquisa Apoio CNPq (Qtd.)";
			indicative = "cnpq";

            setGraphInformations(max, tamanho);
			break;
			
		case R.id.radio_technological_diffusion_investment:
			tittle = "Projeto de Difuseo Tecnolegica (R$)";
			indicative = "projetos_ciencia_tecnologia";
			historico.clear();

            setGraphInformations(max, tamanho);
			break;
			
		case R.id.radio_technological_diffusion_amount:
			tittle = "Projeto de Difuseo Tecnolegica (Qtd.)";
			indicative = "projetos_ciencia_tecnologia";

            setGraphInformations(max, tamanho);
			break;
			
		case R.id.radio_ideb_elementary_finals:
			tittle = "IDEB do Ensino Fundamental (Series Finais)";
			indicative = "ideb";
			historico.clear();
			for (int i = 0; i < state.getIdebs().length; i++)
				historico.add((float) state.getIdebs()[i].getElementary());
			break;
			
		case R.id.radio_ideb_elementary_inicials:
			tittle = "IDEB do Ensino Fundamental (Series Iniciais)";
			indicative = "ideb";

            setGraphInformations(max, tamanho);
			break;
			
		case R.id.radio_ideb_high_school:
			tittle = "IDEB do Ensino Medio";
			indicative = "ideb";

            setGraphInformations(max, tamanho);
			break;
			
		case R.id.radio_teen_searchers_investment:
			tittle = "Jovens pesquisadores (R$)";
			indicative = "teen_searchers";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_teen_searchers_amount:
			tittle = "Jovens pesquisadores (Qtd.)";
			indicative = "teen_searchers";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_pib:
			tittle = "Participaeeo Estadual no PIB (%)";
			indicative = "percentual_pib_participation";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_population:
			tittle = "Populaeeo";
			indicative = "population";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_primeiros_projetos_investment:
			tittle = "Programa Primeiros Projetos (R$)";
			indicative = "primeiros_projetos";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_primeiros_projetos_amount:
			tittle = "Programa Primeiros Projetos (Qtd.)";
			indicative = "primeiros_projetos";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_inct_projects_investment:
			tittle = "Projetos INCT (R$)";
			indicative = "projetos_inct";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_inct_projects_amount:
			tittle = "Projetos INCT (Qtd.)";
			indicative = "projetos_inct";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_students_per_class_elementary:
			tittle = "Media de Alunos por Turma do Ensino Fundamental (Qtd.)";
			indicative = "alunos_por_turma_ensino_medio";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_students_per_class_high_school:
			tittle = "Media de Alunos por Turma do Ensino Medio (Qtd.)";
			indicative = "alunos_por_turma_ensino_medio";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_class_hours_elementary:
			tittle = "Media de horas aula dierias do Ensino Fundamental";
			indicative = "daily_class_hours_average_medio";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_class_hours_high_school:
			tittle = "Media de horas aula dierias do Ensino Medio";
			indicative = "daily_class_hours_average_medio";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_distortion_rate_elementary:
			tittle = "Taxa de Distoreeo Idade/Serie do Ensino Fundamental (%)";
			indicative = "taxa_distorcao";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_distortion_rate_high_school:
			tittle = "Taxa de Distoreeo Idade/Serie do Ensino Medio (%)";
			indicative = "taxa_distorcao";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_approval_rate_elementary:
			tittle = "Taxa de Aproveitamento do Ensino Fundamental (%)";
			indicative = "utilization_rate";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_approval_rate_high_school:
			tittle = "Taxa de Aproveitamento do Ensino Medio (%)";
			indicative = "utilization_rate";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_dropout_rate_elementary:
			tittle = "Taxa de Abandono do Ensino Fundamental (%)";
			indicative = "dropout_rate";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_dropout_rate_high_school:
			tittle = "Taxa de Abandono do Ensino Medio (%)";
			indicative = "dropout_rate";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_initial_census_elementary:
			tittle = "census Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)";
			indicative = "census";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_final_census_elementary:
			tittle = "census Escolar dos Anos Finais do Ensino Fundamental (Matriculados)";
			indicative = "census";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_census_high_school:
			tittle = "census Escolar do Ensino Medio (Matriculados)";
			indicative = "census";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_census_eja_elementary:
			tittle = "census Escolar do EJA - Fundamental (Matriculados)";
			indicative = "census";

            setGraphInformations(max, tamanho);
			break;

		case R.id.radio_census_high_school_eja:
			tittle = "census Escolar do EJA - Medio (Matriculados)";
			indicative = "census";

            setGraphInformations(max, tamanho);
			break;

		}
	}


	/**
	 * Grabs an instance of State type.
	 * @return State object.
     */
	private State getStateInfo() {
		State tempState = null;

		//Retrieves the information on current State
		int position = historicPosition;
		
		try {
			tempState = (State) StateConroller.getInstance(this).grabState(position);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return tempState;
	}


	/**
	 * Loads the next sequential view.
	 * @param view The view to be loaded.
     */
	public void clickButtonNext(View view) {

		//Loads Graph Line screen with retrieved info from the user.
		Intent intent = new Intent(this, ScreenLineGraph.class);
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int i=0; i<historico.size(); i++)
			temp.add(historico.get(i)+"");
		
		intent.putStringArrayListExtra("HISTORICO", temp);
		intent.putExtra("TITULO", tittle);
		intent.putExtra("POSICAO_ESTADO", historicPosition);
		intent.putExtra("INDICATIVO_GRAFICO", indicative);
		startActivity(intent);
	}
		
}
