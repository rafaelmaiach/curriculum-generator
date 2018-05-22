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
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (con != null) {
            try {
                preparedStatement = con.prepareStatement(SELECT_ACCESS_BY_USERID);
                preparedStatement.setInt(1, userId);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    // Get Access data
                    accessReturn = new Access();
                    accessReturn.setLogin(resultSet.getString(2));
                    accessReturn.setPassword(resultSet.getString(3));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return accessReturn;
    }

    @Override
    public void insertAccess(Connection con, Access access, int userId) throws SQLException {
        PreparedStatement preparedStatement = null;
        preparedStatement = con.prepareStatement(INSERT_ACCESS);

        preparedStatement.setInt(1, userId);
        preparedStatement.setString(2, access.getLogin());
        preparedStatement.setString(3, access.getPassword());
        preparedStatement.executeUpdate();
    }
}
