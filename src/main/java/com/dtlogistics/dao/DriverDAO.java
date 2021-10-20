package com.dtlogistics.dao;

import com.dtlogistics.models.Driver;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DriverDAO extends AbstractDAO<Driver, Integer> {

    @Override
    public Driver findById(Integer id) {
        return em.find(Driver.class, id);
    }

    public Driver findByPrivateNumber (String privateNumber) {
        TypedQuery<Driver> query = em.createNamedQuery("Driver.findByPrivateNumber", Driver.class);
        query.setParameter("privateNumber", privateNumber);
        return query.getSingleResult();
    }

    @Override
    public List<Driver> findAll() {
        return em.createQuery("From Driver", Driver.class).getResultList();
    }

    @Override
    public void save(Driver driver) {
        em.persist(driver);
    }

    @Override
    public void update(Driver driver) {
        em.merge(driver);
    }

    @Override
    public void delete(Driver driver) {
        em.remove(driver);
    }
}
