package com.example.model.repository;

import java.util.List;

public interface IUtilityDao <T> {
    List<T> findAll();

    T findById(int id);

    boolean add(T t);

    boolean edit(int id, T t);

    boolean remove(int id);
}
