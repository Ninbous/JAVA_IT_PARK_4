package ru.itpark;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import static org.junit.Assert.*;

public class DoorsDaoJdbcImplTest {

    private DoorsDaoJdbcImpl doorsDaoJdbc;

    @Before
    public void setUp() throws Exception {
        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        doorsDaoJdbc = new DoorsDaoJdbcImpl(database);
    }

    @Test
    public void findOneTest() {
        Door actual = doorsDaoJdbc.find(1L);
        Door expected = Door.builder()
                .id(1L)
                .price(100)
                .name("Дверь_1")
                .build();

        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws Exception {
    }

}