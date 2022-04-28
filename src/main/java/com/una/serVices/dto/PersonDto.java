package com.una.serVices.dto;

import com.una.serVices.data.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PersonDto {

    @NotNull
    @NotEmpty
    private int id;
    @NotBlank
    private String full_name;
    @NotBlank
    private String email;
    @NotBlank
    private String cell_phone;
    @NotBlank
    private String province;
    @NotBlank
    private String address;
    @NotNull
    private Date birth_date;

    private User user;
}
