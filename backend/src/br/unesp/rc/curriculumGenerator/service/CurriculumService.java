package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.model.Curriculum;

public interface CurriculumService {
    public abstract Curriculum selectCurriculumByUserId(int userId);
}
