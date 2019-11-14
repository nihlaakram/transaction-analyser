package com.nihla.model.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Merchant {

    private String name;
    private Map<String, PaymentTransaction> activeTransactions;
    private Map<String, ReverseTransaction> reversedTransactions;

    public String getName() {
        return name;
    }

    public Map<String, PaymentTransaction> getActiveTransactions() {
        return activeTransactions;
    }

    public Merchant(String name) {
        this.name = name;
        this.activeTransactions = new HashMap<String, PaymentTransaction>();
        this.reversedTransactions = new HashMap<String, ReverseTransaction>();
    }

    public void addTransaction (PaymentTransaction transaction) {
        this.activeTransactions.put( transaction.getId(), transaction);
    }

    public void removeTransaction (ReverseTransaction transaction) {
        this.activeTransactions.remove(transaction.getReverseId());
        this.reversedTransactions.put( transaction.getId(), transaction);
    }

    public double getAverageTransactions(long fromTime, long toTime) {
        Iterator it = activeTransactions.entrySet().iterator();
        double sum = 0;
        int count = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            PaymentTransaction transaction = (PaymentTransaction)pair.getValue();
            long timestamp = transaction.getTimestamp();
            if (timestamp >= fromTime && timestamp <= toTime) {
                sum += transaction.getAmount();
                count++;
            }
        }
        return sum / count;
    }
}
