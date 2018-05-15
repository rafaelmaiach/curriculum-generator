package br.unesp.rc.curriculumGenerator.controller.command;

import br.unesp.rc.curriculumGenerator.controller.helper.Helper;
import br.unesp.rc.curriculumGenerator.model.Curriculum;
import br.unesp.rc.curriculumGenerator.utils.CurriculumModel1;
import br.unesp.rc.curriculumGenerator.utils.GenerateCurriculum;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;

public class GetCurriculum implements ICommand {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String JSONString = Helper.getJSONfromHttpExchange(httpExchange);

        //JSON from String to Object
        Curriculum curriculum = new ObjectMapper().readValue(JSONString, Curriculum.class);

        GenerateCurriculum generateCurriculum = new CurriculumModel1();
        File generatedCurriculum = generateCurriculum.Export(curriculum);

        // Add the required response header for a Word file
        Headers headers = httpExchange.getResponseHeaders();
        headers.add("Content-Type", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");

        byte[] byteArray = new byte[(int) generatedCurriculum.length()];
        FileInputStream fileInputStream = new FileInputStream(generatedCurriculum);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        bufferedInputStream.read(byteArray, 0, byteArray.length);

        // Set response
        httpExchange.sendResponseHeaders(200, generatedCurriculum.length());
        OutputStream responseBody = httpExchange.getResponseBody();
        responseBody.write(byteArray, 0, byteArray.length);
        responseBody.close();
    }
}
