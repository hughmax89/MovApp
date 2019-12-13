package com.hgs.data.internet.model.request;

import java.util.Map;

public class FileModelRequest {
    private Map<String, String> attributes;
    private String typeFormat;
    private String url;

    public FileModelRequest(Map attributes, String typeFormat, String url) {
        this.attributes = attributes;
        this.typeFormat = typeFormat;
        this.url = url;
    }

    public FileModelRequest() {
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map attributes) {
        this.attributes = attributes;
    }

    public String getTypeFormat() {
        return typeFormat;
    }

    public void setTypeFormat(String typeFormat) {
        this.typeFormat = typeFormat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
