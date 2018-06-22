package br.unesp.rc.curriculumGenerator.model;

/**
 * This class represents languages that the curriculum owner can speak
 */
public class Language {

    private String name;

    private LanguageProeficiency languageProeficiency;

    public Language() {
    }

    /**
     * @return the language name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the language name
     *
     * @param name the language name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Language Proeficiency
     * LanguageProeficiency.BASIC
     * LanguageProeficiency.INTERMEDIARY
     * LanguageProeficiency.ADVANCED
     * LanguageProeficiency.FLUENT
     */
    public LanguageProeficiency getLanguageProeficiency() {
        return languageProeficiency;
    }

    /**
     * Sets the Language Proeficiency
     *
     * @param languageProeficiency the language proeficiency
     *                             LanguageProeficiency.BASIC
     *                             LanguageProeficiency.INTERMEDIARY
     *                             LanguageProeficiency.ADVANCED
     *                             LanguageProeficiency.FLUENT
     */
    public void setLanguageProeficiency(LanguageProeficiency languageProeficiency) {
        this.languageProeficiency = languageProeficiency;
    }
}
