package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Language;

import java.util.List;

public interface LanguageDAO {
    final String SELECT_LANGUAGE_BY_CURRICULUMID =
            "SELECT l.idLanguage, l.name, l.languageProeficiency, l.Curriculum_idCurriculum\n" +
                    "FROM language l\n" +
                    "WHERE l.Curriculum_idCurriculum = ?";

    public abstract List<Language> selectLanguageByCurriculumId(int curriculumId);
}
