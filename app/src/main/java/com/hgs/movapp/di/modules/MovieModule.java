package com.hgs.movapp.di.modules;

import com.hgs.data.entity.MovieEntity;
import com.hgs.data.mapper.MovieMapper;
import com.hgs.data.repository.GeneralDBRepository;
import com.hgs.data.repository.movie.MovieLocalDataSource;
import com.hgs.data.repository.movie.MovieNetworkDataSource;
import com.hgs.data.repository.movie.MovieRepository;
import com.hgs.device.NetworkConnectionChecker;
import com.hgs.domain.repository.IMovieRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieModule {

    public MovieModule(){}

    @Provides
    IMovieRepository provideMovieRepository(
            MovieLocalDataSource local,
            MovieNetworkDataSource network,
            NetworkConnectionChecker connectionChecker) {

        return new MovieRepository(local, network, connectionChecker);

    }

    @Provides
    MovieLocalDataSource provideMovieLocalDataSource(){
        return new MovieLocalDataSource(
                new GeneralDBRepository<MovieEntity>(MovieEntity.class),
                new MovieMapper()
        );
    }

}
