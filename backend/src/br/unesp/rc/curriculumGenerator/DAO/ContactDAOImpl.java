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
        PreparedStatement pstm = null;
        ResultSet res = null;

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_CONTACT_BY_USERID);
                pstm.setInt(1, userId);

                res = pstm.executeQuery();
                while (res.next()) {
                    // Get Contact data
                    contactReturn = new Contact();
                    contactReturn.setCellPhone(res.getString(2));
                    contactReturn.setEmail(res.getString(2));
                    contactReturn.setGithub(res.getString(2));
                    contactReturn.setLinkedin(res.getString(2));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return contactReturn;
    }
}
