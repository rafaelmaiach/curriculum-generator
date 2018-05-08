package br.unesp.rc.curriculumGenerator.utils;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileOutputStream;

public abstract class GenerateCurriculum {
    public void Export() throws Exception {
        String TEST_CURRICULUM_PATH = "generatedCurriculum/";
        String TEST_CURRICULUM_FILE = "test.docx";

        Boolean dirCreated = new File(TEST_CURRICULUM_PATH).mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(TEST_CURRICULUM_PATH + TEST_CURRICULUM_FILE));

        XWPFDocument document = new XWPFDocument();

        createDocumentHeader(document);
        createDocumentContent(document);
        createDocumentFooter(document);

        document.write(fileOutputStream);
        fileOutputStream.close();

        System.out.println("Document created");
    }

    protected abstract void createDocumentHeader(XWPFDocument document);

    protected abstract void createDocumentContent(XWPFDocument document);

    protected abstract void createDocumentFooter(XWPFDocument document);
}
