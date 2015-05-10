package com.yofi.sltpn104.activity;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.callback.CallbackAdmin;
import com.yofi.sltpn104.helper.ApiHelper;
import com.yofi.sltpn104.helper.SessionControl;
import com.yofi.sltpn104.model.AdminModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity{

	EditText username;
	EditText password;
	Button btnlogin, btnnotlogin;
	SessionControl session = SessionControl.getInstance();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		username = (EditText) findViewById(R.id.textusername);
		password = (EditText) findViewById(R.id.textpassword);
		btnlogin = (Button) findViewById(R.id.btnlogin);
		btnnotlogin = (Button) findViewById(R.id.btnnotlogin);
		btnlogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new ApiHelper().login(username.getText().toString(), 
						password.getText().toString(), 
						new CallbackAdmin() {
							
							@Override
							public void onSuccess(AdminModel adminmodel) {
								Intent i = new Intent(getApplicationContext(), Sltpn.class);
								i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			                    i.putExtra("login", adminmodel);
			                    startActivity(i);
			                    finish();
			                    session.getSessionManager().setLogin(true, "admin");
							}
							
							@Override
							public void onException(String reason) {
								Toast.makeText(getApplicationContext(), "exception", Toast.LENGTH_SHORT).show();
							}
							
							@Override
							public void onError(String reason) {
								Toast.makeText(getApplicationContext(), reason, Toast.LENGTH_SHORT).show();
							}
						});
			}
		});
		
		btnnotlogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(), Sltpn.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
                session.getSessionManager().setLogin(true, "guru");
			}
		});
	}
}