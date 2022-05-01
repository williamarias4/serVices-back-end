package com.una.serVices.service;

import java.util.List;
import java.util.Optional;

public interface IService<T,A> {

    T get(A id);

    List<T> getAll();

    boolean exists(T t);

    T save(T t) throws Exception;

    void update(T t, String[] params);

    void delete(T t);

}
