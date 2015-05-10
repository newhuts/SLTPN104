package com.yofi.sltpn104.callback;

import java.util.List;

import com.yofi.sltpn104.model.NilaiModel;

public interface CallbackNilaiList {
        public void onSuccess(List<NilaiModel> absensiModellist);
        
        public void onError(String reason);
        
        public void onException(String reason);
        
    }