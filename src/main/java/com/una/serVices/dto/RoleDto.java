package com.una.serVices.dto;

import com.una.serVices.data.Role;
import com.una.serVices.data.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class RoleDto {

    @NotNull
    @NotBlank
    private Role.Type type;

    private User user;
}
