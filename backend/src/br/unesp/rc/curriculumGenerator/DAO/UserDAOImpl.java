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

    @Override
    public int insertUser(User user) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int userId = -1;

        con = FactoryConnection.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                preparedStatement = con.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);

                // Insert user
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getCountry());
                preparedStatement.setString(3, user.getState());
                preparedStatement.setString(4, user.getCity());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    userId = resultSet.getInt(1);
                }

                // Insert access
                AccessDAO accessDAO = new AccessDAOImpl();
                accessDAO.insertAccess(con, user.getAccess(), userId);

                // Insert contact
                ContactDAO contactDAO = new ContactDAOImpl();
                contactDAO.insertContact(con, user.getContact(), userId);

                con.commit();
            } catch (SQLException ex) {

                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                System.err.println("ERROR inserting user. Message: " + ex.getMessage());
                return -1;
            }
        }

        return userId;
    }
}
