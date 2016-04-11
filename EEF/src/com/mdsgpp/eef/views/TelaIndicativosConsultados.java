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

	CheckBox cbIdeb, cbPib, cbPopulacao, cbPrimeirosProjetos, cbProjetosCnpq,
			cbProjetosDifusao, cbProjetosIniciacao, cbProjetosJovens, cbCenso,
			cbAlunosTurma, cbHorasAula, cbTaxaDistorcao, cbTaxaAbandono,
			cbAprovacao;
	boolean idebView, pibView, populationView, firstProjectsView, cnpqProjectsView,
			projectDiffusionView, initiationProjectsView, jovensProjectsView, censusView,
			studentsClassView, hoursPerClassView, distortionRateView, schoolDropoutRateView,
			approvalView;
	int position01, position02;

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
		case R.id.sobre:
<<<<<<< HEAD
			loadAboutScreen();
=======
			openAboutScreen();
>>>>>>> 1d79114fdc0bff4e5ff2f85fef159ab0fdac2ee0
			break;
		case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        break;
		default:
			break;
		}

		return true;
	}

<<<<<<< HEAD
	public void loadAboutScreen() {
=======
	public void openAboutScreen() {
>>>>>>> 1d79114fdc0bff4e5ff2f85fef159ab0fdac2ee0
		Intent intent = new Intent(this, TelaSobreEscolhaIndicativo.class);
		startActivity(intent);
	}

	private void inicializaCheckBox() {
		cbIdeb = (CheckBox) findViewById(R.id.checkBox_ideb);
		cbPib = (CheckBox) findViewById(R.id.checkBox_participacao_pib);
		cbPopulacao = (CheckBox) findViewById(R.id.checkBox_populacao);
		cbPrimeirosProjetos = (CheckBox) findViewById(R.id.checkBox_primeiros_projeto);
		cbProjetosCnpq = (CheckBox) findViewById(R.id.checkBox_projetos_cnpq);
		cbProjetosDifusao = (CheckBox) findViewById(R.id.checkBox_projetos_difusao);
		cbProjetosIniciacao = (CheckBox) findViewById(R.id.checkBox_projetos_iniciacao);
		cbProjetosJovens = (CheckBox) findViewById(R.id.checkBox_projetos_jovens);
		cbCenso = (CheckBox) findViewById(R.id.checkBox_censo);
		cbAlunosTurma = (CheckBox) findViewById(R.id.checkBox_quantidade_aluno);
		cbHorasAula = (CheckBox) findViewById(R.id.checkBox_horas_aula);
		cbTaxaDistorcao = (CheckBox) findViewById(R.id.checkBox_distortion_rate);
		cbTaxaAbandono = (CheckBox) findViewById(R.id.checkBox_taxa_abandono);
		cbAprovacao = (CheckBox) findViewById(R.id.checkBox_taxa_aprovacao);
	}

	private void capturaValores() {
		idebView = cbIdeb.isChecked();
		pibView = cbPib.isChecked();
		populationView = cbPopulacao.isChecked();
		firstProjectsView = cbPrimeirosProjetos.isChecked();
		cnpqProjectsView = cbProjetosCnpq.isChecked();
		projectDiffusionView = cbProjetosDifusao.isChecked();
		initiationProjectsView = cbProjetosIniciacao.isChecked();
		jovensProjectsView = cbProjetosJovens.isChecked();
		censusView = cbCenso.isChecked();
		studentsClassView = cbAlunosTurma.isChecked();
		hoursPerClassView = cbHorasAula.isChecked();
		distortionRateView = cbTaxaDistorcao.isChecked();
		schoolDropoutRateView = cbTaxaAbandono.isChecked();
		approvalView = cbAprovacao.isChecked();
	}

	public void marcaOuDesmarcaCheckBox(boolean opcaoEscolhida) {
		cbIdeb.setChecked(opcaoEscolhida);
		cbPib.setChecked(opcaoEscolhida);
		cbPopulacao.setChecked(opcaoEscolhida);
		cbPrimeirosProjetos.setChecked(opcaoEscolhida);
		cbProjetosCnpq.setChecked(opcaoEscolhida);
		cbProjetosDifusao.setChecked(opcaoEscolhida);
		cbProjetosIniciacao.setChecked(opcaoEscolhida);
		cbProjetosJovens.setChecked(opcaoEscolhida);
		cbCenso.setChecked(opcaoEscolhida);
		cbAlunosTurma.setChecked(opcaoEscolhida);
		cbHorasAula.setChecked(opcaoEscolhida);
		cbTaxaDistorcao.setChecked(opcaoEscolhida);
		cbTaxaAbandono.setChecked(opcaoEscolhida);
		cbAprovacao.setChecked(opcaoEscolhida);
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

		intent.putExtra("INDEX_CHOOSED_STATE1", position01);
		intent.putExtra("INDEX_CHOOSED_STATE2", position02);

		startActivity(intent);
	}

}
