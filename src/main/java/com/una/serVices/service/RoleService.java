package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.data.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Component(value = ComponentConfig.Service.ROLE)
public class RoleService implements IService<Role, Long> {

    @Qualifier(ComponentConfig.DAO.ROLE)
    @Autowired
    private Dao dao;

    @Override
    public Role get(Long id) {
        Role person = (Role) dao.get(id);
        return (Role) dao.get(id);
    }

    @Override
    public List<Role> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean exists(Role role) {
        List<Role> roles = dao.getAll();
        for (Role iterator : roles) {
            if (Objects.equals(role.getId(), iterator.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Role save(Role role) {
        if (exists(role)) {
            return null;
        }
        dao.save(role);
        return role;
    }

    @Override
    public void update(Role role) {
        dao.update(role);
    }

    @Override
    public void delete(Role role) {
        dao.delete(role);
    }


}


