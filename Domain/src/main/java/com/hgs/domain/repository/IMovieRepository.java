package com.hgs.domain.repository;


import com.hgs.domain.core.Movie;

import java.util.List;

import io.reactivex.Observable;

public interface IMovieRepository {

    Observable<List<Movie>> getMoviePopularList();

    Observable<List<Movie>> getMovieTopRatedList();

    Observable<List<Movie>> getMovieUpcomingList();
}
