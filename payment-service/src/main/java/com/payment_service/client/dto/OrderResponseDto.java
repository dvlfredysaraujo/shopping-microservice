package com.payment_service.client.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResponseDto {
    @JsonProperty("timesTamp")
    @JsonAlias("timesTamp")
    private String timesTamp;

    @JsonProperty("status")
    @JsonAlias("status")
    private Integer status;

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
    private DetailOrderHeader data;

    public OrderResponseDto() {
    }

    public String getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(String timesTamp) {
        this.timesTamp = timesTamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public DetailOrderHeader getData() {
        return data;
    }

    public void setData(DetailOrderHeader data) {
        this.data = data;
    }
}
