package com.order_service.client.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse {
    @JsonProperty("timesTamp")
    @JsonAlias("timesTamp")
    private String timesTamp;

    @JsonProperty("status")
    @JsonAlias("status")
    private int status;

    @JsonProperty("error")
    @JsonAlias("error")
    private String error;

    @JsonProperty("message")
    @JsonAlias("message")
    private String message;

    @JsonProperty("path")
    @JsonAlias("path")
    private String path;

    @JsonProperty("data")
    @JsonAlias("data")
    private ProductSpecifications data;

    public ProductResponse() {
    }

    public String getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(String timesTamp) {
        this.timesTamp = timesTamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ProductSpecifications getData() {
        return data;
    }

    public void setData(ProductSpecifications data) {
        this.data = data;
    }
}
