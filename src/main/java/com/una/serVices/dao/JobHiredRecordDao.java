package com.una.serVices.dao;
import com.google.common.base.Preconditions;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.data.JobHiredRecord;
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
@Component(value = ComponentConfig.DAO.JOB_HIRED_RECORD)
public class JobHiredRecordDao extends HibernateDao implements Dao<JobHiredRecord, Long> {


    @Override
    public JobHiredRecord get(Long id) {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<JobHiredRecord> cr = cb.createQuery(JobHiredRecord.class);
        Root<JobHiredRecord> root = cr.from(JobHiredRecord.class);
        cr.select(root).where(cb.equal(root.get("id"), id));

        TypedQuery<JobHiredRecord> typed = getCurrentSession().createQuery(cr);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }


    @Override
    public List<JobHiredRecord> getAll() {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<JobHiredRecord> cq = cb.createQuery(JobHiredRecord.class);
        Root<JobHiredRecord> rootEntry = cq.from(JobHiredRecord.class);
        CriteriaQuery<JobHiredRecord> all = cq.select(rootEntry);
        TypedQuery<JobHiredRecord> allQuery = getCurrentSession().createQuery(all);
        Hibernate.initialize(allQuery.getResultList());
        return allQuery.getResultList();
    }

    @Override
    public JobHiredRecord save(JobHiredRecord jobH) {
        Preconditions.checkNotNull(jobH);
        return (JobHiredRecord) getCurrentSession().save(jobH);
    }

    @Override
    public JobHiredRecord update(JobHiredRecord jobH) {
        Preconditions.checkNotNull(jobH);
        getCurrentSession().merge(jobH);
        return jobH;
    }

    @Override
    public void delete(JobHiredRecord jobH) {
        Preconditions.checkNotNull(jobH);
        getCurrentSession().delete(jobH);
    }
}



