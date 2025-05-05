package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.TransactionRequest;
import com.shop.mandiri_market.dto.TransactionResponse;
import com.shop.mandiri_market.entity.*;
import com.shop.mandiri_market.repository.CashierRepository;
import com.shop.mandiri_market.repository.ProductRepository;
import com.shop.mandiri_market.repository.ProductStockRepository;
import com.shop.mandiri_market.repository.TransactionRepository;
import com.shop.mandiri_market.service.TransactionService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CashierRepository cashierRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductStockRepository productStockRepository;

    @Override
    @Transactional
    public String createTransaction(TransactionRequest transactionRequest) {
        Cashier cashier = cashierRepository.findById(transactionRequest.getCashierId()).orElse(null);
        Product product = productRepository.findById(transactionRequest.getProductId()).orElse(null);
        ProductStock productStock = productStockRepository.findByProductId(product.getId()).orElse(null);
//        ProductStock productStock = productStockRepository.findById(transactionRequest.getProductId()).orElse(null);
//        Product product = productRepository.findById(transactionRequest.getProductId()).orElse(null);

        if (productStock.getStock() >= transactionRequest.getQuantity()){
            BigDecimal totalBuy = product.getPrice().multiply(BigDecimal.valueOf(transactionRequest.getQuantity()));
            if (transactionRequest.getNominalAmount().compareTo(totalBuy) >= 0) {
                cashier.setBalance(cashier.getBalance().add(totalBuy));
                productStock.setStock(productStock.getStock() - transactionRequest.getQuantity());
                Transaction transaction = Transaction.builder()
                        .id(UUID.randomUUID().toString())
                        .cashier(cashier)
                        .paid(transactionRequest.getNominalAmount())
                        .totalBuy(totalBuy)
                        .changeAmount(transactionRequest.getNominalAmount().compareTo(totalBuy) > 0 ? transactionRequest.getNominalAmount().subtract(totalBuy) : BigDecimal.ZERO)
                        .createdAt(Timestamp.from(Instant.now()))
                        .status("SUCCESS")
                        .build();

                TransactionDetail transactionDetail = TransactionDetail.builder()
                        .id(UUID.randomUUID().toString())
                        .product(product)
                        .transaction(transaction)
                        .quantity(transactionRequest.getQuantity())
                        .createdAt(Timestamp.from(Instant.now()).toLocalDateTime())
                        .status("SUCCESS")
                        .build();
                transaction.setTransactionDetails(List.of(transactionDetail));
                transactionRepository.save(transaction);
                cashierRepository.save(cashier);
                productStockRepository.save(productStock);
            }
        }
        return "Success created transaction";
    }

    @Override
    public List<TransactionResponse> getAll() {
        return transactionRepository.findAll().stream().flatMap(data -> data.getTransactionDetails().stream()
                        .map(detail -> TransactionResponse.builder()
                                .cashierId(data.getCashier())
                                .productId(detail.getProduct())
                                .totalBuy(data.getTotalBuy())
                                .paid(data.getPaid())
                                .changeAmount(data.getChangeAmount())
                                .createdAt(data.getCreatedAt())
                                .transactionId(data.getId())
                                .quantity(detail.getQuantity())
                                .status(data.getStatus())
                                .build()
                        ))
                .collect(Collectors.toList());
    }

    @Override
    public String deletedUser(String id) {
        transactionRepository.findById(id).map(data -> {
            data.setIsDeleted(String.valueOf(Boolean.TRUE));
            transactionRepository.save(data);
            return data;
        });

        return "SUCCESS DELETED";
    }
}





