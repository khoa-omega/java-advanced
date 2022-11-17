package com.vti.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory factory;

    public static Session openSession() {
        if (factory == null || factory.isClosed()) {
            Configuration configuration = new Configuration().configure();
            configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
            factory = configuration.buildSessionFactory();
        }
        return factory.openSession();
    }

    public static void closeFactory() {
        if (factory != null) {
            factory.close();
        }
    }
}
