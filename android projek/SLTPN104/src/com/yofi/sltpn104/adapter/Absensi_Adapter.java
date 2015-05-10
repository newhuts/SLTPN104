package com.yofi.sltpn104.adapter;

import java.util.ArrayList;
import java.util.List;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.model.AbsensiModel;
import com.yofi.sltpn104.model.GuruModel;
import com.yofi.sltpn104.model.NilaiModel;
import com.yofi.sltpn104.model.SiswaModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Absensi_Adapter extends BaseAdapter{
	
	LayoutInflater inflater = null;
	List<AbsensiModel> Modellist = new ArrayList<AbsensiModel>();
	public Absensi_Adapter(Context context, List<AbsensiModel> list) {
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Modellist = list;
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Modellist.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		if (view == null) {
			view = inflater.inflate(R.layout.adp_absensi, arg2, false);
		}
		
		TextView id = (TextView) view.findViewById(R.id.absensi_id);
		TextView masuk = (TextView) view.findViewById(R.id.absensi_jammasuk);
		TextView keluar = (TextView) view.findViewById(R.id.absensi_jamkeluar);
		TextView tgl = (TextView) view.findViewById(R.id.absensi_tgl);
		
		AbsensiModel model = Modellist.get(position);
		id.setText(model.getId_absen());
		masuk.setText("Jam Masuk: "+model.getJam_msk());
		keluar.setText("Jam Keluar: "+model.getJam_klr());
		tgl.setText(model.getTgl_msk());
		
		
		
		return view;
	}

}
