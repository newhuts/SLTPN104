package com.yofi.sltpn104.model;

import android.os.Parcel;
import android.os.Parcelable;

public class KelasModel implements Parcelable{
	
	private String kd_kls, nip, nm_kls;
	
	public KelasModel(String kd_kls, String nip, String nm_kls) {
		this.kd_kls = kd_kls;
		this.nip = nip;
		this.nm_kls = nm_kls;
	}
	
	public KelasModel(Parcel parcel) {
		kd_kls = parcel.readString();
		nip = parcel.readString();
		nm_kls = parcel.readString();
	}

	public String getKd_kls() {
		return kd_kls;
	}

	public void setKd_kls(String kd_kls) {
		this.kd_kls = kd_kls;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNm_kls() {
		return nm_kls;
	}

	public void setNm_kls(String nm_kls) {
		this.nm_kls = nm_kls;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(kd_kls);
		dest.writeString(nip);
		dest.writeString(nm_kls);
	}
	
	public static final Creator<KelasModel> CREATOR = new Creator<KelasModel>() {
        @Override
        public KelasModel[] newArray(int size) {
            return new KelasModel[size];
        }

        @Override
        public KelasModel createFromParcel(Parcel source) {
            return new KelasModel(source);
        }
    };
	
}
