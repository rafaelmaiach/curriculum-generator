package br.unesp.rc.curriculumGenerator.service;

public class FactoryService {
    public FactoryService() {
    }

    public static UserService getUserService() {
        return new UserServiceImpl();
    }
}
