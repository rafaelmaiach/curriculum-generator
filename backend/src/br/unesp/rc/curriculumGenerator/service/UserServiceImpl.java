package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.DAO.FactoryDAO;
import br.unesp.rc.curriculumGenerator.DAO.UserDAO;
import br.unesp.rc.curriculumGenerator.model.User;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = FactoryDAO.getUserDAO();
    }

    @Override
    public User selectUserByLogin(String login, String password) {
        User user = null;

        user = this.userDAO.selectUserByLogin(login, password);

        return user;
    }
}
