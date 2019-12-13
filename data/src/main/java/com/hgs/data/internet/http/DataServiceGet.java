package com.hgs.data.internet.http;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DataServiceGet extends DataService {

    @Override
    public Response execute(String url, String json){
        Request.Builder builder = getBuilder(url);
        RequestBody requestBody = getRequestBody("",json);
        builder.get();
        //builder.header("Authorization", "Bearer "+ CrossComponent.getAccessToken());
        Request request = builder.build();

        return callRequest(request);
    }
}
