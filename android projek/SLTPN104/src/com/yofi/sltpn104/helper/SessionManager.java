package com.yofi.sltpn104.helper;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {

    SharedPreferences pref;
    Editor editor;
    Context mContext;
    int PRIVATE_MODE = 0;
    public static final String PREF_NAME = "sltpn";
    public static final String IS_LOGIN = "IsLoggedIn";


    @SuppressLint("CommitPrefEdits")
    public SessionManager(Context context){
        mContext = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean islogin, String akses){
        editor.putBoolean(IS_LOGIN, islogin);
        editor.putString("akses", akses);
        editor.commit();
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public String getAkses(){
        return pref.getString("akses", "guru");
    }
}
