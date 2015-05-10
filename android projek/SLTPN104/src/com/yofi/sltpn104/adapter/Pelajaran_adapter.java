package com.yofi.sltpn104.adapter;

import java.util.ArrayList;
import java.util.List;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.model.GuruModel;
import com.yofi.sltpn104.model.PelajaranModel;
import com.yofi.sltpn104.model.SiswaModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Pelajaran_adapter extends BaseAdapter{
	
	LayoutInflater inflater = null;
	List<PelajaranModel> Modellist = new ArrayList<PelajaranModel>();
	public Pelajaran_adapter(Context context, List<PelajaranModel> list) {
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
			view = inflater.inflate(R.layout.adp_pelajaran, arg2, false);
		}
		
		TextView kode = (TextView) view.findViewById(R.id.pelajaran_kode);
		TextView nama = (TextView) view.findViewById(R.id.pelajaran_nama);
		TextView hari = (TextView) view.findViewById(R.id.pelajaran_hari);
		TextView jam = (TextView) view.findViewById(R.id.pelajaran_jam);
		TextView kelas = (TextView) view.findViewById(R.id.pelajaran_kelas);
		TextView semester = (TextView) view.findViewById(R.id.pelajaran_semester);
		
		PelajaranModel model = Modellist.get(position);
		kode.setText(model.getKd_pel());
		nama.setText(model.getNm_pel());
		hari.setText(model.getHari());
		jam.setText(model.getJam());
		kelas.setText("Kelas: "+model.getKls());
		semester.setText("Semester: "+model.getSemester());
		
		
		return view;
	}

}
