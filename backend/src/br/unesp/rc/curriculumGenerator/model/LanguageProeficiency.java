package br.unesp.rc.curriculumGenerator.model;

public enum LanguageProeficiency {

    BASIC(1), INTERMEDIARY(2), ADVANCED(3), FLUENT(4);

    private int value;

    private LanguageProeficiency(int languageProeficiency) {
        this.setValue(languageProeficiency);
    }

    public static LanguageProeficiency valueOf(int index) {
        switch (index) {
            case 1:
                return LanguageProeficiency.BASIC;
            case 2:
                return LanguageProeficiency.INTERMEDIARY;
            case 3:
                return LanguageProeficiency.ADVANCED;
            case 4:
                return LanguageProeficiency.FLUENT;
        }

        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        switch (this) {
            case BASIC:
                return "Básico";
            case FLUENT:
                return "Fluente";
            case ADVANCED:
                return "Avançado";
            case INTERMEDIARY:
                return "Intermediário";
        }

        return "";
    }
}
