package com.dtlogistics.dao;

import com.dtlogistics.config.HibernateSessionFactoryUtil;
import com.dtlogistics.models.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractDAO<T, K> {

    @PersistenceContext
    protected EntityManager em;

    T findById(K id) {
        return null;
    }

    List<T> findAll() {
        return null;
    }

    void save(T t) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction transac = session.beginTransaction();
//        session.save(t);
//        transac.commit();
//        session.close();
        em.persist(t);
    }

    void update(T t) {
        em.merge(t);
    }

    void delete(T t) {
        em.remove(t);
    }

}