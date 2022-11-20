package com.una.serVices.dao;

import com.google.common.base.Preconditions;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.data.BusinessProfile;
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
@Component(value = ComponentConfig.DAO.BUSINESS_PROFILE_V_1)
public class BusinessProfileDao extends HibernateDao implements Dao<BusinessProfile, Long>{

    @Override
    public BusinessProfile get(Long id) {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<BusinessProfile> cr = cb.createQuery(BusinessProfile.class);
        Root<BusinessProfile> root = cr.from(BusinessProfile.class);
        cr.select(root).where(cb.equal(root.get("id"), id));

        TypedQuery<BusinessProfile> typed = getCurrentSession().createQuery(cr);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<BusinessProfile> getAll() {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<BusinessProfile> cq = cb.createQuery(BusinessProfile.class);
        Root<BusinessProfile> rootEntry = cq.from(BusinessProfile.class);
        CriteriaQuery<BusinessProfile> all = cq.select(rootEntry);
        TypedQuery<BusinessProfile> allQuery = getCurrentSession().createQuery(all);
        Hibernate.initialize(allQuery.getResultList());
        return allQuery.getResultList();
    }

    @Override
    public BusinessProfile save(BusinessProfile businessProfile) {
        Preconditions.checkNotNull(businessProfile);
        getCurrentSession().save(businessProfile);
        return businessProfile;
    }

    @Override
    public BusinessProfile update(BusinessProfile businessProfile) {
        Preconditions.checkNotNull(businessProfile);
        getCurrentSession().merge(businessProfile);
        return businessProfile;
    }

    @Override
    public void delete(BusinessProfile businessProfile) {
        Preconditions.checkNotNull(businessProfile);
        getCurrentSession().delete(businessProfile);
    }
}
