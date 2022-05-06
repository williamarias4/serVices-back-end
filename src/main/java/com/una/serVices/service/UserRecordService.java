package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.data.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Component(value = ComponentConfig.Service.USER_RECORD)
public class UserRecordService implements IService<UserRecord, Long> {

    @Qualifier(ComponentConfig.DAO.USER_RECORD)
    @Autowired
    private Dao dao;

    @Override
    public UserRecord get(Long id) {
        UserRecord userR = (UserRecord) dao.get(id);
        return (UserRecord) dao.get(id);
    }

    @Override
    public List<UserRecord> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean exists(UserRecord userR) {

        return false;
    }

    @Override
    public UserRecord save(UserRecord userR) {
        if (exists(userR)) {
            return null;
        }
        dao.save(userR);
        return userR;
    }

    @Override
    public void update(UserRecord userR) {
        dao.update(userR);
    }

    @Override
    public void delete(UserRecord userR) {
        dao.delete(userR);
    }


}



