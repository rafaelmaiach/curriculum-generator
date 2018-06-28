package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.model.Curriculum;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CurriculumService {
    public abstract List<Curriculum> selectCurriculumByUserId(int userId);

    public abstract int insertCurriculum(Curriculum curriculum, int userId);

    public File getCurriculumFile(Curriculum curriculum, int curriculumModel) throws IOException;
}
