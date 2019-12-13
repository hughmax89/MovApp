package com.hgs.movapp.contracts;

import com.hgs.domain.core.Movie;
import com.hgs.movapp.base.BaseView;
import com.hgs.movapp.presenter.base.BasePresenter;

import java.util.List;

public interface SeriesContract {

    interface View extends BaseView<Presenter> {

        void showLoadingIndicator();

        void hideLoadingIndicator();

        void showMessage(String message);

        void setReultSeriesPopular(List<Movie> movieList);

        void setReultSeriesTopRated(List<Movie> movieList);

        void setReultSeriesUpcoming(List<Movie> movieList);
    }

    interface Presenter extends BasePresenter {

        void start();

        void result(int requestCode, int resultCode);

        void GetSeriesPopular();

        void GetSeriesTopRated();

        void GetSeriesUpcoming();
    }
}

