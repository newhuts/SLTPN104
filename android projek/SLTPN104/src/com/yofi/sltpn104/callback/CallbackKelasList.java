package com.yofi.sltpn104.callback;

import java.util.List;

import com.yofi.sltpn104.model.KelasModel;

public interface CallbackKelasList {
        public void onSuccess(List<KelasModel> kelasModellist);
        
        public void onError(String reason);
        
        public void onException(String reason);
        
    }