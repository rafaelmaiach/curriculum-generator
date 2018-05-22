package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Access;

import java.sql.Connection;
import java.sql.SQLException;

public interface AccessDAO {
    final String SELECT_ACCESS_BY_USERID =
            "SELECT a.User_idUser, a.login, a.password\n" +
                    "FROM access a\n" +
                    "WHERE a.User_idUser = ?";

    final String INSERT_ACCESS =
            "INSERT INTO access(User_idUser, login, password) " +
                    "VALUES(?, ?, ?)";

    public abstract Access selectAccessByUserId(int userId);

    public abstract void insertAccess(Connection con, Access access, int userId) throws SQLException;
}
