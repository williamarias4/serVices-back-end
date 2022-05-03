package com.una.serVices.controller;

import com.una.serVices.config.APIRoute;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.data.BusinessProfile;
import com.una.serVices.data.User;
import com.una.serVices.dto.BusinessProfileDto;
import com.una.serVices.dto.UserDto;
import com.una.serVices.service.IService;
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
public class BusinessProfileController implements IController<BusinessProfileDto, BusinessProfile>{

    @Autowired
    private ModelMapper modelMapper;

    @Qualifier(ComponentConfig.Service.USER)
    @Autowired
    private IService service;

    @Qualifier(ComponentConfig.Service.BUSINESS_PROFILE)
    @Autowired
    private IService service2;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@Valid @RequestBody BusinessProfileDto businessProfileDto) throws Exception {
        service2.save(businessProfileDto);
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
