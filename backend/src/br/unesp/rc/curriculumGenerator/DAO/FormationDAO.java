package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Formation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface FormationDAO {
    final String SELECT_FORMATION_BY_CURRICULUMID =
            "SELECT f.idFormation, f.name, f.institution, f.location, f.startDate, f.finalDate\n" +
                    "FROM formation f\n" +
                    "WHERE f.Curriculum_idCurriculum = ?";

    final String INSERT_FORMATION =
            "INSERT INTO formation(Curriculum_idCurriculum, name, institution, startDate, finalDate, location) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

    public abstract List<Formation> selectFormationByCurriculumId(int curriculumId);

    public abstract void insertFormation(Connection con, Formation formation, int curriculumId) throws SQLException;
}
