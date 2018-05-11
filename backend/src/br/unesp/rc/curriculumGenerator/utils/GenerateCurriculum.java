package br.unesp.rc.curriculumGenerator.utils;

import br.unesp.rc.curriculumGenerator.model.Curriculum;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileOutputStream;

public abstract class GenerateCurriculum {
    public void Export(Curriculum curriculum) throws Exception {
        String TEST_CURRICULUM_PATH = "generatedCurriculum/";
        String TEST_CURRICULUM_FILE = "test.docx";

        Boolean dirCreated = new File(TEST_CURRICULUM_PATH).mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(TEST_CURRICULUM_PATH + TEST_CURRICULUM_FILE));

        XWPFDocument document = new XWPFDocument();

        createDocumentHeader(document, curriculum);
        createDocumentContent(document, curriculum);
        createDocumentFooter(document, curriculum);

        document.write(fileOutputStream);
        fileOutputStream.close();

        System.out.println("Document created");
    }

    protected abstract void createDocumentHeader(XWPFDocument document, Curriculum curriculum);

    protected abstract void createDocumentContent(XWPFDocument document, Curriculum curriculum);

    protected abstract void createDocumentFooter(XWPFDocument document, Curriculum curriculum);
}
