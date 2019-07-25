package com.conferenceManagement.data.dao;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();

    T findById(Integer id);

    void add(T t);
}
