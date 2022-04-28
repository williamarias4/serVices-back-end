package com.una.serVices.controller;

import com.una.serVices.config.APIRoutes;
import com.una.serVices.data.User;
import com.una.serVices.dto.UserDto;
import com.una.serVices.service.ILoginService;
import com.una.serVices.service.IService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(APIRoutes.API.USERS_V1)
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IService service;

    @Autowired
    private ILoginService login;

    @GetMapping(APIRoutes.RestAPI.GET_ALL)
    public List<UserDto> getAllUsers() {

        return (List<UserDto>) service.getAll().stream().map(user -> modelMapper
                .map(user, UserDto.class)).collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto save(@Valid @RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        service.save(user);
        if(service.exists(user)){
            return convertToDto(user);
        }
        return null;
    }



    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    private User convertToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }


}
