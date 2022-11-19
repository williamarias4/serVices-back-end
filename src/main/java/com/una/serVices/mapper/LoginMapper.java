package com.una.serVices.mapper;

import com.una.serVices.data.User;
import com.una.serVices.dto.LoginDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoginMapper {

    @Mapping(source = "loginDto.user_name", target = "user_name")
    @Mapping(source = "loginDto.password", target = "password")
    User converToEntity(LoginDto loginDto);
}
