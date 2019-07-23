package com.conferenceManagement.data.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

    @Override
    public Date convert (String value){
        try {
            return simpleDateFormat.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }
}
