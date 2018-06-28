package br.unesp.rc.curriculumGenerator.model;

/**
 * This class represents the access to the software
 */
public class Access {

    private String login;

    private String password;

    private User user;

    public Access() {
    }

    /**
     * @return the login (username)
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login (username)
     *
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the user class
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the Access owner
     *
     * @param user the user class
     */
    public void setUser(User user) {
        this.user = user;
    }
}
