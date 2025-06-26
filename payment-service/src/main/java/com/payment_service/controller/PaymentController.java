package com.payment_service.controller;

import com.payment_service.dto.PaymentRequestDto;
import com.payment_service.dto.PaymentResponseDto;
import com.payment_service.service.PaymentService;
import com.payment_service.utils.ApiResponse;
import com.payment_service.utils.ResponseUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<PaymentResponseDto>> pay(
            @Valid @RequestBody PaymentRequestDto request) {
        PaymentResponseDto resp = paymentService.processPayment(request);
        return ResponseUtils.buildSuccessResponse(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/{transactionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<PaymentResponseDto>> getByTransaction(
            @PathVariable String transactionId) {
        PaymentResponseDto resp = paymentService.getPaymentByTransactionId(transactionId);
        return ResponseUtils.buildSuccessResponse(resp, HttpStatus.OK);
    }
}
