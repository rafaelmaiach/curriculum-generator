package br.unesp.rc.curriculumGenerator.model;

import java.util.ArrayList;
import java.util.List;

public class Curriculum {

    private String objective;

    private String summary;

    private User user;

    private List<Ability> abilities;

    private List<Formation> formations;

    private List<Language> languages;

    private List<ProfessionalExperience> professionalExperiences;

    public Curriculum() {
        this.setAbilities(new ArrayList<>());
        this.setFormations(new ArrayList<>());
        this.setLanguages(new ArrayList<>());
        this.setProfessionalExperiences(new ArrayList<>());
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public void addFormation(Formation formation) {
        this.formations.add(formation);
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public void addLanguage(Language language) {
        this.languages.add(language);
    }

    public List<ProfessionalExperience> getProfessionalExperiences() {
        return professionalExperiences;
    }

    public void setProfessionalExperiences(List<ProfessionalExperience> professionalExperiences) {
        this.professionalExperiences = professionalExperiences;
    }

    public void addProfesionalExperience(ProfessionalExperience professionalExperience) {
        this.professionalExperiences.add(professionalExperience);
    }
}
