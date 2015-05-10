package com.yofi.sltpn104.activity;

import java.util.List;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.adapter.Absensi_Adapter;
import com.yofi.sltpn104.adapter.Guru_Adapter;
import com.yofi.sltpn104.adapter.Kelas_Adapter;
import com.yofi.sltpn104.adapter.Nilai_Adapter;
import com.yofi.sltpn104.adapter.Pelajaran_adapter;
import com.yofi.sltpn104.adapter.Siswa_Adapter;
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
import com.yofi.sltpn104.model.NilaiModel;
import com.yofi.sltpn104.model.PelajaranModel;
import com.yofi.sltpn104.model.SiswaModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class Lihat extends Activity{

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listmenu);
		final ListView listView = (ListView) findViewById(R.id.listmenu);
		
		Intent intent = getIntent();
		
		switch (intent.getStringExtra("lihat")) {
		case "Lihat Siswa":
			new ApiHelper().getSiswa("admin", new CallbackSiswaList() {
				
				@Override
				public void onSuccess(List<SiswaModel> listSiswa) {
					listView.setAdapter(new Siswa_Adapter(getApplicationContext(), listSiswa));
				}
				
				@Override
				public void onException(String reason) {
					toast(reason);
				}
				
				@Override
				public void onError(String reason) {
					toast(reason);
				}
			});
			break;
		case "Lihat Guru":
			new ApiHelper().getGuru("admin", new CallbackGuruList() {
				
				@Override
				public void onSuccess(List<GuruModel> guruModellist) {
					listView.setAdapter(new Guru_Adapter(getApplicationContext(), guruModellist));
				}
				
				@Override
				public void onException(String reason) {
					toast(reason);
				}
				
				@Override
				public void onError(String reason) {
					toast(reason);
				}
			});
			break;
		case "Lihat Pelajaran":
			new ApiHelper().getPelajaran("admin", new CallbackPelajaranList() {
				
				@Override
				public void onSuccess(List<PelajaranModel> pelajaranModel) {
					listView.setAdapter(new Pelajaran_adapter(getApplicationContext(), pelajaranModel));
				}
				
				@Override
				public void onException(String reason) {
					toast(reason);
				}
				
				@Override
				public void onError(String reason) {
					toast(reason);
				}
			});
			break;
		case "Lihat Nilai":
			new ApiHelper().getNilai("admin", new CallbackNilaiList() {
				
				@Override
				public void onSuccess(List<NilaiModel> nilaiModellist) {
					listView.setAdapter(new Nilai_Adapter(getApplicationContext(), nilaiModellist));
				}
				
				@Override
				public void onException(String reason) {
					toast(reason);
				}
				
				@Override
				public void onError(String reason) {
					toast(reason);
				}
			});
			break;
		case "Lihat Absensi":
			new ApiHelper().getAbsensi("admin", new CallbackAbsensiList() {
				
				@Override
				public void onSuccess(List<AbsensiModel> absensiModellist) {
					listView.setAdapter(new Absensi_Adapter(getApplicationContext(), absensiModellist));
				}
				
				@Override
				public void onException(String reason) {
					toast(reason);
				}
				
				@Override
				public void onError(String reason) {
					toast(reason);
				}
			});
			break;
		case "Lihat Kelas":
			new ApiHelper().getKelas("admin", new CallbackKelasList() {
				
				@Override
				public void onSuccess(List<KelasModel> kelasModellist) {
					listView.setAdapter(new Kelas_Adapter(getApplicationContext(), kelasModellist));
				}
				
				@Override
				public void onException(String reason) {
					toast(reason);
				}
				
				@Override
				public void onError(String reason) {
					toast(reason);
				}
			});
			break;
			
		default:
			break;
		}
		
		
		
	}
	
	private void toast(String reason){
		Toast.makeText(getApplicationContext(), reason, Toast.LENGTH_SHORT).show();
	}
}
