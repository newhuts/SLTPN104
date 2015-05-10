package com.yofi.sltpn104.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ListModel implements Parcelable{

	private int icon;
	private String title;
	
	public ListModel(int icons, String titles) {
		this.icon = icons;
		this.title = titles;
	}
	
	public ListModel(Parcel parcel) {
		icon = parcel.readInt();
		title = parcel.readString();
	}
	
	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(icon);
		dest.writeString(title);
	}
	
	public static final Creator<ListModel> CREATOR = new Creator<ListModel>() {
        @Override
        public ListModel[] newArray(int size) {
            return new ListModel[size];
        }

        @Override
        public ListModel createFromParcel(Parcel source) {
            return new ListModel(source);
        }
    };

}
