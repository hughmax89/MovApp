package com.hgs.data.internet.service;

import com.hgs.data.configurations.Configuration;
import com.hgs.data.internet.http.DataServiceGet;
import com.hgs.data.internet.model.response.ResponseModelList;
import com.hgs.data.utils.Logger;
import com.hgs.domain.core.Movie;

import javax.inject.Inject;

import okhttp3.Response;

public class SeriesService {

        public final String BASE_URL_GET_SERIES_POPULAR = "/tv";
        public final String BASE_URL_GET_SERIES_TOP_RATED = "/tv/top-rated";
        public final String BASE_URL_GET_SERIES_UPCOMING = "/tv/upcoming";

        @Inject
        public SeriesService(){}

        public ResponseModelList<Movie> getAllSeriesPopular()throws Exception{

            DataServiceGet dataServiceGet = new DataServiceGet();
            try
            {

                Response response = dataServiceGet.execute(
                        Configuration.getBaseUrl()+ BASE_URL_GET_SERIES_POPULAR, "");


                ResponseModelList entityResponse = ResponseHelper.getSeriesListResponse(response);
                entityResponse.setIsValid(true);

                return entityResponse;

            }catch (Exception e) {
                e.printStackTrace();
                Logger.e("Series Popular","Series Popular - ocurrio un error: "+e.getMessage());
            }

            ResponseModelList<Movie> resp = new ResponseModelList<>();
            resp.setIsValid(false);

            return resp;

        }

        public ResponseModelList<Movie> getAllSeriesTopRated()throws Exception{

            DataServiceGet dataServiceGet = new DataServiceGet();
            try
            {

                Response response = dataServiceGet.execute(
                        Configuration.getBaseUrl()+ BASE_URL_GET_SERIES_TOP_RATED, "");


                ResponseModelList entityResponse = ResponseHelper.getSeriesListResponse(response);
                entityResponse.setIsValid(true);

                return entityResponse;

            }catch (Exception e) {
                e.printStackTrace();
                Logger.e("Series Top Rated","Series Top Rated - ocurrio un error: "+e.getMessage());
            }

            ResponseModelList<Movie> resp = new ResponseModelList<>();
            resp.setIsValid(false);

            return resp;

        }

        public ResponseModelList<Movie> getAllSeriesUpcoming()throws Exception{

            DataServiceGet dataServiceGet = new DataServiceGet();
            try
            {

                Response response = dataServiceGet.execute(
                        Configuration.getBaseUrl()+ BASE_URL_GET_SERIES_UPCOMING, "");


                ResponseModelList entityResponse = ResponseHelper.getSeriesListResponse(response);
                entityResponse.setIsValid(true);

                return entityResponse;

            }catch (Exception e) {
                e.printStackTrace();
                Logger.e("Series Upcoming","Series Upcoming - ocurrio un error: "+e.getMessage());
            }

            ResponseModelList<Movie> resp = new ResponseModelList<>();
            resp.setIsValid(false);

            return resp;

        }
}

