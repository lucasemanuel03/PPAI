package org.example;

import org.example.Clases.Pais;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;

    static {
        try {
            // Create SessionFactory from hibernate.cfg.xml
            factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pais.class).buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        return factory.getCurrentSession();
    }
}

