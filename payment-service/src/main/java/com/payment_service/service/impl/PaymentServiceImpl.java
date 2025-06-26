package com.payment_service.service.impl;

import com.payment_service.client.OrderFeignClient;
import com.payment_service.client.dto.OrderResponseDto;
import com.payment_service.dto.PaymentRequestDto;
import com.payment_service.dto.PaymentResponseDto;
import com.payment_service.exception.BadRequestException;
import com.payment_service.exception.ResourceNotFoundException;
import com.payment_service.model.Payment;
import com.payment_service.payment.PaymentMethod;
import com.payment_service.repository.PaymentRepository;
import com.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final OrderFeignClient orderFeignClient;
    private final PaymentRepository paymentRepository;
    private final PaymentMethod paymentMethod;

    @Autowired
    public PaymentServiceImpl(OrderFeignClient orderFeignClient, PaymentRepository paymentRepository, PaymentMethod paymentMethod) {
        this.orderFeignClient = orderFeignClient;
        this.paymentRepository = paymentRepository;
        this.paymentMethod = paymentMethod;
    }

    @Override
    @Transactional
    public PaymentResponseDto processPayment(PaymentRequestDto request) {
        OrderResponseDto order = orderFeignClient.getOrderById(request.getOrderId());
        if (order == null) {
            throw new ResourceNotFoundException("Order not found with id: " + request.getOrderId());
        }

        if (!order.getData().getTotalAmount().equals(request.getAmount())) {
            throw new BadRequestException("Amount does not match order total");
        }

        PaymentResponseDto resp = paymentMethod.process(request);
        resp.setOrderDetailsHeader(order.getData());

        Payment entity = new Payment();
        entity.setTransactionId(resp.getTransactionId());
        entity.setOrderId(request.getOrderId());
        entity.setCustomerId(request.getCustomerId());
        entity.setStatus(resp.getStatus());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setAmount(request.getAmount());
        paymentRepository.save(entity);

        return resp;
    }

    @Override
    public PaymentResponseDto getPaymentByTransactionId(String transactionId) {
        Payment p = paymentRepository.findByTransactionId(transactionId);
        if (p == null) {
            throw new ResourceNotFoundException("Payment not found with transactionId: " + transactionId);
        }
        PaymentResponseDto resp = new PaymentResponseDto();
        resp.setTransactionId(p.getTransactionId());
        resp.setStatus(p.getStatus());
        resp.setMessage("Retrieved");
        return resp;
    }
}
