package br.unesp.rc.curriculumGenerator.controller.command;

import br.unesp.rc.curriculumGenerator.controller.helper.Helper;
import br.unesp.rc.curriculumGenerator.model.Curriculum;
import br.unesp.rc.curriculumGenerator.service.CurriculumService;
import br.unesp.rc.curriculumGenerator.service.FactoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

/**
 * This class is used as a command to the frontend application to insert a new curriculum to database.
 */
public class NewCurriculum implements ICommand {

    /**
     * Receives a POST Request with a Curriculum JSON and inserts the Curriculum to database.
     *
     * @param httpExchange httpExchange
     * @throws IOException IOException
     */
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (Helper.isRequestMethodOptions(httpExchange))
            return;

        String JSONRequest = Helper.getJSONfromHttpExchange(httpExchange);

        ObjectMapper objectMapper = new ObjectMapper();
        Curriculum curriculum = objectMapper.readValue(JSONRequest, Curriculum.class);

        int userId = curriculum.getUser().getIdUser();

        CurriculumService curriculumService = FactoryService.getCurriculumService();
        int curriculumId = curriculumService.insertCurriculum(curriculum, userId);

        //Set the "curriculumId" as response to the frontend
        String response = Integer.toString(curriculumId);

        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
