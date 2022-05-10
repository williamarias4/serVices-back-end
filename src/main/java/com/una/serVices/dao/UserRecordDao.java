package com.una.serVices.dao;
import com.google.common.base.Preconditions;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.data.UserRecord;
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
@Component(value = ComponentConfig.DAO.USER_RECORD)
public class UserRecordDao extends HibernateDao implements Dao<UserRecord, Long> {


    @Override
    public UserRecord get(Long id) {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<UserRecord> cr = cb.createQuery(UserRecord.class);
        Root<UserRecord> root = cr.from(UserRecord.class);
        cr.select(root).where(cb.equal(root.get("id"), id));

        TypedQuery<UserRecord> typed = getCurrentSession().createQuery(cr);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }


    @Override
    public List<UserRecord> getAll() {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<UserRecord> cq = cb.createQuery(UserRecord.class);
        Root<UserRecord> rootEntry = cq.from(UserRecord.class);
        CriteriaQuery<UserRecord> all = cq.select(rootEntry);
        TypedQuery<UserRecord> allQuery = getCurrentSession().createQuery(all);
        Hibernate.initialize(allQuery.getResultList());
        return allQuery.getResultList();
    }

    @Override
    public UserRecord save(UserRecord userR) {
        Preconditions.checkNotNull(userR);
        return (UserRecord) getCurrentSession().save(userR);
    }

    @Override
    public void update(UserRecord userR) {
        Preconditions.checkNotNull(userR);
        getCurrentSession().merge(userR);
    }

    @Override
    public void delete(UserRecord userR) {
        Preconditions.checkNotNull(userR);
        getCurrentSession().delete(userR);
    }
}



