package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;

public class TelaComparacao extends Comparacao {
	@Override
	public void clickBotaoComparacaoEstados(View view) {
		Intent intent = new Intent(this, TelaIndicativosConsultados.class);
		getStatesSpinner01().getSelectedItem().toString();
		getStatesSpinner().getSelectedItem().toString();

		int position1 = getTodosEstados().indexOf(getStatesSpinner01().getSelectedItem()
				.toString());
		int position2 = getTodosEstados().indexOf(getStatesSpinner().getSelectedItem()
				.toString());

		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", position1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", position2);

		startActivity(intent);
		
	}
	
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
    
    public void loadAboutScreen() {
    	Intent intent = new Intent(this, TelaSobreComparacao.class);
    	startActivity(intent);
    }
	
	public void clickBotaoSobreComparacao(View view) {
    	Intent intent = new Intent(this, TelaSobreComparacao.class);
    	startActivity(intent);
    }
}
