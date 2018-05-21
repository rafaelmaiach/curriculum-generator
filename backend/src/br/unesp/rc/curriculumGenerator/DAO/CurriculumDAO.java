package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.Curriculum;

import java.util.List;

public interface CurriculumDAO {
    final String SELECT_CURRICULUM_BY_USERID =
            "SELECT c.idCurriculum, c.objective, c.summary, c.name, c.country, c.state, c.city, c.cellPhone, c.email, c.github, c.linkedin, c.User_idUser\n" +
                    "FROM curriculum c\n" +
                    "WHERE c.User_idUser = ?";

    public abstract List<Curriculum> selectCurriculumByUserId(int userId);
}
