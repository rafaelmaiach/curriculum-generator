package br.unesp.rc.curriculumGenerator.demo;

import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class test {
    private static final String TEST_CURRICULUM_PATH = "generatedCurriculum/";
    private static final String TEST_CURRICULUM_FILE = "test.docx";

    public static void main(String args[]) {
        try {
            Boolean dirCreated = new File(TEST_CURRICULUM_PATH).mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(TEST_CURRICULUM_PATH + TEST_CURRICULUM_FILE));

            XWPFDocument document = new XWPFDocument();

            createDocumentHeader(document);
            createDocumentContent(document);
            createDocumentFooter(document);

            document.write(fileOutputStream);
            fileOutputStream.close();

            System.out.println("Document created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDocumentHeader(XWPFDocument document) {
        XWPFHeader header = document.createHeader(HeaderFooterType.FIRST);
        XWPFTable headerTable = header.createTable(1, 1);
        XWPFTableCell tableCell = headerTable.getRow(0).getCell(0);
        tableCell.removeParagraph(0);

        XWPFRun firstLine = tableCell.addParagraph().createRun();
        firstLine.setText("SEU NOME");
        firstLine.setColor("0070C0");
        firstLine.setFontFamily("Georgia");
        firstLine.setFontSize(32);
        firstLine.setBold(true);

        XWPFRun secondLine = tableCell.addParagraph().createRun();
        secondLine.setText("Seu Endereço aqui");
        secondLine.setColor("595959");
        secondLine.setFontFamily("Calibri");
        secondLine.setFontSize(11);
        secondLine.setBold(false);

        XWPFRun thirdLine = tableCell.addParagraph().createRun();
        thirdLine.setText("Celular: (00) 9 9999 9999");
        thirdLine.setColor("595959");
        thirdLine.setFontFamily("Calibri");
        thirdLine.setFontSize(11);
        thirdLine.setBold(false);

        XWPFRun fourthLine = tableCell.addParagraph().createRun();
        fourthLine.setText("Seu Email");
        fourthLine.setText(" - Seu Linkedin");
        fourthLine.setText(" - Seu Twitter");
        fourthLine.setText(" - Seu Blog");
        fourthLine.setText(" - Seu Portfolio");
        fourthLine.setColor("0070C0");
        fourthLine.setFontFamily("Calibri");
        fourthLine.setFontSize(11);
        fourthLine.setBold(true);

        document.createParagraph().setBorderBottom(Borders.SINGLE);
    }

    private static void createDocumentContent(XWPFDocument document) {
        createObjectiveSection(document);
        createExperienceSection(document);
        createFormationSection(document);
        createAbilitySection(document);
        createProfessionalProfileSection(document);
    }

    private static void createObjectiveSection(XWPFDocument document) {
        document.createParagraph();
        XWPFParagraph objectiveTitle = document.createParagraph();
        objectiveTitle.setStyle("Title1");

        XWPFRun objectiveTitleText = objectiveTitle.createRun();
        objectiveTitleText.setText("OBJETIVO");
        objectiveTitleText.setFontFamily("Georgia");
        objectiveTitleText.setFontSize(14);
        objectiveTitleText.setBold(true);

        XWPFTable objectiveTable = document.createTable(1, 1);
        XWPFTableCell tableCell = objectiveTable.getRow(0).getCell(0);
        tableCell.removeParagraph(0);

        XWPFParagraph tableParagraph = tableCell.addParagraph();
        tableParagraph.setIndentationLeft(5 * 102);
        XWPFRun cellText = tableParagraph.createRun();

        cellText.setText("Desejo fazer parte do time da empresa oferecendo o melhor. " +
                "Sou uma pessoa muito dedicada e comprometida com as atribuições que são dadas a mim.");
        cellText.setColor("595959");
        cellText.setFontFamily("Calibri");
        cellText.setFontSize(11);
    }

    private static void createExperienceSection(XWPFDocument document) {
    }

    private static void createFormationSection(XWPFDocument document) {
    }

    private static void createAbilitySection(XWPFDocument document) {
    }

    private static void createProfessionalProfileSection(XWPFDocument document) {
        document.createParagraph();
        XWPFParagraph professionalProfileTitle = document.createParagraph();
        professionalProfileTitle.setStyle("Title1");

        XWPFRun professionalProfileTitleText = professionalProfileTitle.createRun();
        professionalProfileTitleText.setText("PERFIL PROFISSIONAL");
        professionalProfileTitleText.setFontFamily("Georgia");
        professionalProfileTitleText.setFontSize(14);
        professionalProfileTitleText.setBold(true);

        XWPFTable professionalProfileTable = document.createTable(1, 1);
        XWPFTableCell tableCell = professionalProfileTable.getRow(0).getCell(0);
        tableCell.removeParagraph(0);

        XWPFParagraph tableParagraph = tableCell.addParagraph();
        tableParagraph.setIndentationLeft(5 * 102);
        XWPFRun cellText = tableParagraph.createRun();

        cellText.setText("Descreva aqui o que você mais gosta de fazer, publicações relevantes, certificações, idiomas " +
                "e o que mais você ver como importante de você e que tenha a ver com a vaga pretendida.");
        cellText.setColor("595959");
        cellText.setFontFamily("Calibri");
        cellText.setFontSize(11);
    }

    private static void createDocumentFooter(XWPFDocument document) {
    }
}
