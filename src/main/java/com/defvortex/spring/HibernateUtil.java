package com.defvortex.spring;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate/hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Error to create session factory");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

