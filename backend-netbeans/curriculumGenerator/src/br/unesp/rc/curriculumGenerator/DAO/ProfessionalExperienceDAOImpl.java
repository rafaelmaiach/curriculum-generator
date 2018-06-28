package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.ProfessionalExperience;
import br.unesp.rc.curriculumGenerator.utils.FactoryConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessionalExperienceDAOImpl implements ProfessionalExperienceDAO {

    /**
     * @param curriculumId The curriculums's Id to database
     * @return The list of Professional Experiences
     */
    @Override
    public List<ProfessionalExperience> selectProfessionalExperienceByCurriculumId(int curriculumId) {
        Connection con = FactoryConnection.getConnection();
        List<ProfessionalExperience> professionalExperienceList = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (con != null) {
            try {
                preparedStatement = con.prepareStatement(SELECT_PROFESSIONALEXPERIENCE_BY_CURRICULUMID);
                preparedStatement.setInt(1, curriculumId);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (professionalExperienceList == null)
                        professionalExperienceList = new ArrayList<ProfessionalExperience>();

                    // Get Ability data
                    ProfessionalExperience professionalExperienceReturn = new ProfessionalExperience();
                    professionalExperienceReturn.setJob(resultSet.getString(2));
                    professionalExperienceReturn.setStartDate(resultSet.getString(3));
                    professionalExperienceReturn.setFinalDate(resultSet.getString(4));
                    professionalExperienceReturn.setCompany(resultSet.getString(5));
                    professionalExperienceReturn.setLocation(resultSet.getString(6));
                    professionalExperienceReturn.setJobDescription(resultSet.getString(7));

                    professionalExperienceList.add(professionalExperienceReturn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return professionalExperienceList;
    }

    /**
     * Insert a new Professional Experience to the database
     *
     * @param con                    the connection to the database
     * @param professionalExperience Professional Experience class with the informations that will be inserted to the database
     * @param curriculumId           The curriculum's Id that has the Professional Experience
     * @throws SQLException
     */
    @Override
    public void insertProfessionalExperience(Connection con, ProfessionalExperience professionalExperience, int curriculumId) throws SQLException {
        PreparedStatement preparedStatement = null;
        preparedStatement = con.prepareStatement(INSERT_PROFESSIONALEXPERIENCE);

        preparedStatement.setInt(1, curriculumId);
        preparedStatement.setString(2, professionalExperience.getJob());
        preparedStatement.setString(3, professionalExperience.getStartDate());
        preparedStatement.setString(4, professionalExperience.getFinalDate());
        preparedStatement.setString(5, professionalExperience.getCompany());
        preparedStatement.setString(6, professionalExperience.getLocation());
        preparedStatement.setString(7, professionalExperience.getJobDescription());

        preparedStatement.executeUpdate();
    }
}
