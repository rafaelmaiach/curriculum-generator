package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.User;

public interface UserDAO {
    final String SELECT_USER_BY_LOGIN =
            "SELECT idUser, name, country, state, city\n" +
                    "FROM user u\n" +
                    "   INNER JOIN access a ON u.idUser = a.User_idUser\n" +
                    "WHERE a.login = ?" +
                    "      and a.password = ?";

    final String INSERT_USER =
            "INSERT INTO user(name, country, state, city) " +
                    "VALUES(?, ?, ?, ?)";

    public abstract User selectUserByLogin(String login, String password);

    public abstract int insertUser(User user);
}
