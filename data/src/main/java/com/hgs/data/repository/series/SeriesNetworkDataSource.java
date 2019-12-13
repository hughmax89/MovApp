package com.hgs.data.repository.series;

import com.hgs.data.internet.model.response.ResponseModelList;
import com.hgs.data.internet.service.MovieService;
import com.hgs.data.internet.service.SeriesService;
import com.hgs.domain.core.Movie;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class SeriesNetworkDataSource {

    private SeriesService service;

        @Inject
        public SeriesNetworkDataSource(SeriesService _service){
            this.service = _service;
        }

        public Observable<List<Movie>> GetSeriesPopularList()
        {
            return Observable.create(new ObservableOnSubscribe<List<Movie>>()
            {

                @Override
                public void subscribe(ObservableEmitter<List<Movie>> emitter)
                {
                    try
                    {

                        ResponseModelList<Movie> response = service.getAllSeriesPopular();

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

        public Observable<List<Movie>> GetSeriesTopRatedList()
        {
            return Observable.create(new ObservableOnSubscribe<List<Movie>>()
            {

                @Override
                public void subscribe(ObservableEmitter<List<Movie>> emitter)
                {
                    try
                    {

                        ResponseModelList<Movie> response = service.getAllSeriesTopRated();

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

        public Observable<List<Movie>> GetSeriesUpcomingList()
        {
            return Observable.create(new ObservableOnSubscribe<List<Movie>>()
            {

                @Override
                public void subscribe(ObservableEmitter<List<Movie>> emitter)
                {
                    try
                    {

                        ResponseModelList<Movie> response = service.getAllSeriesUpcoming();

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

