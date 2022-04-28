package com.una.serVices.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

    Optional<T> get(int id);

    List<T> getAll();

    boolean exists(T t);

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);

}
