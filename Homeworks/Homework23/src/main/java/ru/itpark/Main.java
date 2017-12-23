package ru.itpark;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        //Для PostgreSQL
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/artur_db");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "1111");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("show_sql", "true");

        //Для HSQL
//        configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
//        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:testdb");
//        configuration.setProperty("hibernate.connection.username", "sa");
//        configuration.setProperty("hibernate.connection.password", "");
//        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
//        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        // замена hbm
        configuration.addAnnotatedClass(Door.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();

        Query<Door> doorQuery =
                session.createQuery("from Door door where door.id = ?", Door.class);

        doorQuery.setParameter(0, 2L);
        Door door = doorQuery.getSingleResult();
        System.out.println(door);
    }
}
