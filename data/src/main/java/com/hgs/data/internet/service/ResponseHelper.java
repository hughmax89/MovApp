package com.hgs.data.internet.service;

import com.hgs.data.internet.model.response.ResponseModelList;
import com.hgs.data.utils.JsonSerializer;
import com.hgs.data.utils.Logger;
import com.hgs.domain.core.Movie;

import java.util.Collections;
import java.util.List;

import okhttp3.Response;

public class ResponseHelper {


    /******* LIST **********/


    public static ResponseModelList<Movie> getMovieListResponse(Response response)
    {
        try {

            Logger.d("Movies","GetEntitiesMoviesListResponse - Ingresando a Serializar Respuesta: ");
            if (response.isSuccessful()) {
                String json = response.body().string();

                List<Movie> entities = JsonSerializer.mapJsonToObjectList(json, Movie.class);

                Logger.i("Movies","GetEntitiesMoviesListResponse - entidad: " + entities);

                return new ResponseModelList<Movie>(entities);
            }


        } catch (Exception e) {
            e.printStackTrace();
            Logger.e("Movies","GetEntitiesMoviesListResponse - ocurrio un error: "+e.getMessage());
        }

        return new ResponseModelList<Movie>((List<Movie>) Collections.EMPTY_LIST);
    }

    public static ResponseModelList<Movie> getSeriesListResponse(Response response)
    {
        try {

            Logger.d("Movies","GetEntitiesSeriesListResponse - Ingresando a Serializar Respuesta: ");
            if (response.isSuccessful()) {
                String json = response.body().string();

                List<Movie> entities = JsonSerializer.mapJsonToObjectList(json, Movie.class);

                Logger.i("Movies","GetEntitiesSeriesListResponse - entidad: " + entities);

                return new ResponseModelList<Movie>(entities);
            }


        } catch (Exception e) {
            e.printStackTrace();
            Logger.e("Movies","GetEntitiesSeriesListResponse - ocurrio un error: "+e.getMessage());
        }

        return new ResponseModelList<Movie>((List<Movie>) Collections.EMPTY_LIST);
    }


}
