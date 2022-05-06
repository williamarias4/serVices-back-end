package com.una.serVices.service;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.Dao;
import com.una.serVices.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Component(value = ComponentConfig.Service.PERSON)
public class PersonService implements IService<Person, Long> {

    @Qualifier(ComponentConfig.DAO.PERSON)
    @Autowired
    private Dao dao;

    @Override
    public Person get(Long id) {
        Person person = (Person) dao.get(id);
        return (Person) dao.get(id);
    }

    @Override
    public List<Person> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean exists(Person person) {

        return false;
    }

    @Override
    public Person save(Person person) {
        if (exists(person)) {
            return null;
        }
        dao.save(person);
        return person;
    }

    @Override
    public void update(Person person) {
        dao.update(person);
    }

    @Override
    public void delete(Person person) {
        dao.delete(person);
    }


}

