package com.beebacktask.principal;

import java.util.Calendar;

import com.beebacktask.model.Lancamento;
import com.beebacktask.ws.LancamentoWs;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailsActivity extends Activity{
	
	private int year;
	private int month;
	private int day;
	TextView txvDetailsDate;
	static final int DATE_DIALOG_ID = 999;
	private Lancamento l;
	private String prioridade = "";
	ImageButton btnPriority;
	EditText edtTaskDetails;
	CheckBox chkFinishDetails;
	LinearLayout linearDetailsPriority;
	private int listPosition;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		ActionBar bar = getActionBar();
		bar.setHomeButtonEnabled(true);
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setDisplayHomeAsUpEnabled(true);
		
		setContentView(R.layout.details_view);
		btnPriority = (ImageButton)findViewById(R.id.btnPriority);
		btnPriority.setBackgroundResource(R.drawable.ic_details_priority_none);
		edtTaskDetails = (EditText)findViewById(R.id.edtTaskDetails);
		chkFinishDetails = (CheckBox)findViewById(R.id.chkFinishDetails);
		linearDetailsPriority = (LinearLayout)findViewById(R.id.linearDetailsPriority);
		Bundle parametro = getIntent().getExtras();
		if(parametro != null){
			l = (Lancamento)parametro.getSerializable("lancamento");
			listPosition = parametro.getInt("listPosition");
			if(l != null){
				edtTaskDetails.setText(l.getDsTitulo());
				chkFinishDetails.setSelected(l.isIcSelected());
				if(l.getIcPrioridade().equals("1")){
					linearDetailsPriority.setBackgroundResource(R.color.important);
					btnPriority.setBackgroundResource(R.drawable.ic_details_priority_import);
				}
				else if (l.getIcPrioridade().equals("2"))
					linearDetailsPriority.setBackgroundResource(R.color.high);
				btnPriority.setBackgroundResource(R.drawable.ic_details_priority_high);
			}
		}
		txvDetailsDate = (TextView)findViewById(R.id.txvDetailsDate);
	}
	
	public void selectDate(View view){
		 // Process to get Current Date
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // Launch Date Picker Dialog
        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                            int monthOfYear, int dayOfMonth) {
                        // Display Selected date in textbox
                        txvDetailsDate.setText(dayOfMonth + "-"
                                + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
        dpd.show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		int id = item.getItemId();
		if(id == R.id.action_confirm){
			inserirTarefa();
			Intent i = new Intent(DetailsActivity.this,MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
		}
		else if(id == R.id.action_remove){
			LancamentoWs.removerTarefa(l.getLancamentoId(), listPosition);
			Intent i = new Intent(DetailsActivity.this,MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
		}
		return true;
	}
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		super.onPrepareOptionsMenu(menu);
		if(l == null){
			menu.findItem(R.id.action_remove).setVisible(false);
		}else{
			menu.findItem(R.id.action_remove).setVisible(true);
		}
		return true;
	}
	private void inserirTarefa(){
		if(!edtTaskDetails.getText().toString().equals("")){
			Lancamento l = new Lancamento();
			l.setLancamentoId(LancamentoWs.getLstTarefas().size());
			l.setDsTitulo(edtTaskDetails.getText().toString());
			l.setIcPrioridade(prioridade);
			l.setDtTarefaFim(txvDetailsDate.getText().toString());
			
			LancamentoWs.inserirTarefa(l);
		}
	}
	public void mudarPrioridade(View view){
		
		if(prioridade.equals("")){
			btnPriority.setBackgroundResource(R.drawable.ic_details_priority_import);
			linearDetailsPriority.setBackgroundResource(R.color.important);
			prioridade = "1";
		}
		else if(prioridade.equals("1")){
			btnPriority.setBackgroundResource(R.drawable.ic_details_priority_high);
			linearDetailsPriority.setBackgroundResource(R.color.high);
			prioridade = "2";
		}
		else{
			btnPriority.setBackgroundResource(R.drawable.ic_details_priority_none);
			linearDetailsPriority.setBackgroundResource(R.color.none);
			prioridade = "";
		}
		
	}

}
