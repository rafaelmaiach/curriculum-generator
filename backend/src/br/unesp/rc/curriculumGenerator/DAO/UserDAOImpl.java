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
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (con != null) {
            try {
                preparedStatement = con.prepareStatement(SELECT_USER_BY_LOGIN);
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    // Get user data
                    userReturn = new User();
                    userReturn.setIdUser(resultSet.getInt(1));
                    userReturn.setName(resultSet.getString(2));
                    userReturn.setCountry(resultSet.getString(3));
                    userReturn.setState(resultSet.getString(4));
                    userReturn.setCity(resultSet.getString(5));

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
