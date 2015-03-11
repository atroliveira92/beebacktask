package com.beebacktask.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;

public class Converters {

	public static String convertData(String dataString){
		try{
			SimpleDateFormat formatar = null;
			String[] pegar = dataString.split("T");
			formatar = new SimpleDateFormat( "yyyy-MM-dd" );     
			Date data = formatar.parse(pegar[0]);     
			formatar= new SimpleDateFormat( "dd/MM/yyyy" );
			String dataDoDia = formatar.format(new Date(System.currentTimeMillis()));
			String dataStr = formatar.format(data);
			if(dataDoDia.equals(dataStr))
				return "hoje";
			
			return dataStr;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return "";
	}	
}
