package com.hgs.movapp;


import com.hgs.movapp.base.BaseView;
import com.hgs.movapp.presenter.base.BasePresenter;

public interface MainContract {

    interface View extends BaseView<Presenter> {
        void showLoadingIndicator();

        void hideLoadingIndicator();

        void showMessage(String message);

    }

    interface Presenter extends BasePresenter {

        void start();

        void result(int requestCode, int resultCode);


    }

}
