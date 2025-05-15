package com.shop.mandiri_market;

import com.shop.mandiri_market.service.Calculator;
import com.shop.mandiri_market.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockTest {

    @Mock
    private Calculator calculator;

    @InjectMocks
    private CalculatorService calculatorService;

    public MockTest() {
        MockitoAnnotations.openMocks(this); // inisialisasi mock
    }

    @Test
    void testMultiplyThenAdd() {
        // Arrange
        when(calculator.multiply(2, 3)).thenReturn(6);
        when(calculator.add(6, 4)).thenReturn(10);

        // Act
        int result = calculatorService.multiplyThenAdd(2, 3, 4);

        // Assert
        assertEquals(10, result);

        // Verifikasi method dipanggil
        verify(calculator).multiply(2, 3);
        verify(calculator).add(6, 4);
        System.out.println("SUCCESS");
    }
}
