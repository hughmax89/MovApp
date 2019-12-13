package com.hgs.domain.usecases.general;

import com.hgs.domain.core.Movie;
import com.hgs.domain.interface_adapters.PostExecutionThread;
import com.hgs.domain.interface_adapters.ThreadExecutor;
import com.hgs.domain.repository.IMovieRepository;
import com.hgs.domain.usecases.base.UseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class GetMoviesTopRatedListUseCase extends UseCase<GetMoviesTopRatedListUseCase.RequestValues, GetMoviesTopRatedListUseCase.ResponseValue> {

    private IMovieRepository movieRepository;

    @Inject
    protected GetMoviesTopRatedListUseCase(
            ThreadExecutor threadExecutor
            , PostExecutionThread postExecutionThread
            , IMovieRepository movieRepository) {
        super(threadExecutor, postExecutionThread);
        this.movieRepository = movieRepository;
    }

    @Override
    protected Observable<ResponseValue> createObservableUseCase(GetMoviesTopRatedListUseCase.RequestValues requestValues) {
        return movieRepository.getMovieTopRatedList()
                .map(new Function<List<Movie>, ResponseValue>() {
                    @Override
                    public GetMoviesTopRatedListUseCase.ResponseValue apply(List<Movie> movieList) {
                        return new GetMoviesTopRatedListUseCase.ResponseValue(movieList);
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

        public List<Movie> getmResultMoviesTopRated() {
            return mResultMovies;
        }

    }
}


