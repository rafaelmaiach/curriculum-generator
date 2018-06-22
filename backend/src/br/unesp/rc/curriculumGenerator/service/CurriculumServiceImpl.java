package br.unesp.rc.curriculumGenerator.service;

import br.unesp.rc.curriculumGenerator.DAO.CurriculumDAO;
import br.unesp.rc.curriculumGenerator.DAO.FactoryDAO;
import br.unesp.rc.curriculumGenerator.apachepoi.utils.FactoryCurriculumModel;
import br.unesp.rc.curriculumGenerator.apachepoi.utils.GenerateCurriculum;
import br.unesp.rc.curriculumGenerator.model.Curriculum;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CurriculumServiceImpl implements CurriculumService {
    CurriculumDAO curriculumDAO;

    public CurriculumServiceImpl() {
        this.curriculumDAO = FactoryDAO.getCurriculumDAO();
    }

    /**
     * @param userId The user's Id to database
     * @return The list of curriculum to the user
     */
    @Override
    public List<Curriculum> selectCurriculumByUserId(int userId) {
        List<Curriculum> curriculumList = null;

        curriculumList = this.curriculumDAO.selectCurriculumByUserId(userId);

        return curriculumList;
    }

    /**
     * Insert a new curriculum to the database
     *
     * @param curriculum Curriculum class with the informations that will be inserted to the database
     * @param userId     The user's Id that owns the Curriculum
     * @return The new Curriculum Id in the databasse if successfull. -1 if failed.
     */
    @Override
    public int insertCurriculum(Curriculum curriculum, int userId) {
        int curriculumId = 0;

        curriculumId = this.curriculumDAO.insertCurriculum(curriculum, userId);

        return curriculumId;
    }

    /**
     * Uses "Apache Poi" to generate a ".docx" file to the given curriculum
     *
     * @param curriculum      The curriculum to generate the file
     * @param curriculumModel The model that will be used to generate.
     * @return The file that was generated
     * @throws IOException
     */
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
