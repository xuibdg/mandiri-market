package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.OrderPaymentRequest;
import com.shop.mandiri_market.entity.Order;
import com.shop.mandiri_market.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ValidateTransactionGeneral {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void validateAndSaveOrder(OrderPaymentRequest request){
        Order order = new Order();
        order.setDescription(request.getDescription());
        orderRepository.save(order);
    }

}
