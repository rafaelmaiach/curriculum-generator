package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Contact;
import br.unesp.rc.curriculumGenerator.utils.FactoryConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAOImpl implements ContactDAO {

    /**
     * @param userId The user's Id to database
     * @return The The user's Contact
     */
    @Override
    public Contact selectContactByUserId(int userId) {
        Connection con = FactoryConnection.getConnection();
        Contact contactReturn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (con != null) {
            try {
                preparedStatement = con.prepareStatement(SELECT_CONTACT_BY_USERID);
                preparedStatement.setInt(1, userId);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    // Get Contact data
                    contactReturn = new Contact();
                    contactReturn.setCellPhone(resultSet.getString(2));
                    contactReturn.setEmail(resultSet.getString(3));
                    contactReturn.setGithub(resultSet.getString(4));
                    contactReturn.setLinkedin(resultSet.getString(5));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return contactReturn;
    }

    /**
     * Insert a new Ability to the database
     *
     * @param con     the connection to the database
     * @param contact Contact class with the informations that will be inserted to the database
     * @param userId  The user's Id that owns the contact
     * @throws SQLException
     */
    @Override
    public void insertContact(Connection con, Contact contact, int userId) throws SQLException {
        PreparedStatement preparedStatement = null;
        preparedStatement = con.prepareStatement(INSERT_CONTACT);

        preparedStatement.setInt(1, userId);
        preparedStatement.setString(2, contact.getCellPhone());
        preparedStatement.setString(3, contact.getEmail());
        preparedStatement.setString(4, contact.getGithub());
        preparedStatement.setString(5, contact.getLinkedin());
        preparedStatement.executeUpdate();
    }
}
