package ru.itpark;

import org.hibernate.SessionFactory;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

public class DoorDaoHibernateTest {

    DoorDao doorDaoHibernate;
    EntityManager entityManager;
    Door doorForDeleteTestById, doorForDeleteTestByObject;

    @Before
    public void setUp() throws Exception {

        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/artur_db");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "1111");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("show_sql", "true");

        configuration.addAnnotatedClass(Door.class);

        SessionFactory factory = configuration.buildSessionFactory();

        doorDaoHibernate = new DoorDaoHibernate(factory); //Тут создается свой ентити менеджер, почему то доступ к нему получить нельзя через .manager даже когда паблик
        entityManager = factory.createEntityManager(); //приходится создавать другой менеджер


        //Create door for test delete method
        doorForDeleteTestById = Door.builder()
                .model("doorForDeleteTestById")
                .price(50000f)
                .build();
        doorDaoHibernate.create(doorForDeleteTestById);

        //Create door for test deleteByObject method
        doorForDeleteTestByObject = Door.builder()
                .model("doorForDeleteTestByObject")
                .price(50000f)
                .build();
        doorDaoHibernate.create(doorForDeleteTestByObject);
    }


    @Test
    public void createTest() {
        Door expected = Door.builder()
                .model("Door_Amfora3453")
                .price(13400f)
                .build();
        doorDaoHibernate.create(expected);
        //language=SQL

        TypedQuery<Door> query = entityManager.createQuery("from Door door WHERE model=?",Door.class);
        query.setParameter(0,"Door_Amfora3453");
        Door actual = query.getSingleResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteTest(){

        doorDaoHibernate.delete(doorForDeleteTestById.getId());

        Door actual = entityManager.find(Door.class, doorForDeleteTestById.getId());

        Assert.assertEquals(null, actual);
    }

    @Test
    public void deleteByObjectTest(){

        doorDaoHibernate.deleteByObject(doorForDeleteTestByObject);

        Door actual = entityManager.find(Door.class, doorForDeleteTestByObject.getId());

        Assert.assertEquals(null, actual);
    }

    @After
    public void tearDown() throws Exception {
        //TODO: Удаление таблицы или откат изменений и тд.
        // entityManager.createQuery("DELETE FROM doors ").executeUpdate();
    }
}