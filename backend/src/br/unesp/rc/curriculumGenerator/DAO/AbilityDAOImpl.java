package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Ability;
import br.unesp.rc.curriculumGenerator.utils.FactoryConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbilityDAOImpl implements AbilityDAO {
    @Override
    public List<Ability> selectAbilityByCurriculumId(int curriculumId) {
        Connection con = FactoryConnection.getConnection();
        List<Ability> abilityList = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (con != null) {
            try {
                preparedStatement = con.prepareStatement(SELECT_ABILITY_BY_CURRICULUMID);
                preparedStatement.setInt(1, curriculumId);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (abilityList == null) abilityList = new ArrayList<Ability>();

                    // Get Ability data
                    Ability abilityReturn = new Ability();
                    abilityReturn.setName(resultSet.getString(2));

                    abilityList.add(abilityReturn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return abilityList;
    }
}
