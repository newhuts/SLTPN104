package com.yofi.sltpn104.callback;

import java.util.List;

import com.yofi.sltpn104.model.PelajaranModel;

public interface CallbackPelajaranList {
        public void onSuccess(List<PelajaranModel> pelajaranModel);
        
        public void onError(String reason);
        
        public void onException(String reason);
        
    }