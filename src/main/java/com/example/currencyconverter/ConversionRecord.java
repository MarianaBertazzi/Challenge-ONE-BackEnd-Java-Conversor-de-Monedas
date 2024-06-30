package com.example.currencyconverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversionRecord {
    private final String timestamp;
    private final double amount;
    private final String fromCurrency;
    private final double convertedAmount;
    private final String toCurrency;

    public ConversionRecord(double amount, String fromCurrency, double convertedAmount, String toCurrency) {
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.amount = amount;
        this.fromCurrency = fromCurrency;
        this.convertedAmount = convertedAmount;
        this.toCurrency = toCurrency;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f %s = %.2f %s", timestamp, amount, fromCurrency, convertedAmount, toCurrency);
    }
}

