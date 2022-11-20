package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Component
public class LoginService implements ILoginService {

    @Qualifier(ComponentConfig.DAO.USER_V_1)
    @Autowired
    private Dao dao;

    @Override
    public User login(User user) {
        List<User> users = new ArrayList<>();
        users = dao.getAll();
        for (User userAux : users) {
            if (userAux.getUser_name().equals(user.getUser_name()) && BCrypt.checkpw(user.getPassword(),
                    userAux.getPassword())) {
                return userAux;
            }

        }
        return null;
    }

    @Override
    public User getUserDb(User user) {
        List<User> users = new ArrayList<>();
        users = dao.getAll();
        for (User userAux : users) {
            if (userAux.getUser_name().equals(user.getUser_name())) {
                return userAux;
            }

        }
        return null;
    }
}
