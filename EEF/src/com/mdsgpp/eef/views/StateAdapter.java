package com.mdsgpp.eef.views;

import com.mdsgpp.eef.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StateAdapter extends BaseAdapter{

	String states[] = {"Acre", "Alagoas", "Amape", "Amazonas", "Bahia",
			"Ceare", "Distrito Federal","Esperito Santo","Goies", "Maranheo",
			"Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pare", "Paraiba",
			"Parane", "Pernambuco", "Piaue", "Rio de Janeiro", "Rio Grande do Norte",
			"Rio Grande do Sul", "Rondenia", "Roreima", "Santa Catarina", "Seo Paulo",
			"Sergipe", "Tocantins"};
	
	String abbreviations[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT",
			"MS", "MG",
			"PA", "PB", "PR", "PE",	"PI", "RJ", "RN","RS", "RO", "RR", "SC", "SP", "SE", "TO" };
	
	String flags[] = {"acre", "alagoas", "amapa", "amazonas", "bahia",
			"ceara", "distritofederal", "espiritosanto", "goias", "maranhao",
			"matogrosso", "matogrossodosul", "minasgerais", "para", "paraiba",
			"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
			"riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo",
			"sergipe", "tocantins"};
	
	private LayoutInflater mInflater;
	private ViewHolder holder;
	private Context context;
	
	static class ViewHolder {
		private TextView tvName;
		private TextView tvAbbreviation;
		private ImageView tvFlags;
	}
	
	public StateAdapter(Context context) {
		this.context = context;
		mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return states.length;
	}

	@Override
	public Object getItem(int position) {
		return states[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Infla o layout, e pega os views jogando no holder para economizar processamento
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.listview_item , null);
			holder = new ViewHolder();
		 
			holder.tvName = (TextView) convertView.findViewById(R.id.textview_states_list);
			holder.tvAbbreviation = (TextView) convertView.findViewById(R.id.textview_states_abbreviations);
			
			holder.tvFlags = (ImageView) convertView.findViewById(R.id.imageView_flags);
			if(holder.tvFlags==null)
				Log.i(null, "nulo");
			else{
				Log.i(null, "nao nulo");
			}

		} else {
			// pega do holder se tudo je tiver sido iniciado
			holder = (ViewHolder) convertView.getTag();
		}
				
		holder.tvName.setText(states[position]);
		holder.tvAbbreviation.setText(abbreviations[position]);
		int idFlag = context.getResources().getIdentifier(flags[position], "drawable", context
                .getPackageName());
		holder.tvFlags.setImageResource(idFlag);
		convertView.setTag(holder);
		
		return convertView;
	}

}
