package br.unesp.rc.curriculumGenerator.model;

import java.util.ArrayList;
import java.util.List;

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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public List<Curriculum> getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(List<Curriculum> curriculums) {
        this.curriculums = curriculums;
    }

    public void addCurriculum(Curriculum curriculum) {
        this.curriculums.add(curriculum);
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
