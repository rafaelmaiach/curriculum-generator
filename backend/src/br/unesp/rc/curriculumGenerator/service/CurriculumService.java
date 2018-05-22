package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.model.Curriculum;

import java.util.List;

public interface CurriculumService {
    public abstract List<Curriculum> selectCurriculumByUserId(int userId);

    public abstract int insertCurriculum(Curriculum curriculum, int userId);
}
