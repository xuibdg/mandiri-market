package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.TransactionRequest;
import com.shop.mandiri_market.entity.Transaction;
import com.shop.mandiri_market.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public String createTransaction(TransactionRequest transactionRequest) {
        return "Success created transaction";
    }

}
