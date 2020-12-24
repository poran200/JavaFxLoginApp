package com.mycompany.mydbgui.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T,I> {
    T save(T t);
    Optional<T> findByModel(T t);
    T update(T t);
    Optional<T> finById(I i);
    List<T> findAll();
    boolean removeBYId(I i);

}
