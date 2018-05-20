package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Access;

public interface AccessDAO {
    final String SELECT_ACCESS_BY_USERID =
            "SELECT a.User_idUser, a.login, a.password\n" +
                    "FROM access a\n" +
                    "WHERE a.User_idUser = ?";

    public abstract Access selectAccessByUserId(int userId);
}
