package com.nihla;

import com.nihla.process.Processor;
import com.nihla.util.Constants;
import com.nihla.util.Messages;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;

public class GetAverageTransactionTestCase {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeClass
    public void setup() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
    }

    @AfterClass
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testGetAverageTransaction() {

        String csvFile = "<pathToCSV>";
        String fromDate = "<fromDate>";
        String toDate = "<toDate>";
        String merchant = "<merchant>";

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

        outContent.reset();
        analyser.getAverage(fromDate, toDate, merchant);
        Assert.assertEquals(outContent.toString(), "Number of transactions = 1\n" +
                "Average Transaction Value = 59.99\n");

    }
}
