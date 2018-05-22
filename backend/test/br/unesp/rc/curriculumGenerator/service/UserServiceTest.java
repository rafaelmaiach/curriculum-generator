package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.model.Access;
import br.unesp.rc.curriculumGenerator.model.Contact;
import br.unesp.rc.curriculumGenerator.model.User;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

    public User generateUser() {
        User userToBeInserted = new User();
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

        return userToBeInserted;
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
        User userToBeInserted = generateUser();

        UserService userService = FactoryService.getUserService();
        int userId = userService.insertUser(userToBeInserted);

        Assert.assertNotEquals(-1, userId);
    }

    @Test
    public void insertUserDuplicateLoginTest() {
        User userDuplicateLogin = generateUser();

        UserService userService = FactoryService.getUserService();

        // First time. No problem inserting.
        int userId = userService.insertUser(userDuplicateLogin);
        Assert.assertNotEquals(-1, userId);

        // Second time. Exception will be generated and the "userId" will result -1
        userId = userService.insertUser(userDuplicateLogin);
        Assert.assertEquals(-1, userId);
    }
}
