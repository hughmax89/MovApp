package com.hgs.movapp.presenter;

import android.app.ProgressDialog;

import com.hgs.domain.usecases.base.DefaultObserver;
import com.hgs.domain.usecases.general.GetMoviesPopularListUseCase;
import com.hgs.domain.usecases.general.GetMoviesTopRatedListUseCase;
import com.hgs.domain.usecases.general.GetMoviesUpcomingListUseCase;

import com.hgs.movapp.base.BaseView;
import com.hgs.movapp.contracts.MovieContract;

import javax.inject.Inject;

public class MoviePresenter implements MovieContract.Presenter {

    private MovieContract.View mView;
    private GetMoviesPopularListUseCase getMoviesPopularListUseCase;
    private GetMoviesTopRatedListUseCase getMoviesTopRatedListUseCase;
    private GetMoviesUpcomingListUseCase getMoviesUpcomingListUseCase;

    @Inject
    public MoviePresenter(GetMoviesPopularListUseCase getMoviesPopularListUseCase,
                          GetMoviesTopRatedListUseCase getMoviesTopRatedListUseCase,
                          GetMoviesUpcomingListUseCase getMoviesUpcomingListUseCase)
    {
        this.getMoviesPopularListUseCase = getMoviesPopularListUseCase;
        this.getMoviesTopRatedListUseCase = getMoviesTopRatedListUseCase;
        this.getMoviesUpcomingListUseCase = getMoviesUpcomingListUseCase;
    }

    @Override
    public void start() {

    }

    @Override
    public void setView(BaseView view) {
        mView = (MovieContract.View) view;
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void GetMoviesPopular() {
        getMoviesPopularListUseCase.execute(
                new MoviePresenter.MoviePopularListObserver(),
                new GetMoviesPopularListUseCase.RequestValues()
        );
    }

    private final class MoviePopularListObserver extends DefaultObserver<GetMoviesPopularListUseCase.ResponseValue>
    {
        @Override
        public void onNext(GetMoviesPopularListUseCase.ResponseValue responseValue)
        {
            mView.setReultMoviesPopular(responseValue.getmResultMoviesPopular());
        }


        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }

    }

    @Override
    public void GetMoviesTopRated() {
        getMoviesTopRatedListUseCase.execute(
                new MoviePresenter.MovieTopRatedListObserver(),
                new GetMoviesTopRatedListUseCase.RequestValues()
        );
    }

    private final class MovieTopRatedListObserver extends DefaultObserver<GetMoviesTopRatedListUseCase.ResponseValue>
    {
        @Override
        public void onNext(GetMoviesTopRatedListUseCase.ResponseValue responseValue)
        {
            mView.setReultMoviesTopRated(responseValue.getmResultMoviesTopRated());
        }


        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }

    }

    @Override
    public void GetMoviesUpcoming() {
        getMoviesUpcomingListUseCase.execute(
                new MoviePresenter.MovieUpcomingListObserver(),
                new GetMoviesUpcomingListUseCase.RequestValues()
        );
    }

    private final class MovieUpcomingListObserver extends DefaultObserver<GetMoviesUpcomingListUseCase.ResponseValue>
    {
        @Override
        public void onNext(GetMoviesUpcomingListUseCase.ResponseValue responseValue)
        {
            mView.setReultMoviesUpcoming(responseValue.getmResultMoviesUpcoming());
        }


        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }

    }
}
