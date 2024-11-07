package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
//    private static SessionFactory factory;
//
//
//    protected void setUp() throws Exception {
//        // A SessionFactory is set up once for an application!
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml
//                .build();
//        try {
//            factory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//        }
//        catch (Exception e) {
//            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//            // so destroy it manually.
//            StandardServiceRegistryBuilder.destroy( registry );
//        }
//    }
//
////    static {
////        try {
////            // Create SessionFactory from hibernate.cfg.xml
////            factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pais.class).buildSessionFactory();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//    public static org.hibernate.Session getSession() {
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml
//                .build();
//        try {
//            factory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//        }
//        catch (Exception e) {
//            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//            // so destroy it manually.
//            StandardServiceRegistryBuilder.destroy( registry );
//        }
//        return factory.getCurrentSession();
//    }
//}

}