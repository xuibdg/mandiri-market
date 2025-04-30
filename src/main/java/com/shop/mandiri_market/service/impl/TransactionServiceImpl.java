package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.TransactionRequest;
import com.shop.mandiri_market.entity.Cashier;
import com.shop.mandiri_market.entity.Product;
import com.shop.mandiri_market.entity.ProductStock;
import com.shop.mandiri_market.entity.Transaction;
import com.shop.mandiri_market.repository.CashierRepository;
import com.shop.mandiri_market.repository.ProductRepository;
import com.shop.mandiri_market.repository.ProductStockRepository;
import com.shop.mandiri_market.service.TransactionService;
import com.shop.mandiri_market.utils.exception.BusinessException;
import com.shop.mandiri_market.utils.exception.GlobalErrorMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    CashierRepository cashierRepository;
    ProductRepository productRepository;
    ProductStockRepository productStockRepository;
    @Override
    public String createTransaction(TransactionRequest transactionRequest) {
        Cashier cashier = cashierRepository.findById(transactionRequest.getCashierId()).orElseThrow(() -> new BusinessException(HttpStatus.BAD_REQUEST, GlobalErrorMapping.CASHIER_NOT_FOUND));
        ProductStock productStock = productStockRepository.findById(transactionRequest.getProductId()).orElseThrow(() -> new BusinessException(HttpStatus.BAD_REQUEST, GlobalErrorMapping.PRODUCT_STOCK_NOT_FOUND));
        Product product = productRepository.findById(transactionRequest.getProductId()).orElseThrow(() -> new BusinessException(HttpStatus.BAD_REQUEST, GlobalErrorMapping.PRODUCT_NOT_FOUND));

        if (productStock.getStock() <= transactionRequest.getQuantity()){
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

}
