package com.beebacktask.principal;

import com.beebacktask.tool.CryptoBeeback;
import com.beebacktask.tool.InternetConnection;
import com.beebacktask.ws.UserProfileWs;
import com.beebacktask.principal.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
	EditText edtLogin = null;
	EditText edtPassword = null;
	private String user = "";
	private String password = "";
	
	public void onCreate(Bundle savedIntent){
		super.onCreate(savedIntent);
		setContentView(R.layout.login_view);
		edtLogin = (EditText)findViewById(R.id.edtLogin);
		edtLogin.setText("arthuroliveira92");
		edtPassword = (EditText)findViewById(R.id.edtPassword);
		edtPassword.setText("deadmau5arthur");
	}
	public void entrar(View view){
		user = edtLogin.getText().toString();
		password = edtPassword.getText().toString();
		
		new LoginAsyncTask().execute();
	}
	public class LoginAsyncTask extends AsyncTask<Void,Boolean,Boolean>{
		private ProgressDialog dialog;
		private String auth;
		private boolean internetConnection;
		@Override
        protected void onPreExecute() {
			dialog = new ProgressDialog(LoginActivity.this,
					android.R.style.Theme_Holo_Light_Dialog);
	        dialog.setMessage("Carregando, aguarde...");
	        dialog.show();
        }
		@Override
		protected Boolean doInBackground(Void... params) {
			boolean retorno = false;
			internetConnection =InternetConnection.isConnectingToInternet(LoginActivity.this); 
			if(internetConnection){
				CryptoBeeback cryptoBeeback = new CryptoBeeback();
				auth = cryptoBeeback.encriptarLogin(user,password);
				if(UserProfileWs.autenticarUsuario(user, auth)){
					if(UserProfileWs.loginUsuario(user)){
						retorno = true;
					}
				}
			}
			return retorno;
		}
		@Override
		protected void onPostExecute(Boolean retorno){
			if(dialog != null)
				dialog.dismiss();
			
			if(retorno){
				startActivity(new Intent(LoginActivity.this,MainActivity.class));
			}else{
				if(internetConnection){
					Toast.makeText(LoginActivity.this, "Voc� est� sem conex�o com a internet !", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(LoginActivity.this, "Erro ao efetuar o login !", Toast.LENGTH_SHORT).show();
				}
			}
		}
		
	}
}
