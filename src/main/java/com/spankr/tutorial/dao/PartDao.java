/**
 *
 */
package com.spankr.tutorial.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spankr.tutorial.entity.Part;

/**
 * @author lee_vettleson
 *
 */
@Repository
@Transactional
public class PartDao {

    protected static Logger logger = LoggerFactory.getLogger(PartDao.class);

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Get a part by its ID
     * @param id
     * @return 
     */
    public Part get(final long id) {
        logger.debug("Retrieving part {}", id);

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        return (Part) session.get(Part.class, id);
    }

    /**
     * Persist a part
     * @param p part to persist
     */
    public void upsert(Part p) {
        if (p != null) {
            logger.debug("upserting a part {}", p.getMfgNumber());
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(p);
        }
    }
}
