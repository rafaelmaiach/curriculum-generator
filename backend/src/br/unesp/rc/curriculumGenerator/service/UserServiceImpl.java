package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.DAO.FactoryDAO;
import br.unesp.rc.curriculumGenerator.DAO.UserDAO;
import br.unesp.rc.curriculumGenerator.model.User;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = FactoryDAO.getUserDAO();
    }

    /**
     * @param login    The user's login
     * @param password The user's password
     * @return The user that owns the given login and password
     */
    @Override
    public User selectUserByLogin(String login, String password) {
        User user = null;

        user = this.userDAO.selectUserByLogin(login, password);

        return user;
    }

    /**
     * Insert a new User to the database
     * @param user The User class with the informations that will be inserted to the database
     * @return The new user Id in the databasse if successfull. -1 if failed.
     */
    @Override
    public int insertUser(User user) {
        int userId = 0;

        userId = this.userDAO.insertUser(user);

        return userId;
    }
}
