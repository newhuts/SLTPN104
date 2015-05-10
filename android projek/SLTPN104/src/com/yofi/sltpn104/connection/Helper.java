package com.yofi.sltpn104.connection;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;




import com.yofi.sltpn104.callback.CallbackHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helper extends AsyncTask<String , Void, String>{

    public static String BASE_URL = "http://192.168.88.234/sltpn104/";
    public static String LOGIN = "login.php";
    public static String GETSISWA = "get_siswa.php";
    public static String GETGURU = "get_guru.php";
    public static String GETPELAJARAN = "get_pelajaran.php";
    public static String GETNILAI = "get_nilai.php";
    public static String GETABSENSI = "get_absensi.php";
    public static String GETKELAS = "get_kelas.php";
    public static String INPUTSISWA = "input_siswa.php";
    public static String INPUTGURU = "input_guru.php";
    public static String INPUTPELAJARAN = "input_pelajaran.php";
    public static String INPUTNILAI = "input_nilai.php";
    public static String INPUTABSENSI = "input_absensi.php";
    public static String INPUTKELAS = "input_kelas.php";
    
    List<NameValuePair>param;
    private CallbackHelper mFragmentCallback;
	String url, method;

    public Helper(CallbackHelper fragmentCallback) {
        mFragmentCallback = fragmentCallback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
	    
    @Override
    protected String doInBackground(String... params) {
        String request = params[0];
        method = params[1];
        param = new ArrayList<>();
        switch (request) {
            case "login":
                url = BASE_URL + "" + LOGIN;
                param.add(new BasicNameValuePair("username", params[2]));
                param.add(new BasicNameValuePair("password", params[3]));
                break;
            case "get_siswa":
            	url = BASE_URL + "" + GETSISWA;
                param.add(new BasicNameValuePair("akses", params[2]));
            	break;
            case "get_guru":
            	url = BASE_URL + "" + GETGURU;
                param.add(new BasicNameValuePair("akses", params[2]));
            	break;
            case "get_pelajaran":
            	url = BASE_URL + "" + GETPELAJARAN;
                param.add(new BasicNameValuePair("akses", params[2]));
            	break;
            case "get_nilai":
            	url = BASE_URL + "" + GETNILAI;
                param.add(new BasicNameValuePair("akses", params[2]));
            	break;
            case "get_absensi":
            	url = BASE_URL + "" + GETABSENSI;
                param.add(new BasicNameValuePair("akses", params[2]));
            	break;
            case "get_kelas":
            	url = BASE_URL + "" + GETKELAS;
                param.add(new BasicNameValuePair("akses", params[2]));
            	break;
            case "input_siswa":
            	url = BASE_URL + "" + INPUTSISWA;
                param.add(new BasicNameValuePair("nis", params[2]));
                param.add(new BasicNameValuePair("kd_kls", params[3]));
                param.add(new BasicNameValuePair("nm_siswa", params[4]));
                param.add(new BasicNameValuePair("almt_siswa", params[5]));
                param.add(new BasicNameValuePair("tgl_lhr_siswa", params[6]));
                param.add(new BasicNameValuePair("temp_lhr_siswa", params[7]));
                param.add(new BasicNameValuePair("jns_klmn_siswa", params[8]));
                param.add(new BasicNameValuePair("agm_siswa", params[9]));
                param.add(new BasicNameValuePair("tlp_siswa", params[10]));
                param.add(new BasicNameValuePair("kls", params[11]));
            	break;
            case "input_guru":
            	url = BASE_URL + "" + INPUTGURU;
                param.add(new BasicNameValuePair("nip", params[2]));
                param.add(new BasicNameValuePair("nm_guru", params[3]));
                param.add(new BasicNameValuePair("jns_klmn_guru", params[4]));
                param.add(new BasicNameValuePair("temp_lhr_guru", params[5]));
                param.add(new BasicNameValuePair("tgl_lhr_guru", params[6]));
                param.add(new BasicNameValuePair("almt_guru", params[7]));
                param.add(new BasicNameValuePair("agm_guru", params[8]));
                param.add(new BasicNameValuePair("status_peg", params[9]));
                param.add(new BasicNameValuePair("thn_masuk", params[10]));
                param.add(new BasicNameValuePair("tgs_mgjr_mp", params[11]));
                param.add(new BasicNameValuePair("tlp_guru", params[12]));
            	break;
            case "input_pelajaran":
            	url = BASE_URL + "" + INPUTPELAJARAN;
                param.add(new BasicNameValuePair("kd_pel", params[2]));
                param.add(new BasicNameValuePair("hari", params[3]));
                param.add(new BasicNameValuePair("jam", params[4]));
                param.add(new BasicNameValuePair("kls", params[5]));
                param.add(new BasicNameValuePair("semester", params[6]));
                param.add(new BasicNameValuePair("nm_pel", params[7]));
                break;
            case "input_nilai":
            	url = BASE_URL + "" + INPUTNILAI;
                param.add(new BasicNameValuePair("nis", params[2]));
                param.add(new BasicNameValuePair("nip", params[3]));
                param.add(new BasicNameValuePair("kd_pel", params[4]));
                param.add(new BasicNameValuePair("kd_kls", params[5]));
                param.add(new BasicNameValuePair("nm_siswa", params[6]));
                param.add(new BasicNameValuePair("nilai", params[7]));
                param.add(new BasicNameValuePair("ket", params[8]));
                break;
            case "input_absensi":
            	url = BASE_URL + "" + INPUTABSENSI;
                param.add(new BasicNameValuePair("id_absen", params[2]));
                param.add(new BasicNameValuePair("tgl_msk", params[3]));
                param.add(new BasicNameValuePair("jam_msk", params[4]));
                param.add(new BasicNameValuePair("jam_klr", params[5]));
                param.add(new BasicNameValuePair("status", params[6]));
                param.add(new BasicNameValuePair("ket_absen", params[7]));
                break;
            case "input_kelas":
            	url = BASE_URL + "" + INPUTKELAS;
                param.add(new BasicNameValuePair("kd_kls", params[2]));
                param.add(new BasicNameValuePair("nip", params[3]));
                param.add(new BasicNameValuePair("nm_kls", params[4]));
                break;
            	
        }
            Log.e("tembak api", ">"+url+"  "+method+"  "+ Arrays.toString(params));
        return HttpRequest.makeHttpRequest(url, method, param);
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        mFragmentCallback.onTaskDone(result);
    }
}
