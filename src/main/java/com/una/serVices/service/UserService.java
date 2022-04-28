package com.una.serVices.service;

import com.una.serVices.dao.Dao;
import com.una.serVices.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@Component
public class UserService implements IService<User> {

    @Autowired
    private Dao dao;

    @Override
    public Optional<User> get(int id) {
        return dao.get(id);
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean exists(User user) {
        List<User> users = dao.getAll();
        for(User iterator : users){
            if(Objects.equals(user.getPerson().getId(), iterator.getPerson().getId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }

    @Override
    public void update(User user, String[] params) {
        dao.update(user, params);
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }


}
