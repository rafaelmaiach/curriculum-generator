package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.DAO.CurriculumDAO;
import br.unesp.rc.curriculumGenerator.DAO.FactoryDAO;
import br.unesp.rc.curriculumGenerator.apachepoi.utils.GenerateCurriculum;
import br.unesp.rc.curriculumGenerator.model.Curriculum;
import br.unesp.rc.curriculumGenerator.utils.FactoryCurriculumModel;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CurriculumServiceImpl implements CurriculumService {
    CurriculumDAO curriculumDAO;

    public CurriculumServiceImpl() {
        this.curriculumDAO = FactoryDAO.getCurriculumDAO();
    }

    @Override
    public List<Curriculum> selectCurriculumByUserId(int userId) {
        List<Curriculum> curriculumList = null;

        curriculumList = this.curriculumDAO.selectCurriculumByUserId(userId);

        return curriculumList;
    }

    @Override
    public int insertCurriculum(Curriculum curriculum, int userId) {
        int curriculumId = 0;

        curriculumId = this.curriculumDAO.insertCurriculum(curriculum, userId);

        return curriculumId;
    }

    @Override
    public File getCurriculumFile(Curriculum curriculum, int curriculumModel) throws IOException {
        //Set default name at user's curriculum If not defined
        String userName = curriculum.getName();
        if (userName == null || userName.isEmpty())
            curriculum.setName("Default Name");

        GenerateCurriculum generateCurriculum = FactoryCurriculumModel.getCurriculumModel(curriculumModel);
        File generatedCurriculum = generateCurriculum.Export(curriculum);

        return generatedCurriculum;
    }
}
