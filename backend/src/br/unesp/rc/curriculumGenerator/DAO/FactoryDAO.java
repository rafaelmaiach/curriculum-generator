package br.unesp.rc.curriculumGenerator.DAO;

public class FactoryDAO {
    private FactoryDAO() {

    }

    public static UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    public static AccessDAO getAccessDAO() {
        return new AccessDAOImpl();
    }

    public static ContactDAO getContactDAO() {
        return new ContactDAOImpl();
    }
}
