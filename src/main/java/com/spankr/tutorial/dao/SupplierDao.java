/**
 *
 */
package com.spankr.tutorial.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spankr.tutorial.entity.Supplier;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author lee_vettleson
 *
 */
@Repository
@Transactional
public class SupplierDao {

    protected static Logger logger = LoggerFactory.getLogger(SupplierDao.class);

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Get all Suppliers
     *
     * @return a collection of suppliers in the system
     */
    @SuppressWarnings("unchecked")
    public List<Supplier> getAllSuppliers() {
        logger.debug("Retrieving all supplier");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM Supplier");

        // Retrieve all
        return query.list();
    }

    /**
     * Get a supplier by its id
     *
     * @param id
     * @return supplier
     */
    public Supplier get(final long id) {
        logger.debug("Retrieving supplier {}", id);

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Supplier sup = (Supplier) session.get(Supplier.class, id);
        return sup;
    }

    /**
     * Get a supplier by its name.
     * Thank you http://stackoverflow.com/questions/14977018/jpa-how-to-get-entity-based-on-field-value-other-than-id
     * @param name
     * @return supplier
     */
    public Supplier get(final String name){
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Supplier.class);
        return (Supplier)criteria.add(Restrictions.eq("name", name)).uniqueResult();
    }
    
    /**
     * Get a supplier with its parts populated
     *
     * @param id
     * @return
     */
    public Supplier getSupplierWithParts(final long id) {
        logger.debug("Retrieving supplier {}", id);

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Supplier sup = (Supplier) session.get(Supplier.class, id);
        // since parts are a lazy collection on the supplier, if you want the parts you need to call
        // the collection while the session is still active.
        // The simplest way is to call a .size() on it.
        // see http://stackoverflow.com/questions/15359306/how-to-load-lazy-fetched-items-from-hibernate-jpa-in-my-controller
        // I just drop it in the logging message below
        logger.debug("Found {}, has {} parts", sup.getName(), sup.getParts().size());
        return sup;
    }

    /**
     * Persist a supplier
     * @param s supplier to persist
     */
    public void upsert(Supplier s) {
        // Retrieve session from Hibernate
        if (s != null) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(s);
        }
    }
}
