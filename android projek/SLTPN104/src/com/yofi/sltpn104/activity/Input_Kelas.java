package com.yofi.sltpn104.activity;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.callback.CallbackInput;
import com.yofi.sltpn104.helper.ApiHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Input_Kelas extends Activity{
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_kelas);
		final EditText kd_kls = (EditText) findViewById(R.id.ik_kd_kls);
		final EditText nip = (EditText) findViewById(R.id.ik_nip);
		final EditText nm_kls = (EditText) findViewById(R.id.ik_nm_kls);
		Button save = (Button) findViewById(R.id.ik_save);
		
		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new ApiHelper().inputKelas(
						kd_kls.getText().toString(), 
						nip.getText().toString(), 
						nm_kls.getText().toString(), 
						new CallbackInput() {
							
							@Override
							public void onSuccess(String success) {
								Toast.makeText(getApplicationContext(), success, Toast.LENGTH_SHORT).show();
							}
							
							@Override
							public void onException(String reason) {
								Toast.makeText(getApplicationContext(), reason, Toast.LENGTH_SHORT).show();
							}
							
							@Override
							public void onError(String reason) {
								Toast.makeText(getApplicationContext(), reason, Toast.LENGTH_SHORT).show();
							}
						});
			}
		});
		
		
	}
}
