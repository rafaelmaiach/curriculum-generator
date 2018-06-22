package br.unesp.rc.curriculumGenerator.utils;

import br.unesp.rc.curriculumGenerator.apachepoi.utils.CurriculumModel1;
import br.unesp.rc.curriculumGenerator.apachepoi.utils.GenerateCurriculum;

public class FactoryCurriculumModel {
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
