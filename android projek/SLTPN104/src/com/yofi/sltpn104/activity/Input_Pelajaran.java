package com.yofi.sltpn104.activity;

import java.util.Calendar;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.callback.CallbackInput;
import com.yofi.sltpn104.helper.ApiHelper;
import com.yofi.sltpn104.utils.Utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class Input_Pelajaran extends Activity{
	
	Calendar mcurrentTime = Calendar.getInstance();
    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
    int minute = mcurrentTime.get(Calendar.MINUTE);
    
    String jns_kelamin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_pelajaran);
		
		final EditText kd_pel = (EditText) findViewById(R.id.ip_kd_pel);
		final EditText hari = (EditText) findViewById(R.id.ip_hari);
		final EditText jam = (EditText) findViewById(R.id.ip_jam);
		Button jambtn = (Button) findViewById(R.id.ip_jambtn);
		final EditText kls = (EditText) findViewById(R.id.ip_kls);
		final EditText semester = (EditText) findViewById(R.id.ip_semester);
		final EditText nm_pel = (EditText) findViewById(R.id.ip_nama);
		Button save = (Button) findViewById(R.id.ig_save);
		 jambtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new TimePickerDialog(Input_Pelajaran.this, new TimePickerDialog.OnTimeSetListener() {
					
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						jam.setText(hourOfDay+":"+minute);
					}
				}, hour, minute, true).show();
			}
		});
		 
		 save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new ApiHelper().inputPelajaran(
						kd_pel.getText().toString(), 
						hari.getText().toString(), 
						jam.getText().toString(), 
						kls.getText().toString(), 
						semester.getText().toString(), 
						nm_pel.getText().toString(),
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
