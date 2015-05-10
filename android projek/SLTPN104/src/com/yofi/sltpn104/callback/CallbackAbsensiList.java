package com.yofi.sltpn104.callback;

import java.util.List;

import com.yofi.sltpn104.model.AbsensiModel;

public interface CallbackAbsensiList {
        public void onSuccess(List<AbsensiModel> absensiModellist);
        
        public void onError(String reason);
        
        public void onException(String reason);
        
    }