package br.unesp.rc.curriculumGenerator.demo;

import br.unesp.rc.curriculumGenerator.utils.CurriculumModel1;
import br.unesp.rc.curriculumGenerator.utils.GenerateCurriculum;

public class test {
    public static void main(String args[]) {
        GenerateCurriculum generateCurriculum = new CurriculumModel1();

        try {
            //generateCurriculum.Export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}