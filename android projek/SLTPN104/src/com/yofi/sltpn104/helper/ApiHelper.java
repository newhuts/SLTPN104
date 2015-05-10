package com.yofi.sltpn104.helper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.yofi.sltpn104.callback.CallbackAbsensiList;
import com.yofi.sltpn104.callback.CallbackAdmin;
import com.yofi.sltpn104.callback.CallbackGuruList;
import com.yofi.sltpn104.callback.CallbackHelper;
import com.yofi.sltpn104.callback.CallbackInput;
import com.yofi.sltpn104.callback.CallbackKelasList;
import com.yofi.sltpn104.callback.CallbackNilaiList;
import com.yofi.sltpn104.callback.CallbackPelajaranList;
import com.yofi.sltpn104.callback.CallbackSiswaList;
import com.yofi.sltpn104.connection.Helper;
import com.yofi.sltpn104.model.AbsensiModel;
import com.yofi.sltpn104.model.AdminModel;
import com.yofi.sltpn104.model.GuruModel;
import com.yofi.sltpn104.model.KelasModel;
import com.yofi.sltpn104.model.NilaiModel;
import com.yofi.sltpn104.model.PelajaranModel;
import com.yofi.sltpn104.model.SiswaModel;

public class ApiHelper {
	
	public void login(String username, String password, final CallbackAdmin callbackAdmin) {
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						JSONObject obj = new JSONObject(jso.getString("d"));
                        JSONObject obb = new JSONObject(obj.getString("login"));
                        AdminModel adminModel = new AdminModel();
                        adminModel.setUsername(obb.getString("username"));
                        adminModel.setPassword(obb.getString("password"));
                        adminModel.setAkses(obb.getString("akses"));
                        adminModel.setIsLogin(true);
                        callbackAdmin.onSuccess(adminModel);
					}else {
						JSONObject obb = new JSONObject(jso.getString("e"));
						callbackAdmin.onError(obb.getString("reason"));
					}
				} catch (JSONException e) {
					callbackAdmin.onException("exception");
					e.printStackTrace();
				}
			}
		}).execute("login", "POST", username,password);
	}
	
	public void getSiswa(String akses, final CallbackSiswaList callbackSiswaList){
		final List<SiswaModel> siswaModelslList = new ArrayList<SiswaModel>();
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						JSONObject obj = new JSONObject(jso.getString("d"));
						JSONArray siswaarray = new JSONArray(obj.getString("siswa"));
						for (int i = 0; i < siswaarray.length(); i++) {
							JSONObject siswa = siswaarray.getJSONObject(i);
							siswaModelslList.add(new SiswaModel(
									siswa.getString("nis"), 
									siswa.getString("kd_kls"), 
									siswa.getString("nm_siswa"), 
									siswa.getString("almt_siswa"), 
									siswa.getString("tgl_lhr_siswa"), 
									siswa.getString("temp_lhr_siswa"), 
									siswa.getString("jns_klmn_siswa"), 
									siswa.getString("agm_siswa"), 
									siswa.getString("tlp_siswa"), 
									siswa.getString("kls")
									));
						}
						callbackSiswaList.onSuccess(siswaModelslList);
					}else {
						JSONObject obb = new JSONObject(jso.getString("e"));
						callbackSiswaList.onError(obb.getString("reason"));
					}
				} catch (JSONException e) {
					callbackSiswaList.onException("exception");
					e.printStackTrace();
				}
			}
		}).execute("get_siswa", "GET", akses);
	}
	
	public void getGuru(String akses, final CallbackGuruList callbackGuru){
		final List<GuruModel> guruModelslList = new ArrayList<GuruModel>();
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						JSONObject obj = new JSONObject(jso.getString("d"));
						JSONArray siswaarray = new JSONArray(obj.getString("guru"));
						for (int i = 0; i < siswaarray.length(); i++) {
							JSONObject siswa = siswaarray.getJSONObject(i);
							guruModelslList.add(new GuruModel(
									siswa.getString("nip"), 
									siswa.getString("nm_guru"), 
									siswa.getString("jns_klmn_guru"), 
									siswa.getString("temp_lhr_guru"), 
									siswa.getString("tgl_lhr_guru"), 
									siswa.getString("almt_guru"), 
									siswa.getString("agm_guru"), 
									siswa.getString("status_peg"), 
									siswa.getString("thn_masuk"), 
									siswa.getString("tgs_mgjr_mp"),
									siswa.getString("tlp_guru")
									));
						}
						callbackGuru.onSuccess(guruModelslList);
					}else {
						JSONObject obb = new JSONObject(jso.getString("e"));
						callbackGuru.onError(obb.getString("reason"));
					}
				} catch (JSONException e) {
					callbackGuru.onException("exception");
					e.printStackTrace();
				}
			}
		}).execute("get_guru", "GET", akses);
	}
	
	public void getPelajaran(String akses, final CallbackPelajaranList callbackPelajaran){
		final List<PelajaranModel> pelajaranModelslList = new ArrayList<PelajaranModel>();
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						JSONObject obj = new JSONObject(jso.getString("d"));
						JSONArray siswaarray = new JSONArray(obj.getString("pelajaran"));
						for (int i = 0; i < siswaarray.length(); i++) {
							JSONObject siswa = siswaarray.getJSONObject(i);
							pelajaranModelslList.add(new PelajaranModel(
									siswa.getString("kd_pel"), 
									siswa.getString("hari"), 
									siswa.getString("jam"), 
									siswa.getString("kls"), 
									siswa.getString("semester"), 
									siswa.getString("nm_pel")
									));
						}
						callbackPelajaran.onSuccess(pelajaranModelslList);
					}else {
						JSONObject obb = new JSONObject(jso.getString("e"));
						callbackPelajaran.onError(obb.getString("reason"));
					}
				} catch (JSONException e) {
					callbackPelajaran.onException("exception");
					e.printStackTrace();
				}
			}
		}).execute("get_pelajaran", "GET", akses);
	}
	
	public void getNilai(String akses, final CallbackNilaiList callbackNilaiList){
		final List<NilaiModel> nilaiModelslList = new ArrayList<NilaiModel>();
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						JSONObject obj = new JSONObject(jso.getString("d"));
						JSONArray siswaarray = new JSONArray(obj.getString("nilai"));
						for (int i = 0; i < siswaarray.length(); i++) {
							JSONObject siswa = siswaarray.getJSONObject(i);
							nilaiModelslList.add(new NilaiModel(
									siswa.getString("nis"), 
									siswa.getString("nip"), 
									siswa.getString("kd_pel"), 
									siswa.getString("kd_kls"), 
									siswa.getString("nm_siswa"), 
									siswa.getString("nilai"),
									siswa.getString("ket")
									));
						}
						callbackNilaiList.onSuccess(nilaiModelslList);
					}else {
						JSONObject obb = new JSONObject(jso.getString("e"));
						callbackNilaiList.onError(obb.getString("reason"));
					}
				} catch (JSONException e) {
					callbackNilaiList.onException("exception");
					e.printStackTrace();
				}
			}
		}).execute("get_nilai", "GET", akses);
	}
	
	public void getAbsensi(String akses, final CallbackAbsensiList callbackAbsensi){
		final List<AbsensiModel> absensiModelslList = new ArrayList<AbsensiModel>();
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						JSONObject obj = new JSONObject(jso.getString("d"));
						JSONArray siswaarray = new JSONArray(obj.getString("absensi"));
						for (int i = 0; i < siswaarray.length(); i++) {
							JSONObject siswa = siswaarray.getJSONObject(i);
							absensiModelslList.add(new AbsensiModel(
									siswa.getString("id_absen"), 
									siswa.getString("tgl_msk"), 
									siswa.getString("jam_msk"), 
									siswa.getString("jam_klr"), 
									siswa.getString("status"), 
									siswa.getString("ket_absen")
									));
						}
						callbackAbsensi.onSuccess(absensiModelslList);
					}else {
						JSONObject obb = new JSONObject(jso.getString("e"));
						callbackAbsensi.onError(obb.getString("reason"));
					}
				} catch (JSONException e) {
					callbackAbsensi.onException("exception");
					e.printStackTrace();
				}
			}
		}).execute("get_absensi", "GET", akses);
	}
	
	public void getKelas(String akses, final CallbackKelasList callbackKelasList) {
		final List<KelasModel> kelasModelslList = new ArrayList<KelasModel>();
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						JSONObject obj = new JSONObject(jso.getString("d"));
						JSONArray siswaarray = new JSONArray(obj.getString("kelas"));
						for (int i = 0; i < siswaarray.length(); i++) {
							JSONObject siswa = siswaarray.getJSONObject(i);
							kelasModelslList.add(new KelasModel(
									siswa.getString("kd_kls"), 
									siswa.getString("nip"),
									siswa.getString("nm_kls")
									));
						}
						callbackKelasList.onSuccess(kelasModelslList);
					}else {
						JSONObject obb = new JSONObject(jso.getString("e"));
						callbackKelasList.onError(obb.getString("reason"));
					}
				} catch (JSONException e) {
					callbackKelasList.onException("exception");
					e.printStackTrace();
				}
			}
		}).execute("get_kelas", "GET", akses);
	}
	
	
	public void inputSiswa(String nis, String kd_kls,String nm_siswa,String almt_siswa,String tgl_lhr_siswa,
			String temp_lhr_siswa,String jns_klmn_siswa,String agm_siswa,String tlp_siswa,String kls, 
			final CallbackInput callbackInput){
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						callbackInput.onSuccess("oke");
					}else {
						callbackInput.onError("Gagal Input Siswa");
					}
				} catch (JSONException e) {
					callbackInput.onError("Terjadi Kesalahan!!!");
					e.printStackTrace();
				}
			}
		}).execute("input_siswa", "POST", 
				nis, 
				kd_kls, 
				nm_siswa, 
				almt_siswa, 
				tgl_lhr_siswa, 
				temp_lhr_siswa, 
				jns_klmn_siswa,
				agm_siswa, 
				tlp_siswa, 
				kls);
	}

	public void inputGuru(String nip,String nm_guru,String jns_klmn_guru,String temp_lhr_guru,String tgl_lhr_guru, 
			String almt_guru,String agm_guru,String status_peg,String thn_masuk,String tgs_mgjr_mp,
			String tlp_guru, final CallbackInput callbackInput){
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						callbackInput.onSuccess("oke");
					}else {
						callbackInput.onError("Gagal Input Siswa");
					}
				} catch (JSONException e) {
					callbackInput.onError("Terjadi Kesalahan!!!");
					e.printStackTrace();
				}
			}
		}).execute("input_guru", "POST", 
				nip,
				nm_guru, 
				jns_klmn_guru, 
				temp_lhr_guru, 
				tgl_lhr_guru, 
				almt_guru, 
				agm_guru, 
				status_peg,
				thn_masuk, 
				tgs_mgjr_mp,
				tlp_guru);
		
	}
	
	public void inputPelajaran(String kd_pel,String hari,String jam,String kls,String semester,String nm_pel,
			final CallbackInput callbackInput){
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						callbackInput.onSuccess("oke");
					}else {
						callbackInput.onError("Gagal Input Siswa");
					}
				} catch (JSONException e) {
					callbackInput.onError("Terjadi Kesalahan!!!");
					e.printStackTrace();
				}
			}
		}).execute("input_pelajaran", "POST", kd_pel, hari, jam, kls, semester, nm_pel);
		
	}
	
	public void inputNilai(String nis,String nip,String kd_pel,String kd_kls,String nm_siswa,
			String nilai,String ket, final CallbackInput callbackInput) {
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						callbackInput.onSuccess("oke");
					}else {
						callbackInput.onError("Gagal Input Siswa");
					}
				} catch (JSONException e) {
					callbackInput.onError("Terjadi Kesalahan!!!");
					e.printStackTrace();
				}
			}
		}).execute("input_nilai", "POST", nis, nip, kd_pel, kd_kls, nm_siswa, nilai, ket);	
	}
	
	public void inputAbsensi(String id_absen,String tgl_msk,String jam_msk,String jam_klr,String status,
			String ket_absen, final CallbackInput callbackInput) {
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						callbackInput.onSuccess("oke");
					}else {
						callbackInput.onError("Gagal Input Siswa");
					}
				} catch (JSONException e) {
					callbackInput.onError("Terjadi Kesalahan!!!");
					e.printStackTrace();
				}
			}
		}).execute("input_absensi", "POST", id_absen, tgl_msk, jam_msk, jam_klr, status, ket_absen);
	}
	
	public void inputKelas(String kd_kls,String nip,String nm_kls, final CallbackInput callbackInput) {
		new Helper(new CallbackHelper() {
			
			@Override
			public void onTaskDone(String result) {
				Log.e("Login", ">"+result);
				try {
					JSONObject jso = new JSONObject(result);
					if (jso.has("d")) {
						callbackInput.onSuccess("oke");
					}else {
						callbackInput.onError("Gagal Input Siswa");
					}
				} catch (JSONException e) {
					callbackInput.onError("Terjadi Kesalahan!!!");
					e.printStackTrace();
				}
			}
		}).execute("input_kelas", "POST", kd_kls, nip, nm_kls);
	}
	
}
