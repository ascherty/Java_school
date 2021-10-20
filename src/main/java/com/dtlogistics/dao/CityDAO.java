package com.dtlogistics.dao;

import com.dtlogistics.config.HibernateSessionFactoryUtil;
import com.dtlogistics.models.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDAO extends AbstractDAO<City, Integer> {

    public City findById(int id) {
        return em.find(City.class, id);
    }

    @Override
    public List<City> findAll() {
        List<City> cities = (List<City>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From City").list();
        return cities;
    }

    @Override
    public void save(City city) {

    }

    @Override
    public void update(City city) {
        em.merge(city);
    }

    @Override
    public void delete(City city) {
        em.remove(city);
    }
}
