package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Contact;

public interface ContactDAO {
    final String SELECT_CONTACT_BY_USERID =
            "SELECT c.User_idUser, c.cellPhone, c.email, c.github, c.linkedin\n" +
                    "FROM contact c\n" +
                    "WHERE c.User_idUser = ?";

    public abstract Contact selectContactByUserId(int userId);
}
