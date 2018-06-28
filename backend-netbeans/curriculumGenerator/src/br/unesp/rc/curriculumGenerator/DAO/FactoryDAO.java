package br.unesp.rc.curriculumGenerator.DAO;

/**
 * This class is used to create Data Access Objects. It should never be instanciated. It just uses static methods.
 */
public class FactoryDAO {
    private FactoryDAO() {
    }

    /**
     * Creates a UserDAO
     *
     * @return UserDAO
     */
    public static UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    /**
     * Creates a AccessDAO
     *
     * @return AccessDAO
     */
    public static AccessDAO getAccessDAO() {
        return new AccessDAOImpl();
    }

    /**
     * Creates a ContactDAO
     *
     * @return ContactDAO
     */
    public static ContactDAO getContactDAO() {
        return new ContactDAOImpl();
    }

    /**
     * Creates a CurriculumDAO
     *
     * @return CurriculumDAO
     */
    public static CurriculumDAO getCurriculumDAO() {
        return new CurriculumDAOImpl();
    }

    /**
     * Creates a AbilityDAO
     *
     * @return AbilityDAO
     */
    public static AbilityDAO getAbilityDAO() {
        return new AbilityDAOImpl();
    }

    /**
     * Creates a FormationDAO
     *
     * @return FormationDAO
     */
    public static FormationDAO getFormationDAO() {
        return new FormationDAOImpl();
    }

    /**
     * Creates a ProfessionalExperienceDAO
     *
     * @return ProfessionalExperienceDAO
     */
    public static ProfessionalExperienceDAO getProfessionalExperienceDAO() {
        return new ProfessionalExperienceDAOImpl();
    }

    /**
     * Creates a LanguageDAO
     *
     * @return LanguageDAO
     */
    public static LanguageDAO getLanguageDAO() {
        return new LanguageDAOImpl();
    }
}
