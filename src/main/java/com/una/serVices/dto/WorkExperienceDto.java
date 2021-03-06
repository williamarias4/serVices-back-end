package com.una.serVices.dto;

import com.una.serVices.data.BusinessProfile;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class WorkExperienceDto {


    private long id;
    @NotBlank
    private String title;
    @NotBlank
    private String company_name;
    @NotNull
    private Date start_date;
    @NotNull
    private Date end_date;
    @NotBlank
    private String description;
    @NotNull
    private BusinessProfile business_profile;
}
