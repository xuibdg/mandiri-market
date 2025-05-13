package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.OrderPaymentRequest;
import com.shop.mandiri_market.entity.Order;
import com.shop.mandiri_market.entity.Payment;
import com.shop.mandiri_market.repository.OrderRepository;
import com.shop.mandiri_market.repository.PaymentRepository;
import com.shop.mandiri_market.service.OrderPaymentService;
import jakarta.persistence.EntityManager;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ValidateTransactionGeneral validateTransactionGeneral;

    @Autowired
    private EntityManager entityManager;

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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
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


    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @SneakyThrows
    public String updateProcessor(Long id, OrderPaymentRequest request) {
        try {
            Payment payment1  = paymentRepository.findById(id).orElseThrow();
            //Thread.sleep(10000); // 10 detik, biar bisa ubah dari query luar
            entityManager.clear();// clear cache supaya query kedua benar-benar ambil dari DB
            Payment payment2  = paymentRepository.findById(id).orElseThrow();
            payment2.setAmount(payment2.getAmount() + request.getAmount());
            paymentRepository.save(payment2);
            return "success data asal" + payment1 + " data baru " + payment2;
        } catch (RuntimeException e) {
            return "error: " + e.getMessage();
        }
    }





}
