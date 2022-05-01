package com.una.serVices.dto;

import com.una.serVices.data.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotBlank
    private String user_name;
    @NotBlank
    private String password;

    private String reset_password_token;
    @NotNull
    private Person person;
    @NotNull
    private Role role;

    private BusinessProfile business_profile;

    private UserRecord record;

    private JobHiredRecord job_hired_record_publisher;

    private JobHiredRecord job_hired_record_customer;

}
