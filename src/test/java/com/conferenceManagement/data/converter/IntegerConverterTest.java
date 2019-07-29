package com.conferenceManagement.data.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerConverterTest {
    @Test
    public void convert() {
        IntegerConverter integerConverter = new IntegerConverter();
        assertEquals(123, integerConverter.convert("123").intValue());
        assertNotEquals(456,integerConverter.convert("123").intValue());
        assertNull(integerConverter.convert("123sdf"));
    }
}