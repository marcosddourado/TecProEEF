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

public class ScreenStateHistory extends Activity {
	HashMap<String, String> information;
	private TextView abbreviation;
	private TextView name;
	private TextView population;
	private TextView pibParticipation;
	private TextView scienceTechnologyProjectsQuantity;
	private TextView idebs;
	private	TextView primeirosProjetos;
	private TextView researchValues;
	private TextView jovensPesquisadoresValue;
	private TextView initiationProjectsValue;
	private ImageView flags;
	private TextView censusValue;
	private TextView averageStudentsClassValue;
	private TextView averageHoursClassElementary;
	private TextView averageHoursClassHIghSchool;
	private TextView distortionRateAgeGradeValue;
	private TextView achievementRateValue;
	private TextView dropoutRateValue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_historico_estado);
		
		catchInformation();
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
		Intent intent = new Intent(this, ScreenOverIndicativeHistory.class);
    	startActivity(intent);	
	}
	
	private void catchInformation() {
		Intent intent = getIntent();
		
		int position = intent.getIntExtra("ESTADO", 0);
		information = new HashMap <String, String>();
		
		initializeTextFields();
		
		try {
			information = StateConroller.getInstance(this).readCompleteState(position);
			filltextFields(information);
			setImage(position);
			
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso es informaeees.", Toast.LENGTH_SHORT).show();
			Log.i("IOExceptionStateHistory", e.toString());
		}
	}

	private void initializeTextFields() {
		
		abbreviation = (TextView) findViewById(R.id.textView_sigla);
		name = (TextView) findViewById(R.id.textView_nome_estado);
		population = (TextView) findViewById(R.id.textView_populacao_valor);
		pibParticipation = (TextView) findViewById(R.id.textView_participacao_pib_valor);
		scienceTechnologyProjectsQuantity = (TextView) findViewById(R.id.textView_numero_projetos_quantidade);
		idebs = (TextView) findViewById(R.id.textView_idebs);
		primeirosProjetos = (TextView) findViewById(R.id.textView_primeiros_projetos);
		researchValues = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa);
		jovensPesquisadoresValue = (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor);
		initiationProjectsValue = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor);
		
		censusValue = (TextView) findViewById(R.id.textView_census_high_school_valor);
		averageStudentsClassValue = (TextView) findViewById(R.id.textView_media_alunos_por_turma_valor);
		averageHoursClassElementary = (TextView) findViewById(R.id.textView_horas_aula_ensino_elementary);
		averageHoursClassHIghSchool = (TextView) findViewById(R.id.textView_horas_aula_ensino_high_school);
		distortionRateAgeGradeValue = (TextView) findViewById(R.id.textView_distortion_rate_valor);
		achievementRateValue = (TextView) findViewById(R.id.textView_approval_rate_valor);
		dropoutRateValue = (TextView) findViewById(R.id.textView_dropout_rate_valor);
	}
	
	private void filltextFields(HashMap<String, String> informacoes) {
		abbreviation.setText(informacoes.get("sigla"));
		name.setText(informacoes.get("nome"));
		population.setText(informacoes.get("populacao"));
		pibParticipation.setText(informacoes.get("percentual_participacao_pib"));
		scienceTechnologyProjectsQuantity.setText(informacoes.get("projetos_ciencia_tecnologia"));
		idebs.setText(informacoes.get("ideb"));
		primeirosProjetos.setText(informacoes.get("primeiros_projetos"));
		researchValues.setText(informacoes.get("cnpq"));
		jovensPesquisadoresValue.setText(informacoes.get("jovens_pesquisadores"));
		initiationProjectsValue.setText(informacoes.get("projetos_inct"));
		
		averageStudentsClassValue.setText(informacoes.get("alunos_por_turma_ensino_high_school"));
		censusValue.setText(informacoes.get("censo"));
		averageHoursClassElementary.setText(informacoes.get("horas_aula_ensino_elementary"));
		averageHoursClassHIghSchool.setText(informacoes.get("horas_aula_ensino_high_school"));
		distortionRateAgeGradeValue.setText(informacoes.get("distortion_rate"));
		achievementRateValue.setText(informacoes.get("taxa_aprovacao"));
		dropoutRateValue.setText(informacoes.get("taxa_abandono"));
		
	}
	
	private void setImage(int position) {
		// O nome das bandeiras te sem acento
		// A slueeo que eu acho mais simples e ter um array com os nomes dos estados sem acento, e pegar o nome certo pela position
		String flags[] = {"acre", "alagoas", "amapa", "amazonas", "bahia",
				"ceara", "distritofederal", "espiritosanto", "goias", "maranhao",
				"matogrosso", "matogrossodosul", "minasgerais", "para", "paraiba",
				"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
				"riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo",
				"sergipe", "tocantins"};	
		
		this.flags = (ImageView) findViewById(R.id.imageView_flags);
		int idFlag = getResources().getIdentifier(flags[position], "drawable", getPackageName());
		this.flags.setImageResource(idFlag);
	}
	
    public void clickGenerateGraphPerIndicativeButton(View view){
		Intent intent1 = getIntent();
		
		int position = intent1.getIntExtra("ESTADO", 0);
		
    	Intent intent = new Intent(this, ScreenLineGraphIndicative.class);
    	intent.putExtra("ESTADO", position);
    	
		intent.putExtra("CB_IDEB", true);
		intent.putExtra("CB_PIB", true);
		intent.putExtra("CB_POPULACAO", true);
		intent.putExtra("CB_PRIMEIROS_PROJETOS", true);
		intent.putExtra("CB_PROJETOS_CNPQ", true);
		intent.putExtra("CB_PROJETOS_DIFUSAO", true);
		intent.putExtra("CB_PROJETOS_INICIACAO", true);
		intent.putExtra("CB_PROJETOS_JOVENS", true);
		intent.putExtra("CB_ALUNOS_TURMA", true);
		intent.putExtra("CB_APROVACAO",true);
		intent.putExtra("CB_CENSO", true);
		intent.putExtra("CB_HORAS_AULA", true);
		intent.putExtra("CB_TAXA_ABANDONO", true);
		intent.putExtra("CB_TAXA_DISTORCAO", true);
		
		startActivity(intent);
    }

}
