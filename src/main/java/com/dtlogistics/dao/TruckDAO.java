package com.dtlogistics.dao;

import com.dtlogistics.models.Truck;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TruckDAO extends AbstractDAO<Truck, Integer> {

    @Override
    public Truck findById(Integer id) {
        return em.find(Truck.class, id);
    }

    public Truck findByNumber (String number) {
        TypedQuery<Truck> query = em.createNamedQuery("Truck.findByNumber", Truck.class);
        query.setParameter("number", number);
        return query.getSingleResult();
    }

    @Override
    public List<Truck> findAll() {
        return em.createQuery("From Truck", Truck.class).getResultList();
    }

    @Override
    public void save(Truck truck) {
        em.persist(truck);
    }

    @Override
    public void update(Truck truck) {
        em.merge(truck);
    }

    @Override
    public void delete(Truck truck) {
        em.remove(truck);
    }
}
