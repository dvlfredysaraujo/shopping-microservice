package com.payment_service.client.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class DetailOrderHeader {

    @JsonProperty("orderId")
    @JsonAlias("orderId")
    private Integer orderId;

    @JsonProperty("customerId")
    @JsonAlias("customerId")
    private Integer customerId;

    @JsonProperty("status")
    @JsonAlias("status")
    private String status;

    @JsonProperty("createdAt")
    @JsonAlias("createdAt")
    private LocalDateTime createdAt;

    @JsonProperty("totalAmount")
    @JsonAlias("totalAmount")
    private Float totalAmount;

    @JsonProperty("items")
    @JsonAlias("items")
    private List<DetailOrderDto> items;

    public DetailOrderHeader() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<DetailOrderDto> getItems() {
        return items;
    }

    public void setItems(List<DetailOrderDto> items) {
        this.items = items;
    }
}
