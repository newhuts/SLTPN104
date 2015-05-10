package com.yofi.sltpn104.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NilaiModel implements Parcelable{
	
	private String nis, nip, kd_pel, kd_kls, nm_siswa, nilai, ket;

	public NilaiModel(String nis, String nip, String kd_pel, String kd_kls,
			String nm_siswa, String nilai, String ket) {
		super();
		this.nis = nis;
		this.nip = nip;
		this.kd_pel = kd_pel;
		this.kd_kls = kd_kls;
		this.nm_siswa = nm_siswa;
		this.nilai = nilai;
		this.ket = ket;
	}
	
	public NilaiModel(Parcel parcel) {
		nis = parcel.readString();
		nip = parcel.readString();
		kd_pel = parcel.readString();
		kd_kls = parcel.readString();
		nm_siswa = parcel.readString();
		nilai = parcel.readString();
		ket = parcel.readString();
	}
	
	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getKd_pel() {
		return kd_pel;
	}

	public void setKd_pel(String kd_pel) {
		this.kd_pel = kd_pel;
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

	public String getNilai() {
		return nilai;
	}

	public void setNilai(String nilai) {
		this.nilai = nilai;
	}

	public String getKet() {
		return ket;
	}

	public void setKet(String ket) {
		this.ket = ket;
	}

	public static Creator<NilaiModel> getCreator() {
		return CREATOR;
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(nis);
		dest.writeString(nip);
		dest.writeString(kd_pel);
		dest.writeString(kd_kls);
		dest.writeString(nm_siswa);
		dest.writeString(nilai);
		dest.writeString(ket);
	}

	public static final Creator<NilaiModel> CREATOR = new Creator<NilaiModel>() {
        @Override
        public NilaiModel[] newArray(int size) {
            return new NilaiModel[size];
        }

        @Override
        public NilaiModel createFromParcel(Parcel source) {
            return new NilaiModel(source);
        }
    };
	
}
