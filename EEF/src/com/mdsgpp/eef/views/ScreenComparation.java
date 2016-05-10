package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;

public class ScreenComparation extends Comparation {
	@Override
	public void clickButtonStatesComparation(View view) {
		Intent intent = new Intent(this, ScreenConsultedIndicative.class);
		getStatesSpinner01().getSelectedItem().toString();
		getStatesSpinner().getSelectedItem().toString();

		int position1 = getAllStates().indexOf(getStatesSpinner01().getSelectedItem()
				.toString());
		int position2 = getAllStates().indexOf(getStatesSpinner().getSelectedItem()
				.toString());

		intent.putExtra("INDEX_CHOOSED_STATE1", position1);
		intent.putExtra("INDEX_CHOOSED_STATE2", position2);

		startActivity(intent);
		
	}
	
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
    	Intent intent = new Intent(this, TelaSobreComparacao.class);
    	startActivity(intent);
    }
	
	public void clickButtonAboutComparationcao(View view) {
    	Intent intent = new Intent(this, TelaSobreComparacao.class);
    	startActivity(intent);
    }
}
