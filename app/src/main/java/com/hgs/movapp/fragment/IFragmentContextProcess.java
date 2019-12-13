package com.hgs.movapp.fragment;

import android.content.Context;

import java.util.List;

public interface IFragmentContextProcess extends IFragmentProcess{
    void onCompleteProcess(List list, boolean isLocalOrigin);
    void setContext(Context context);
}
