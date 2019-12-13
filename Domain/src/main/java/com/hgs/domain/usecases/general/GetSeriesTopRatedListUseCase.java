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

public class GetSeriesTopRatedListUseCase extends UseCase<GetSeriesTopRatedListUseCase.RequestValues, GetSeriesTopRatedListUseCase.ResponseValue> {

    private ISeriesRepository seriesRepository;

    @Inject
    protected GetSeriesTopRatedListUseCase(
            ThreadExecutor threadExecutor
            , PostExecutionThread postExecutionThread
            , ISeriesRepository seriesRepository) {
        super(threadExecutor, postExecutionThread);
        this.seriesRepository = seriesRepository;
    }

    @Override
    protected Observable<GetSeriesTopRatedListUseCase.ResponseValue> createObservableUseCase(GetSeriesTopRatedListUseCase.RequestValues requestValues) {
        return seriesRepository.getSeriesTopRatedList()
                .map(new Function<List<Movie>, GetSeriesTopRatedListUseCase.ResponseValue>() {
                    @Override
                    public GetSeriesTopRatedListUseCase.ResponseValue apply(List<Movie> movieList) {
                        return new GetSeriesTopRatedListUseCase.ResponseValue(movieList);
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

        public List<Movie> getmResultSeriesTopRated() {
            return mResultMovies;
        }

    }
}

