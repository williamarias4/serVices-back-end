package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.data.Job;
import com.una.serVices.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Component(value = ComponentConfig.Service.JOB)
public class JobService implements IService<Job, Long>, IGetAllByService<Job, String> {

    @Qualifier(ComponentConfig.DAO.JOB_V_1)
    @Autowired
    private Dao dao;

    @Qualifier(ComponentConfig.DAO.USER_V_1)
    @Autowired
    private Dao dao2;

    @Override
    public Job get(Long id) {
        return null;
    }

    @Override
    public List<Job> getAll() {
        return dao.getAll();
    }

    @Override
    public List<Job> getAllBy(String user_name) {
        List<Job> jobs = getAll();
        List<Job> jobsAux = new ArrayList<>();
        for (Job job : jobs) {
            if (job.getPublisher().getUser_name().equals(user_name)) {
                jobsAux.add(job);
            }
        }
        return jobsAux;
    }

    @Override
    public boolean exists(Job job) {
        return false;
    }

    @Override
    public Job save(Job job) {
        User user = (User) dao2.get(job.getPublisher().getUser_name());
        job.setPublisher(user);
        return (Job) dao.save(job);
    }

    @Override
    public Job update(Job job) {
        return (Job) dao.update(job);
    }

    @Override
    public void delete(Job job) {

    }


}
