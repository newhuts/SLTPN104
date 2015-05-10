package com.yofi.sltpn104.adapter;

import java.util.ArrayList;
import java.util.List;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.model.GuruModel;
import com.yofi.sltpn104.model.KelasModel;
import com.yofi.sltpn104.model.NilaiModel;
import com.yofi.sltpn104.model.SiswaModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Kelas_Adapter extends BaseAdapter{
	
	LayoutInflater inflater = null;
	List<KelasModel> Modellist = new ArrayList<KelasModel>();
	public Kelas_Adapter(Context context, List<KelasModel> list) {
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
			view = inflater.inflate(R.layout.adp_kelas, arg2, false);
		}
		
		TextView kode = (TextView) view.findViewById(R.id.kelas_kode);
		TextView nama = (TextView) view.findViewById(R.id.kelas_nama);
		TextView nip = (TextView) view.findViewById(R.id.kelas_nip);
		
		KelasModel model = Modellist.get(position);
		kode.setText(model.getKd_kls());
		nama.setText(model.getNm_kls());
		nip.setText(model.getNip());
		
		
		
		return view;
	}

}
