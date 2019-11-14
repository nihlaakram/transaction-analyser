package com.nihla.model.entity;

import java.util.Date;

public class PaymentTransaction {
    private String id;
    private long timestamp;
    private double amount;

    public PaymentTransaction(String id, long timestamp, double amount) {
        this.id = id;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

}
