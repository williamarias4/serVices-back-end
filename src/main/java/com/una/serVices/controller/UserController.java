package com.una.serVices.controller;

import com.una.serVices.config.APIRoute;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.config.jwt.JwtTokenUtil;
import com.una.serVices.data.JwtResponse;
import com.una.serVices.data.User;
import com.una.serVices.dto.LoginDto;
import com.una.serVices.dto.UserDto;
import com.una.serVices.mapper.LoginMapper;
import com.una.serVices.mapper.UserMapper;
import com.una.serVices.service.ILoginService;
import com.una.serVices.service.IService;
import com.una.serVices.service.JwtUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(APIRoute.API.USERS_V1)
@CrossOrigin
public class UserController implements IController<UserDto, User> {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserService jwtUserService;
    @Autowired
    private ModelMapper modelMapper;
    @Qualifier(ComponentConfig.Service.USER)
    @Autowired
    private IService<User, String> service;
    @Autowired
    private ILoginService login;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LoginMapper loginMapper;

    @GetMapping(APIRoute.Session.GET_BY_USER_NAME)
    public ResponseEntity<UserDto> getByUsername(@PathVariable String user_name) {
        User user = service.get(user_name);
        return ResponseEntity.ok(userMapper.convertToDto(user));
    }

    @GetMapping(APIRoute.RestAPI.GET_ALL)
    public List<UserDto> getAllUsers() {
        return service.getAll().stream().map(user -> modelMapper
                .map(user, UserDto.class)).collect(Collectors.toList());
    }

    @PostMapping(value = APIRoute.Session.AUTHENTICATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginDto authenticationRequest) throws Exception {

        User user = loginMapper.convertToEntity(authenticationRequest);

        authenticate(user.getUser_name(), user.getPassword());

        final UserDetails userDetails = jwtUserService.loadUserByUsername(user.getUser_name());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping(value = APIRoute.Session.REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto save(@Valid @RequestBody UserDto userDto) {
        User user = userMapper.convertToEntity(userDto);
        return userMapper.convertToDto(service.save(user));
    }

    @PostMapping(value = APIRoute.Session.LOG_IN, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDto> login(@Valid @RequestBody LoginDto loginDto) {
        User user = loginMapper.convertToEntity(loginDto);
        User loggedInUser = login.login(user);
        return ResponseEntity.ok(userMapper.convertToDto(loggedInUser));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @Deprecated
    public User convertToEntity(LoginDto loginDto) {
        return modelMapper.map(loginDto, User.class);
    }

    @Deprecated
    @Override
    public UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Deprecated
    @Override
    public User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

}

