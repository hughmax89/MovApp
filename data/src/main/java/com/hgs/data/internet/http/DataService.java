package com.hgs.data.internet.http;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.hgs.data.configurations.Configuration;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class DataService {

    private final OkHttpClient client = new OkHttpClient.Builder()
        .addNetworkInterceptor(new StethoInterceptor())
        .connectTimeout(Configuration.getTimeOut(), Configuration.getTimeUnit())
        .writeTimeout(Configuration.getTimeOut(), Configuration.getTimeUnit())
        .readTimeout(Configuration.getTimeOut(), Configuration.getTimeUnit())
        .build();

    private static final String AUTHOTIZATION = "Authorization";
    private static final String STRINGEMPTY = "";
    static final String TYPE_JSON = "application/json; charset=utf-8";

    public abstract Response execute(String url, String json);

    Request.Builder getBuilder(String url){

        return new Request.Builder()
            .header(AUTHOTIZATION,isToken())
            .url(url);
    }

    RequestBody getRequestBody(String TypeFormat, String json){
        MediaType type = MediaType.parse(TypeFormat);
        return RequestBody.create(type, json);
    }

    Response callRequest(Request request){
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String isToken() {
        if (Configuration.getIsAuthentication()){

            String token = Configuration.getTokenString();
            if (token == null) {
                return STRINGEMPTY;
            }

            return token;
        }

        return STRINGEMPTY;
    }
}