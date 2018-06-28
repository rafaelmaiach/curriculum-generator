package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.ProfessionalExperience;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ProfessionalExperienceDAO {
    final String SELECT_PROFESSIONALEXPERIENCE_BY_CURRICULUMID =
            "SELECT pe.idProfessionalExperience, pe.job, pe.startDate, pe.finalDate, pe.company, pe.location, pe.jobDescription, pe.Curriculum_idCurriculum\n" +
                    "FROM professionalexperience pe\n" +
                    "WHERE pe.Curriculum_idCurriculum = ?";

    final String INSERT_PROFESSIONALEXPERIENCE =
            "INSERT INTO professionalexperience(Curriculum_idCurriculum, job, startDate, finalDate, company, location, jobDescription)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)";

    public abstract List<ProfessionalExperience> selectProfessionalExperienceByCurriculumId(int curriculumId);

    public abstract void insertProfessionalExperience(Connection con, ProfessionalExperience professionalExperience, int curriculumId) throws SQLException;
}
