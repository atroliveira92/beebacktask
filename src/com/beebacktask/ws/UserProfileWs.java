package com.beebacktask.ws;

import android.util.Log;

import com.beebacktask.model.UserProfile;
import com.google.gson.Gson;

public class UserProfileWs {
	
	private static String authToken;
	private static UserProfile userProfile;
	private static Gson gson = new Gson();
	public static String getAuthToken() {
		return authToken;
	}
	public static UserProfile getUserProfile() {
		return userProfile;
	}
	
	public static boolean autenticarUsuario(String nome, String auth){
		
		try{
			authToken = auth;
			String retorno = DataService.callWebServiceGet("Auth", authToken);
			if(!retorno.equals("")){
				return Boolean.parseBoolean(retorno);
			}
		return false;
		}
		catch(Exception ex)
		{
			Log.i("Erro ao autenticar",ex.getMessage());
			return false;
		}
	}
	
	public static boolean loginUsuario(String user){
		boolean retorno = false;
		try{
			String jsonService = DataService.callWebServiceGet("StartupApp?username="+user, authToken);
			if(jsonService != null || jsonService.equals("")){
				userProfile = gson.fromJson(jsonService, UserProfile.class);
				if(userProfile != null)
					retorno = true;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return retorno;
	}
	
}
