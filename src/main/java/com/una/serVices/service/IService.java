package com.una.serVices.service;

import com.una.serVices.data.BusinessProfile;
import com.una.serVices.data.User;

import java.util.List;
import java.util.Optional;

public interface IService<T,A> {

    T get(A id);
    List<T> getAll();
    boolean exists(T t);
    T save(T t);
    T update(T t);
    void delete(T t);

}
