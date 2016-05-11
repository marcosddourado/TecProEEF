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

public class ScreenState extends Activity {

	private TextView textViewAbbrev;
	private TextView textViewName;
	private TextView textViewPopulation;
	private TextView textViewPibParticipation;
	private TextView textViewScienceTechnologyProjectsQuantity;
	private TextView textViewScienceTechnologyProjectsValue;
	private TextView textViewIdebElementary;
	private TextView textViewIdebHighSchool;
	private TextView textViewIdebInitials;
	private	TextView textViewPrimeirosProjetosQuantity;
	private TextView textViewPrimeirosProjetosValue;
	private TextView textViewResearchQuantity;
	private TextView textViewResearchValues;
	private TextView textViewJovensPesquisadoresQuantity;
	private TextView textViewJovensPesquisadoresValue;
	private TextView textViewInitiationProjectsQuantity;
	private TextView textViewInitiationProjectsValue;
	private ImageView imageViewFlags;
	private TextView textViewCensusInitialsElementary;
	private TextView textViewCensusFinalsElementary;
	private TextView textViewCensusHighSchool;
	private TextView textViewCensusEjaElementary;
	private TextView textViewCensoEjaHighSchool;
	private TextView textViewAverageStudentsPerClassElementary;
	private TextView textViewAverageStudentsPerClassHighSchool;
	private TextView textViewAverageHoursClassElementary;
	private TextView textViewAverageHoursClassHighSchool;
	private TextView textViewDistortionRateGradeElementary;
	private TextView textViewDistortionRateGradeHighSchool;
	private TextView textViewAchievementRateElementary;
	private TextView textViewAchievementRateHighSchool;
	private TextView textViewDropoutRateElementary;
	private TextView 		textViewDropoutRateHighSchool;
	
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
			case R.id.about:
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
			informacoes = StateConroller.getInstance(this).readState(position);
			preencheCamposTexto(informacoes);
			setImagem(position);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso es informaeees.", Toast.LENGTH_SHORT).show();
			Log.i("IOException-ScreenState", e.toString());
		}
	}
	
	private void inicializaCamposTexto() {
		
		textViewAbbrev = (TextView) findViewById(R.id.textView_sigla);
		textViewName = (TextView) findViewById(R.id.textView_nome_estado);
		textViewPopulation = (TextView) findViewById(R.id.textView_populacao_valor);
		textViewPibParticipation = (TextView) findViewById(R.id.textView_participacao_pib_valor);
		textViewScienceTechnologyProjectsQuantity = (TextView) findViewById(R.id.textView_numero_projetos_quantidade);
		textViewScienceTechnologyProjectsValue = (TextView) findViewById(R.id.textView_valor_investido_projetos);
		textViewIdebElementary = (TextView) findViewById(R.id.textView_ideb_elementary);
		textViewIdebHighSchool = (TextView) findViewById(R.id.textView_ideb_ensinomedio);
		textViewIdebInitials = (TextView) findViewById(R.id.textView_ideb_iniciais);
		textViewPrimeirosProjetosQuantity = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade);
		textViewPrimeirosProjetosValue = (TextView) findViewById(R.id.textView_programa_primeiros_projetos_valor);
		textViewResearchQuantity = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade);
		textViewResearchValues = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa);
		textViewJovensPesquisadoresQuantity = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade);
		textViewJovensPesquisadoresValue = (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor);
		textViewInitiationProjectsQuantity = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade);
		textViewInitiationProjectsValue = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor);
		
		textViewCensusInitialsElementary = (TextView) findViewById(R.id.textView_initial_census_elementary);
		textViewCensusFinalsElementary = (TextView) findViewById(R.id.textView_final_census_elementary);
		textViewCensusHighSchool = (TextView) findViewById(R.id.textView_census_high_school);
		textViewCensusEjaElementary = (TextView) findViewById(R.id.textView_census_elementary_eja);
		textViewCensoEjaHighSchool = (TextView) findViewById(R.id.textView_census_high_school_eja);
		textViewAverageStudentsPerClassElementary = (TextView) findViewById(R.id.textView_media_alunos_por_turma_elementary);
		textViewAverageStudentsPerClassHighSchool = (TextView) findViewById(R.id.textView_media_alunos_por_turma_high_school);
		textViewAverageHoursClassElementary = (TextView) findViewById(R.id.textView_horas_aula_ensino_elementary);
		textViewAverageHoursClassHighSchool = (TextView) findViewById(R.id.textView_horas_aula_ensino_high_school);
		textViewDistortionRateGradeElementary = (TextView) findViewById(R.id.textView_distortion_rate_elementary);
		textViewDistortionRateGradeHighSchool = (TextView) findViewById(R.id.textView_distortion_rate_high_school);
		textViewAchievementRateElementary = (TextView) findViewById(R.id.textView_approval_rate_elementary);
		textViewAchievementRateHighSchool = (TextView) findViewById(R.id.textView_approval_rate_high_school);
		textViewDropoutRateElementary = (TextView) findViewById(R.id.textView_dropout_rate_elementary);
		textViewDropoutRateHighSchool = (TextView) findViewById(R.id.textView_dropout_rate_high_school);
	}
	
	private void preencheCamposTexto(HashMap<String, String> informacoes) {
		textViewAbbrev.setText(informacoes.get("sigla"));
		textViewName.setText(informacoes.get("nome"));
		textViewPopulation.setText(informacoes.get("populacao"));
		textViewPibParticipation.setText(informacoes.get("percentual_participacao_pib"));
		textViewScienceTechnologyProjectsQuantity.setText(informacoes.get("projetos_ciencia_tecnologia"));
		textViewScienceTechnologyProjectsValue.setText(informacoes.get("valor_ciencia_tecnologia"));
		textViewIdebElementary.setText(informacoes.get("ideb_elementary_final"));
		textViewIdebHighSchool.setText(informacoes.get("ideb_ensino_high_school"));
		textViewIdebInitials.setText(informacoes.get("ideb_elementary_inicial"));
		textViewPrimeirosProjetosQuantity.setText(informacoes.get("quantidade_primeiros_projetos"));
		textViewPrimeirosProjetosValue.setText(informacoes.get("valor_primeiros_projetos"));
	    textViewResearchQuantity.setText(informacoes.get("quantidade_projeto_cnpq"));
		textViewResearchValues.setText(informacoes.get("valor_projetos_cnpq"));
		textViewJovensPesquisadoresQuantity.setText(informacoes.get("quantidade_projeto_jovens_pesquisadores"));
		textViewJovensPesquisadoresValue.setText(informacoes.get("valor_projetos_jovens_pesquisadores"));
		textViewInitiationProjectsQuantity.setText(informacoes.get("quantidade_projetos_inct"));
		textViewInitiationProjectsValue.setText(informacoes.get("valor_projetos_inct"));
		
		textViewCensusInitialsElementary.setText(informacoes.get("censo_anos_iniciais_elementary"));
		textViewCensusFinalsElementary.setText(informacoes.get("censo_anos_finais_elementary"));
		textViewCensusHighSchool.setText(informacoes.get("censo_ensino_high_school"));
		textViewCensusEjaElementary.setText(informacoes.get("censo_eja_elementary"));
		textViewCensoEjaHighSchool.setText(informacoes.get("censo_eja_high_school"));
		textViewAverageStudentsPerClassElementary.setText(informacoes.get("alunos_por_turma_ensino_elementary"));
		textViewAverageStudentsPerClassHighSchool.setText(informacoes.get("alunos_por_turma_ensino_high_school"));
		textViewAverageHoursClassElementary.setText(informacoes.get("horas_aula_ensino_elementary"));
		textViewAverageHoursClassHighSchool.setText(informacoes.get("horas_aula_ensino_high_school"));
		textViewDistortionRateGradeElementary.setText(informacoes.get("distortion_rate_elementary"));
		textViewDistortionRateGradeHighSchool.setText(informacoes.get("distortion_rate_high_school"));
		textViewAchievementRateElementary.setText(informacoes.get("taxa_aprovacao_elementary"));
		textViewAchievementRateHighSchool.setText(informacoes.get("taxa_aprovacao_high_school"));
		textViewDropoutRateElementary.setText(informacoes.get("taxa_aprovacao_elementary"));
		textViewDropoutRateHighSchool.setText(informacoes.get("taxa_aprovacao_high_school"));
		
	}
	
	private void setImagem(int position) {
		String bandeiras[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", 
				"ceara", "distritofederal", "espiritosanto", "goias", "maranhao",
				"matogrosso", "matogrossodosul", "minasgerais", "para", "paraiba",
				"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
				"riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo",
				"sergipe", "tocantins"};	
		
		imageViewFlags = (ImageView) findViewById(R.id.imageView_flags);
		int idFlag = getResources().getIdentifier(bandeiras[position], "drawable", getPackageName());
		imageViewFlags.setImageResource(idFlag);
	}
	
	public void clickBotaoHistoricoEstado(View view) {
		Intent intentAux = getIntent();
		int position = intentAux.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);
		Log.i("position tela estado", position+"");
		
		Intent intent = new Intent(this, ScreenStateHistory.class);
		intent.putExtra("ESTADO", position);
		
		startActivity(intent);
	}

}
