package com.nihla.process;

import com.nihla.model.entity.Merchant;
import com.nihla.model.entity.PaymentTransaction;
import com.nihla.model.entity.ReverseTransaction;
import com.nihla.util.Constants;
import com.nihla.util.Utility;

import java.util.*;

public class Processor {
    private  Map <String, Merchant> merchants;

    public Processor() {
        this.merchants =  new HashMap<String, Merchant>();
    }

    public void processCSVInput (String input) {
        String[] data = input.split(Constants.CSV_SPLITTER);
        String id = data[0].trim();
        long timestamp = Utility.dateTimeConverter(data[1]);
        double amount = Double.parseDouble(data[2]);
        String merchant = data[3].trim();
        String type = data[4].trim();

        if (!merchants.containsKey(merchant)) {
            merchants.put(merchant, new Merchant(merchant));
        }
        if (type.equals(Constants.TRANSACTION_PAYMENT)) {
            PaymentTransaction transaction = new PaymentTransaction(id, timestamp, amount);
            merchants.get(merchant).addTransaction(transaction);
        } else if (type.equals(Constants.TRANSACTION_REVERSAL)){
            String reverseId = data[5].trim();
            ReverseTransaction transaction = new ReverseTransaction(id, timestamp, amount, reverseId);
            merchants.get(merchant).removeTransaction(transaction);
        }
    }
    public void getAverage(String fromDate, String toDate, String merchant) {
        Merchant merchant1 = merchants.get(merchant);
        long fromTime = Utility.dateTimeConverter(fromDate);
        long toTime = Utility.dateTimeConverter(toDate);
        System.out.println(merchant1.getAverageTransactions(fromTime, toTime));
    }
}
