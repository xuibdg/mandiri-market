package com.shop.mandiri_market;

import com.shop.mandiri_market.service.Calculator;
import com.shop.mandiri_market.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class UnitTest {

    private Calculator calculator ;
    private List<String> logs;
    private TransactionServiceImpl transactionServiceImpl;


    @BeforeEach
    void setUp(){
        this.calculator = new Calculator();
        this.transactionServiceImpl = new TransactionServiceImpl();
        this.logs = new ArrayList<>();
    }

//    @Test
//    void testAdd(){
//        int result = calculator.add(5, 4);
//        logs.add("add method executed");
//        assertEquals(9, result, "addition should return the correct result");
//    }
//
//    @Test
//    void testAdditionFailure() {
//        logs.add("add method executed");
//        assertEquals(10, calculator.add(4, 3)); // ❌ Failure: expected 10 but was 7
//    }
//
//    @Test
//    void testDivisionError() {
//        logs.add("divide method executed");
//        calculator.divide(10, 0); // ❌ Error: rithmeticExceptionA
//    }
//
//    @Disabled("Feature not implemented yet")
//    @Test
//    void testMultiply() {
//        logs.add("multiply method executed");
//        assertEquals(20, calculator.multiply(4, 5)); // Skipped
//    }

    @Test
    void testValidateTotalBuy() {
        logs.add("ValidateTotalBuy method executed");
        assertEquals(BigDecimal.valueOf(5000), transactionServiceImpl.validateTotalBuy(5, BigDecimal.valueOf(1000)));
    }

    @Test
    void testUUID() {
        logs.add("UUID method executed");
        System.out.println(UUID.randomUUID().getMostSignificantBits());
    }



    @AfterEach
    void tearDown(){
        System.out.println(logs);
        logs.clear(); //bersihkan log setelah setiap pengujian
        System.out.println("logs cleared after test execute");


    }

}