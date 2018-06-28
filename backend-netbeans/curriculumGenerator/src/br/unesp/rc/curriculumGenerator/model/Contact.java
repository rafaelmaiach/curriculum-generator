package br.unesp.rc.curriculumGenerator.model;

/**
 * This class represents some user's Contacts, e.g., cellPhone, email, etc.
 */
public class Contact {

    private String cellPhone;

    private String email;

    private String github;

    private String linkedin;

    private User user;

    public Contact() {
    }

    /**
     * @return the user's cellphone
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * Sets the user's cellphone
     *
     * @param cellPhone
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email
     *
     * @param email the user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the user's github
     */
    public String getGithub() {
        return github;
    }

    /**
     * Sets the user's github
     *
     * @param github the user's github
     */
    public void setGithub(String github) {
        this.github = github;
    }

    /**
     * @return the user's linkedin
     */
    public String getLinkedin() {
        return linkedin;
    }

    /**
     * Sets the user's linkedin
     *
     * @param linkedin
     */
    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    /**
     * @return the contact owner
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the contact owner
     *
     * @param user the contact owner
     */
    public void setUser(User user) {
        this.user = user;
    }
}
