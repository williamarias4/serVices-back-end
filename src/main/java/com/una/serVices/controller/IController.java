package com.una.serVices.controller;

import com.una.serVices.data.User;
import com.una.serVices.dto.UserDto;

import java.util.Optional;

public interface IController<T,C> {

    T convertToDto(C c);

    C convertToEntity(T t);
}
