package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.model.User;

public interface UserService {
    public abstract User selectUserByLogin(String login, String password);

    public abstract int insertUser(User user);
}
