package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Ability;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AbilityDAO {
    final String SELECT_ABILITY_BY_CURRICULUMID =
            "SELECT a.idAbility, a.name, a.Curriculum_idCurriculum\n" +
                    "FROM ability a\n" +
                    "WHERE a.Curriculum_idCurriculum = ?";

    final String INSERT_ABILITY =
            "INSERT INTO ability(Curriculum_idCurriculum, name)" +
                    "VALUES (?, ?)";

    public abstract List<Ability> selectAbilityByCurriculumId(int curriculumId);

    public abstract void insertAbility(Connection con, Ability ability, int curriculumId) throws SQLException;
}
