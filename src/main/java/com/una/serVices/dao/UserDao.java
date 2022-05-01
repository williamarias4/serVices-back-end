package com.una.serVices.dao;

import com.google.common.base.Preconditions;
import com.una.serVices.data.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Component
public class UserDao extends HibernateDao implements Dao<User, String> {


    @Override
    public User get(String user_name) {
            /*Person person = new Person();
            User user = (User) getCurrentSession().get(User.class, (Serializable) person);*/
        User user = (User) getCurrentSession().get(User.class, user_name);
        return user;
    }


    @Override
    public List<User> getAll() {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = getCurrentSession().createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public void save(User user) {
        Preconditions.checkNotNull(user);
        getCurrentSession().save(user);
    }

    @Override
    public void update(User user, String[] params) {
        Preconditions.checkNotNull(user);
        getCurrentSession().merge(user);
    }

    @Override
    public void delete(User user) {
        Preconditions.checkNotNull(user);
        getCurrentSession().delete(user);
    }
}
