package com.payment_service.service;

import com.payment_service.dto.PaymentRequestDto;
import com.payment_service.dto.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto processPayment(PaymentRequestDto request);
    PaymentResponseDto getPaymentByTransactionId(String transactionId);
}
