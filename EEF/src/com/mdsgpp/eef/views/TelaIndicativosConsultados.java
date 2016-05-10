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
	CheckBox cbPopulacao;
	CheckBox cbPrimeirosProjetos;
	CheckBox cbProjetosCnpq;
	CheckBox cbProjetosDifusao;
	CheckBox cbProjetosIniciacao;
	CheckBox cbProjetosJovens;
	CheckBox cbCenso;
	CheckBox cbAlunosTurma;
	CheckBox cbHorasAula;
	CheckBox cbTaxaDistorcao;
	CheckBox cbTaxaAbandono;
	CheckBox cbAprovacao;

	boolean bIdeb;
	boolean bPib;
	boolean bPopulacao;
	boolean bPrimeirosProjetos;
	boolean bProjetosCnpq;
	boolean bProjetosDifusao;
	boolean bProjetosIniciacao;
	boolean bProjetosJovens;
	boolean bCenso;
	boolean bAlunosTurma;
	boolean bHorasAula;
	boolean bTaxaDistorcao;
	boolean bTaxaAbandono;
	boolean bAprovacao;

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
		bIdeb = cbIdeb.isChecked();
		bPib = cbPib.isChecked();
		bPopulacao = cbPopulacao.isChecked();
		bPrimeirosProjetos = cbPrimeirosProjetos.isChecked();
		bProjetosCnpq = cbProjetosCnpq.isChecked();
		bProjetosDifusao = cbProjetosDifusao.isChecked();
		bProjetosIniciacao = cbProjetosIniciacao.isChecked();
		bProjetosJovens = cbProjetosJovens.isChecked();
		bCenso = cbCenso.isChecked();
		bAlunosTurma = cbAlunosTurma.isChecked();
		bHorasAula = cbHorasAula.isChecked();
		bTaxaDistorcao = cbTaxaDistorcao.isChecked();
		bTaxaAbandono = cbTaxaAbandono.isChecked();
		bAprovacao = cbAprovacao.isChecked();
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
		intent.putExtra("CB_IDEB", bIdeb);
		intent.putExtra("CB_PIB", bPib);
		intent.putExtra("CB_POPULACAO", bPopulacao);
		intent.putExtra("CB_PRIMEIROS_PROJETOS", bPrimeirosProjetos);
		intent.putExtra("CB_PROJETOS_CNPQ", bProjetosCnpq);
		intent.putExtra("CB_PROJETOS_DIFUSAO", bProjetosDifusao);
		intent.putExtra("CB_PROJETOS_INICIACAO", bProjetosIniciacao);
		intent.putExtra("CB_PROJETOS_JOVENS", bProjetosJovens);
		intent.putExtra("CB_ALUNOS_TURMA", bAlunosTurma);
		intent.putExtra("CB_APROVACAO", bAprovacao);
		intent.putExtra("CB_CENSO", bCenso);
		intent.putExtra("CB_HORAS_AULA", bHorasAula);
		intent.putExtra("CB_TAXA_ABANDONO", bTaxaAbandono);
		intent.putExtra("CB_TAXA_DISTORCAO", bTaxaDistorcao);

		intent.putExtra("INDEX_CHOOSED_STATE1", position01);
		intent.putExtra("INDEX_CHOOSED_STATE2", position02);

		startActivity(intent);
	}

}
