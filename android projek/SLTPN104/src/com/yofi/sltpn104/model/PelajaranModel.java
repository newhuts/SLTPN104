package com.yofi.sltpn104.model;

import android.os.Parcel;
import android.os.Parcelable;

public class PelajaranModel implements Parcelable{
	
	private String kd_pel, hari, jam, kls, semester, nm_pel;
	
	
	

	public PelajaranModel(String kd_pel, String hari, String jam, String kls,
			String semester, String nm_pel) {
		this.kd_pel = kd_pel;
		this.hari = hari;
		this.jam = jam;
		this.kls = kls;
		this.semester = semester;
		this.nm_pel = nm_pel;
	}
	
	public PelajaranModel(Parcel parcel) {
		kd_pel = parcel.readString();
		hari = parcel.readString();
		jam = parcel.readString();
		kls = parcel.readString();
		semester = parcel.readString();
		nm_pel = parcel.readString();
	}

	public String getKd_pel() {
		return kd_pel;
	}

	public void setKd_pel(String kd_pel) {
		this.kd_pel = kd_pel;
	}

	public String getHari() {
		return hari;
	}

	public void setHari(String hari) {
		this.hari = hari;
	}

	public String getJam() {
		return jam;
	}

	public void setJam(String jam) {
		this.jam = jam;
	}

	public String getKls() {
		return kls;
	}

	public void setKls(String kls) {
		this.kls = kls;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getNm_pel() {
		return nm_pel;
	}

	public void setNm_pel(String nm_pel) {
		this.nm_pel = nm_pel;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(kd_pel);
		dest.writeString(hari);
		dest.writeString(jam);
		dest.writeString(kls);
		dest.writeString(semester);
		dest.writeString(nm_pel);
	}
	
	public static final Creator<PelajaranModel> CREATOR = new Creator<PelajaranModel>() {
        @Override
        public PelajaranModel[] newArray(int size) {
            return new PelajaranModel[size];
        }

        @Override
        public PelajaranModel createFromParcel(Parcel source) {
            return new PelajaranModel(source);
        }
    };
	
}
