package com.yofi.sltpn104.adapter;

import java.util.ArrayList;
import java.util.List;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.model.GuruModel;
import com.yofi.sltpn104.model.SiswaModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Guru_Adapter extends BaseAdapter{
	
	LayoutInflater inflater = null;
	List<GuruModel> Modellist = new ArrayList<GuruModel>();
	public Guru_Adapter(Context context, List<GuruModel> list) {
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
			view = inflater.inflate(R.layout.adp_guru, arg2, false);
		}
		
		TextView nip = (TextView) view.findViewById(R.id.guru_nip);
		TextView nama = (TextView) view.findViewById(R.id.guru_nama);
		TextView alamat = (TextView) view.findViewById(R.id.guru_alamat);
		TextView tlp = (TextView) view.findViewById(R.id.guru_telp);
		TextView mengajar = (TextView) view.findViewById(R.id.guru_mengajaar);
		
		GuruModel sModel = Modellist.get(position);
		nip.setText(sModel.getNip());
		nama.setText(sModel.getNm_guru());
		alamat.setText(sModel.getAlmt_guru());
		tlp.setText(sModel.getTlp_guru());
		mengajar.setText(sModel.getTgs_mgjr_mp());
		
		
		
		return view;
	}

}
