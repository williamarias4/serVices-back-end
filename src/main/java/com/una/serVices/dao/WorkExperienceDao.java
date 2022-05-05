package com.una.serVices.dao;

import com.google.common.base.Preconditions;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.data.WorkExperience;
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
@Component(value = ComponentConfig.DAO.WORK_EXPERIENCE )
public class WorkExperienceDao extends HibernateDao implements Dao<WorkExperience, Long> {


    @Override
    public WorkExperience get(Long id) {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<WorkExperience> cr = cb.createQuery(WorkExperience.class);
        Root<WorkExperience> root = cr.from(WorkExperience.class);
        cr.select(root).where(cb.equal(root.get("id"), id));

        TypedQuery<WorkExperience> typed = getCurrentSession().createQuery(cr);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }


    @Override
    public List<WorkExperience> getAll() {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<WorkExperience> cq = cb.createQuery(WorkExperience.class);
        Root<WorkExperience> rootEntry = cq.from(WorkExperience.class);
        CriteriaQuery<WorkExperience> all = cq.select(rootEntry);
        TypedQuery<WorkExperience> allQuery = getCurrentSession().createQuery(all);
        Hibernate.initialize(allQuery.getResultList());
        return allQuery.getResultList();
    }

    @Override
    public void save(WorkExperience work) {
        Preconditions.checkNotNull(work);
        getCurrentSession().save(work);
    }

    @Override
    public void update(WorkExperience work) {
        Preconditions.checkNotNull(work);
        getCurrentSession().update(work);
    }

    @Override
    public void delete(WorkExperience work) {
        Preconditions.checkNotNull(work);
        getCurrentSession().delete(work);
    }
}


