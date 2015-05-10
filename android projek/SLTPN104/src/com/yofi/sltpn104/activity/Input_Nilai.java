package com.yofi.sltpn104.activity;

import java.util.Calendar;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.callback.CallbackInput;
import com.yofi.sltpn104.helper.ApiHelper;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Input_Nilai extends Activity{

	
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_nilai);
		final EditText nis = (EditText)findViewById(R.id.in_nis);
		final EditText nip = (EditText)findViewById(R.id.in_nip);
		final EditText kd_pel = (EditText)findViewById(R.id.in_kd_pel);
		final EditText kd_kls = (EditText)findViewById(R.id.in_kd_kls);
		final EditText nm_siswa = (EditText)findViewById(R.id.in_nm_siswa);
		final EditText nilai = (EditText)findViewById(R.id.in_nilai);
		final EditText ket = (EditText)findViewById(R.id.in_ket);
		Button save = (Button) findViewById(R.id.in_save);
		
		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new ApiHelper().inputNilai(
						nis.getText().toString(), 
						nip.getText().toString(), 
						kd_pel.getText().toString(), 
						kd_kls.getText().toString(), 
						nm_siswa.getText().toString(), 
						nilai.getText().toString(), 
						ket.getText().toString(), new CallbackInput() {
							
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
