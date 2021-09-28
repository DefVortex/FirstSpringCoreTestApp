package com.defvortex.spring.repositories;

import com.defvortex.spring.HibernateUtil;
import com.defvortex.spring.entitys.Item;
import com.defvortex.spring.entitys.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {
    Session session;

    public void save(Item item) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    public Item getItemById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Item item = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public List<Item> getListOfItems() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Item> items = session.createQuery("SELECT a FROM Item a", Item.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return items;
    }
}
