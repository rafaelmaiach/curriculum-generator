package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Access;
import br.unesp.rc.curriculumGenerator.model.Contact;
import br.unesp.rc.curriculumGenerator.model.User;
import br.unesp.rc.curriculumGenerator.utils.FactoryConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    @Override
    public User selectUserByLogin(String login, String password) {
        Connection con = FactoryConnection.getConnection();
        User userReturn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_USER_BY_LOGIN);
                pstm.setString(1, login);
                pstm.setString(2, password);

                res = pstm.executeQuery();
                while (res.next()) {
                    // Get user data
                    userReturn = new User();
                    userReturn.setIdUser(res.getInt(1));
                    userReturn.setName(res.getString(2));
                    userReturn.setCountry(res.getString(3));
                    userReturn.setState(res.getString(4));
                    userReturn.setCity(res.getString(5));

                    // Select access
                    AccessDAO accessDAO = new AccessDAOImpl();
                    Access accessReturn = accessDAO.selectAccessByUserId(userReturn.getIdUser());
                    userReturn.setAccess(accessReturn);

                    // Select contact
                    ContactDAO contactDAO = new ContactDAOImpl();
                    Contact contactReturn = contactDAO.selectContactByUserId(userReturn.getIdUser());
                    userReturn.setContact(contactReturn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return userReturn;
    }
}
