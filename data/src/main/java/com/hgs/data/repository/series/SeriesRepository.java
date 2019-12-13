package com.hgs.data.repository.series;

import com.hgs.device.NetworkConnectionChecker;
import com.hgs.domain.core.Movie;
import com.hgs.domain.repository.ISeriesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class SeriesRepository implements ISeriesRepository {

    SeriesLocalDataSource dbDataSource;
    SeriesNetworkDataSource networkDataSource;
    private NetworkConnectionChecker connectionChecker;

    @Inject
    public SeriesRepository(
            SeriesLocalDataSource local,
            SeriesNetworkDataSource network,
            NetworkConnectionChecker connectionChecker){
        dbDataSource = local;
        networkDataSource = network;
        this.connectionChecker = connectionChecker;
    }

    @Override
    public Observable<List<Movie>> getSeriesPopularList() {

        return networkDataSource.GetSeriesPopularList().doOnNext(new Consumer<List<Movie>>() {
            @Override
            public void accept(List<Movie> movieList) throws Exception {
                for (Movie item: movieList) {
                    if(!dbDataSource.existSeries(item.getId())){
                        dbDataSource.saveSeries(item);
                    }

                }
            }
        });
    }

    @Override
    public Observable<List<Movie>> getSeriesUpcomingList() {

        return networkDataSource.GetSeriesUpcomingList().doOnNext(new Consumer<List<Movie>>() {
            @Override
            public void accept(List<Movie> movieList) throws Exception {
                for (Movie item: movieList) {
                    if(!dbDataSource.existSeries(item.getId())){
                        dbDataSource.saveSeries(item);
                    }

                }
            }
        });
    }

    @Override
    public Observable<List<Movie>> getSeriesTopRatedList() {

        return networkDataSource.GetSeriesTopRatedList().doOnNext(new Consumer<List<Movie>>() {
            @Override
            public void accept(List<Movie> movieList) throws Exception {
                for (Movie item: movieList) {
                    if(!dbDataSource.existSeries(item.getId())){
                        dbDataSource.saveSeries(item);
                    }

                }
            }
        });
    }


}


