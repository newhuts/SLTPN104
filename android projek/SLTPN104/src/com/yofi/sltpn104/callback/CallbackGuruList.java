package com.yofi.sltpn104.callback;

import java.util.List;

import com.yofi.sltpn104.model.GuruModel;

public interface CallbackGuruList {
        public void onSuccess(List<GuruModel> guruModellist);
        
        public void onError(String reason);
        
        public void onException(String reason);
        
    }