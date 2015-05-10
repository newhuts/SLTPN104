package com.yofi.sltpn104.callback;

public interface CallbackInput {
        public void onSuccess(String success);
        
        public void onError(String reason);
        
        public void onException(String reason);
        
    }