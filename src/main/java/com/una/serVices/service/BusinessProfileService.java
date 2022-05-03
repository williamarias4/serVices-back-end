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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        List<User> users = dao.getAll();
        List<BusinessProfile> businessProfiles = new ArrayList<>();
        for(User userAux : users){
            if(userAux.getBusiness_profile().equals(businessProfiles)){
                return true;
            }

        }
        return false;
    }

    @Override
    public BusinessProfile save(BusinessProfile businessProfile) {
        User user = (User) dao.get(businessProfile.getUser().getUser_name());
        user.getBusiness_profile().setAbout(businessProfile.getAbout());
        user.getBusiness_profile().setExperience(businessProfile.getExperience());
        user.getBusiness_profile().setJobs(businessProfile.getJobs());
        dao.update(user);
        if(exists(businessProfile)){
            return businessProfile;
        }
        return null;

    }

    @Override
    public void update(BusinessProfile businessProfile) {
        User user = (User) dao.get(businessProfile.getUser().getUser_name());
        user.getBusiness_profile().setAbout(businessProfile.getAbout());
        user.getBusiness_profile().setExperience(businessProfile.getExperience());
        user.getBusiness_profile().setJobs(businessProfile.getJobs());
        dao.update(user);
    }


    @Override
    public void delete(BusinessProfile businessProfile) {

    }
}
