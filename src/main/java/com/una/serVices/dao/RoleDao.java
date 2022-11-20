package com.una.serVices.dao;

import com.google.common.base.Preconditions;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.data.Role;
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
@Component(value = ComponentConfig.DAO.ROLE_V_1)
public class RoleDao extends HibernateDao implements GetDao<Role, Role.Type> {

    @Override
    public Role get(Role.Type role_type) {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Role> cr = cb.createQuery(Role.class);
        Root<Role> root = cr.from(Role.class);
        cr.select(root).where(cb.equal(root.get("type"), role_type));

        TypedQuery<Role> typed = getCurrentSession().createQuery(cr);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Role> getAll() {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> rootEntry = cq.from(Role.class);
        CriteriaQuery<Role> all = cq.select(rootEntry);
        TypedQuery<Role> allQuery = getCurrentSession().createQuery(all);
        Hibernate.initialize(allQuery.getResultList());
        return allQuery.getResultList();
    }

    public void save(Role role) {
        Preconditions.checkNotNull(role);
        getCurrentSession().save(role);
    }
}
