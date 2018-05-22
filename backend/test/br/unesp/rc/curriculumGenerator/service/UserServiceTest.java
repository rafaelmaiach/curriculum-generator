package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.model.Access;
import br.unesp.rc.curriculumGenerator.model.Contact;
import br.unesp.rc.curriculumGenerator.model.User;
import org.junit.*;

public class UserServiceTest {
    User userToBeInserted;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        userToBeInserted = new User();
        userToBeInserted.setName("NAME TEST INSERT");
        userToBeInserted.setCountry("COUNTRY TEST INSERT");
        userToBeInserted.setState("STATE TEST INSERT");
        userToBeInserted.setCity("CITY TEST INSERT");

        Contact contact = new Contact();
        contact.setCellPhone("TEST INSERT 999");
        contact.setEmail("testinsert@test.com");
        contact.setGithub("www.github.com/testinsert");
        contact.setLinkedin("test insert");
        userToBeInserted.setContact(contact);

        Access access = new Access();
        String fakeLogin = Long.toHexString(Double.doubleToLongBits(Math.random())); //Generates Fake Login so we don't have problem with UNIQUE KEY at database
        access.setLogin(fakeLogin);
        access.setPassword("pass");
        userToBeInserted.setAccess(access);
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

    @Test
    public void insertUserTest() {
        UserService userService = FactoryService.getUserService();
        int userId = userService.insertUser(userToBeInserted);

        Assert.assertNotEquals(-1, userId);
    }
}
