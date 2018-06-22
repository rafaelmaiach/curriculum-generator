package br.unesp.rc.curriculumGenerator.model;

/**
 * This class represents "Abilities" of a person
 */
public class Ability {

    private String name;

    public Ability() {
    }

    /**
     * @return the name of the ability
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the ability
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
