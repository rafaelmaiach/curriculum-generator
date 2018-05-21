package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Curriculum;

public interface CurriculumDAO {
    final String SELECT_CURRICULUM_BY_USERID =
            "";

    public abstract Curriculum selectCurriculumByUserId(int userId);
}
