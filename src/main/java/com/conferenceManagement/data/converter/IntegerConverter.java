package com.conferenceManagement.data.converter;

public class IntegerConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String value) {
        if (value.matches("\\d+")){
            return Integer.valueOf(value);
        } else {
            return null;
        }
    }
}
