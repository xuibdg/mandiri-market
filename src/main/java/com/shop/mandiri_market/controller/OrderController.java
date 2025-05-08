package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.OrderPaymentRequest;
import com.shop.mandiri_market.entity.Order;
import com.shop.mandiri_market.entity.Payment;
import com.shop.mandiri_market.service.OrderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderPaymentService orderPaymentService;


    @PostMapping("/create-order-payment")
    public String createOrderAndPayment(@RequestBody OrderPaymentRequest orderPaymentRequest) {
        Order order = new Order();
        order.setDescription(orderPaymentRequest.getDescription());

        Payment payment = new Payment();
        payment.setAmount(orderPaymentRequest.getAmount());

        try {
            orderPaymentService.createOrderAndPayment(order, payment);
            return "Order and payment created successfully";
        } catch (Exception e) {
            return "error : " + e.getMessage();
        }

    }


    @PostMapping("/transaction-order-payment")
    public String processTransactionOrder(@RequestBody OrderPaymentRequest orderPaymentRequest) {
        try {
            orderPaymentService.processTransactionOrder(orderPaymentRequest);
            return "Order and payment created successfully";
        } catch (Exception e) {
            return "error : " + e.getMessage();
        }
    }

}
