package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.OrderPaymentRequest;
import com.shop.mandiri_market.entity.Order;
import com.shop.mandiri_market.entity.Payment;
import com.shop.mandiri_market.repository.OrderRepository;
import com.shop.mandiri_market.repository.PaymentRepository;
import com.shop.mandiri_market.service.OrderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ValidateTransactionGeneral validateTransactionGeneral;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrderAndPayment(Order order, Payment payment) {

        orderRepository.save(order);

        paymentRepository.save(payment);

        if (payment.getAmount() <= 0){
            throw new IllegalArgumentException("payment amount must be greater than zero");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public String processTransactionOrder(OrderPaymentRequest request){
        validateTransactionGeneral.validateAndSaveOrder(request);
        validateAndSavePayment(request);

        return "SUCCESS Create Transaction, description: "+ request.getDescription() + " paymentAmount : Rp." +request.getAmount();

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void validateAndSavePayment(OrderPaymentRequest request){
        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        paymentRepository.save(payment);

        if (payment.getAmount() <= 0){
            throw new IllegalArgumentException("payment amount must be greater than zero");
        }
    }



}
