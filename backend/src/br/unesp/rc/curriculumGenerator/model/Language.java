package br.unesp.rc.curriculumGenerator.model;

public class Language {

    private String name;

    private LanguageProeficiency languageProeficiency;

    public Language() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LanguageProeficiency getLanguageProeficiency() {
        return languageProeficiency;
    }

    public void setLanguageProeficiency(LanguageProeficiency languageProeficiency) {
        this.languageProeficiency = languageProeficiency;
    }
}
