package com.yofi.sltpn104.adapter;

import java.util.ArrayList;
import java.util.List;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.model.ListModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListMenu extends BaseAdapter {
	
	LayoutInflater inflater = null;
	List<ListModel> listModels = new ArrayList<ListModel>();
	public ListMenu(Context context, List<ListModel> list) {
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		listModels = list;
	}

	@Override
	public int getCount() {
		return listModels.size();
	}

	@Override
	public Object getItem(int arg0) {
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		if (arg1 == null) {
			arg1 = inflater.inflate(R.layout.adp_listmenu, arg2, false);
		}
		ListModel listModel = listModels.get(arg0);
		ImageView imageView = (ImageView) arg1.findViewById(R.id.listmenu_icon);
		TextView textView = (TextView) arg1.findViewById(R.id.listmenu_text);
		
		imageView.setImageResource(listModel.getIcon());
		textView.setText(listModel.getTitle());
		
		return arg1;
	}
	
	public String getTitle(int position){
		return listModels.get(position).getTitle();
	}

}
