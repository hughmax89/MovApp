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

public class GetMoviesPopularListUseCase extends UseCase<GetMoviesPopularListUseCase.RequestValues, GetMoviesPopularListUseCase.ResponseValue> {

    private IMovieRepository movieRepository;

    @Inject
    protected GetMoviesPopularListUseCase(
            ThreadExecutor threadExecutor
            , PostExecutionThread postExecutionThread
            , IMovieRepository movieRepository) {
        super(threadExecutor, postExecutionThread);
        this.movieRepository = movieRepository;
    }

    @Override
    protected Observable<GetMoviesPopularListUseCase.ResponseValue> createObservableUseCase(GetMoviesPopularListUseCase.RequestValues requestValues) {
        return movieRepository.getMoviePopularList()
                .map(new Function<List<Movie>, GetMoviesPopularListUseCase.ResponseValue>() {
                    @Override
                    public GetMoviesPopularListUseCase.ResponseValue apply(List<Movie> movieList) {
                        return new GetMoviesPopularListUseCase.ResponseValue(movieList);
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

        public List<Movie> getmResultMoviesPopular() {
            return mResultMovies;
        }

    }
}
