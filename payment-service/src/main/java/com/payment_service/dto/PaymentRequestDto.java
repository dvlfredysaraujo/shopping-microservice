package com.payment_service.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PaymentRequestDto {

    @NotNull(message = "Order ID cannot be null")
    @JsonAlias("orderId")
    @JsonProperty("orderId")
    private Integer orderId;

    @JsonAlias("customerId")
    @JsonProperty("customerId")
    @NotNull(message = "Customer ID cannot be null")
    private Integer customerId;

    @JsonAlias("cardNumber")
    @JsonProperty("cardNumber")
    @NotNull(message = "Card number cannot be null")
    private String cardNumber;

    @JsonAlias("expirationDate")
    @JsonProperty("expirationDate")
    @NotNull(message = "Expiration date cannot be null")
    private String expirationDate;

    @JsonAlias("cvv")
    @JsonProperty("cvv")
    @NotNull(message = "CVV cannot be null")
    private String cvv;

    @JsonAlias("amount")
    @JsonProperty("amount")
    @NotNull(message = "Amount cannot be null")
    @Min(value = 0, message = "Amount must be non-negative")
    private Float amount;

    public PaymentRequestDto() {
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
