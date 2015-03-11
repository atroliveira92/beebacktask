package com.beebacktask.tool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class InternetConnection {

	public static boolean isConnectingToInternet(Context _context){
        try{
    	ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
          if (connectivity != null)
          {
              NetworkInfo[] info = connectivity.getAllNetworkInfo();
              if (info != null)
                  for (int i = 0; i < info.length; i++)
                      if (info[i].getState() == NetworkInfo.State.CONNECTED)
                      {
                          return true;
                      }

          }
        }
        catch(Exception ex){
        	Log.i("ERRO NA CONEXAO",ex.getMessage());
        }
        return false;
    }
}
