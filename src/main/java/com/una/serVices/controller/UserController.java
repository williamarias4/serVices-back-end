package com.una.serVices.controller;

import com.una.serVices.config.APIRoute;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.data.User;
import com.una.serVices.dto.LoginDto;
import com.una.serVices.dto.UserDto;
import com.una.serVices.service.ILoginService;
import com.una.serVices.service.IService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(APIRoute.API.USERS_V1)
public class UserController implements IController<UserDto, User> {

    @Autowired
    private ModelMapper modelMapper;

    @Qualifier(ComponentConfig.Service.USER)
    @Autowired
    private IService service;

    @Qualifier(ComponentConfig.Service.BUSINESS_PROFILE)
    @Autowired
    private IService service2;

    @Autowired
    private ILoginService login;


    @GetMapping(APIRoute.Session.GET_BY_USER_NAME)
    public UserDto getByUsername(@PathVariable String user_name) {
        return convertToDto((User) service.get(user_name));
    }

    @GetMapping(APIRoute.RestAPI.GET_ALL)
    public List<UserDto> getAllUsers() {
        return (List<UserDto>) service.getAll().stream().map(user -> modelMapper
                .map(user, UserDto.class)).collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto save(@Valid @RequestBody UserDto userDto) throws Exception {
        User user = convertToEntity(userDto);
        return convertToDto((User) service.save(user));
    }

    @PostMapping(value = APIRoute.Session.LOG_IN, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto login(@Valid @RequestBody LoginDto loginDto) throws Exception {
        User user = convertToEntity(loginDto);
        if (login.login(user)) {
            return convertToDto((User) login.getUserDb(user));
        }
        return null;
    }


    public User convertToEntity(LoginDto loginDto) {
        return modelMapper.map(loginDto, User.class);
    }

    @Override
    public UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

}

