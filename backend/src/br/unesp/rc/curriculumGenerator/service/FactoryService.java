package br.unesp.rc.curriculumGenerator.service;

public class FactoryService {
    public FactoryService() {
    }

    public static UserService getUserService() {
        return new UserServiceImpl();
    }

    public static CurriculumService getCurriculumService() {
        return new CurriculumServiceImpl();
    }
}
