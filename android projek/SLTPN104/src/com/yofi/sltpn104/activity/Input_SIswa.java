package com.yofi.sltpn104.activity;

import java.util.Calendar;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.callback.CallbackInput;
import com.yofi.sltpn104.helper.ApiHelper;
import com.yofi.sltpn104.utils.Utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Input_SIswa extends Activity{
	
	final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR);
    int mMonth = c.get(Calendar.MONTH);
    int mDay = c.get(Calendar.DAY_OF_MONTH);
    
    String jns_kelamin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_siswa);
		final EditText nis = (EditText) findViewById(R.id.is_nis);
		final EditText kd_kls = (EditText) findViewById(R.id.is_kd_kls);
		final EditText nm_siswa = (EditText) findViewById(R.id.is_nm_siswa);
		final EditText almt_siswa = (EditText) findViewById(R.id.is_almt_siswa);
		final EditText tgl_lahir = (EditText) findViewById(R.id.is_tgl_lahir);
		Button tgl_lahribtn = (Button) findViewById(R.id.is_tgl_lahirbtn);
		final EditText temp_lhr_siswa = (EditText) findViewById(R.id.is_tmp_lahir);
		RadioGroup radio_jk = (RadioGroup) findViewById(R.id.is_jk);
		final EditText agm_siswa = (EditText) findViewById(R.id.is_agm_siswa);
		final EditText tlp_siswa = (EditText) findViewById(R.id.is_telp_siswa);
		final EditText kls = (EditText) findViewById(R.id.is_kelas);
		Button save = (Button) findViewById(R.id.is_save);
		
		tgl_lahribtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new DatePickerDialog(Input_SIswa.this, new DatePickerDialog.OnDateSetListener() {
		            @Override
		            public void onDateSet(DatePicker view, int year,
		                    int monthOfYear, int dayOfMonth) {
		            	tgl_lahir.setText(""+dayOfMonth+"-"+(monthOfYear + 1) +"-"+year);
		            }
		        }, mYear, mMonth, mDay).show();
				
			}
		});
		
		radio_jk.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.lakilaki) {
					jns_kelamin = "Laki - Laki";
				}else {
					jns_kelamin = "Perempuan";
				}
			}
		});
		
		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new ApiHelper().inputSiswa(
						nis.getText().toString(), 
						kd_kls.getText().toString(), 
						nm_siswa.getText().toString(), 
						almt_siswa.getText().toString(), 
						tgl_lahir.getText().toString(), 
						temp_lhr_siswa.getText().toString(), 
						jns_kelamin, 
						agm_siswa.getText().toString(), 
						tlp_siswa.getText().toString(), 
						kls.getText().toString(), 
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
