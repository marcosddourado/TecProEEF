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
	private TextView textViewcensusEjaHighSchool;
	private TextView textViewAverageStudentsPerClassElementary;
	private TextView textViewAverageStudentsPerClassHighSchool;
	private TextView textViewAverageHoursClassElementary;
	private TextView textViewAverageHoursClassHighSchool;
	private TextView textViewDistortionRateGradeElementary;
	private TextView textViewDistortionRateGradeHighSchool;
	private TextView textViewAchievementRateElementary;
	private TextView textViewAchievementRateHighSchool;
	private TextView textViewDropoutRateElementary;
	private TextView textViewDropoutRateHighSchool;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_estado);
		
		catchInfomration();
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
	    
	    public void loadAboutScreen() {
	    	Intent intent = new Intent(this, ScreenAboutState.class);
	    	startActivity(intent);
	    }
	
	private void catchInfomration() {
		Intent intent = getIntent();
		int position = intent.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);
		
		initializeTextFields();
		
	    HashMap<String, String> information = new HashMap <String, String>();
	    
	    try {
			information = StateConroller.getInstance(this).readState(position);
			fillTextFields(information);
			setImage(position);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso es informaeees.", Toast.LENGTH_SHORT).show();
			Log.i("IOException-ScreenState", e.toString());
		}
	}
	
	private void initializeTextFields() {
		
		textViewAbbrev = (TextView) findViewById(R.id.textView_sigla);
		textViewName = (TextView) findViewById(R.id.textView_nome_estado);
		textViewPopulation = (TextView) findViewById(R.id.textView_population_valor);
		textViewPibParticipation = (TextView) findViewById(R.id.textView_pib_participation_valor);
		textViewScienceTechnologyProjectsQuantity = (TextView) findViewById(R.id.textView_project_numbers_quantidade);
		textViewScienceTechnologyProjectsValue = (TextView) findViewById(R.id.textView_valor_investido_projetos);
		textViewIdebElementary = (TextView) findViewById(R.id.textView_ideb_elementary);
		textViewIdebHighSchool = (TextView) findViewById(R.id.textView_ideb_ensinomedio);
		textViewIdebInitials = (TextView) findViewById(R.id.textView_ideb_iniciais);
		textViewPrimeirosProjetosQuantity = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade);
		textViewPrimeirosProjetosValue = (TextView) findViewById(R.id.textView_first_program_projects_valor);
		textViewResearchQuantity = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade);
		textViewResearchValues = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa);
		textViewJovensPesquisadoresQuantity = (TextView) findViewById(R.id.textView_teen_searchers_quantidade);
		textViewJovensPesquisadoresValue = (TextView) findViewById(R.id.textView_teen_searchers_valor);
		textViewInitiationProjectsQuantity = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade);
		textViewInitiationProjectsValue = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor);
		
		textViewCensusInitialsElementary = (TextView) findViewById(R.id.textView_initial_census_elementary);
		textViewCensusFinalsElementary = (TextView) findViewById(R.id.textView_final_census_elementary);
		textViewCensusHighSchool = (TextView) findViewById(R.id.textView_census_high_school);
		textViewCensusEjaElementary = (TextView) findViewById(R.id.textView_census_elementary_eja);
		textViewcensusEjaHighSchool = (TextView) findViewById(R.id.textView_census_high_school_eja);
		textViewAverageStudentsPerClassElementary = (TextView) findViewById(R.id.textView_students_average_per_class_elementary);
		textViewAverageStudentsPerClassHighSchool = (TextView) findViewById(R.id.textView_students_average_per_class_high_school);
		textViewAverageHoursClassElementary = (TextView) findViewById(R.id.textView_daily_class_hours_average_elementary);
		textViewAverageHoursClassHighSchool = (TextView) findViewById(R.id.textView_daily_class_hours_average_high_school);
		textViewDistortionRateGradeElementary = (TextView) findViewById(R.id.textView_distortion_rate_elementary);
		textViewDistortionRateGradeHighSchool = (TextView) findViewById(R.id.textView_distortion_rate_high_school);
		textViewAchievementRateElementary = (TextView) findViewById(R.id.textView_approval_rate_elementary);
		textViewAchievementRateHighSchool = (TextView) findViewById(R.id.textView_approval_rate_high_school);
		textViewDropoutRateElementary = (TextView) findViewById(R.id.textView_dropout_rate_elementary);
		textViewDropoutRateHighSchool = (TextView) findViewById(R.id.textView_dropout_rate_high_school);
	}
	
	private void fillTextFields(HashMap<String, String> information) {
		textViewAbbrev.setText(information.get("sigla"));
		textViewName.setText(information.get("nome"));
		textViewPopulation.setText(information.get("population"));
		textViewPibParticipation.setText(information.get("percentual_pib_participation"));
		textViewScienceTechnologyProjectsQuantity.setText(information.get("projetos_ciencia_tecnologia"));
		textViewScienceTechnologyProjectsValue.setText(information.get("valor_ciencia_tecnologia"));
		textViewIdebElementary.setText(information.get("ideb_elementary_final"));
		textViewIdebHighSchool.setText(information.get("ideb_ensino_high_school"));
		textViewIdebInitials.setText(information.get("ideb_elementary_inicial"));
		textViewPrimeirosProjetosQuantity.setText(information.get("quantidade_primeiros_projetos"));
		textViewPrimeirosProjetosValue.setText(information.get("valor_primeiros_projetos"));
	    textViewResearchQuantity.setText(information.get("quantidade_projeto_cnpq"));
		textViewResearchValues.setText(information.get("valor_projetos_cnpq"));
		textViewJovensPesquisadoresQuantity.setText(information.get("quantidade_projeto_teen_searchers"));
		textViewJovensPesquisadoresValue.setText(information.get("valor_projetos_teen_searchers"));
		textViewInitiationProjectsQuantity.setText(information.get("quantidade_projetos_inct"));
		textViewInitiationProjectsValue.setText(information.get("valor_projetos_inct"));
		
		textViewCensusInitialsElementary.setText(information.get("census_initial_years_elemetary"));
		textViewCensusFinalsElementary.setText(information.get("census_final_years_elemetary"));
		textViewCensusHighSchool.setText(information.get("census_high_school"));
		textViewCensusEjaElementary.setText(information.get("census_eja_elementary"));
		textViewcensusEjaHighSchool.setText(information.get("census_high_school_eja"));
		textViewAverageStudentsPerClassElementary.setText(information.get("alunos_por_turma_ensino_elementary"));
		textViewAverageStudentsPerClassHighSchool.setText(information.get("alunos_por_turma_ensino_high_school"));
		textViewAverageHoursClassElementary.setText(information.get("daily_class_hours_average_elementary"));
		textViewAverageHoursClassHighSchool.setText(information.get("daily_class_hours_average_high_school"));
		textViewDistortionRateGradeElementary.setText(information.get("distortion_rate_elementary"));
		textViewDistortionRateGradeHighSchool.setText(information.get("distortion_rate_high_school"));
		textViewAchievementRateElementary.setText(information.get("utilization_rate_elementary"));
		textViewAchievementRateHighSchool.setText(information.get("utilization_rate_high_school"));
		textViewDropoutRateElementary.setText(information.get("utilization_rate_elementary"));
		textViewDropoutRateHighSchool.setText(information.get("utilization_rate_high_school"));
		
	}
	
	private void setImage(int position) {
		String flags[] = {"acre", "alagoas", "amapa", "amazonas", "bahia",
				"ceara", "distritofederal", "espiritosanto", "goias", "maranhao",
				"matogrosso", "matogrossodosul", "minasgerais", "para", "paraiba",
				"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
				"riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo",
				"sergipe", "tocantins"};	
		
		imageViewFlags = (ImageView) findViewById(R.id.imageView_flags);
		int idFlag = getResources().getIdentifier(flags[position], "drawable", getPackageName());
		imageViewFlags.setImageResource(idFlag);
	}
	
	public void clickStateHistoryButton(View view) {
		Intent intentAux = getIntent();
		int position = intentAux.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);
		Log.i("position tela estado", position+"");
		
		Intent intent = new Intent(this, ScreenStateHistory.class);
		intent.putExtra("ESTADO", position);
		
		startActivity(intent);
	}

}
