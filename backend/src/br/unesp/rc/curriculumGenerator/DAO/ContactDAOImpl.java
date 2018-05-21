package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Contact;
import br.unesp.rc.curriculumGenerator.utils.FactoryConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAOImpl implements ContactDAO {
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
                    contactReturn.setEmail(resultSet.getString(2));
                    contactReturn.setGithub(resultSet.getString(2));
                    contactReturn.setLinkedin(resultSet.getString(2));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return contactReturn;
    }
}
