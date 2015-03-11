package com.beebacktask.principal;


import static com.beebacktask.tool.Common.CHAVE_DEVICE;
import static com.beebacktask.tool.Common.DEVICE_ID;
import static com.beebacktask.tool.Common.SENDER_ID;
import static com.beebacktask.tool.Common.REGISTRAR;

import java.util.ArrayList;

import com.beebacktask.ws.UserProfileWs;
import com.beebacktask.model.*;
import com.beebacktask.principal.R;
import com.beebacktask.tool.ItemListTask;
import com.beebacktask.ws.LancamentoWs;
import com.google.android.gcm.GCMRegistrar;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.SearchView;

public class MainActivity extends Activity implements SearchView.OnQueryTextListener {
	ListView lsvTask;
	private SearchView mSearchView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		
		final String regId = GCMRegistrar.getRegistrationId(this);
		if (regId.equals("")) {
			//GCMRegistrar.register(this, SENDER_ID);
		} else {
			Log.v("push", "Already registered");
			CHAVE_DEVICE = regId;
			if(REGISTRAR){
				//new RegisterTask().execute();
			}
			REGISTRAR = false;
		}
		
		lsvTask = (ListView)findViewById(R.id.lsvTask);
		
		LancamentoWs.carregarLancamento();
		lsvTask.setAdapter(new ItemListTask(this, LancamentoWs.getLstTarefas()));
		
		lsvTask.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View row, int position,
					long arg3) {
				
				Object o = lsvTask.getItemAtPosition(position);
				Lancamento l = (Lancamento)o;
				
				Intent i = new Intent(MainActivity.this,DetailsActivity.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("lancamento", l);
				bundle.putInt("listPosition", position);
				i.putExtras(bundle);
				startActivity(i);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) searchItem.getActionView();
        setupSearchView(searchItem);

        return true;
	}
	 private void setupSearchView(MenuItem searchItem) {
		 mSearchView.setOnQueryTextListener(this);
	 }
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_setting) {
			return true;
		}else if(id == R.id.action_add){
			startActivity(new Intent(MainActivity.this,DetailsActivity.class));
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		return false;
	}
	private class RegisterTask extends AsyncTask<String, Void, String[]>{
		String retorno = null;
		private  boolean running = true;
		
		@Override
		protected String[] doInBackground(String... arg0) {
			Log.i("ID DO DEVICE ",DEVICE_ID);
			//retorno = UserProfileWs.RegistrarAparelho(CHAVE_DEVICE,DEVICE_ID);
			if(retorno != null){
				return new String[]{"ok"};
			}
			return null;
		}
		@Override
        protected void onPostExecute(String[] result) {
          if(result == null) {
        	  //Log.i(TAG,"recebeu um OK quando enviou para o servidor!");
  			Toast.makeText(MainActivity.this, "Problemas para registrar aparelho para receber notificação, tente mais tarde!", Toast.LENGTH_LONG).show();
          }else{
        	  //Toast.makeText(TarefasActivity.this, retorno, Toast.LENGTH_LONG).show();
          }
        }
	}
}