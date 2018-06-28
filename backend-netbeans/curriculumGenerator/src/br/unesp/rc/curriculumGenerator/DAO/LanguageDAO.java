package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Language;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface LanguageDAO {
    final String SELECT_LANGUAGE_BY_CURRICULUMID =
            "SELECT l.idLanguage, l.name, l.languageProeficiency, l.Curriculum_idCurriculum\n" +
                    "FROM language l\n" +
                    "WHERE l.Curriculum_idCurriculum = ?";

    final String INSERT_LANGUAGE =
            "INSERT INTO language(Curriculum_idCurriculum, name, languageProeficiency)" +
                    "VALUES (?, ?, ?)";

    public abstract List<Language> selectLanguageByCurriculumId(int curriculumId);

    public abstract void insertLanguage(Connection con, Language language, int curriculumId) throws SQLException;
}
