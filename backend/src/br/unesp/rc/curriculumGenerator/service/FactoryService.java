package br.unesp.rc.curriculumGenerator.service;

/**
 * This class is used to create Services. It should never be instanciated. It just uses static methods.
 */
public class FactoryService {
    public FactoryService() {
    }

    /**
     * Creates a UserService
     *
     * @return UserService
     */
    public static UserService getUserService() {
        return new UserServiceImpl();
    }

    /**
     * Creates a CurriculumService
     *
     * @return CurriculumService
     */
    public static CurriculumService getCurriculumService() {
        return new CurriculumServiceImpl();
    }
}
