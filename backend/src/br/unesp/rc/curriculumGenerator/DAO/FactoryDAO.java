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

    public static CurriculumDAO getCurriculumDAO() {
        return new CurriculumDAOImpl();
    }

    public static AbilityDAO getAbilityDAO() {
        return new AbilityDAOImpl();
    }

    public static FormationDAO getFormationDAO() {
        return new FormationDAOImpl();
    }

    public static ProfessionalExperienceDAO getProfessionalExperienceDAO() {
        return new ProfessionalExperienceDAOImpl();
    }

    public static LanguageDAO getLanguageDAO() {
        return new LanguageDAOImpl();
    }
}
