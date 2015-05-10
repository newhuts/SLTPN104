package com.yofi.sltpn104.utils;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

public class Utils {
	
	final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR);
    int mMonth = c.get(Calendar.MONTH);
    int mDay = c.get(Calendar.DAY_OF_MONTH);
    String tgl = "";

	public String gettanggal(Context context){
		
		new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                    int monthOfYear, int dayOfMonth) {
            	tgl = ""+dayOfMonth+"-"+(monthOfYear + 1) +"-"+year;
            }
        }, mYear, mMonth, mDay).show();
        return tgl;
	}
	
}
