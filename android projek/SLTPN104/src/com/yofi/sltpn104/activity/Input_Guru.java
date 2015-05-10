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

public class Input_Guru extends Activity{

	final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR);
    int mMonth = c.get(Calendar.MONTH);
    int mDay = c.get(Calendar.DAY_OF_MONTH);
    
    String jns_kelamin;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_guru);
		final EditText nip = (EditText) findViewById(R.id.ig_nip);
		final EditText nm_guru = (EditText) findViewById(R.id.ig_nama);
		RadioGroup jns_klmn_guru = (RadioGroup) findViewById(R.id.ig_jk);
		final EditText temp_lhr_guru = (EditText) findViewById(R.id.ig_tmp_lahir);
		final EditText tgl_lhr_guru = (EditText) findViewById(R.id.ig_tgl_lahir);
		Button tglButton = (Button) findViewById(R.id.ig_tgl_lahirbtn);
		final EditText almt_guru = (EditText) findViewById(R.id.ig_almt_guru);
		final EditText agm_guru = (EditText) findViewById(R.id.ig_agama);
		final EditText status_peg = (EditText) findViewById(R.id.ig_status_peg);
		final EditText thn_masuk = (EditText) findViewById(R.id.ig_thnmasuk);
		final EditText tgs_mgjr_mp = (EditText) findViewById(R.id.ig_tgs_mgjr);
		final EditText tlp_guru = (EditText) findViewById(R.id.ig_telp);
		Button save = (Button) findViewById(R.id.ig_save);
		
		tglButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new DatePickerDialog(Input_Guru.this, new DatePickerDialog.OnDateSetListener() {
		            @Override
		            public void onDateSet(DatePicker view, int year,
		                    int monthOfYear, int dayOfMonth) {
		            	tgl_lhr_guru.setText(""+dayOfMonth+"-"+(monthOfYear + 1) +"-"+year);
		            }
		        }, mYear, mMonth, mDay).show();
				
			}
		});
		
		jns_klmn_guru.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
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
			public void onClick(View arg0) {
				new ApiHelper().inputGuru(
						nip.getText().toString(), 
						nm_guru.getText().toString(), 
						jns_kelamin, 
						temp_lhr_guru.getText().toString(), 
						tgl_lhr_guru.getText().toString(), 
						almt_guru.getText().toString(), 
						agm_guru.getText().toString(), 
						status_peg.getText().toString(), 
						thn_masuk.getText().toString(), 
						tgs_mgjr_mp.getText().toString(), 
						tlp_guru.getText().toString(), 
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
