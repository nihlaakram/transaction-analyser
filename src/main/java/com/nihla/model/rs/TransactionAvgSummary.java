package com.nihla.model.rs;

public class TransactionAvgSummary {

    private double average;
    private int count;

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TransactionAvgSummary(double average, int count) {
        this.average = average;
        this.count = count;
    }
}
