package com.yofi.sltpn104.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AbsensiModel implements Parcelable{
	
	private String id_absen, tgl_msk, jam_msk, jam_klr, status, ket_absen;

	public AbsensiModel(String id_absen, String tgl_msk, String jam_msk,
			String jam_klr, String status, String ket_absen) {
		this.id_absen = id_absen;
		this.tgl_msk = tgl_msk;
		this.jam_msk = jam_msk;
		this.jam_klr = jam_klr;
		this.status = status;
		this.ket_absen = ket_absen;
	}
	
	public AbsensiModel(Parcel parcel){
		id_absen = parcel.readString();
		tgl_msk = parcel.readString();
		jam_msk = parcel.readString();
		jam_klr = parcel.readString();
		status = parcel.readString();
		ket_absen = parcel.readString();
	}

	public String getId_absen() {
		return id_absen;
	}

	public void setId_absen(String id_absen) {
		this.id_absen = id_absen;
	}

	public String getTgl_msk() {
		return tgl_msk;
	}

	public void setTgl_msk(String tgl_msk) {
		this.tgl_msk = tgl_msk;
	}

	public String getJam_msk() {
		return jam_msk;
	}

	public void setJam_msk(String jam_msk) {
		this.jam_msk = jam_msk;
	}

	public String getJam_klr() {
		return jam_klr;
	}

	public void setJam_klr(String jam_klr) {
		this.jam_klr = jam_klr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKet_absen() {
		return ket_absen;
	}

	public void setKet_absen(String ket_absen) {
		this.ket_absen = ket_absen;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(id_absen);
		dest.writeString(tgl_msk);
		dest.writeString(jam_msk);
		dest.writeString(jam_klr);
		dest.writeString(status);
		dest.writeString(ket_absen);
	}
	
	public static final Creator<AbsensiModel> CREATOR = new Creator<AbsensiModel>() {
        @Override
        public AbsensiModel[] newArray(int size) {
            return new AbsensiModel[size];
        }

        @Override
        public AbsensiModel createFromParcel(Parcel source) {
            return new AbsensiModel(source);
        }
    };
	
}
