package com.nihla;

import com.nihla.process.Processor;
import com.nihla.util.Messages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No CSV file provided");
            System.exit(1);
        }
        String csvFile = args[0];
        BufferedReader br = null;
        String line = "";
        Processor analyser = new Processor();
        System.out.println("Loading transactions..");
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                analyser.processCSVInput(line);
            }
        } catch (IOException e) {
            System.out.printf(Messages.ERROR_OCCURRED, e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Successfully loaded transactions.\n");

        Scanner sc = new Scanner(System.in);

        System.out.println(Messages.ENTER_INPUT);

        System.out.print(Messages.FROM_DATE_INPUT);
        String fromDate = sc.nextLine();

        System.out.print(Messages.TO_DATE_INPUT);
        String toDate = sc.nextLine();

        System.out.print(Messages.MERCHANT_INPUT);
        String merchant = sc.nextLine();

        analyser.getAverage(fromDate.trim(), toDate.trim(), merchant.trim());

    }
}
