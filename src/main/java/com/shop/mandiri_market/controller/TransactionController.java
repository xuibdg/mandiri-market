package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.TransactionRequest;
import com.shop.mandiri_market.dto.TransactionResponse;
import com.shop.mandiri_market.service.TransactionService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@NoArgsConstructor
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @PostMapping("/create-transaction")
    String createTransaction(@RequestBody TransactionRequest transactionRequest){
        return transactionService.createTransaction(transactionRequest);
    }

    @GetMapping("/transactions")
    public List<TransactionResponse> getAll() {
        return transactionService.getAll();
    }
}
