package com.conferenceManagement.data.converter;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class DateConverterTest {
    @Test
    public void convert() throws ParseException {
        String testValue = "05/05/1000";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateConverter dateConverter = new DateConverter();
        assertEquals(simpleDateFormat.parse(testValue), dateConverter.convert(testValue));
        assertNull(dateConverter.convert(""));
    }
}