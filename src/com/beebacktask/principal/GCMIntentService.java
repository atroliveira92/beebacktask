package com.beebacktask.principal;

import static com.beebacktask.tool.Common.CHAVE_DEVICE;
import static com.beebacktask.tool.Common.DEVICE_ID;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.beebacktask.ws.LancamentoWs;

import com.google.android.gcm.GCMBaseIntentService;
import com.beebacktask.principal.R;

import static com.beebacktask.tool.Common.SENDER_ID;
	
public class GCMIntentService extends GCMBaseIntentService{

	private static final String TAG = "===GCMIntentService===";
	Context _context;
	String chave = "";
	public GCMIntentService() {
        super(SENDER_ID);
        
        Log.i("GCMINTENT","Passou por aqui!!!");
        //Toast.makeText(_context, TAG+" "+SENDER_ID, Toast.LENGTH_LONG).show();
    }
	
	@Override
	protected void onError(Context arg0, String errorId) {
		// TODO Auto-generated method stub
		
		Log.i(TAG, "Received error: " + errorId);
		//Toast.makeText(arg0,"Erro : " + errorId , Toast.LENGTH_LONG).show();
		
	}

	@Override
	protected void onMessage(Context context, Intent i) {
			    
		
		// TODO Auto-generated method stub
		try{
			
			Log.i(TAG,"recebeu uma mensagem !");
			String message = i.getExtras().getString("message");
			String idPublicacao = i.getExtras().getString("idPublicacao");
			//LancamentoWs.idLancamento = Integer.parseInt(idPublicacao);
			//Toast.makeText(context, "Recebeu uma mensagem "+message, Toast.LENGTH_SHORT).show();
			//Log.i(TAG,message);
			//Toast.makeText(context, message, Toast.LENGTH_LONG).show();
			
			generateNotification(context, message,"beeback", idPublicacao);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	protected void onRegistered(Context arg0, String registrationId) {
		// TODO Auto-generated method stub
		try{
			Log.i(TAG, "Device registered: regId = " + registrationId);
			CHAVE_DEVICE = registrationId;
			_context = arg0;
			new RegisterTask().execute();
		}
		catch(Exception ex){
			Log.i("Erro aqui",ex.getMessage());
		}
	}

	@Override
	protected void onUnregistered(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		Log.i(TAG, "unregistered = "+arg1);
		Toast.makeText(arg0, "Desregistrou: "+arg1, Toast.LENGTH_LONG).show();
		
	}
	
	private static void generateNotification(Context context, String message, String title, String idPublicacao) {

        int icon = R.drawable.ic_launcher;

        NotificationManager notificationManager = 
        		(NotificationManager) context.getSystemService(
        				Context.NOTIFICATION_SERVICE);
        
        
        Intent notificationIntent = new Intent(context, InitActivity.class);
        notificationIntent.putExtra("message", message);

        // set intent so it does not start a new activity
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | 
        		Intent.FLAG_ACTIVITY_SINGLE_TOP | 
        		Intent.FLAG_ACTIVITY_NEW_TASK |
        		Intent.FLAG_ACTIVITY_NO_HISTORY);
        PendingIntent intent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
        
        		
        		
        Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);            

         Notification notification = new NotificationCompat.Builder(context)
         .setContentTitle(title)
         .setContentText(message)
         .setTicker(title)
         .setContentIntent(intent)
         .setSmallIcon(icon)
         .setLights(Color.YELLOW, 1, 2)
         .setAutoCancel(true) 	
         .setSound(defaultSound)
         .build();
         
         notification.flags |= Notification.FLAG_AUTO_CANCEL;
         notification.defaults |= Notification.DEFAULT_SOUND;
         notification.defaults |= Notification.DEFAULT_LIGHTS;
         notification.defaults |= Notification.DEFAULT_VIBRATE;
         
         //Log.i("Notificacao","Ta mandando a notificação, parece q deu certo");
         //Toast.makeText(context, "Ta mandando a notificação, parece q deu certo", Toast.LENGTH_SHORT).show();
        notificationManager.notify(0, notification);
        
        //Toast.makeText(context, "Mandou !", Toast.LENGTH_SHORT).show();
	}
	private class RegisterTask extends AsyncTask<String, Void, String[]>{
		String retorno = null;
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
          if(result != null) {
        	  //Log.i(TAG,"recebeu um OK quando enviou para o servidor!");
  			//Toast.makeText(_context, retorno, Toast.LENGTH_LONG).show();
          }
        }
	}

}
