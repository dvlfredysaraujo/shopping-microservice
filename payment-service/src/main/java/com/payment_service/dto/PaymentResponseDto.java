package com.payment_service.dto;

import com.payment_service.client.dto.DetailOrderHeader;
import com.payment_service.client.dto.OrderResponseDto;

public class PaymentResponseDto {
    private String transactionId;
    private String status;
    private String message;
    private DetailOrderHeader orderDetailsHeader;

    public PaymentResponseDto() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DetailOrderHeader getOrderDetailsHeader() {
        return orderDetailsHeader;
    }

    public void setOrderDetailsHeader(DetailOrderHeader orderDetailsHeader) {
        this.orderDetailsHeader = orderDetailsHeader;
    }
}
