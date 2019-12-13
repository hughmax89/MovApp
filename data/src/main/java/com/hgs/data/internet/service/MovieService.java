package com.hgs.data.internet.service;

import com.hgs.data.configurations.Configuration;
import com.hgs.data.internet.http.DataServiceGet;
import com.hgs.data.internet.model.response.ResponseModelList;
import com.hgs.data.utils.Logger;
import com.hgs.domain.core.Movie;

import javax.inject.Inject;

import okhttp3.Response;



public class MovieService {

    public final String BASE_URL_GET_MOVIES_POPULAR = "/movie";
    public final String BASE_URL_GET_MOVIES_TOP_RATED = "/movie/top-rated";
    public final String BASE_URL_GET_MOVIES_UPCOMING = "/movie/upcoming";

    @Inject
    public MovieService(){}

    public ResponseModelList<Movie> getAllMoviesPopular()throws Exception{

        DataServiceGet dataServiceGet = new DataServiceGet();
        try
        {

            Response response = dataServiceGet.execute(
                    Configuration.getBaseUrl()+ BASE_URL_GET_MOVIES_POPULAR, "");


            ResponseModelList entityResponse = ResponseHelper.getMovieListResponse(response);
            entityResponse.setIsValid(true);

            return entityResponse;

        }catch (Exception e) {
            e.printStackTrace();
            Logger.e("Movies Popular","Movies Popular - ocurrio un error: "+e.getMessage());
        }

        ResponseModelList<Movie> resp = new ResponseModelList<>();
        resp.setIsValid(false);

        return resp;

    }

    public ResponseModelList<Movie> getAllMoviesTopRated()throws Exception{

        DataServiceGet dataServiceGet = new DataServiceGet();
        try
        {

            Response response = dataServiceGet.execute(
                    Configuration.getBaseUrl()+ BASE_URL_GET_MOVIES_TOP_RATED, "");


            ResponseModelList entityResponse = ResponseHelper.getMovieListResponse(response);
            entityResponse.setIsValid(true);

            return entityResponse;

        }catch (Exception e) {
            e.printStackTrace();
            Logger.e("Movies Top Rated","Movies Top Rated - ocurrio un error: "+e.getMessage());
        }

        ResponseModelList<Movie> resp = new ResponseModelList<>();
        resp.setIsValid(false);

        return resp;

    }

    public ResponseModelList<Movie> getAllMoviesUpcoming()throws Exception{

        DataServiceGet dataServiceGet = new DataServiceGet();
        try
        {

            Response response = dataServiceGet.execute(
                    Configuration.getBaseUrl()+ BASE_URL_GET_MOVIES_UPCOMING, "");


            ResponseModelList entityResponse = ResponseHelper.getMovieListResponse(response);
            entityResponse.setIsValid(true);

            return entityResponse;

        }catch (Exception e) {
            e.printStackTrace();
            Logger.e("Movies Upcoming","Movies Upcoming - ocurrio un error: "+e.getMessage());
        }

        ResponseModelList<Movie> resp = new ResponseModelList<>();
        resp.setIsValid(false);

        return resp;

    }
}
