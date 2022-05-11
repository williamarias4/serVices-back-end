package com.una.serVices.dao;

import java.util.List;

public interface GetDao<T,A> {

    T get(A id);

    List<T> getAll();
}
