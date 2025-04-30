package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.MUserRequest;
import com.shop.mandiri_market.dto.TransactionRequest;
import com.shop.mandiri_market.dto.TransactionResponse;
import com.shop.mandiri_market.service.TransactionService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@NoArgsConstructor
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @PostMapping("/create-transaction")
    String createTransaction(@RequestBody TransactionRequest transactionRequest){
        return transactionService.createTransaction(transactionRequest);
    }

    @GetMapping("/get-all")
    List<TransactionResponse> getAll(@RequestParam(required = false, defaultValue = "") String name){
        return transactionService.getAll(name);

    }

    @PutMapping("/{id}")
    String updateUser(@PathVariable String id, @RequestBody TransactionRequest request){
        return transactionService.updateUser(id, request);
    }


    @DeleteMapping("/{id}")
    String deletedUser(@PathVariable String id){
        return transactionService.deletedUser(id);
    }
}
