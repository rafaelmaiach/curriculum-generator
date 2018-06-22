package br.unesp.rc.curriculumGenerator.apachepoi.utils;

import br.unesp.rc.curriculumGenerator.model.Curriculum;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This abstract class is used to define the basic steps to generate a curriculum file.
 * All Curriculum Model class should extends this.
 */
public abstract class GenerateCurriculum {
    private final static String CURRICULUM_PATH = "generatedCurriculum/";
    protected XWPFDocument document;

    /**
     * The generated ".docx" file is exported to the path: $PROJECT\generatedCurriculum\
     *
     * @param curriculum The curriculum to generate the file.
     * @return The "File" class with the instance to the ".docx" file generated.
     * @throws IOException
     * @throws InvalidOperationException Curriculum's user is not defined
     */
    public File Export(Curriculum curriculum) throws IOException {
        String userName = curriculum.getName();
        if (!(userName == null || userName.isEmpty())) {
            String curriculumFileName = userName + ".docx";
            curriculumFileName = curriculumFileName.replaceAll("[^a-zA-Z0-9.-]", "_");

            new File(CURRICULUM_PATH).mkdirs(); //Create PATH
            File documentFile = new File(CURRICULUM_PATH + curriculumFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(documentFile);

            this.document = new XWPFDocument();

            createDocumentHeader(curriculum);
            createDocumentContent(curriculum);
            createDocumentFooter(curriculum);

            document.write(fileOutputStream);
            fileOutputStream.close();

            return documentFile;
        } else
            throw new InvalidOperationException("Curriculum's user not defined");
    }

    /**
     * Creates the Document Header
     *
     * @param curriculum The curriculum to generate the file.
     */
    protected abstract void createDocumentHeader(Curriculum curriculum);

    /**
     * Creates the Document Content
     *
     * @param curriculum The curriculum to generate the file.
     */
    protected abstract void createDocumentContent(Curriculum curriculum);

    /**
     * Creates the Document Footer
     *
     * @param curriculum The curriculum to generate the file.
     */
    protected abstract void createDocumentFooter(Curriculum curriculum);
}
