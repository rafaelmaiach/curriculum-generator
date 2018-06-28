package br.unesp.rc.curriculumGenerator.utils;

import org.junit.*;

import java.sql.Connection;

public class FactoryConnectionTest {
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConnection() {
        Connection connection = FactoryConnection.getConnection();
        Assert.assertNotNull(connection);
    }
}
