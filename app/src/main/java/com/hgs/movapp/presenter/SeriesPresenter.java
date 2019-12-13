package com.hgs.movapp.presenter;

import com.hgs.domain.usecases.base.DefaultObserver;
import com.hgs.domain.usecases.general.GetSeriesPopularListUseCase;
import com.hgs.domain.usecases.general.GetSeriesTopRatedListUseCase;
import com.hgs.domain.usecases.general.GetSeriesUpcomingListUseCase;
import com.hgs.movapp.base.BaseView;
import com.hgs.movapp.contracts.SeriesContract;

import javax.inject.Inject;



public class SeriesPresenter implements SeriesContract.Presenter {

    private SeriesContract.View mView;
    private GetSeriesPopularListUseCase getSeriesPopularListUseCase;
    private GetSeriesTopRatedListUseCase getSeriesTopRatedListUseCase;
    private GetSeriesUpcomingListUseCase getSeriesUpcomingListUseCase;

    @Inject
    public SeriesPresenter(GetSeriesPopularListUseCase getSeriesPopularListUseCase,
                          GetSeriesTopRatedListUseCase getSeriesTopRatedListUseCase,
                          GetSeriesUpcomingListUseCase getSeriesUpcomingListUseCase)
    {
        this.getSeriesPopularListUseCase = getSeriesPopularListUseCase;
        this.getSeriesTopRatedListUseCase = getSeriesTopRatedListUseCase;
        this.getSeriesUpcomingListUseCase = getSeriesUpcomingListUseCase;
    }

    @Override
    public void start() {

    }

    @Override
    public void setView(BaseView view) {

    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void GetSeriesPopular() {
        getSeriesPopularListUseCase.execute(
                new SeriesPresenter.SeriesPopularListObserver(),
                new GetSeriesPopularListUseCase.RequestValues()
        );
    }

    private final class SeriesPopularListObserver extends DefaultObserver<GetSeriesPopularListUseCase.ResponseValue>
    {
        @Override
        public void onNext(GetSeriesPopularListUseCase.ResponseValue responseValue)
        {
            mView.setReultSeriesPopular(responseValue.getmResultSeriesPopular());
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
    public void GetSeriesTopRated() {
        getSeriesTopRatedListUseCase.execute(
                new SeriesPresenter.SeriesTopRatedListObserver(),
                new GetSeriesTopRatedListUseCase.RequestValues()
        );
    }

    private final class SeriesTopRatedListObserver extends DefaultObserver<GetSeriesTopRatedListUseCase.ResponseValue>
    {
        @Override
        public void onNext(GetSeriesTopRatedListUseCase.ResponseValue responseValue)
        {
            mView.setReultSeriesTopRated(responseValue.getmResultSeriesTopRated());
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
    public void GetSeriesUpcoming() {
        getSeriesUpcomingListUseCase.execute(
                new SeriesPresenter.SeriesUpcomingListObserver(),
                new GetSeriesUpcomingListUseCase.RequestValues()
        );
    }

    private final class SeriesUpcomingListObserver extends DefaultObserver<GetSeriesUpcomingListUseCase.ResponseValue>
    {
        @Override
        public void onNext(GetSeriesUpcomingListUseCase.ResponseValue responseValue)
        {
            mView.setReultSeriesUpcoming(responseValue.getmResultSeriesUpcoming());
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

