package com.una.serVices.dto;

import com.una.serVices.data.Job;
import com.una.serVices.data.User;
import com.una.serVices.data.UserRecord;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class JobHiredRecordDto {

    @NotNull
    private Job job;
    @NotNull
    private Date hire_date;
    @NotNull
    private User publisher;
    @NotNull
    private User customer;

    private UserRecord user_record;
}
