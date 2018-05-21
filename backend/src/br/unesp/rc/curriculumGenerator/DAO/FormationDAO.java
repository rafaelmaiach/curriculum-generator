package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Formation;

import java.util.List;

public interface FormationDAO {
    final String SELECT_FORMATION_BY_CURRICULUMID =
            "SELECT f.idFormation, f.name, f.institution, f.location, f.startDate, f.finalDate\n" +
                    "FROM formation f\n" +
                    "WHERE f.Curriculum_idCurriculum = ?";

    public abstract List<Formation> selectFormationByCurriculumId(int curriculumId);
}
