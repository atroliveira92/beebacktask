package com.beebacktask.principal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class InitActivity extends Activity{

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		startActivity(new Intent(InitActivity.this,LoginActivity.class));
	}
	
}