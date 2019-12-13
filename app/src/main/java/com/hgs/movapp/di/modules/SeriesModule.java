package com.hgs.movapp.di.modules;

import com.hgs.data.entity.MovieEntity;
import com.hgs.data.mapper.MovieMapper;
import com.hgs.data.repository.GeneralDBRepository;
import com.hgs.data.repository.movie.MovieLocalDataSource;
import com.hgs.data.repository.movie.MovieNetworkDataSource;
import com.hgs.data.repository.series.SeriesLocalDataSource;
import com.hgs.data.repository.series.SeriesNetworkDataSource;
import com.hgs.data.repository.series.SeriesRepository;
import com.hgs.device.NetworkConnectionChecker;
import com.hgs.domain.repository.ISeriesRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class SeriesModule {

    public SeriesModule(){}

    @Provides
    ISeriesRepository provideMovieRepository(
            SeriesLocalDataSource local,
            SeriesNetworkDataSource network,
            NetworkConnectionChecker connectionChecker) {

        return new SeriesRepository(local, network, connectionChecker);

    }

    @Provides
    SeriesLocalDataSource provideMovieLocalDataSource(){
        return new SeriesLocalDataSource(
                new GeneralDBRepository<MovieEntity>(MovieEntity.class),
                new MovieMapper()
        );
    }

}

