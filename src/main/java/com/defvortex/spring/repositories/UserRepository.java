package com.defvortex.spring.repositories;

import com.defvortex.spring.HibernateUtil;
import com.defvortex.spring.entitys.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    SessionFactory sessionFactory;
    Session session;

    public void save(User user) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUserById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public List<User> getListOfUsers() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("SELECT a FROM User a", User.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return users;
    }
}
