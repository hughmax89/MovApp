package com.hgs.data.mapper;


import com.hgs.data.entity.MovieEntity;
import com.hgs.domain.core.Movie;

import javax.inject.Inject;

public class MovieMapper extends Mapper<Movie, MovieEntity> {

    @Inject
    public MovieMapper(){}

    @Override
    public MovieEntity map(Movie value)
    {
        MovieEntity movieEntity = new MovieEntity();

        movieEntity.id = value.getId();
        movieEntity.popularity = value.getPopularity();
        movieEntity.overview = value.getOverview();
        movieEntity.release_date = value.getRelease_date();
        movieEntity.title = value.getTitle();
        movieEntity.adult = value.isAdult();
        movieEntity.poster_path = value.getPoster_path();
        movieEntity.media_type = value.getMedia_type();
        movieEntity.original_language = value.getOriginal_language();
        movieEntity.original_title = value.getOriginal_title();

        return movieEntity;
    }

    @Override
    public Movie reverseMap(MovieEntity value)
    {
        Movie movie = new Movie();

        movie.setId(value.id);
        movie.setPopularity(value.popularity);
        movie.setOverview(value.overview);
        movie.setRelease_date(value.release_date);
        movie.setTitle(value.title);
        movie.setAdult(value.adult);
        movie.setPoster_path(value.poster_path);
        movie.setMedia_type(value.media_type);
        movie.setOriginal_language(value.original_language);
        movie.setOriginal_title(value.original_title);

        return movie;
    }
}
