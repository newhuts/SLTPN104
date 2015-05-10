package com.yofi.sltpn104.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SiswaModel implements Parcelable{

	private String nis, kd_kls, nm_siswa, almt_siswa, tgl_lhr_siswa, temp_lhr_siswa, jns_klmn_siswa, agm_siswa, tlp_siswa, kls;	
	
	public SiswaModel(String nis, String kd_kls, String nm_siswa,
			String almt_siswa, String tgl_lhr_siswa, String temp_lhr_siswa,
			String jns_klmn_siswa, String agm_siswa, String tlp_siswa,
			String kls) {
		this.nis = nis;
		this.kd_kls = kd_kls;
		this.nm_siswa = nm_siswa;
		this.almt_siswa = almt_siswa;
		this.tgl_lhr_siswa = tgl_lhr_siswa;
		this.temp_lhr_siswa = temp_lhr_siswa;
		this.jns_klmn_siswa = jns_klmn_siswa;
		this.agm_siswa = agm_siswa;
		this.tlp_siswa = tlp_siswa;
		this.kls = kls;
	}
	
	public SiswaModel(Parcel parcel) {
		nis = parcel.readString();
		kd_kls = parcel.readString();
		nm_siswa = parcel.readString();
		almt_siswa = parcel.readString();
		tgl_lhr_siswa = parcel.readString();
		temp_lhr_siswa = parcel.readString();
		jns_klmn_siswa = parcel.readString();
		agm_siswa = parcel.readString();
		tlp_siswa = parcel.readString();
		kls = parcel.readString();
	}
	

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getKd_kls() {
		return kd_kls;
	}

	public void setKd_kls(String kd_kls) {
		this.kd_kls = kd_kls;
	}

	public String getNm_siswa() {
		return nm_siswa;
	}

	public void setNm_siswa(String nm_siswa) {
		this.nm_siswa = nm_siswa;
	}

	public String getAlmt_siswa() {
		return almt_siswa;
	}

	public void setAlmt_siswa(String almt_siswa) {
		this.almt_siswa = almt_siswa;
	}

	public String getTgl_lhr_siswa() {
		return tgl_lhr_siswa;
	}

	public void setTgl_lhr_siswa(String tgl_lhr_siswa) {
		this.tgl_lhr_siswa = tgl_lhr_siswa;
	}

	public String getTemp_lhr_siswa() {
		return temp_lhr_siswa;
	}

	public void setTemp_lhr_siswa(String temp_lhr_siswa) {
		this.temp_lhr_siswa = temp_lhr_siswa;
	}

	public String getJns_klmn_siswa() {
		return jns_klmn_siswa;
	}

	public void setJns_klmn_siswa(String jns_klmn_siswa) {
		this.jns_klmn_siswa = jns_klmn_siswa;
	}

	public String getAgm_siswa() {
		return agm_siswa;
	}

	public void setAgm_siswa(String agm_siswa) {
		this.agm_siswa = agm_siswa;
	}

	public String getTlp_siswa() {
		return tlp_siswa;
	}

	public void setTlp_siswa(String tlp_siswa) {
		this.tlp_siswa = tlp_siswa;
	}

	public String getKls() {
		return kls;
	}

	public void setKls(String kls) {
		this.kls = kls;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(nis);
		dest.writeString(kd_kls);
		dest.writeString(nm_siswa);
		dest.writeString(almt_siswa);
		dest.writeString(tgl_lhr_siswa);
		dest.writeString(temp_lhr_siswa);
		dest.writeString(jns_klmn_siswa);
		dest.writeString(agm_siswa);
		dest.writeString(tlp_siswa);
		dest.writeString(kls);
	}
	
	public static final Creator<SiswaModel> CREATOR = new Creator<SiswaModel>() {
        @Override
        public SiswaModel[] newArray(int size) {
            return new SiswaModel[size];
        }

        @Override
        public SiswaModel createFromParcel(Parcel source) {
            return new SiswaModel(source);
        }
    };
	
}
