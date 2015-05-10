package com.yofi.sltpn104.adapter;

import java.util.ArrayList;
import java.util.List;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.model.SiswaModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Siswa_Adapter extends BaseAdapter{
	
	LayoutInflater inflater = null;
	List<SiswaModel> siswaModellist = new ArrayList<SiswaModel>();
	public Siswa_Adapter(Context context, List<SiswaModel> list) {
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		siswaModellist = list;
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return siswaModellist.size();
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
			view = inflater.inflate(R.layout.adp_siswa, arg2, false);
		}
		
		TextView nis = (TextView) view.findViewById(R.id.siswa_nis);
		TextView nama = (TextView) view.findViewById(R.id.siswa_nama);
		TextView alamat = (TextView) view.findViewById(R.id.siswa_alamat);
		TextView tlp = (TextView) view.findViewById(R.id.siswa_telp);
		TextView kelas = (TextView) view.findViewById(R.id.siswa_kelas);
		
		SiswaModel sModel = siswaModellist.get(position);
		nis.setText(sModel.getNis());
		nama.setText(sModel.getNm_siswa());
		alamat.setText(sModel.getAlmt_siswa());
		tlp.setText(sModel.getTlp_siswa());
		kelas.setText(sModel.getKls());
		
		
		
		
		return view;
	}

}
