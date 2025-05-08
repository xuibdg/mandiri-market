package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.TransactionRequest;
import com.shop.mandiri_market.dto.TransactionResponse;
import com.shop.mandiri_market.service.TransactionService;
import com.shop.mandiri_market.utils.exception.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@NoArgsConstructor
@AllArgsConstructor
public class TransactionController extends BaseCRUDController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create-transaction")
    BaseResponse<String> createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return buildSuccessResponse(transactionService.createTransaction(transactionRequest));
    }

    @GetMapping("/transactions")
    public List<TransactionResponse> getAll() {
        return transactionService.getAll();
    }
}
