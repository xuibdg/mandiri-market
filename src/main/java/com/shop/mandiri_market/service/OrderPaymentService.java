package com.shop.mandiri_market.service;

import com.shop.mandiri_market.dto.OrderPaymentRequest;
import com.shop.mandiri_market.entity.Order;
import com.shop.mandiri_market.entity.Payment;

public interface OrderPaymentService {
    public void createOrderAndPayment(Order order, Payment payment);

    public String processTransactionOrder(OrderPaymentRequest request);

    public String updateProcessor(Long id, OrderPaymentRequest request);
}
