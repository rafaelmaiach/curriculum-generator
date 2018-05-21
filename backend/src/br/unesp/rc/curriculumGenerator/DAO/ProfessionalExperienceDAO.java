package br.unesp.rc.curriculumGenerator.DAO;

import br.unesp.rc.curriculumGenerator.model.ProfessionalExperience;

import java.util.List;

public interface ProfessionalExperienceDAO {
    final String SELECT_PROFESSIONALEXPERIENCE_BY_CURRICULUMID =
            "SELECT pe.idProfessionalExperience, pe.job, pe.startDate, pe.finalDate, pe.company, pe.location, pe.jobDescription, pe.Curriculum_idCurriculum\n" +
                    "FROM professionalexperience pe\n" +
                    "WHERE pe.Curriculum_idCurriculum = ?";

    public abstract List<ProfessionalExperience> selectProfessionalExperienceByCurriculumId(int curriculumId);
}
