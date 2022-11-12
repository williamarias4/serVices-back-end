package com.una.serVices.mapper;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.data.User;
import com.una.serVices.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User convertToEntity(UserDto userdto);
    List<User> convertToEntities(List<UserDto> userDtos);
    UserDto convertToDto(User user);
    List<UserDto> convertToDtos(List<User> users);
}
