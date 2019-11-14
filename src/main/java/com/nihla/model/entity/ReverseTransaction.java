package com.nihla.model.entity;

import java.util.Date;

public class ReverseTransaction {

    private String id;
    private long timestamp;
    private double amount;
    private String reverseId;

    public ReverseTransaction(String id, long timestamp, double amount, String reverseId) {
        this.id = id;
        this.timestamp = timestamp;
        this.amount = amount;
        this.reverseId = reverseId;
    }

    public String getId() {
        return id;
    }

    public String getReverseId() {
        return reverseId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

}
