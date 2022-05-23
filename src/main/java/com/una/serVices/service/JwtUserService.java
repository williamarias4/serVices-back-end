package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class JwtUserService implements UserDetailsService {

    @Qualifier(ComponentConfig.DAO.USER)
    @Autowired
    private Dao dao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.una.serVices.data.User user = (com.una.serVices.data.User) dao.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(user.getUser_name(), user.getPassword(),
                new ArrayList<>());
    }

   /* public UserDao save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }*/

}
