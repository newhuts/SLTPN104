package com.yofi.sltpn104.callback;

import java.util.List;

import com.yofi.sltpn104.model.SiswaModel;

public interface CallbackSiswaList {
        public void onSuccess(List<SiswaModel> listSiswalist);
        
        public void onError(String reason);
        
        public void onException(String reason);
        
    }