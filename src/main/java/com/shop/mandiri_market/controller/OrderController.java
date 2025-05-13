package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.OrderPaymentRequest;
import com.shop.mandiri_market.entity.Order;
import com.shop.mandiri_market.entity.Payment;
import com.shop.mandiri_market.service.OrderPaymentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update-processor/{id}")
    public String updateProcessor(@PathVariable Long id, @RequestBody OrderPaymentRequest orderPaymentRequest) {
        try {
            String s = orderPaymentService.updateProcessor(id, orderPaymentRequest);
            return "update-processor successfully " + s;
        } catch (RuntimeException e) {
            return "error : " + e.getMessage();
        }
    }

    @PutMapping("/update-processor-v2/{id}")
    public String updateProcessorv2(@PathVariable Long id, @RequestBody OrderPaymentRequest orderPaymentRequest) {
        try {
            orderPaymentService.updateProcessor(id, orderPaymentRequest);
            return "update-processor successfully";
        } catch (Exception e) {
            return "error : " + e.getMessage();
        }
    }


}
