package com.una.serVices.mapper;

import com.una.serVices.data.User;
import com.una.serVices.dto.UserDto;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper
public interface IUserMapper {

    User convertToEntity(UserDto userdto);

    List<User> convertToEntities(List<UserDto> userDtos);

    UserDto convertToDto(User user);

    List<UserDto> convertToDtos(List<User> users);
}
