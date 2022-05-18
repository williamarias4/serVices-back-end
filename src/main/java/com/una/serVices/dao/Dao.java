package com.una.serVices.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T,A> {

    T get(A id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    void delete(T t);
}
