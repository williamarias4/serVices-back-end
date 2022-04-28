package com.una.serVices.service;

import com.una.serVices.dao.Dao;
import com.una.serVices.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Component
public class LoginService implements ILoginService {

    @Autowired
    private Dao dao;


    @Override
    public boolean login(User user) {
        List<User> users = new ArrayList<>();
        users = dao.getAll();
        for (User userAux : users) {
            if (userAux.getUsername().equals(user.getUsername()) && userAux.getPassword()
                    .equals(user.getPassword())) {
                return true;
            }

        }
        return false;
    }

    @Override
    public User getUserDb(User user) {
        List<User> users = new ArrayList<>();
        users = dao.getAll();
        for (User userAux : users) {
            if (userAux.getUsername().equals(user.getUsername()) && userAux.getPassword()
                    .equals(user.getPassword())) {
                return userAux;
            }

        }
        return null;
    }
}
