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

public class GetMoviesUpcomingListUseCase extends UseCase<GetMoviesUpcomingListUseCase.RequestValues, GetMoviesUpcomingListUseCase.ResponseValue> {

    private IMovieRepository movieRepository;

    @Inject
    protected GetMoviesUpcomingListUseCase(
            ThreadExecutor threadExecutor
            , PostExecutionThread postExecutionThread
            , IMovieRepository movieRepository) {
        super(threadExecutor, postExecutionThread);
        this.movieRepository = movieRepository;
    }

    @Override
    protected Observable<ResponseValue> createObservableUseCase(GetMoviesUpcomingListUseCase.RequestValues requestValues) {
        return movieRepository.getMovieUpcomingList()
                .map(new Function<List<Movie>, ResponseValue>() {
                    @Override
                    public GetMoviesUpcomingListUseCase.ResponseValue apply(List<Movie> movieList) {
                        return new GetMoviesUpcomingListUseCase.ResponseValue(movieList);
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

        public List<Movie> getmResultMoviesUpcoming() {
            return mResultMovies;
        }

    }
}



