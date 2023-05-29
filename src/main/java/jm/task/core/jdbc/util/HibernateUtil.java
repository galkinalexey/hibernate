package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {

        if(sessionFactory == null) {

            try {
                Configuration config = new Configuration();

                Properties properties = new Properties();
                properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/database1");
                properties.setProperty(Environment.USER, "root");
                properties.setProperty(Environment.PASS, "root");
                properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

                properties.setProperty(Environment.SHOW_SQL, "true");

                properties.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                properties.setProperty(Environment.HBM2DDL_AUTO, "create-drop");

                config.setProperties(properties);

                config.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(config.getProperties())
                        .build();

                sessionFactory = config.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return sessionFactory;

    }


}
