package com.yofi.sltpn104.helper;

public class SessionControl {

	private static SessionControl ourInstance;
    private SessionManager sessionManager;

    public static SessionControl getInstance() {
        if (ourInstance == null) {
            ourInstance = new SessionControl();
        }
        return ourInstance;
    }


    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
