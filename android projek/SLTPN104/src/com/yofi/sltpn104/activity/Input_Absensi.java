package com.yofi.sltpn104.activity;

import java.util.Calendar;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.callback.CallbackInput;
import com.yofi.sltpn104.helper.ApiHelper;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class Input_Absensi extends Activity{

	final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR);
    int mMonth = c.get(Calendar.MONTH);
    int mDay = c.get(Calendar.DAY_OF_MONTH);
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);
	
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_absensi);
		
		final EditText id_absen = (EditText) findViewById(R.id.ia_id_absen);
		final EditText tgl_msk = (EditText) findViewById(R.id.ia_tgl_msk);
		final Button tgl_mskbtn = (Button) findViewById(R.id.ia_tgl_mskbtn);
		final EditText jam_msk = (EditText) findViewById(R.id.ia_jam_msk);
		Button mskbtn = (Button) findViewById(R.id.ia_jam_mskbtn);
		final EditText jam_klr = (EditText) findViewById(R.id.ia_jam_klr);
		Button klrbtn = (Button) findViewById(R.id.ia_jam_klrbtn);
		final EditText status = (EditText) findViewById(R.id.ia_status);
		final EditText ket_absen = (EditText) findViewById(R.id.ia_ket_absen);
		Button save = (Button) findViewById(R.id.ia_save);
		
		tgl_mskbtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new DatePickerDialog(Input_Absensi.this, new DatePickerDialog.OnDateSetListener() {
		            @Override
		            public void onDateSet(DatePicker view, int year,
		                    int monthOfYear, int dayOfMonth) {
		            	tgl_msk.setText(""+dayOfMonth+"-"+(monthOfYear + 1) +"-"+year);
		            }
		        }, mYear, mMonth, mDay).show();
				
			}
		});
		
		mskbtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new TimePickerDialog(Input_Absensi.this, new TimePickerDialog.OnTimeSetListener() {
					
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						jam_msk.setText(hourOfDay+":"+minute);
					}
				}, hour, minute, true).show();
			}
		});
		
		klrbtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new TimePickerDialog(Input_Absensi.this, new TimePickerDialog.OnTimeSetListener() {
					
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						jam_klr.setText(hourOfDay+":"+minute);
					}
				}, hour, minute, true).show();
			}
		});
		
		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new ApiHelper().inputAbsensi(
						id_absen.getText().toString(), 
						tgl_msk.getText().toString(), 
						jam_msk.getText().toString(), 
						jam_klr.getText().toString(), 
						status.getText().toString(), 
						ket_absen.getText().toString(), 
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
