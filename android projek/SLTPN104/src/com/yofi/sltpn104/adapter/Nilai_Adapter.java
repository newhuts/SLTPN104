package com.yofi.sltpn104.adapter;

import java.util.ArrayList;
import java.util.List;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.model.GuruModel;
import com.yofi.sltpn104.model.NilaiModel;
import com.yofi.sltpn104.model.SiswaModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Nilai_Adapter extends BaseAdapter{
	
	LayoutInflater inflater = null;
	List<NilaiModel> Modellist = new ArrayList<NilaiModel>();
	public Nilai_Adapter(Context context, List<NilaiModel> list) {
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
			view = inflater.inflate(R.layout.adp_nilai, arg2, false);
		}
		
		TextView nis = (TextView) view.findViewById(R.id.nilai_nis);
		TextView nama = (TextView) view.findViewById(R.id.nilai_nama);
		TextView nip = (TextView) view.findViewById(R.id.nilai_nip);
		TextView nilai = (TextView) view.findViewById(R.id.nilai_nilai);
		TextView ket = (TextView) view.findViewById(R.id.nilai_ket);
		
		NilaiModel model = Modellist.get(position);
		nis.setText(model.getNis());
		nama.setText(model.getNm_siswa());
		nip.setText(model.getNip());
		nilai.setText(model.getNilai());
		ket.setText("ket: "+model.getKet());
		
		
		
		return view;
	}

}
