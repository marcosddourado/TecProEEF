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

public class TelaIndicativosConsultados extends Activity {

	CheckBox cbIdeb;
	CheckBox cbPib;
	CheckBox cbPopulation;
	CheckBox cbFirstProjects;
	CheckBox cbProjectsCnpq;
	CheckBox cbProjectsDiffusion;
	CheckBox cbProjectsIniciation;
	CheckBox cbProjectsYoung;
	CheckBox cbCensus;
	CheckBox cbClassStudents;
	CheckBox cbClassTime;
	CheckBox cbDistortionTax;
	CheckBox cbAbandonTax;
	CheckBox cbApproval;

	boolean bIdeb;
	boolean bPib;
	boolean bPopulation;
	boolean bFirstProjects;
	boolean bProjectsCnpq;
	boolean bProjectsDiffusion;
	boolean bProjectsIniciation;
	boolean bProjectsYoung;
	boolean bCensus;
	boolean bClassStudents;
	boolean bClassTime;
	boolean bDistortionTax;
	boolean bAbandonTax;
	boolean bApproval;

	int position01;
	int position02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_indicativos_consultados);
		Intent intentAuxiliar = getIntent();

		inicializaCheckBox();

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
		Intent intent = new Intent(this, TelaSobreEscolhaIndicativo.class);
		startActivity(intent);
	}

	private void inicializaCheckBox() {
		cbIdeb = (CheckBox) findViewById(R.id.checkBox_ideb);
		cbPib = (CheckBox) findViewById(R.id.checkBox_participacao_pib);
		cbPopulation = (CheckBox) findViewById(R.id.checkBox_populacao);
		cbFirstProjects = (CheckBox) findViewById(R.id.checkBox_primeiros_projeto);
		cbProjectsCnpq = (CheckBox) findViewById(R.id.checkBox_projetos_cnpq);
		cbProjectsDiffusion = (CheckBox) findViewById(R.id.checkBox_projetos_difusao);
		cbProjectsIniciation = (CheckBox) findViewById(R.id.checkBox_projetos_iniciacao);
		cbProjectsYoung = (CheckBox) findViewById(R.id.checkBox_projetos_jovens);
		cbCensus = (CheckBox) findViewById(R.id.checkBox_censo);
		cbClassStudents = (CheckBox) findViewById(R.id.checkBox_quantidade_aluno);
		cbClassTime = (CheckBox) findViewById(R.id.checkBox_horas_aula);
		cbDistortionTax = (CheckBox) findViewById(R.id.checkBox_distortion_rate);
		cbAbandonTax = (CheckBox) findViewById(R.id.checkBox_taxa_abandono);
		cbApproval = (CheckBox) findViewById(R.id.checkBox_taxa_aprovacao);
	}

	private void capturaValores() {
		bIdeb = cbIdeb.isChecked();
		bPib = cbPib.isChecked();
		bPopulation = cbPopulation.isChecked();
		bFirstProjects = cbFirstProjects.isChecked();
		bProjectsCnpq = cbProjectsCnpq.isChecked();
		bProjectsDiffusion = cbProjectsDiffusion.isChecked();
		bProjectsIniciation = cbProjectsIniciation.isChecked();
		bProjectsYoung = cbProjectsYoung.isChecked();
		bCensus = cbCensus.isChecked();
		bClassStudents = cbClassStudents.isChecked();
		bClassTime = cbClassTime.isChecked();
		bDistortionTax = cbDistortionTax.isChecked();
		bAbandonTax = cbAbandonTax.isChecked();
		bApproval = cbApproval.isChecked();
	}

	public void marcaOuDesmarcaCheckBox(boolean opcaoEscolhida) {
		cbIdeb.setChecked(opcaoEscolhida);
		cbPib.setChecked(opcaoEscolhida);
		cbPopulation.setChecked(opcaoEscolhida);
		cbFirstProjects.setChecked(opcaoEscolhida);
		cbProjectsCnpq.setChecked(opcaoEscolhida);
		cbProjectsDiffusion.setChecked(opcaoEscolhida);
		cbProjectsIniciation.setChecked(opcaoEscolhida);
		cbProjectsYoung.setChecked(opcaoEscolhida);
		cbCensus.setChecked(opcaoEscolhida);
		cbClassStudents.setChecked(opcaoEscolhida);
		cbClassTime.setChecked(opcaoEscolhida);
		cbDistortionTax.setChecked(opcaoEscolhida);
		cbAbandonTax.setChecked(opcaoEscolhida);
		cbApproval.setChecked(opcaoEscolhida);
	}

	public void onRadioButtonMarcarTodosClicked(View view) {
		marcaOuDesmarcaCheckBox(true);
	}

	public void onRadioButtonDesmarcarTodosClicked(View view) {
		marcaOuDesmarcaCheckBox(false);
	}

	public void clickBotaoTodosIndicativos(View view) {
		capturaValores();

		Intent intent = new Intent(this, TelaResultadoConsulta.class);
		intent.putExtra("CB_IDEB", bIdeb);
		intent.putExtra("CB_PIB", bPib);
		intent.putExtra("CB_POPULATION", bPopulation);
		intent.putExtra("CB_FIRST_PROJECTS", bFirstProjects);
		intent.putExtra("CB_PROJECTS_CNPQ", bProjectsCnpq);
		intent.putExtra("CB_PROJECTS_DIFFUSION", bProjectsDiffusion);
		intent.putExtra("CB_PROJECTS_INICIATION", bProjectsIniciation);
		intent.putExtra("CB_PROJECTS_YOUNG", bProjectsYoung);
		intent.putExtra("CB_CLASS_STUDENTS", bClassStudents);
		intent.putExtra("CB_APPROVAL", bApproval);
		intent.putExtra("CB_CENSUS", bCensus);
		intent.putExtra("CB_CLASS_TIME", bClassTime);
		intent.putExtra("CB_ABANDON_TAX", bAbandonTax);
		intent.putExtra("CB_DISTORTION_TAX", bDistortionTax);

		intent.putExtra("INDEX_CHOOSED_STATE1", position01);
		intent.putExtra("INDEX_CHOOSED_STATE2", position02);

		startActivity(intent);
	}

}
