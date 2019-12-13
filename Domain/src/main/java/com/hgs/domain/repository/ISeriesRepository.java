package com.hgs.domain.repository;

import com.hgs.domain.core.Movie;

import java.util.List;

import io.reactivex.Observable;

public interface ISeriesRepository {
    Observable<List<Movie>> getSeriesPopularList();
    Observable<List<Movie>> getSeriesTopRatedList();
    Observable<List<Movie>> getSeriesUpcomingList();
}

