package com.una.serVices.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {

    @NotBlank
    private String user_name;
    @NotBlank
    private String password;
}
