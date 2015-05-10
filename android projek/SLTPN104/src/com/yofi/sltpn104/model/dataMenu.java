package com.yofi.sltpn104.model;

import java.util.ArrayList;
import java.util.List;

import com.yofi.sltpn104.R;

public class dataMenu {
	
	int[] icon = {
			R.drawable.ic_format_list_bulleted_grey600_48dp,
			R.drawable.ic_add_box_grey600_48dp,
			R.drawable.ic_local_print_shop_grey600_48dp
	};
	
	String[] title = {
			"Menu View",
			"Menu Input",
			"Menu Laporan"
	};

	public List<ListModel> getMenuutama(){
		List<ListModel> list = new ArrayList<ListModel>();
		list.add(new ListModel(R.drawable.ic_format_list_bulleted_grey600_48dp, "Menu Lihat"));
		list.add(new ListModel(R.drawable.ic_add_box_grey600_48dp, "Menu Input"));
		list.add(new ListModel(R.drawable.ic_local_print_shop_grey600_48dp, "Menu Laporan"));
		return list;
	}
	
	public List<ListModel> getMenuutamaGuru(){
		List<ListModel> list = new ArrayList<ListModel>();
		list.add(new ListModel(R.drawable.ic_format_list_bulleted_grey600_48dp, "Menu Lihat"));
		list.add(new ListModel(R.drawable.ic_local_print_shop_grey600_48dp, "Menu Laporan"));
		return list;
	}
	
	public List<ListModel> getMenuInput(){
		List<ListModel> list = new ArrayList<ListModel>();
		list.add(new ListModel(R.drawable.ic_add_box_grey600_48dp, "Input Siswa"));
		list.add(new ListModel(R.drawable.ic_add_box_grey600_48dp, "Input Guru"));
		list.add(new ListModel(R.drawable.ic_add_box_grey600_48dp, "Input Pelajaran"));
		list.add(new ListModel(R.drawable.ic_add_box_grey600_48dp, "Input Nilai"));
		list.add(new ListModel(R.drawable.ic_add_box_grey600_48dp, "Input Absensi"));
		list.add(new ListModel(R.drawable.ic_add_box_grey600_48dp, "Input Kelas"));
		return list;
	}
	
	public List<ListModel> getMenuLihat(){
		List<ListModel> list = new ArrayList<ListModel>();
		list.add(new ListModel(R.drawable.ic_format_list_bulleted_grey600_48dp, "Lihat Siswa"));
		list.add(new ListModel(R.drawable.ic_format_list_bulleted_grey600_48dp, "Lihat Guru"));
		list.add(new ListModel(R.drawable.ic_format_list_bulleted_grey600_48dp, "Lihat Pelajaran"));
		list.add(new ListModel(R.drawable.ic_format_list_bulleted_grey600_48dp, "Lihat Nilai"));
		list.add(new ListModel(R.drawable.ic_format_list_bulleted_grey600_48dp, "Lihat Absensi"));
		list.add(new ListModel(R.drawable.ic_format_list_bulleted_grey600_48dp, "Lihat Kelas"));
		return list;
	}
	
	public List<ListModel> getMenuLaporan(){
		List<ListModel> list = new ArrayList<ListModel>();
		list.add(new ListModel(R.drawable.ic_local_print_shop_grey600_48dp, "Simpan Data Siswa"));
		list.add(new ListModel(R.drawable.ic_local_print_shop_grey600_48dp, "Simpan Data Guru"));
		list.add(new ListModel(R.drawable.ic_local_print_shop_grey600_48dp, "Simpan Data Pelajaran"));
		list.add(new ListModel(R.drawable.ic_local_print_shop_grey600_48dp, "Simpan Data Nilai"));
		list.add(new ListModel(R.drawable.ic_local_print_shop_grey600_48dp, "Simpan Data Absensi"));
		list.add(new ListModel(R.drawable.ic_local_print_shop_grey600_48dp, "Simpan Data Kelas"));
		return list;
	}
	
}
