package com.beebacktask.tool;

import java.util.ArrayList;

import com.beebacktask.model.Lancamento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.beebacktask.principal.R;

import android.view.View.OnClickListener;
public class ItemListTask extends BaseAdapter{

	private static ArrayList<Lancamento> lstLancamento;
	private LayoutInflater l_Inflater;
	private Context c;
	
	public ItemListTask(Context context, ArrayList<Lancamento> results){
		lstLancamento = results;
		
		if(context != null)
			l_Inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lstLancamento.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lstLancamento.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		  if (convertView == null) {
		   convertView = l_Inflater.inflate(R.layout.item_list_task, null);
		   holder = new ViewHolder();
		   holder.txvTitle = (TextView)convertView.findViewById(R.id.txvListTitle);
		   holder.txvDate = (TextView)convertView.findViewById(R.id.txvListDate);
		   holder.chkFinish = (CheckBox)convertView.findViewById(R.id.chkFinish);
		   holder.linearPriority = (LinearLayout)convertView.findViewById(R.id.linearPriority);
		   convertView.setTag(holder);
		   
			 /* holder.chkFinish.setOnClickListener(new View.OnClickListener(){
				  public void onClick(View v) { 
					  CheckBox cb = (CheckBox)v;
					  //Lancamento l = (Lancamento)cb.getTag();
					  Toast.makeText(c, "Clicado em ", Toast.LENGTH_LONG).show();
				  }
			  });*/

		  }else{
			  holder = (ViewHolder) convertView.getTag();
		  }
		  Lancamento l = lstLancamento.get(position);
		  if(l.getIcPrioridade().equals(""))
			  holder.linearPriority.setBackgroundResource(R.color.none);
		  else if(l.getIcPrioridade().equals("1"))
			  holder.linearPriority.setBackgroundResource(R.color.important);
		  else
			  holder.linearPriority.setBackgroundResource(R.color.high);
		  
		  holder.chkFinish.setTag(l);
		  holder.txvTitle.setText(l.getDsTitulo());
		  holder.txvDate.setText(l.getDtTarefaFim());
		return convertView;
	}
	
	 static class ViewHolder {
		  	  CheckBox chkFinish;
			  TextView txvTitle;
			  TextView txvDate;
			  LinearLayout linearPriority;
		 }

}
