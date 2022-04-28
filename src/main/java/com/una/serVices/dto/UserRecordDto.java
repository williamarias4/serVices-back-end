package com.una.serVices.dto;

import com.una.serVices.data.JobHiredRecord;
import com.una.serVices.data.User;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class UserRecordDto {

    @NotNull
    private User user;

    private Set<JobHiredRecord> jobs_hired;
}
