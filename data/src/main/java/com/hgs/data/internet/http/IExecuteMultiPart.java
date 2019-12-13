package com.hgs.data.internet.http;
import com.hgs.data.internet.model.request.FileModelRequest;

import okhttp3.Response;

public interface IExecuteMultiPart {
    Response ExecuteMultiPart(
            String url,
            FileModelRequest fileModelRequest);
}
