package com.payment_service.payment;

import com.payment_service.dto.PaymentRequestDto;
import com.payment_service.dto.PaymentResponseDto;

public interface PaymentMethod {

    public PaymentResponseDto process(PaymentRequestDto request);
}
