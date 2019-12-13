package com.hgs.data.internet.model.request;

import java.util.List;

public class RequestModelList<T> extends RequestModelCustom {
    private List<T> entities;

    public RequestModelList(List<T> entities) {
        this.entities = entities;
    }

    public List<T> getEntities() {
        return entities;
    }

}
