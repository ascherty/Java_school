package com.dtlogistics.dao;

import com.dtlogistics.config.HibernateSessionFactoryUtil;
import com.dtlogistics.models.Truck;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TruckDAO implements DAO<Truck> {

    @Override
    public Truck findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Truck.class, id);
    }

    @Override
    public List<Truck> findAll() {
        List<Truck> trucks = (List<Truck>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Truck").list();
        return trucks;
    }

    @Override
    public void save(Truck truck) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(truck);
        t.commit();
        session.close();
    }

    @Override
    public void update(Truck truck) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(truck);
        t.commit();
        session.close();
    }

    @Override
    public void delete(Truck truck) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(truck);
        t.commit();
        session.close();
    }
}
