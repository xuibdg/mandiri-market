package com.shop.mandiri_market.service;

import com.shop.mandiri_market.dto.TransactionRequest;
import com.shop.mandiri_market.dto.TransactionResponse;

import java.util.List;

public interface TransactionService {
    String createTransaction(TransactionRequest transactionRequest);
    String deletedUser(String id);
    List<TransactionResponse> getAll ();

}
