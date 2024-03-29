package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.dao.GetDao;
import com.una.serVices.data.Role;
import com.una.serVices.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Component(value = ComponentConfig.Service.USER)
public class UserService implements IService<User, String> {

    @Qualifier(ComponentConfig.DAO.USER_V_1)
    @Autowired
    private Dao dao;

    @Qualifier(ComponentConfig.DAO.ROLE_V_1)
    @Autowired
    private GetDao getDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public User get(String user_name) {
        User user = new User();
        user.setUser_name(user_name);

        if (user_name != null && exists(user)) {
            return (User) dao.get(user_name);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean exists(User user) {
        List<User> users = dao.getAll();
        for (User iterator : users) {
            if (Objects.equals(user.getUser_name(), iterator.getUser_name())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User save(User user) {
        /*if (exists(user)) {
            throw new RuntimeException("User already exists");
        }*/
        String pass = user.getPassword();
        user.setPassword(bcryptEncoder.encode(pass));
        if (user.getRole().getType() != null) {
            Role.Type role_type = user.getRole().getType();
            Role role = (Role) getDao.get(role_type);
            if (role.getType().equals(role_type)) {
                user.setRole(role);
                return (User) dao.save(user);
            }
        }
        throw new RuntimeException("Role not valid");
    }

    @Override
    public User update(User user) {
        return (User) dao.update(user);
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }


}
