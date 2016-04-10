package com.mdsgpp.eef.views;

import java.io.IOException;
import java.util.HashMap;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateConroller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Gravity;

public class IndicativeAdapter extends BaseAdapter{
	
	private HashMap<String, String> state;
	private String choosedIndicative;
	private String tittle;
	private Context context;
	private ViewHolder holder;
	private LayoutInflater inflater;
	
	String bandeiras[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", 
			"ceara", "distritofederal", "espiritosanto", "goias", "maranhao",
			"matogrosso", "matogrossodosul", "minasgerais", "para", "paraiba",
			"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
			"riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo",
			"sergipe", "tocantins"};
	
	static class ViewHolder{
		private TextView tvName;
		private TextView tvIndicativeValue;
		private ImageView tvFlags;
	}
	
	public IndicativeAdapter(String tittle, String choosedIndicative, Context context){
		this.choosedIndicative = choosedIndicative;
		this.tittle = tittle;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return 28;
	}

	@Override
	public HashMap<String, String> getItem(int position) {
		HashMap<String, String> state = null;
		try {
			state = StateConroller.getInstance(context).readState(position);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	
	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		if(view == null) {
			view = this.inflater.inflate(R.layout.listview_indicatives_item, null);
			holder = new ViewHolder();
				
			holder.tvName = (TextView) view.findViewById(R.id.textview_list_indicatives_name);
			holder.tvIndicativeValue = (TextView) view.findViewById(R.id.textview_list_indicatives_content);
			holder.tvFlags = (ImageView) view.findViewById(R.id.imageview_list_indicatives_flags);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		
		if(position == 0){//Titulo
			holder.tvName.setText(tittle);
			holder.tvName.setGravity(Gravity.CENTER_HORIZONTAL);
			holder.tvIndicativeValue.setVisibility(View.GONE);
			holder.tvFlags.setImageResource(NO_SELECTION);
		} else {//Indicativos e seus valores
			state = getItem(position-1);
			holder.tvName.setText(state.get("nome"));
			holder.tvIndicativeValue.setText( getValue(state.get(choosedIndicative)) );
			holder.tvIndicativeValue.setVisibility(View.VISIBLE);
			
			int idFlag = context.getResources().getIdentifier(bandeiras[position-1], "drawable", context.getPackageName());
			holder.tvFlags.setImageResource(idFlag);
		}
		
		
		return view;
	}
	
	private String getValue(String linha) {
		if (linha.contains(":")) {
			String partes[] = linha.split(": ");
			return partes[1];
		}
		
		return linha;
	}
}