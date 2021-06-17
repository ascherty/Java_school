package com.dtlogistics.dao;

import com.dtlogistics.config.HibernateSessionFactoryUtil;
import com.dtlogistics.models.Driver;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DriverDAO implements DAO<Driver> {

    @Override
    public Driver findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Driver.class, id);
    }

    @Override
    public List<Driver> findAll() {
        List<Driver> drivers = (List<Driver>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Driver").list();
        return drivers;
    }

    @Override
    public void save(Driver driver) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(driver);
        t.commit();
        session.close();
    }

    @Override
    public void update(Driver driver) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(driver);
        t.commit();
        session.close();
    }

    @Override
    public void delete(Driver driver) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(driver);
        t.commit();
        session.close();
    }
}
