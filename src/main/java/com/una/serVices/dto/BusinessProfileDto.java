package com.una.serVices.dto;

import com.una.serVices.data.Job;
import com.una.serVices.data.User;
import com.una.serVices.data.WorkExperience;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class BusinessProfileDto {

    @NotBlank
    private String about;

    private Set<WorkExperience> experience;

    private Set<Job> jobs;

    @NotNull
    private User user;
}
