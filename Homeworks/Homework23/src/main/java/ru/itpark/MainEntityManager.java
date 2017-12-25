package ru.itpark;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MainEntityManager {
    public static void main(String[] args) {
       // EntityManagerFactory entityManagerFactory =
     //           Persistence.createEntityManagerFactory( "persistence" );

        Configuration configuration = new Configuration();

        //Для PostgreSQL
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/artur_db");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "1111");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("show_sql", "true");

        configuration.addAnnotatedClass(Door.class);

        SessionFactory factory = configuration.buildSessionFactory();

        EntityManager entityManager = factory.createEntityManager();


        entityManager.getTransaction().begin();
        Door user = Door.builder()
                .price(230f)
                .model("Марсель")
                .build();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        TypedQuery<Door> doorQuery = entityManager.createQuery("from Door", Door.class);
        List<Door> doorList = doorQuery.getResultList();
        System.out.println(doorList);
    }
}