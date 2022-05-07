package com.una.serVices.service;

public interface ISaveService<T> {

    boolean exists(T t);

    T save(T t);

    void update(T t);
}
