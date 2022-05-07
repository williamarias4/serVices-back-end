package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.data.User;
import com.una.serVices.data.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@Component(value = ComponentConfig.Service.WORK_EXPERIENCE)
public class WorkExperienceService implements IService<WorkExperience, Long> {

    @Qualifier(ComponentConfig.DAO.USER)
    @Autowired
    private Dao dao;

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
        User user = (User) dao.get(workExperience.getBusiness_profile().getUser().getUser_name());
        WorkExperience workExperienceAux = new WorkExperience();
        workExperienceAux.setTitle(workExperience.getTitle());
        workExperienceAux.setCompany_name(workExperience.getCompany_name());
        workExperienceAux.setDescription(workExperience.getDescription());
        workExperienceAux.setStart_date(workExperience.getStart_date());
        workExperienceAux.setEnd_date(workExperience.getEnd_date());
        workExperienceAux.setBusiness_profile(user.getBusiness_profile());
        user.getBusiness_profile().getExperience().add(workExperienceAux);
        dao.update(user);
        if (exists(workExperience)) {
            return null;
        }
        dao.save(workExperience);
        return workExperience;

    }

    @Override
    public void update(WorkExperience workExperience) {
        dao.update(workExperience);
    }

    @Override
    public void delete(WorkExperience workExperience) {
        dao.delete(workExperience);
    }
}
