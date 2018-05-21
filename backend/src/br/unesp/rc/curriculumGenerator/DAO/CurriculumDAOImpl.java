package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.*;
import br.unesp.rc.curriculumGenerator.utils.FactoryConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurriculumDAOImpl implements CurriculumDAO {
    @Override
    public List<Curriculum> selectCurriculumByUserId(int userId) {
        Connection con = FactoryConnection.getConnection();
        List<Curriculum> curriculumList = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (con != null) {
            try {
                preparedStatement = con.prepareStatement(SELECT_CURRICULUM_BY_USERID);
                preparedStatement.setInt(1, userId);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (curriculumList == null) curriculumList = new ArrayList<Curriculum>();

                    //Get curriculum data
                    Curriculum curriculumReturn = new Curriculum();
                    curriculumReturn.setIdCurriculum(resultSet.getInt(1));
                    curriculumReturn.setObjective(resultSet.getString(2));
                    curriculumReturn.setSummary(resultSet.getString(3));
                    curriculumReturn.setName(resultSet.getString(4));
                    curriculumReturn.setCountry(resultSet.getString(5));
                    curriculumReturn.setState(resultSet.getString(6));
                    curriculumReturn.setCity(resultSet.getString(7));
                    curriculumReturn.setCellPhone(resultSet.getString(8));
                    curriculumReturn.setEmail(resultSet.getString(9));
                    curriculumReturn.setGithub(resultSet.getString(10));
                    curriculumReturn.setLinkedin(resultSet.getString(11));

                    // Select Ability
                    AbilityDAO abilityDAO = new AbilityDAOImpl();
                    List<Ability> abilityList = abilityDAO.selectAbilityByCurriculumId(curriculumReturn.getIdCurriculum());
                    curriculumReturn.setAbilities(abilityList);

                    // Select Formation
                    FormationDAO formationDAO = new FormationDAOImpl();
                    List<Formation> formationList = formationDAO.selectFormationByCurriculumId(curriculumReturn.getIdCurriculum());
                    curriculumReturn.setFormations(formationList);

                    // Select Language
                    LanguageDAO languageDAO = new LanguageDAOImpl();
                    List<Language> languageList = languageDAO.selectLanguageByCurriculumId(curriculumReturn.getIdCurriculum());
                    curriculumReturn.setLanguages(languageList);

                    // Select ProfessionalExperience
                    ProfessionalExperienceDAO professionalExperienceDAO = new ProfessionalExperienceDAOImpl();
                    List<ProfessionalExperience> professionalExperienceList = professionalExperienceDAO.selectProfessionalExperienceByCurriculumId(curriculumReturn.getIdCurriculum());
                    curriculumReturn.setProfessionalExperiences(professionalExperienceList);

                    curriculumList.add(curriculumReturn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return curriculumList;
    }
}
