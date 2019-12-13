package com.hgs.movapp.presenter.base;


import com.hgs.movapp.base.BaseView;

public interface BasePresenter {

    void start();

    void setView(BaseView view);

}