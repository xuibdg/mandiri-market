package com.shop.mandiri_market.service;

import com.shop.mandiri_market.dto.TransactionRequest;

public interface TransactionService {
    String createTransaction(TransactionRequest transactionRequest);
}
