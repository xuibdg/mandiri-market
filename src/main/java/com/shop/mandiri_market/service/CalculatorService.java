package com.shop.mandiri_market.service;

public class CalculatorService {
    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int multiplyThenAdd(int a, int b, int c) {
        int mul = calculator.multiply(a, b);
        return calculator.add(mul, c);
    }
}
