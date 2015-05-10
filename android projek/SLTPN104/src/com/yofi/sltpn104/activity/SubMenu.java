package com.yofi.sltpn104.activity;

import java.util.ArrayList;
import java.util.List;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.adapter.ListMenu;
import com.yofi.sltpn104.callback.CallbackAbsensiList;
import com.yofi.sltpn104.callback.CallbackGuruList;
import com.yofi.sltpn104.callback.CallbackKelasList;
import com.yofi.sltpn104.callback.CallbackNilaiList;
import com.yofi.sltpn104.callback.CallbackPelajaranList;
import com.yofi.sltpn104.callback.CallbackSiswaList;
import com.yofi.sltpn104.helper.ApiHelper;
import com.yofi.sltpn104.model.AbsensiModel;
import com.yofi.sltpn104.model.GuruModel;
import com.yofi.sltpn104.model.KelasModel;
import com.yofi.sltpn104.model.ListModel;
import com.yofi.sltpn104.model.NilaiModel;
import com.yofi.sltpn104.model.PelajaranModel;
import com.yofi.sltpn104.model.SiswaModel;
import com.yofi.sltpn104.model.dataMenu;
import com.yofi.sltpn104.utils.FileOperations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class SubMenu extends Activity implements OnItemClickListener{

	List<ListModel> listModel = new ArrayList<ListModel>(); 
	Intent intent;
	ListMenu listmenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listmenu);
		ListView list = (ListView) findViewById(R.id.listmenu);
		
		intent = getIntent();
		if (intent.getStringExtra("menu").equals("input")) {
			listModel = new dataMenu().getMenuInput();
		}else if (intent.getStringExtra("menu").equals("lihat")) {
			listModel = new dataMenu().getMenuLihat();
		}else if (intent.getStringExtra("menu").equals("laporan")) {
			listModel = new dataMenu().getMenuLaporan();
		}
		listmenu = new ListMenu(getApplicationContext(),listModel);
		list.setAdapter(listmenu);
		list.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Log.e("title submenu", listmenu.getTitle(arg2));
		if (intent.getStringExtra("menu").equals("lihat")) {
			Intent i = new Intent(getApplicationContext(), Lihat.class);
			i.putExtra("lihat", listmenu.getTitle(arg2));
			startActivity(i);
		}else if (intent.getStringExtra("menu").equals("input")) {
			Intent intent = null;
			switch (listmenu.getTitle(arg2)) {
			case "Input Siswa":
				intent = new Intent(getApplicationContext(), Input_SIswa.class);
				break;
			case "Input Guru":
				intent = new Intent(getApplicationContext(), Input_Guru.class);
				break;
			case "Input Pelajaran":
				intent = new Intent(getApplicationContext(), Input_Pelajaran.class);
				break;
			case "Input Nilai":
				intent = new Intent(getApplicationContext(), Input_Nilai.class);
				break;
			case "Input Absensi":
				intent = new Intent(getApplicationContext(), Input_Absensi.class);
				break;
			case "Input Kelas":
				intent = new Intent(getApplicationContext(), Input_Kelas.class);
				break;
			default:
				break;
			}
			startActivity(intent);
		}else if (intent.getStringExtra("menu").equals("laporan")) {
			switch (listmenu.getTitle(arg2)) {
			case "Simpan Data Siswa":
				new ApiHelper().getSiswa("admin", new CallbackSiswaList() {
					
					@Override
					public void onSuccess(List<SiswaModel> listSiswalist) {
						String filename = "Siswa";
						FileOperations fop = new FileOperations();
						fop.writeSiswa(filename, listSiswalist);
			            if (fop.writeSiswa(filename, listSiswalist)) {
			                Toast.makeText(getApplicationContext(),
			                        filename + ".pdf berhasil disimpan", Toast.LENGTH_SHORT)
			                        .show();
			            } else {
			                Toast.makeText(getApplicationContext(), "Gagal menyimpan "+ filename +".pdf",
			                        Toast.LENGTH_SHORT).show();
			            }
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
				break;
			case "Simpan Data Guru":
				new ApiHelper().getGuru("admin", new CallbackGuruList() {
					
					@Override
					public void onSuccess(List<GuruModel> guruModellist) {
						String filename = "Guru";
						FileOperations fop = new FileOperations();
						fop.writeGuru(filename, guruModellist);
			            if (fop.writeGuru(filename, guruModellist)) {
			                Toast.makeText(getApplicationContext(),
			                        filename + ".pdf berhasil disimpan", Toast.LENGTH_SHORT)
			                        .show();
			            } else {
			                Toast.makeText(getApplicationContext(), "Gagal menyimpan "+ filename +".pdf",
			                        Toast.LENGTH_SHORT).show();
			            }
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
				
				break;
			case "Simpan Data Pelajaran":
				new ApiHelper().getPelajaran("admin", new CallbackPelajaranList() {
					
					@Override
					public void onSuccess(List<PelajaranModel> pelajaranModel) {
						String filename = "Pelajaran";
						FileOperations fop = new FileOperations();
						fop.writePelajaran(filename, pelajaranModel);
			            if (fop.writePelajaran(filename, pelajaranModel)) {
			                Toast.makeText(getApplicationContext(),
			                        filename + ".pdf berhasil disimpan", Toast.LENGTH_SHORT)
			                        .show();
			            } else {
			                Toast.makeText(getApplicationContext(), "Gagal menyimpan "+ filename +".pdf",
			                        Toast.LENGTH_SHORT).show();
			            }
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
				
				break;
			case "Simpan Data Nilai":
				new ApiHelper().getNilai("admin", new CallbackNilaiList() {
					
					@Override
					public void onSuccess(List<NilaiModel> absensiModellist) {
						String filename = "Nilai";
						FileOperations fop = new FileOperations();
						fop.writeNilai(filename, absensiModellist);
			            if (fop.writeNilai(filename, absensiModellist)) {
			                Toast.makeText(getApplicationContext(),
			                        filename + ".pdf berhasil disimpan", Toast.LENGTH_SHORT)
			                        .show();
			            } else {
			                Toast.makeText(getApplicationContext(), "Gagal menyimpan "+ filename +".pdf",
			                        Toast.LENGTH_SHORT).show();
			            }
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
				
				break;
			case "Simpan Data Absensi":
				new ApiHelper().getAbsensi("admin", new CallbackAbsensiList() {
					
					@Override
					public void onSuccess(List<AbsensiModel> absensiModellist) {
						String filename = "Absensi";
						FileOperations fop = new FileOperations();
						fop.writeAbsensi(filename, absensiModellist);
			            if (fop.writeAbsensi(filename, absensiModellist)) {
			                Toast.makeText(getApplicationContext(),
			                        filename + ".pdf berhasil disimpan", Toast.LENGTH_SHORT)
			                        .show();
			            } else {
			                Toast.makeText(getApplicationContext(), "Gagal menyimpan "+ filename +".pdf",
			                        Toast.LENGTH_SHORT).show();
			            }
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
				
				break;
			case "Simpan Data Kelas":
				new ApiHelper().getKelas("admin", new CallbackKelasList() {
					
					@Override
					public void onSuccess(List<KelasModel> kelasModellist) {
						String filename = "Kelas";
						FileOperations fop = new FileOperations();
						fop.writeKelas(filename, kelasModellist);
			            if (fop.writeKelas(filename, kelasModellist)) {
			                Toast.makeText(getApplicationContext(),
			                        filename + ".pdf berhasil disimpan", Toast.LENGTH_SHORT)
			                        .show();
			            } else {
			                Toast.makeText(getApplicationContext(), "Gagal menyimpan "+ filename +".pdf",
			                        Toast.LENGTH_SHORT).show();
			            }
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
				
				break;
			default:
				break;
			}
			
            
			
		}
	}
}
