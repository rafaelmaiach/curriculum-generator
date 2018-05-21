package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Language;
import br.unesp.rc.curriculumGenerator.model.LanguageProeficiency;
import br.unesp.rc.curriculumGenerator.utils.FactoryConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanguageDAOImpl implements LanguageDAO {
    @Override
    public List<Language> selectLanguageByCurriculumId(int curriculumId) {
        Connection con = FactoryConnection.getConnection();
        List<Language> languageList = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (con != null) {
            try {
                preparedStatement = con.prepareStatement(SELECT_LANGUAGE_BY_CURRICULUMID);
                preparedStatement.setInt(1, curriculumId);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (languageList == null) languageList = new ArrayList<Language>();

                    // Get Ability data
                    Language languageReturn = new Language();
                    languageReturn.setName(resultSet.getString(2));
                    languageReturn.setLanguageProeficiency(LanguageProeficiency.valueOf(resultSet.getInt(3)));

                    languageList.add(languageReturn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return languageList;
    }
}
