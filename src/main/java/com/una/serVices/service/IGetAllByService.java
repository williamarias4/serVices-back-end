package com.una.serVices.service;

import java.util.List;

public interface IGetAllByService <T,A>{

    List<T> getAllBy(A a);
}
