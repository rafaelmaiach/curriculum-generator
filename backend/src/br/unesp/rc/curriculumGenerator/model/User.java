package br.unesp.rc.curriculumGenerator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the user that has Access to the software
 */
public class User {

    private int idUser;

    private String name;

    private String country;

    private String state;

    private String city;

    private Access access;

    private List<Curriculum> curriculums;

    private Contact contact;

    public User() {
        this.curriculums = new ArrayList<>();
    }

    /**
     * @return the user's database Id
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Sets the user's database Id
     *
     * @param idUser the user's database Id
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name
     * @param name the user's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the user's country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country where the user lives
     * @param country the country where the user lives
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the state where the user lives
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state where the user lives
     * @param state the state where the user lives
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the city where the user lives
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the user lives
     * @param city the city where the user lives
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the user's Access
     */
    public Access getAccess() {
        return access;
    }

    /**
     * Sets the user's Access
     * @param access the user's Access
     */
    public void setAccess(Access access) {
        this.access = access;
    }

    /**
     * @return All user curriculums
     */
    public List<Curriculum> getCurriculums() {
        return curriculums;
    }

    /**
     * Sets the user's list of curriculums
     * @param curriculums Curriculum List
     */
    public void setCurriculums(List<Curriculum> curriculums) {
        this.curriculums = curriculums;
    }

    /**
     * Add a curriculum to the user's list of curriculums
     * @param curriculum curriculum to be added
     */
    public void addCurriculum(Curriculum curriculum) {
        this.curriculums.add(curriculum);
    }

    /**
     * @return the user's contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Sets the user's contact
     * @param contact the user's contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
