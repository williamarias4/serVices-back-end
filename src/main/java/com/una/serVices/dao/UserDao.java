package com.una.serVices.dao;

import com.google.common.base.Preconditions;
import com.una.serVices.data.User;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
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
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root).where(cb.equal(root.get("user_name"), user_name));

        TypedQuery<User> typed = getCurrentSession().createQuery(cr);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }


    @Override
    public List<User> getAll() {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = getCurrentSession().createQuery(all);
        Hibernate.initialize(allQuery.getResultList());
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
