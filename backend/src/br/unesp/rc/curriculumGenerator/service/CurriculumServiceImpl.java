package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.DAO.CurriculumDAO;
import br.unesp.rc.curriculumGenerator.DAO.FactoryDAO;
import br.unesp.rc.curriculumGenerator.model.Curriculum;

public class CurriculumServiceImpl implements CurriculumService {
    CurriculumDAO curriculumDAO;

    public CurriculumServiceImpl() {
        this.curriculumDAO = FactoryDAO.getCurriculumDAO();
    }

    @Override
    public Curriculum selectCurriculumByUserId(int userId) {
        Curriculum curriculum = null;

        curriculum = this.curriculumDAO.selectCurriculumByUserId(userId);

        return curriculum;
    }
}
