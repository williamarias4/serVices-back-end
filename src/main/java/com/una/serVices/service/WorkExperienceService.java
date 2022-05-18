package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.data.BusinessProfile;
import com.una.serVices.data.User;
import com.una.serVices.data.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Component(value = ComponentConfig.Service.WORK_EXPERIENCE)
public class WorkExperienceService implements IService<WorkExperience, Long> {

    @Qualifier(ComponentConfig.DAO.WORK_EXPERIENCE)
    @Autowired
    private Dao dao;

    @Qualifier(ComponentConfig.DAO.BUSINESS_PROFILE)
    @Autowired
    private Dao dao2;

    @Override
    public WorkExperience get(Long id) {
        return null;
    }

    @Override
    public List<WorkExperience> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean exists(WorkExperience workExperience) {
        return false;
    }

    @Override
    public WorkExperience save(WorkExperience workExperience) {
        BusinessProfile businessProfile = (BusinessProfile) dao2.get(workExperience.getBusiness_profile().getId());
        workExperience.setBusiness_profile(businessProfile);
        return (WorkExperience) dao.save(workExperience);
    }

    @Override
    public WorkExperience update(WorkExperience workExperience) {
        return (WorkExperience) dao.update(workExperience);
    }

    @Override
    public void delete(WorkExperience workExperience) {
        dao.delete(workExperience);
    }
}
