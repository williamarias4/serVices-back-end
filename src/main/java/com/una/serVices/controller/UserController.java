package com.una.serVices.controller;

import com.una.serVices.config.APIRoute;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.config.jwt.JwtTokenUtil;
import com.una.serVices.data.JwtResponse;
import com.una.serVices.data.User;
import com.una.serVices.dto.LoginDto;
import com.una.serVices.dto.UserDto;
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
    private IService service;
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

    @PostMapping(value = APIRoute.Session.AUTHENTICATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginDto authenticationRequest) throws Exception {

        User user = convertToEntity(authenticationRequest);

        authenticate(user.getUser_name(), user.getPassword());

        final UserDetails userDetails = jwtUserService.loadUserByUsername(user.getUser_name());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping(value = APIRoute.Session.REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto save(@Valid @RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        return convertToDto((User) service.save(user));
    }

    @PostMapping(value = APIRoute.Session.LOG_IN, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto login(@Valid @RequestBody LoginDto loginDto) {
        User user = convertToEntity(loginDto);
        return convertToDto(login.login(user));
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

