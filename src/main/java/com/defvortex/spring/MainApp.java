package com.defvortex.spring;

import com.defvortex.spring.entitys.Item;
import com.defvortex.spring.entitys.User;
import com.defvortex.spring.services.ItemService;
import com.defvortex.spring.services.UserService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.defvortex.spring")
public class MainApp {

    @Bean
    SessionFactory getSessionFactory() {
        try {
            return new org.hibernate.cfg.Configuration()
                    .configure("hibernate/hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void main(String[] args) {
        InitializeData.forcePrepareData();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainApp.class);

        UserService userService = applicationContext.getBean("userService", UserService.class);
        ItemService itemService = applicationContext.getBean("itemService", ItemService.class);

        userService.save(new User("Thor", 14));
        itemService.save(new Item("Maul", 140L));

        System.out.println(userService.getListOfUsers().toString());
        System.out.println("/------------------------------------/");
        System.out.println(itemService.getListOfItems().toString());


    }
}
