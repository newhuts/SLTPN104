package com.yofi.sltpn104;

import com.yofi.sltpn104.helper.SessionControl;
import com.yofi.sltpn104.helper.SessionManager;

import android.app.Application;

public class Akademik104 extends Application {

	SessionControl sessioncontrol = SessionControl.getInstance();
	@Override
	public void onCreate() {
		super.onCreate();
		sessioncontrol.setSessionManager(new SessionManager(this));
	}
}
