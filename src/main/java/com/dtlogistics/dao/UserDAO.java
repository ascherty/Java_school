package com.dtlogistics.dao;

import com.dtlogistics.config.HibernateSessionFactoryUtil;
import com.dtlogistics.models.Truck;
import com.dtlogistics.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAO extends AbstractDAO <User, Integer> {

    public User findByName (String name) {
        TypedQuery<User> query = em.createNamedQuery("User.findByName", User.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    public User findByEmail (String email) {
        TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update (User user) {
        em.merge(user);
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }
}
