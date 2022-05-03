package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.data.BusinessProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Component(value = ComponentConfig.Service.BUSINESS_PROFILE)
public class BusinessProfileService implements IService<BusinessProfile, Long> {

    @Qualifier(ComponentConfig.DAO.USER)
    @Autowired
    private Dao dao;

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
