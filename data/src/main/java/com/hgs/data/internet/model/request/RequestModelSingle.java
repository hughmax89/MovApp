package com.hgs.data.internet.model.request;

public class RequestModelSingle <T> extends RequestModelCustom {
    private T entity;

    public RequestModelSingle(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

}
