package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.TransactionRequest;
import com.shop.mandiri_market.dto.TransactionResponse;
import com.shop.mandiri_market.entity.Cashier;
import com.shop.mandiri_market.entity.Product;
import com.shop.mandiri_market.entity.ProductStock;
import com.shop.mandiri_market.entity.Transaction;
import com.shop.mandiri_market.repository.CashierRepository;
import com.shop.mandiri_market.repository.ProductRepository;
import com.shop.mandiri_market.repository.ProductStockRepository;
import com.shop.mandiri_market.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private CashierRepository cashierRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductStockRepository productStockRepository;

    @Override
    public String createTransaction(TransactionRequest transactionRequest) {
        Cashier cashier = cashierRepository.findById(transactionRequest.getCashierId()).orElse(null);
        ProductStock productStock = productStockRepository.findById(transactionRequest.getProductId()).orElse(null);
        Product product = productRepository.findById(transactionRequest.getProductId()).orElse(null);

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
            }
        }
        return "Success created transaction";
    }

    @Override
    public List<TransactionResponse> getAll(String name) {
        return List.of();
    }

    @Override
    public String updateUser(String id, TransactionRequest request) {
        return "";
    }

    @Override
    public String deletedUser(String id) {
        return "";
    }

}
