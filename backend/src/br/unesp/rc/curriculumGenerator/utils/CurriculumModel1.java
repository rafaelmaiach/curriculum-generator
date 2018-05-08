package br.unesp.rc.curriculumGenerator.utils;

import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class CurriculumModel1 extends GenerateCurriculum {
    @Override
    protected void createDocumentHeader(XWPFDocument document) {
        //Create the table that has the name inside the header
        XWPFHeader header = document.createHeader(HeaderFooterType.FIRST);
        XWPFTable headerTable = header.createTable(1, 1);

        //Set borders
        headerTable.setInsideVBorder(XWPFTable.XWPFBorderType.NONE, -10, 5, "000000");
        headerTable.setInsideHBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 5, "000000");
        CTTblPr tblpro = headerTable.getCTTbl().getTblPr();
        CTTblBorders borders = tblpro.addNewTblBorders();
        borders.addNewRight().setVal(STBorder.NONE);
        borders.addNewBottom().setVal(STBorder.SINGLE);
        borders.addNewTop().setVal(STBorder.SINGLE);
        borders.addNewLeft().setVal(STBorder.NONE);

        XWPFTableCell tableCell = headerTable.getRow(0).getCell(0);

        //I need to remove the paragraph that is automatically created
        //'cause I will add it myself
        tableCell.removeParagraph(0);

        XWPFParagraph nameParagraph = tableCell.addParagraph();
        XWPFRun nameLine = nameParagraph.createRun();
        nameLine.setFontFamily("Arial");
        nameLine.setFontSize(12);
        nameLine.setBold(true);
        nameLine.setText("Nome Sobrenome");

        //Contact information
        header.createParagraph();

        //City, state, country
        XWPFRun cityStateCountryText = header.createParagraph().createRun();
        cityStateCountryText.setFontFamily("Arial");
        cityStateCountryText.setFontSize(10);
        cityStateCountryText.setText("Cidade");
        cityStateCountryText.setText(", ");
        cityStateCountryText.setText("Estado");
        cityStateCountryText.setText(", ");
        cityStateCountryText.setText("País");

        //Cellphone
        XWPFRun cellphoneText = header.createParagraph().createRun();
        cellphoneText.setFontFamily("Arial");
        cellphoneText.setFontSize(10);
        cellphoneText.setText("Celular: ");
        cellphoneText.setText("+55 19 1234-5678");

        //Cellphone
        XWPFRun emailText = header.createParagraph().createRun();
        emailText.setFontFamily("Arial");
        emailText.setFontSize(10);
        emailText.setText("E-mail: ");
        emailText.setText("email@hotmail.com");

        //GitHub
        XWPFRun githubText = header.createParagraph().createRun();
        githubText.setFontFamily("Arial");
        githubText.setFontSize(10);
        githubText.setText("GitHub: ");
        githubText.setText("https://github.com/username");

        //LinkedIn
        XWPFRun linkedInText = header.createParagraph().createRun();
        linkedInText.setFontFamily("Arial");
        linkedInText.setFontSize(10);
        linkedInText.setText("LinkedIn: ");
        linkedInText.setText("https://www.linkedin.com/in/username");

        //Separator
        this.addLineSeparator(document);
    }

    @Override
    protected void createDocumentContent(XWPFDocument document) {
        createObjectiveSection(document);
        createSummarySection(document);
        createAbilitySection(document);
        createFormationSection(document);
        createLanguagesSection(document);
        createExperienceSection(document);
    }

    private void createObjectiveSection(XWPFDocument document) {
        document.createParagraph();

        XWPFParagraph objectiveParagraph = document.createParagraph();
        objectiveParagraph.setIndentationLeft(249 * 5);
        objectiveParagraph.setIndentationFirstLine(-249 * 5);
        XWPFRun objectiveTitle = objectiveParagraph.createRun();
        objectiveTitle.setFontFamily("Arial");
        objectiveTitle.setFontSize(11);
        objectiveTitle.setBold(true);
        objectiveTitle.setText("Objetivo");
        //Add TAB character
        objectiveTitle.addTab();

        XWPFRun objectiveText = objectiveParagraph.createRun();
        objectiveText.setFontFamily("Arial");
        objectiveText.setFontSize(10);
        objectiveText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.");

        //Separator
        this.addLineSeparator(document);
    }

    private void createSummarySection(XWPFDocument document) {
        document.createParagraph();

        XWPFParagraph summaryParagraph = document.createParagraph();
        summaryParagraph.setIndentationLeft(249 * 5);
        summaryParagraph.setIndentationFirstLine(-249 * 5);
        summaryParagraph.setAlignment(ParagraphAlignment.BOTH);

        XWPFRun summaryTitle = summaryParagraph.createRun();
        summaryTitle.setFontFamily("Arial");
        summaryTitle.setFontSize(11);
        summaryTitle.setBold(true);
        summaryTitle.setText("Resumo");
        //Add TAB character
        summaryTitle.addTab();

        XWPFRun summaryText = summaryParagraph.createRun();
        summaryText.setFontFamily("Arial");
        summaryText.setFontSize(10);

        summaryText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.");
        summaryText.addBreak();
        summaryText.addBreak();
        summaryText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.");
        summaryText.addBreak();
        summaryText.addBreak();
        summaryText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.");

        //Separator
        this.addLineSeparator(document);
    }

    private void createAbilitySection(XWPFDocument document) {
        document.createParagraph();

        XWPFParagraph abilityParagraph = document.createParagraph();
        abilityParagraph.setIndentationLeft(191 * 5);
        abilityParagraph.setSpacingAfter(11 * 5);

        XWPFRun abilityText = abilityParagraph.createRun();
        abilityText.setFontFamily("Arial");
        abilityText.setFontSize(11);
        abilityText.setBold(true);
        abilityText.setText("Habilidades");

        //Create list
        ArrayList<String> documentList = new ArrayList<String>(
                Arrays.asList(
                        new String[]{
                                "Habilidade 1",
                                "Habilidade 2",
                                "Habilidade 3"
                        }));

        CTAbstractNum cTAbstractNum = CTAbstractNum.Factory.newInstance();
        cTAbstractNum.setAbstractNumId(BigInteger.valueOf(0));

        CTLvl cTLvl = cTAbstractNum.addNewLvl();
        cTLvl.addNewNumFmt().setVal(STNumberFormat.DECIMAL);
        cTLvl.addNewLvlText().setVal("%1.");
        cTLvl.addNewStart().setVal(BigInteger.valueOf(1));

        XWPFAbstractNum abstractNum = new XWPFAbstractNum(cTAbstractNum);
        XWPFNumbering numbering = document.createNumbering();
        BigInteger abstractNumID = numbering.addAbstractNum(abstractNum);
        BigInteger numID = numbering.addNum(abstractNumID);

        for (String string : documentList) {
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setIndentationLeft(250 * 5);
            paragraph.setNumID(numID);
            XWPFRun run = paragraph.createRun();
            run.setFontFamily("Arial");
            run.setFontSize(10);
            run.setText(string);
        }

        //Separator
        this.addLineSeparator(document);
    }

    private void createFormationSection(XWPFDocument document) {
        document.createParagraph();

        XWPFParagraph formationParagraph = document.createParagraph();
        formationParagraph.setIndentationLeft(249 * 5);
        formationParagraph.setIndentationFirstLine(-249 * 5);
        XWPFRun formationTitle = formationParagraph.createRun();
        formationTitle.setFontFamily("Arial");
        formationTitle.setFontSize(11);
        formationTitle.setBold(true);
        formationTitle.setText("Graduação");
        //Add TAB character
        formationTitle.addTab();

        //Add first formation
        XWPFRun formationText = formationParagraph.createRun();
        formationText.setFontFamily("Arial");
        formationText.setFontSize(10);
        formationText.setBold(true);
        formationText.setText("Bacharelado em Ciências da Computação");

        XWPFRun formationDateText = formationParagraph.createRun();
        formationDateText.setFontFamily("Arial");
        formationDateText.setFontSize(10);
        formationDateText.setItalic(true);
        formationDateText.setText(" - (2014 – Julho/2018)");
        //Next line
        formationDateText.addBreak();

        //Institution
        XWPFRun formationInstitutionText = formationParagraph.createRun();
        formationInstitutionText.setFontFamily("Arial");
        formationInstitutionText.setFontSize(10);
        formationInstitutionText.setItalic(true);
        formationInstitutionText.setBold(true);
        formationInstitutionText.setText("UNESP, ");

        XWPFRun formationLocationText = formationParagraph.createRun();
        formationLocationText.setFontFamily("Arial");
        formationLocationText.setFontSize(10);
        formationLocationText.setItalic(true);
        formationLocationText.setText("Rio Claro, São Paulo.");

        formationLocationText.addBreak();
        formationLocationText.addBreak();


        //Add second formation
        formationText = formationParagraph.createRun();
        formationText.setFontFamily("Arial");
        formationText.setFontSize(10);
        formationText.setBold(true);
        formationText.setText("Técnico em Informática");

        formationDateText = formationParagraph.createRun();
        formationDateText.setFontFamily("Arial");
        formationDateText.setFontSize(10);
        formationDateText.setItalic(true);
        formationDateText.setText(" - (2012 – 2013)");
        //Next line
        formationDateText.addBreak();

        //Institution
        formationInstitutionText = formationParagraph.createRun();
        formationInstitutionText.setFontFamily("Arial");
        formationInstitutionText.setFontSize(10);
        formationInstitutionText.setItalic(true);
        formationInstitutionText.setBold(true);
        formationInstitutionText.setText("ETEC Deputado Ary de Camargo Pedroso, ");

        formationLocationText = formationParagraph.createRun();
        formationLocationText.setFontFamily("Arial");
        formationLocationText.setFontSize(10);
        formationLocationText.setItalic(true);
        formationLocationText.setText("Piracicaba, São Paulo.");

        this.addLineSeparator(document);
    }

    private void createLanguagesSection(XWPFDocument document) {
        document.createParagraph();

        XWPFParagraph languageParagraph = document.createParagraph();
        languageParagraph.setIndentationLeft(249 * 5);
        languageParagraph.setIndentationFirstLine(-249 * 5);
        XWPFRun languageTitle = languageParagraph.createRun();
        languageTitle.setFontFamily("Arial");
        languageTitle.setFontSize(11);
        languageTitle.setBold(true);
        languageTitle.setText("Idioma");
        //Add TAB character
        languageTitle.addTab();

        //First language
        XWPFRun languageText = languageParagraph.createRun();
        languageText.setFontFamily("Arial");
        languageText.setFontSize(10);
        languageText.setBold(true);
        languageText.setText("Inglês - ");

        XWPFRun languageProeficiencyText = languageParagraph.createRun();
        languageProeficiencyText.setFontFamily("Arial");
        languageProeficiencyText.setFontSize(10);
        languageProeficiencyText.setText("Intermediário para Avançado");
        languageProeficiencyText.addBreak();

        //Second language
        languageText = languageParagraph.createRun();
        languageText.setFontFamily("Arial");
        languageText.setFontSize(10);
        languageText.setBold(true);
        languageText.setText("Espanhol - ");

        languageProeficiencyText = languageParagraph.createRun();
        languageProeficiencyText.setFontFamily("Arial");
        languageProeficiencyText.setFontSize(10);
        languageProeficiencyText.setText("Fluente");
        languageProeficiencyText.addBreak();
    }

    private void createExperienceSection(XWPFDocument document) {
        XWPFRun languageTitle = document.createParagraph().createRun();
        languageTitle.setFontFamily("Arial");
        languageTitle.setFontSize(11);
        languageTitle.setBold(true);
        languageTitle.setText("Experiências Profissionais");

        //First experience
        document.createParagraph();
        XWPFParagraph experienceParagraph = document.createParagraph();
        XWPFRun experienceJobText = experienceParagraph.createRun();
        experienceJobText.setFontFamily("Arial");
        experienceJobText.setFontSize(10);
        experienceJobText.setBold(true);
        experienceJobText.setText("Estagiário Desenvolvimento Web, ");

        XWPFRun jobDateText = experienceParagraph.createRun();
        experienceJobText.setFontFamily("Arial");
        experienceJobText.setFontSize(10);
        jobDateText.setText("Janeiro 2017 – Atualmente, ");

        XWPFRun jobCompanyText = experienceParagraph.createRun();
        jobCompanyText.setFontFamily("Arial");
        jobCompanyText.setFontSize(10);
        jobCompanyText.setText("Empresa, ");

        XWPFRun jobLocationText = experienceParagraph.createRun();
        jobLocationText.setFontFamily("Arial");
        jobLocationText.setFontSize(10);
        jobLocationText.setText("Cidade, Estado");

        XWPFParagraph jobDescriptionParagraph = document.createParagraph();
        jobDescriptionParagraph.setIndentationLeft(150 * 5);
        XWPFRun jobDescriptionText = jobDescriptionParagraph.createRun();
        jobDescriptionText.setFontFamily("Arial");
        jobDescriptionText.setFontSize(10);
        jobDescriptionText.setItalic(true);
        jobDescriptionText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed luctus tempus dolor, non volutpat neque rutrum aliquam. Interdum et malesuada fames ac ante ipsum primis in faucibus.");

        //Second experience
        document.createParagraph();
        experienceParagraph = document.createParagraph();
        experienceJobText = experienceParagraph.createRun();
        experienceJobText.setFontFamily("Arial");
        experienceJobText.setFontSize(10);
        experienceJobText.setBold(true);
        experienceJobText.setText("Estagiário de Desenvolvimento, ");

        jobDateText = experienceParagraph.createRun();
        experienceJobText.setFontFamily("Arial");
        experienceJobText.setFontSize(10);
        jobDateText.setText("Agosto – Dezembro 2016, ");

        jobCompanyText = experienceParagraph.createRun();
        jobCompanyText.setFontFamily("Arial");
        jobCompanyText.setFontSize(10);
        jobCompanyText.setText("Empresa, ");

        jobLocationText = experienceParagraph.createRun();
        jobLocationText.setFontFamily("Arial");
        jobLocationText.setFontSize(10);
        jobLocationText.setText("Cidade, São Paulo");

        jobDescriptionParagraph = document.createParagraph();
        jobDescriptionParagraph.setIndentationLeft(150 * 5);
        jobDescriptionText = jobDescriptionParagraph.createRun();
        jobDescriptionText.setFontFamily("Arial");
        jobDescriptionText.setFontSize(10);
        jobDescriptionText.setItalic(true);
        jobDescriptionText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed luctus tempus dolor, non volutpat neque rutrum aliquam. Interdum et malesuada fames ac ante ipsum primis in faucibus.");
    }

    private void addLineSeparator(XWPFDocument document) {
        //Separator
        XWPFRun separatorText = document.createParagraph().createRun();
        separatorText.setFontFamily("Arial");
        separatorText.setFontSize(10);
        separatorText.setText("_____________________________________________________________________________");
    }

    @Override
    protected void createDocumentFooter(XWPFDocument document) {
        System.out.println("No Footer");
    }
}
