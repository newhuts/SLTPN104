package com.yofi.sltpn104.activity;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.helper.SessionControl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity{

	SessionControl session = SessionControl.getInstance();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				if (session.getSessionManager().isLoggedIn()) {
					goAction(Sltpn.class);
				}else {
					goAction(Login.class);
				}
			}
		}, 2000);
		
	}
	
	private void goAction(Class<?> classes) {
		Intent intent = new Intent(getApplicationContext(), classes);
		startActivity(intent);
		finish();
	}
}
