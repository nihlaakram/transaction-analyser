package com.nihla.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static long dateTimeConverter (String dateTime) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
            Date parsedDate = dateFormat.parse(dateTime);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            return timestamp.getTime();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return -1L;
    }

}
