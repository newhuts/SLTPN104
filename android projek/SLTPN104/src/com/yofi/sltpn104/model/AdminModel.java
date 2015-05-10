package com.yofi.sltpn104.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AdminModel implements Parcelable{

	private String id, username, password, akses;
	private boolean isLogin;
	
	public AdminModel(){
		
	}
	
	public AdminModel(String id,String username,String password,String akses, boolean islogin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.akses = akses;
		this.isLogin = islogin;
	}
	
	public AdminModel(Parcel parcel) {
		id = parcel.readString();
		username = parcel.readString();
		password = parcel.readString();
		akses = parcel.readString();
		isLogin = parcel.readByte() != 0; 
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAkses() {
		return akses;
	}

	public void setAkses(String akses) {
		this.akses = akses;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(id);
		dest.writeString(username);
		dest.writeString(password);
		dest.writeString(akses);
		dest.writeByte((byte) (isLogin ? 1 : 0));
	}
	
	public boolean IsLogin() {
		return isLogin;
	}

	public void setIsLogin(boolean islogin) {
		this.isLogin = islogin;
	}

	public static final Creator<AdminModel> CREATOR = new Creator<AdminModel>() {
        @Override
        public AdminModel[] newArray(int size) {
            return new AdminModel[size];
        }

        @Override
        public AdminModel createFromParcel(Parcel source) {
            return new AdminModel(source);
        }
    };

}
