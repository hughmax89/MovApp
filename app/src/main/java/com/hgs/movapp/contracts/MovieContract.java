package com.hgs.movapp.contracts;

import com.hgs.domain.core.Movie;
import com.hgs.movapp.base.BaseView;
import com.hgs.movapp.presenter.base.BasePresenter;

import java.util.List;

public interface MovieContract {

    interface View extends BaseView<Presenter> {

        void showLoadingIndicator();

        void hideLoadingIndicator();

        void showMessage(String message);

        void setReultMoviesPopular(List<Movie> movieList);

        void setReultMoviesTopRated(List<Movie> movieList);

        void setReultMoviesUpcoming(List<Movie> movieList);
    }

    interface Presenter extends BasePresenter {

        void start();

        void result(int requestCode, int resultCode);

        void GetMoviesPopular();

        void GetMoviesTopRated();

        void GetMoviesUpcoming();
    }
}
