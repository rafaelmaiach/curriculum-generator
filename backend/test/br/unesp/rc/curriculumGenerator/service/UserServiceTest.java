package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.model.User;
import org.junit.*;

public class UserServiceTest {
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
    public void selectUserByLoginTest() {
        UserService userService = FactoryService.getUserService();
        User user = userService.selectUserByLogin("vedoveto", "123456");

        // Assert objects not null
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getContact());
        Assert.assertNotNull(user.getAccess());
    }
}
