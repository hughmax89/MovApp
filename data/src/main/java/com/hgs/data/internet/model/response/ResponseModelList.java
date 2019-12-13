package com.hgs.data.internet.model.response;

import java.util.List;

public class ResponseModelList<T> extends ResponseModelCustom {

    private List<T> entities;

    public ResponseModelList(boolean isValid, String message, List<T> entities) {
        super(isValid, message);
        this.entities = entities;
    }

    public ResponseModelList(List<T> entities) {
        this.entities = entities;
    }

    public ResponseModelList() {

    }

    public List<T> getEntities() {
        return entities;
    }

}
