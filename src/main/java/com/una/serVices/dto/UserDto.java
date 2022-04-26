package com.una.serVices.dto;

import com.una.serVices.data.BusinessProfile;
import com.una.serVices.data.Person;
import com.una.serVices.data.Role;
import com.una.serVices.data.UserRecord;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String reset_password_token;
    @NotNull
    private Person person;
    @NotNull
    private Role role;

    private BusinessProfile business_profile;

    private UserRecord record;
}
