package com.ictv.yellowcab;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash_layout);
		  
	       Thread mythread = new Thread() {
	        public void run() {
	            try {
	                sleep(2000);
	            } catch(Exception e) {}
	            finally {
	                Intent intent = new Intent(SplashActivity.this, TopActivity.class);
	                startActivity(intent);
	            }
	        }
	    };
	    mythread.start();
	}
	
}
