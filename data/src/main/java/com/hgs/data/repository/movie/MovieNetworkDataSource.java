package com.hgs.data.repository.movie;

import com.hgs.data.internet.model.response.ResponseModelList;
import com.hgs.data.internet.service.MovieService;
import com.hgs.domain.core.Movie;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class MovieNetworkDataSource {

    private MovieService service;

    @Inject
    public MovieNetworkDataSource(MovieService _service){
        this.service = _service;
    }

    public Observable<List<Movie>> GetMoviesPopularList()
    {
        return Observable.create(new ObservableOnSubscribe<List<Movie>>()
        {

            @Override
            public void subscribe(ObservableEmitter<List<Movie>> emitter)
            {
                try
                {

                    ResponseModelList<Movie> response = service.getAllMoviesPopular();

                    if (response.isValid()) {
                        emitter.onNext(((ResponseModelList<Movie>)response).getEntities());
                        emitter.onComplete();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    emitter.onError(e);
                }
            }

        });

    }

    public Observable<List<Movie>> GetMoviesTopRatedList()
    {
        return Observable.create(new ObservableOnSubscribe<List<Movie>>()
        {

            @Override
            public void subscribe(ObservableEmitter<List<Movie>> emitter)
            {
                try
                {

                    ResponseModelList<Movie> response = service.getAllMoviesTopRated();

                    if (response.isValid()) {
                        emitter.onNext(((ResponseModelList<Movie>)response).getEntities());
                        emitter.onComplete();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    emitter.onError(e);
                }
            }

        });

    }

    public Observable<List<Movie>> GetMoviesUpcomingList()
    {
        return Observable.create(new ObservableOnSubscribe<List<Movie>>()
        {

            @Override
            public void subscribe(ObservableEmitter<List<Movie>> emitter)
            {
                try
                {

                    ResponseModelList<Movie> response = service.getAllMoviesUpcoming();

                    if (response.isValid()) {
                        emitter.onNext(((ResponseModelList<Movie>)response).getEntities());
                        emitter.onComplete();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    emitter.onError(e);
                }
            }

        });

    }
}
