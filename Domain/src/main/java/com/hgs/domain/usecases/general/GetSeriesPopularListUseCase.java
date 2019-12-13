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

public class GetSeriesPopularListUseCase extends UseCase<GetSeriesPopularListUseCase.RequestValues, GetSeriesPopularListUseCase.ResponseValue> {

    private ISeriesRepository seriesRepository;

    @Inject
    protected GetSeriesPopularListUseCase(
            ThreadExecutor threadExecutor
            , PostExecutionThread postExecutionThread
            , ISeriesRepository seriesRepository) {
        super(threadExecutor, postExecutionThread);
        this.seriesRepository = seriesRepository;
    }

    @Override
    protected Observable<ResponseValue> createObservableUseCase(GetSeriesPopularListUseCase.RequestValues requestValues) {
        return seriesRepository.getSeriesPopularList()
                .map(new Function<List<Movie>, ResponseValue>() {
                    @Override
                    public GetSeriesPopularListUseCase.ResponseValue apply(List<Movie> movieList) {
                        return new GetSeriesPopularListUseCase.ResponseValue(movieList);
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

        public List<Movie> getmResultSeriesPopular() {
            return mResultMovies;
        }

    }
}
