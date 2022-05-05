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
@Component(value = ComponentConfig.DAO.ROLE)
public class RoleDao extends HibernateDao implements Dao<Role, Long> {


    @Override
    public Role get(Long id) {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Role> cr = cb.createQuery(Role.class);
        Root<Role> root = cr.from(Role.class);
        cr.select(root).where(cb.equal(root.get("id"), id));

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

    @Override
    public void save(Role rol) {
        Preconditions.checkNotNull(rol);
        getCurrentSession().save(rol);
    }

    @Override
    public void update(Role rol) {
        Preconditions.checkNotNull(rol);
        getCurrentSession().update(rol);
    }

    @Override
    public void delete(Role rol) {
        Preconditions.checkNotNull(rol);
        getCurrentSession().delete(rol);
    }
}


