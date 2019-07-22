package com.conferenceManagement.data.converter;

public interface Converter<T, R> {
    R convert(T value);
}
