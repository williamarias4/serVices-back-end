package com.una.serVices.dao;
import com.google.common.base.Preconditions;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.data.Job;
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
@Component(value = ComponentConfig.DAO.JOB)
public class JobDao extends HibernateDao implements Dao<Job, Long> {


    @Override
    public Job get(Long job_id) {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Job> cr = cb.createQuery(Job.class);
        Root<Job> root = cr.from(Job.class);
        cr.select(root).where(cb.equal(root.get("job_id"), job_id));

        TypedQuery<Job> typed = getCurrentSession().createQuery(cr);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }


    @Override
    public List<Job> getAll() {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Job> cq = cb.createQuery(Job.class);
        Root<Job> rootEntry = cq.from(Job.class);
        CriteriaQuery<Job> all = cq.select(rootEntry);
        TypedQuery<Job> allQuery = getCurrentSession().createQuery(all);
        Hibernate.initialize(allQuery.getResultList());
        return allQuery.getResultList();
    }

    @Override
    public Job save(Job job) {
        Preconditions.checkNotNull(job);
        getCurrentSession().save(job);
        return job;
    }

    @Override
    public void update(Job job) {
        Preconditions.checkNotNull(job);
        getCurrentSession().merge(job);
    }

    @Override
    public void delete(Job job) {
        Preconditions.checkNotNull(job);
        getCurrentSession().delete(job);
    }
}



