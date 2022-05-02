package com.una.serVices.service;

import com.una.serVices.data.BusinessProfile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public class BusinessProfileService implements IService<BusinessProfile, Long> {


    @Override
    public BusinessProfile get(Long id) {
        return null;
    }

    @Override
    public List<BusinessProfile> getAll() {
        return null;
    }

    @Override
    public boolean exists(BusinessProfile businessProfile) {
        return false;
    }

    @Override
    public BusinessProfile save(BusinessProfile businessProfile) throws Exception {
        return null;
    }

    @Override
    public void update(BusinessProfile businessProfile, String[] params) {

    }

    @Override
    public void delete(BusinessProfile businessProfile) {

    }
}
