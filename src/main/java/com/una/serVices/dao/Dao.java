package com.una.serVices.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T,A> {

    T get(A id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
