package com.payment_service.client.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class DetailOrderDto {

    @JsonProperty("id")
    @JsonAlias("id")
    private Integer id;

    @JsonProperty("productId")
    @JsonAlias("productId")
    private Integer productId;

    @JsonProperty("quantity")
    @JsonAlias("quantity")
    private Integer quantity;

    @JsonProperty("unitPrice")
    @JsonAlias("unitPrice")
    private Float unitPrice;

    @JsonProperty("subTotal")
    @JsonAlias("subTotal")
    private Float subTotal;

    public DetailOrderDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }
}
