package br.unesp.rc.curriculumGenerator.controller.command;

import br.unesp.rc.curriculumGenerator.controller.helper.Helper;
import br.unesp.rc.curriculumGenerator.model.Curriculum;
import br.unesp.rc.curriculumGenerator.utils.FactoryCurriculumModel;
import br.unesp.rc.curriculumGenerator.utils.GenerateCurriculum;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DownloadCurriculum implements ICommand {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (Helper.isRequestMethodOptions(httpExchange))
            return;
        
        Object curriculumModel = -1; // Used to define with model will be generated and downloaded

        String JSONRequest = Helper.getJSONfromHttpExchange(httpExchange);

        //BEGIN - Get "Model" parameter from JSON and remove it from original JSON
        ObjectMapper objectMapper = new ObjectMapper();

        //Create a Map object to parse the original JSON request
        Map<String, String> jsonMap = objectMapper.readValue(JSONRequest, HashMap.class);

        //Get the "model" value and remove it from the Map
        curriculumModel = jsonMap.get("model");
        jsonMap.remove("model");
        if (curriculumModel == null) // If model wasn't defined we will use "-1" as default
            curriculumModel = -1;

        //Generate the JSON again, but WITHOUT the "model" parameter
        JSONRequest = objectMapper.writer().writeValueAsString(jsonMap);
        //END - Get "Model" parameter from JSON and remove it from original JSON

        //JSON from String to Object
        Curriculum curriculum = new ObjectMapper().readValue(JSONRequest, Curriculum.class);

        //Set default name at user's curriculum If not defined
        String userName = curriculum.getName();
        if (userName == null || userName.isEmpty())
            curriculum.setName("Default Name");

        GenerateCurriculum generateCurriculum = FactoryCurriculumModel.getCurriculumModel((int) curriculumModel);
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
