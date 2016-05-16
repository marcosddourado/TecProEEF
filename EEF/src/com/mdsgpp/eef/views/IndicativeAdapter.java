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

    public static final int AMOUNT_OF_STATES = 28;
    public static final int INDICATIVE = 0;
    public static final int STATE_VALUES = 1;
    private HashMap<String, String> state = null;
	private String selectedIndicative = "";
	private String tittle = "";
	private Context context = null;
	private ViewHolder holder = null;
	private LayoutInflater inflater = null;
	private String flags[] = {"acre", "alagoas", "amapa", "amazonas", "bahia",
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
	
	public IndicativeAdapter(String tittle, String selectedIndicative, Context context){
		this.selectedIndicative = selectedIndicative;
		this.tittle = tittle;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return AMOUNT_OF_STATES;
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
		
		if(position == INDICATIVE){
			holder.tvName.setText(tittle);
			holder.tvName.setGravity(Gravity.CENTER_HORIZONTAL);
			holder.tvIndicativeValue.setVisibility(View.GONE);
			holder.tvFlags.setImageResource(NO_SELECTION);
		} else {
			state = getItem(position-1);
			holder.tvName.setText(state.get("nome"));
			holder.tvIndicativeValue.setText( getValue(state.get(selectedIndicative)) );
			holder.tvIndicativeValue.setVisibility(View.VISIBLE);
			
			int idFlag = context.getResources().getIdentifier(flags[position-1], "drawable", context
					.getPackageName());
			holder.tvFlags.setImageResource(idFlag);
		}
		
		
		return view;
	}
	
        private String getValue(String line) {
        String value = "";
		if (line.contains(":")) {
			String values[] = line.split(": ");
			value = values[STATE_VALUES];
		} else {
            value = line;
        }
		
		return value;
	}
}