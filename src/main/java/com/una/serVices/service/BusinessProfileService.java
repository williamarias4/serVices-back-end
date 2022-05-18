package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.data.BusinessProfile;
import com.una.serVices.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Component(value = ComponentConfig.Service.BUSINESS_PROFILE)
public class BusinessProfileService implements ISaveService<BusinessProfile> {

    @Qualifier(ComponentConfig.DAO.BUSINESS_PROFILE)
    @Autowired
    private Dao dao;

    @Qualifier(ComponentConfig.DAO.USER)
    @Autowired
    private Dao dao2;

    @Override
    public boolean exists(BusinessProfile businessProfile) {
        List<User> users = dao2.getAll();
        for (User userAux : users) {
            if (userAux.getUser_name().equals(businessProfile.getUser().getUser_name()) && userAux.getBusiness_profile() != null) {
                return true;
            }

        }
        return false;
    }

    @Override
    public BusinessProfile save(BusinessProfile businessProfile) {
        if (exists(businessProfile)) {
            throw new RuntimeException("Business Profile already exists");
        }
        User user = (User) dao2.get(businessProfile.getUser().getUser_name());
        BusinessProfile businessProfileAux = new BusinessProfile();
        businessProfileAux.setAbout(businessProfile.getAbout());
        businessProfileAux.setExperience(businessProfile.getExperience());
        businessProfileAux.setJobs(businessProfile.getJobs());
        businessProfileAux.setUser(user);
        user.setBusiness_profile(businessProfileAux);
        dao2.update(user);
        if (exists(businessProfile)) {
            User userAux = (User) dao2.get(businessProfile.getUser().getUser_name());
            return userAux.getBusiness_profile();
        }
        return null;

    }

    @Override
    public BusinessProfile update(BusinessProfile businessProfile) {
        return (BusinessProfile) dao.update(businessProfile);
    }

}
