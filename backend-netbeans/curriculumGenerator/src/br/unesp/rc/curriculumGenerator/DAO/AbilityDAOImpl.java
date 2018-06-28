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

    /**
     * @param curriculumId The curriculums's Id to database
     * @return The list of Abilities
     */
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

    /**
     * Insert a new Ability to the database
     *
     * @param con          the connection to the database
     * @param ability      Ability class with the informations that will be inserted to the database
     * @param curriculumId The curriculum's Id that has the Ability
     * @throws SQLException
     */
    @Override
    public void insertAbility(Connection con, Ability ability, int curriculumId) throws SQLException {
        PreparedStatement preparedStatement = null;
        preparedStatement = con.prepareStatement(INSERT_ABILITY);

        preparedStatement.setInt(1, curriculumId);
        preparedStatement.setString(2, ability.getName());
        preparedStatement.executeUpdate();
    }
}
