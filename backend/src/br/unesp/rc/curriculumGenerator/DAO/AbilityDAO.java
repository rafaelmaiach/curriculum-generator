package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Ability;

import java.util.List;

public interface AbilityDAO {
    final String SELECT_ABILITY_BY_CURRICULUMID =
            "SELECT a.idAbility, a.name, a.Curriculum_idCurriculum\n" +
                    "FROM ability a\n" +
                    "WHERE a.Curriculum_idCurriculum = ?";

    public abstract List<Ability> selectAbilityByCurriculumId(int curriculumId);
}
