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
     * Get all Vendors
     *
     * @return
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
     * Get a vendor by its id
     *
     * @param id
     * @return
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
     * Get a vendor by its id
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
        logger.debug("Found {}, has {} parts", sup.getName(), sup.getParts().size());
        return sup;
    }

}
