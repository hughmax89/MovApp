package com.hgs.data.repository.movie;

import com.hgs.device.NetworkConnectionChecker;
import com.hgs.domain.core.Movie;
import com.hgs.domain.repository.IMovieRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MovieRepository implements IMovieRepository {

    MovieLocalDataSource dbDataSource;
    MovieNetworkDataSource networkDataSource;
    private NetworkConnectionChecker connectionChecker;

    @Inject
    public MovieRepository(
            MovieLocalDataSource local,
            MovieNetworkDataSource network,
            NetworkConnectionChecker connectionChecker){
        dbDataSource = local;
        networkDataSource = network;
        this.connectionChecker = connectionChecker;
    }

    @Override
    public Observable<List<Movie>> getMoviePopularList() {

        return networkDataSource.GetMoviesPopularList().doOnNext(new Consumer<List<Movie>>() {
            @Override
            public void accept(List<Movie> movieList) throws Exception {
                for (Movie item: movieList) {
                    if(!dbDataSource.existMovie(item.getId())){
                        dbDataSource.saveMovie(item);
                    }

                }
            }
        });
    }

    @Override
    public Observable<List<Movie>> getMovieUpcomingList() {

        return networkDataSource.GetMoviesUpcomingList().doOnNext(new Consumer<List<Movie>>() {
            @Override
            public void accept(List<Movie> movieList) throws Exception {
                for (Movie item: movieList) {
                    if(!dbDataSource.existMovie(item.getId())){
                        dbDataSource.saveMovie(item);
                    }

                }
            }
        });
    }

    @Override
    public Observable<List<Movie>> getMovieTopRatedList() {

        return networkDataSource.GetMoviesTopRatedList().doOnNext(new Consumer<List<Movie>>() {
            @Override
            public void accept(List<Movie> movieList) throws Exception {
                for (Movie item: movieList) {
                    if(!dbDataSource.existMovie(item.getId())){
                        dbDataSource.saveMovie(item);
                    }

                }
            }
        });
    }


}

