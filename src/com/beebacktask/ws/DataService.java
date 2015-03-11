package com.beebacktask.ws;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class DataService {

	public static HttpGet request;
	public static HttpPost httppost;
	public static String callWebServiceGet(String parametro,String base64)
    {
		HttpClient httpclient = null;
		String result = "";  
		
		try
        {
			String cabecalho = String.format("WRAP access_token=\"%s\"", base64);
			Log.i("cabecalho",cabecalho);
	        HttpResponse httpResponse;
	        httpclient = new DefaultHttpClient();
	        String url = "http://alongwithu.azurewebsites.net/api/"+parametro;
	        //String url = "http://192.168.0.15:1710/api/"+parametro;
	        Log.i("AWU - DEBUG - WS URL",url);
	        request = new HttpGet();
	        request.setHeader("Authorization",cabecalho);
	        request.setURI(new URI(url));
        	httpResponse = httpclient.execute(request);
        	HttpEntity entity = httpResponse.getEntity();
        	if(entity != null){
        		Log.i("achou alguma coisa", "Achou algo no entity");
        		result = EntityUtils.toString(entity);
        		Log.i("AWU - DEBUG - RESULTADO WS",result);
        	}else {
        		Log.i("AWU - DEBUG - RESULTADO WS", "-- NULL--");
        	}
        }
        catch (Exception ex)
        {
        	Log.i("AWU - DEBUG - ERRO",ex.toString());
        	ex.printStackTrace(); 
        }
        finally{
        	httpclient.getConnectionManager().shutdown();
        }		
        return result;
    }
	public static boolean callWebServicePost(String json,String parametro,String base64)
	{

		boolean retorno = false;
		String cabecalho = String.format("WRAP access_token=\"%s\"", base64);
		Log.i("cabecalho",cabecalho);
		Log.i("json",json.toString());
		Log.i("Passou 1","Entrou no web service");
		DefaultHttpClient httpclient = new DefaultHttpClient();
	    httppost = new HttpPost("http://alongwithu.azurewebsites.net/api/"+parametro);
	    //httppost = new HttpPost("http://192.168.0.15:1710/api/"+parametro);
	    
	    Log.i("Passou 2","acessou o web service");
	    try{
	    	 httppost.setHeader("Content-Type", "application/json");
	    	 httppost.setHeader("Accept", "application/json");
	    	 httppost.setHeader("Authorization",cabecalho);

	    	 StringEntity entity = new StringEntity(json,HTTP.UTF_8);
	    	 
	    	 httppost.setEntity(entity);
	    	 HttpResponse response = (HttpResponse)httpclient.execute(httppost);
	    	 HttpEntity back = response.getEntity();
	    	 int status = response.getStatusLine().getStatusCode();
	    	 Log.i("status", String.valueOf(status));
	    	 if(back != null)
	    	 {
	    		  retorno = Boolean.valueOf(EntityUtils.toString(back));
	    		 Log.i("Retornou algo",String.valueOf(retorno));
	    	 }
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    finally{
	    	httpclient.getConnectionManager().shutdown();
	    }
	    return retorno;
	}
}
