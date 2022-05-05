package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.data.JobHiredRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Component(value = ComponentConfig.Service.JOB_HIRED_RECORD)
public class JobHiredRecordService implements IService<JobHiredRecord, Long> {

    @Qualifier(ComponentConfig.DAO.JOB_HIRED_RECORD)
    @Autowired
    private Dao dao;

    @Override
    public JobHiredRecord get(Long id) {
        JobHiredRecord jobH = (JobHiredRecord) dao.get(id);
        return (JobHiredRecord) dao.get(id);
    }

    @Override
    public List<JobHiredRecord> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean exists(JobHiredRecord jobH) {
        List<JobHiredRecord> jobHs = dao.getAll();
        for (JobHiredRecord iterator : jobHs) {
            if (Objects.equals(jobH.getId(), iterator.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public JobHiredRecord save(JobHiredRecord jobH) {
        if (exists(jobH)) {
            return null;
        }
        dao.save(jobH);
        return jobH;
    }

    @Override
    public void update(JobHiredRecord jobH) {
        dao.update(jobH);
    }

    @Override
    public void delete(JobHiredRecord jobH) {
        dao.delete(jobH);
    }


}




