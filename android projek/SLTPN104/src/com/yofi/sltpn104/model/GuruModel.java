package com.yofi.sltpn104.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GuruModel implements Parcelable{
	
	
	

	public GuruModel(String nip, String nm_guru, String jns_klmn_guru,
			String temp_lhr_guru, String tgl_lhr_guru, String almt_guru,
			String agm_guru, String status_peg, String thn_masuk,
			String tgs_mgjr_mp, String tlp_guru) {
		this.nip = nip;
		this.nm_guru = nm_guru;
		this.jns_klmn_guru = jns_klmn_guru;
		this.temp_lhr_guru = temp_lhr_guru;
		this.tgl_lhr_guru = tgl_lhr_guru;
		this.almt_guru = almt_guru;
		this.agm_guru = agm_guru;
		this.status_peg = status_peg;
		this.thn_masuk = thn_masuk;
		this.tgs_mgjr_mp = tgs_mgjr_mp;
		this.tlp_guru = tlp_guru;
	}
	
	public GuruModel(Parcel parcel){
		nip = parcel.readString();
		nm_guru = parcel.readString();
		jns_klmn_guru = parcel.readString();
		temp_lhr_guru = parcel.readString();
		tgl_lhr_guru = parcel.readString();
		almt_guru = parcel.readString();
		agm_guru = parcel.readString();
		status_peg = parcel.readString();
		thn_masuk = parcel.readString();
		tgs_mgjr_mp = parcel.readString();
		tlp_guru = parcel.readString();
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNm_guru() {
		return nm_guru;
	}

	public void setNm_guru(String nm_guru) {
		this.nm_guru = nm_guru;
	}

	public String getJns_klmn_guru() {
		return jns_klmn_guru;
	}

	public void setJns_klmn_guru(String jns_klmn_guru) {
		this.jns_klmn_guru = jns_klmn_guru;
	}

	public String getTemp_lhr_guru() {
		return temp_lhr_guru;
	}

	public void setTemp_lhr_guru(String temp_lhr_guru) {
		this.temp_lhr_guru = temp_lhr_guru;
	}

	public String getTgl_lhr_guru() {
		return tgl_lhr_guru;
	}

	public void setTgl_lhr_guru(String tgl_lhr_guru) {
		this.tgl_lhr_guru = tgl_lhr_guru;
	}

	public String getAlmt_guru() {
		return almt_guru;
	}

	public void setAlmt_guru(String almt_guru) {
		this.almt_guru = almt_guru;
	}

	public String getAgm_guru() {
		return agm_guru;
	}

	public void setAgm_guru(String agm_guru) {
		this.agm_guru = agm_guru;
	}

	public String getStatus_peg() {
		return status_peg;
	}

	public void setStatus_peg(String status_peg) {
		this.status_peg = status_peg;
	}

	public String getThn_masuk() {
		return thn_masuk;
	}

	public void setThn_masuk(String thn_masuk) {
		this.thn_masuk = thn_masuk;
	}

	public String getTgs_mgjr_mp() {
		return tgs_mgjr_mp;
	}

	public void setTgs_mgjr_mp(String tgs_mgjr_mp) {
		this.tgs_mgjr_mp = tgs_mgjr_mp;
	}

	public String getTlp_guru() {
		return tlp_guru;
	}

	public void setTlp_guru(String tlp_guru) {
		this.tlp_guru = tlp_guru;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private String nip, nm_guru, jns_klmn_guru, temp_lhr_guru, tgl_lhr_guru, almt_guru, agm_guru, status_peg, thn_masuk, tgs_mgjr_mp, tlp_guru;

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(nip);
		dest.writeString(nm_guru);
		dest.writeString(jns_klmn_guru);
		dest.writeString(temp_lhr_guru);
		dest.writeString(tgl_lhr_guru);
		dest.writeString(almt_guru);
		dest.writeString(agm_guru);
		dest.writeString(status_peg);
		dest.writeString(thn_masuk);
		dest.writeString(tgs_mgjr_mp);
		dest.writeString(tlp_guru);
	}
	
	public static final Creator<GuruModel> CREATOR = new Creator<GuruModel>() {
        @Override
        public GuruModel[] newArray(int size) {
            return new GuruModel[size];
        }

        @Override
        public GuruModel createFromParcel(Parcel source) {
            return new GuruModel(source);
        }
    };

}
