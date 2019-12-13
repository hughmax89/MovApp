package com.hgs.domain.usecases.general;

import com.hgs.domain.core.Movie;
import com.hgs.domain.interface_adapters.PostExecutionThread;
import com.hgs.domain.interface_adapters.ThreadExecutor;
import com.hgs.domain.repository.ISeriesRepository;
import com.hgs.domain.usecases.base.UseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class GetSeriesUpcomingListUseCase extends UseCase<GetSeriesUpcomingListUseCase.RequestValues, GetSeriesUpcomingListUseCase.ResponseValue> {

    private ISeriesRepository seriesRepository;

    @Inject
    protected GetSeriesUpcomingListUseCase(
            ThreadExecutor threadExecutor
            , PostExecutionThread postExecutionThread
            , ISeriesRepository seriesRepository) {
        super(threadExecutor, postExecutionThread);
        this.seriesRepository = seriesRepository;
    }

    @Override
    protected Observable<GetSeriesUpcomingListUseCase.ResponseValue> createObservableUseCase(GetSeriesUpcomingListUseCase.RequestValues requestValues) {
        return seriesRepository.getSeriesUpcomingList()
                .map(new Function<List<Movie>, GetSeriesUpcomingListUseCase.ResponseValue>() {
                    @Override
                    public GetSeriesUpcomingListUseCase.ResponseValue apply(List<Movie> movieList) {
                        return new GetSeriesUpcomingListUseCase.ResponseValue(movieList);
                    }
                });
    }

    public static final class RequestValues implements UseCase.RequestValues {


    }

    public static final class ResponseValue implements UseCase.ResponseValue {

        private List<Movie> mResultMovies;

        public ResponseValue(List<Movie> resultsMovie) {
            mResultMovies = resultsMovie;
        }

        public List<Movie> getmResultSeriesUpcoming() {
            return mResultMovies;
        }

    }
}


