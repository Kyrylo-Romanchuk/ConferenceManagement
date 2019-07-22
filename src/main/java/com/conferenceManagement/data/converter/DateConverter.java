package com.conferenceManagement.data.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public Date convert (String date){
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
