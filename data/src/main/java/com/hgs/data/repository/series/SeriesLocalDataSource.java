package com.hgs.data.repository.series;

import com.hgs.data.entity.MovieEntity;
import com.hgs.data.mapper.MovieMapper;
import com.hgs.data.repository.DataSource;
import com.hgs.domain.core.Movie;
import com.hgs.domain.repository.IRepository;

import javax.inject.Inject;

public class SeriesLocalDataSource extends DataSource {

    private IRepository<MovieEntity> _movieRepo;
    private MovieMapper _movieMapper;

    @Inject
    public SeriesLocalDataSource(IRepository<MovieEntity> multimediaRepo, MovieMapper multimediaMapper){
        _movieRepo = multimediaRepo;
        _movieMapper = multimediaMapper;
    }

    public boolean existSeries(int id){
        MovieEntity movieEntity = null;
        try {
            movieEntity = _movieRepo.getByUniqueField("id", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieEntity != null;
    }

    public void saveSeries(Movie movie){
        MovieEntity movieEntity = _movieMapper.map(movie);
        try {
            _movieRepo.create(movieEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


