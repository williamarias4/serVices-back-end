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
            return null;
        }
        User userAux = (User) dao.get(businessProfile.getUser().getUser_name());
        BusinessProfile businessProfileAux = new BusinessProfile();
        businessProfileAux.setAbout(businessProfile.getAbout());
        businessProfileAux.setExperience(businessProfile.getExperience());
        businessProfileAux.setJobs(businessProfile.getJobs());
        businessProfileAux.setUser(userAux);
        userAux.setBusiness_profile(businessProfileAux);
        dao.update(userAux);
        if (exists(businessProfile)) {
            User user = (User) dao.get(businessProfile.getUser().getUser_name());
            return user.getBusiness_profile();
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
