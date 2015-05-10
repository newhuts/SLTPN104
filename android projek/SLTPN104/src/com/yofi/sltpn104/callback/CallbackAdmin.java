package com.yofi.sltpn104.callback;

import com.yofi.sltpn104.model.AdminModel;

public interface CallbackAdmin {
        public void onSuccess(AdminModel adminmodel);
        
        public void onError(String reason);
        
        public void onException(String reason);
        
    }