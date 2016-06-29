package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class ScreenConsultedIndicative extends Activity {

	CheckBox cbIdeb;
	CheckBox cbPib;
	CheckBox cbPopulation;
	CheckBox cbFirstProjects;
	CheckBox cbProjectsCnpq;
	CheckBox cbProjectsDiffusion;
	CheckBox cbProjectsInitiation;
	CheckBox cbProjectsYoung;
	CheckBox cbCensus;
	CheckBox cbClassStudents;
	CheckBox cbClassTime;
	CheckBox cbDistortionRate;
	CheckBox cbAbandonRate;
	CheckBox cbApproval;

	boolean bIdeb;
	boolean bPib;
	boolean bPopulation;
	boolean bFirstProjects;
	boolean bProjectsCnpq;
	boolean bProjectsDiffusion;
	boolean bProjectsInitiation;
	boolean bProjectsYoung;
	boolean bCensus;
	boolean bClassStudents;
	boolean bClassTime;
	boolean bDistortionRate;
	boolean bAbandonRate;
	boolean bApproval;

	int position01;
	int position02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_indicativos_consultados);
		Intent intentAuxiliar = getIntent();

		initializeCheckBox();

		position01 = intentAuxiliar.getIntExtra("INDEX_CHOOSED_STATE1", 0);
		position02 = intentAuxiliar.getIntExtra("INDEX_CHOOSED_STATE2", 0);
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
		Intent intent = new Intent(this, ScreenAboutIndicativeChoice.class);
		startActivity(intent);
	}

	private void initializeCheckBox() {
		cbIdeb = (CheckBox) findViewById(R.id.checkBox_ideb);
		cbPib = (CheckBox) findViewById(R.id.checkBox_participacao_pib);
		cbPopulation = (CheckBox) findViewById(R.id.checkBox_population);
		cbFirstProjects = (CheckBox) findViewById(R.id.checkBox_primeiros_projeto);
		cbProjectsCnpq = (CheckBox) findViewById(R.id.checkBox_projetos_cnpq);
		cbProjectsDiffusion = (CheckBox) findViewById(R.id.checkBox_projetos_difusao);
		cbProjectsInitiation = (CheckBox) findViewById(R.id.checkBox_projetos_iniciacao);
		cbProjectsYoung = (CheckBox) findViewById(R.id.checkBox_projetos_jovens);
		cbCensus = (CheckBox) findViewById(R.id.checkBox_census);
		cbClassStudents = (CheckBox) findViewById(R.id.checkBox_quantidade_aluno);
		cbClassTime = (CheckBox) findViewById(R.id.checkBox_horas_aula);
		cbDistortionRate = (CheckBox) findViewById(R.id.checkBox_distortion_rate);
		cbAbandonRate = (CheckBox) findViewById(R.id.checkBox_dropout_rate);
		cbApproval = (CheckBox) findViewById(R.id.checkBox_utilization_rate);
	}

	private void captureValues() {
		bIdeb = cbIdeb.isChecked();
		bPib = cbPib.isChecked();
		bPopulation = cbPopulation.isChecked();
		bFirstProjects = cbFirstProjects.isChecked();
		bProjectsCnpq = cbProjectsCnpq.isChecked();
		bProjectsDiffusion = cbProjectsDiffusion.isChecked();
		bProjectsInitiation = cbProjectsInitiation.isChecked();
		bProjectsYoung = cbProjectsYoung.isChecked();
		bCensus = cbCensus.isChecked();
		bClassStudents = cbClassStudents.isChecked();
		bClassTime = cbClassTime.isChecked();
		bDistortionRate = cbDistortionRate.isChecked();
		bAbandonRate = cbAbandonRate.isChecked();
		bApproval = cbApproval.isChecked();
	}

	public void checkBoxValueChanged(boolean opcaoEscolhida) {
		cbIdeb.setChecked(opcaoEscolhida);
		cbPib.setChecked(opcaoEscolhida);
		cbPopulation.setChecked(opcaoEscolhida);
		cbFirstProjects.setChecked(opcaoEscolhida);
		cbProjectsCnpq.setChecked(opcaoEscolhida);
		cbProjectsDiffusion.setChecked(opcaoEscolhida);
		cbProjectsInitiation.setChecked(opcaoEscolhida);
		cbProjectsYoung.setChecked(opcaoEscolhida);
		cbCensus.setChecked(opcaoEscolhida);
		cbClassStudents.setChecked(opcaoEscolhida);
		cbClassTime.setChecked(opcaoEscolhida);
		cbDistortionRate.setChecked(opcaoEscolhida);
		cbAbandonRate.setChecked(opcaoEscolhida);
		cbApproval.setChecked(opcaoEscolhida);
	}

	public void onRadioButtonMarcarTodosClicked(View view) {
		checkBoxValueChanged(true);
	}

	public void onRadioButtonDesmarcarTodosClicked(View view) {
		checkBoxValueChanged(false);
	}

	public void allIndicativesButtonTouch(View view) {
		captureValues();

		Intent intent = new Intent(this, ScreenQueryResult.class);
		intent.putExtra("CB_IDEB", bIdeb);
		intent.putExtra("CB_PIB", bPib);
		intent.putExtra("CB_POPULATION", bPopulation);
		intent.putExtra("CB_FIRST_PROJECTS", bFirstProjects);
		intent.putExtra("CB_PROJECTS_CNPQ", bProjectsCnpq);
		intent.putExtra("CB_PROJECTS_DIFFUSION", bProjectsDiffusion);
		intent.putExtra("CB_PROJECTS_INITIATION", bProjectsInitiation);
		intent.putExtra("CB_PROJECTS_YOUNG", bProjectsYoung);
		intent.putExtra("CB_CLASS_STUDENTS", bClassStudents);
		intent.putExtra("CB_APPROVAL", bApproval);
		intent.putExtra("CB_CENSUS", bCensus);
		intent.putExtra("CB_CLASS_TIME", bClassTime);
		intent.putExtra("CB_ABANDON_TAX", bAbandonRate);
		intent.putExtra("CB_DISTORTION_TAX", bDistortionRate);

		intent.putExtra("INDEX_CHOOSED_STATE1", position01);
		intent.putExtra("INDEX_CHOOSED_STATE2", position02);

		startActivity(intent);
	}

}
