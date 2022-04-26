package com.una.serVices.dto;

import com.una.serVices.data.BusinessProfile;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class JobDto {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String Category;
    @NotNull
    private BigDecimal price;

    private BusinessProfile business_profile;
}
