package br.unesp.rc.curriculumGenerator.apachepoi.utils;

import br.unesp.rc.curriculumGenerator.model.Curriculum;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class GenerateCurriculum {
    public File Export(Curriculum curriculum) throws IOException {
        String userName = curriculum.getName();
        if (!(userName == null || userName.isEmpty())) {
            final String CURRICULUM_PATH = "generatedCurriculum/";
            String curriculumFileName = userName + ".docx";
            curriculumFileName = curriculumFileName.replaceAll("[^a-zA-Z0-9.-]", "_");

            new File(CURRICULUM_PATH).mkdirs(); //Create PATH
            File documentFile = new File(CURRICULUM_PATH + curriculumFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(documentFile);

            XWPFDocument document = new XWPFDocument();

            createDocumentHeader(document, curriculum);
            createDocumentContent(document, curriculum);
            createDocumentFooter(document, curriculum);

            document.write(fileOutputStream);
            fileOutputStream.close();

            return documentFile;
        } else
            throw new InvalidOperationException("Curriculum's user not defined");
    }

    protected abstract void createDocumentHeader(XWPFDocument document, Curriculum curriculum);

    protected abstract void createDocumentContent(XWPFDocument document, Curriculum curriculum);

    protected abstract void createDocumentFooter(XWPFDocument document, Curriculum curriculum);
}
