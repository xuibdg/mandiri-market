package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.TransactionRequest;
import com.shop.mandiri_market.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private TransactionService transactionService;
    @PostMapping("/create-transaction")
    String createTransaction(@RequestBody TransactionRequest transactionRequest){
        return transactionService.createTransaction(transactionRequest);
    }
}
