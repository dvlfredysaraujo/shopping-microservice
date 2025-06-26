package com.payment_service.payment;

import com.payment_service.dto.PaymentRequestDto;
import com.payment_service.dto.PaymentResponseDto;
import com.payment_service.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.time.YearMonth;
import java.util.UUID;

@Component
public class CreditCardPaymentMethod implements PaymentMethod{
    @Override
    public PaymentResponseDto process(PaymentRequestDto request) {

        String cc = request.getCardNumber();
        if (cc == null || cc.isEmpty() || cc.length() < 16) {
            throw new BadRequestException("Card number must be 16 digits long");
        }

        if (request.getCvv() == null || request.getCvv().length() != 3) {
            throw new BadRequestException("CVV must be 3 digits long");
        }

        YearMonth expiryDate;
        try {
            String[] parts = request.getExpirationDate().split("/");
            expiryDate = YearMonth.of(2000 + Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
        } catch (Exception e) {
            throw new BadRequestException("Invalid expiration date format");
        }
        if (expiryDate.isBefore(YearMonth.now())) {
            throw new BadRequestException("Card expired");
        }

        PaymentResponseDto resp = new PaymentResponseDto();
        resp.setTransactionId(UUID.randomUUID().toString());
        resp.setStatus("PAID");
        resp.setMessage("Payment approved");
        return resp;
    }
}
