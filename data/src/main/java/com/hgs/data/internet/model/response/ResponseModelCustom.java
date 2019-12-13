package com.hgs.data.internet.model.response;

public class ResponseModelCustom {

    private boolean isValid;
    private String message;

    public ResponseModelCustom(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public ResponseModelCustom(){}

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean valid){ this.isValid = valid; }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
