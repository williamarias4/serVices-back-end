package com.una.serVices.controller;

import com.una.serVices.config.APIRoute;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.data.BusinessProfile;
import com.una.serVices.data.WorkExperience;
import com.una.serVices.dto.BusinessProfileDto;
import com.una.serVices.dto.WorkExperienceDto;
import com.una.serVices.service.ISaveService;
import com.una.serVices.service.IService;
import org.hibernate.jdbc.Work;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(APIRoute.API.BUSINESS_PROFILE_V1)
public class BusinessProfileController implements IController<BusinessProfileDto, BusinessProfile> {

    @Autowired
    private ModelMapper modelMapper;

    @Qualifier(ComponentConfig.Service.BUSINESS_PROFILE)
    @Autowired
    private ISaveService service;

    @Qualifier(ComponentConfig.Service.WORK_EXPERIENCE)
    @Autowired
    private IService service2;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BusinessProfileDto save(@Valid @RequestBody BusinessProfileDto businessProfileDto){
        BusinessProfile businessProfile = convertToEntity(businessProfileDto);
        return convertToDto((BusinessProfile) service.save(businessProfile));
    }

    @PostMapping(value =APIRoute.API.WORK_EXPERIENCE_V1, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public WorkExperienceDto save(@Valid @RequestBody WorkExperienceDto workExperienceDto){
        WorkExperience workExperience = convertToEntity(workExperienceDto);
        return convertToDto((WorkExperience) service2.save(workExperience));
    }


    public WorkExperienceDto convertToDto(WorkExperience workExperience) {
        return modelMapper.map(workExperience, WorkExperienceDto.class);
    }


    public WorkExperience convertToEntity(WorkExperienceDto workExperienceDto) {
        return modelMapper.map(workExperienceDto, WorkExperience.class);
    }

    @Override
    public BusinessProfileDto convertToDto(BusinessProfile businessProfile) {
        return modelMapper.map(businessProfile, BusinessProfileDto.class);
    }

    @Override
    public BusinessProfile convertToEntity(BusinessProfileDto businessProfileDto) {
        return modelMapper.map(businessProfileDto, BusinessProfile.class);
    }
}
