package br.unesp.rc.curriculumGenerator.apachepoi.utils;

/**
 * Class used to choose which Model will be used to generate the curriculum
 */
public class FactoryCurriculumModel {

    /**
     * @param model The number of the model
     * @return the CurriculumModel class based on the given param
     */
    public static GenerateCurriculum getCurriculumModel(int model) {
        switch (model) {
            case 1:
                return new CurriculumModel1();

            // Default Curriculum
            default:
                return new CurriculumModel1();
        }
    }
}
