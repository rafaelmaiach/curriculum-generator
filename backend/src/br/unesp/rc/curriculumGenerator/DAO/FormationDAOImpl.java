package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Formation;
import br.unesp.rc.curriculumGenerator.utils.FactoryConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormationDAOImpl implements FormationDAO {
    @Override
    public List<Formation> selectFormationByCurriculumId(int curriculumId) {
        Connection con = FactoryConnection.getConnection();
        List<Formation> formationList = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (con != null) {
            try {
                preparedStatement = con.prepareStatement(SELECT_FORMATION_BY_CURRICULUMID);
                preparedStatement.setInt(1, curriculumId);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (formationList == null) formationList = new ArrayList<Formation>();

                    // Get Ability data
                    Formation formationReturn = new Formation();
                    formationReturn.setName(resultSet.getString(2));
                    formationReturn.setInstitution(resultSet.getString(3));
                    formationReturn.setLocation(resultSet.getString(4));
                    formationReturn.setStartDate(resultSet.getString(5));
                    formationReturn.setFinalDate(resultSet.getString(6));

                    formationList.add(formationReturn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return formationList;
    }
}
