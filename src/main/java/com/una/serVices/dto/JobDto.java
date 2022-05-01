package com.una.serVices.dto;

import com.una.serVices.data.BusinessProfile;
import com.una.serVices.data.JobHiredRecord;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Data
public class JobDto {

    private long id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String category;
    @NotNull
    private BigDecimal price;
    @NotNull
    private boolean active;

    Set<BusinessProfile> business_profile;

    private JobHiredRecord jobs_hired_record;
}
