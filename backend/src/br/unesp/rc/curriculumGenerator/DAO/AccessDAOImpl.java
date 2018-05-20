package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Access;
import br.unesp.rc.curriculumGenerator.utils.FactoryConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccessDAOImpl implements AccessDAO {

    @Override
    public Access selectAccessByUserId(int userId) {
        Connection con = FactoryConnection.getConnection();
        Access accessReturn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_ACCESS_BY_USERID);
                pstm.setInt(1, userId);

                res = pstm.executeQuery();
                while (res.next()) {
                    // Get Access data
                    accessReturn = new Access();
                    accessReturn.setLogin(res.getString(2));
                    accessReturn.setPassword(res.getString(3));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return accessReturn;
    }
}
