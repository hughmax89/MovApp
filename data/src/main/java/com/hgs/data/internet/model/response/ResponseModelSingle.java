package com.hgs.data.internet.model.response;

public class ResponseModelSingle<T> extends ResponseModelCustom {

    private T entity;

    public ResponseModelSingle(boolean isValid, String message, T entity) {
        super(isValid, message);
        this.entity = entity;
    }

    public ResponseModelSingle(T entity) {
        this.entity = entity;
    }

    public ResponseModelSingle(T entity, boolean isValid) {
        super(isValid, "");
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

}
