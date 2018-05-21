package br.unesp.rc.curriculumGenerator.controller.command;

import br.unesp.rc.curriculumGenerator.DAO.CurriculumDAO;
import br.unesp.rc.curriculumGenerator.DAO.FactoryDAO;
import br.unesp.rc.curriculumGenerator.controller.helper.Helper;
import br.unesp.rc.curriculumGenerator.model.Curriculum;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class GetCurriculumList implements ICommand {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        int userId = 0;
        String JSONResponse = "";

        //Find GET Request parameters from httpExchange object
        String URIQuery = httpExchange.getRequestURI().getQuery();
        if (!(URIQuery == null | URIQuery.isEmpty())) {
            //Use "queryToMap" function to create a Map object that has all parameters and and its respective value
            Map<String, String> GETRequestParams = Helper.queryToMap(URIQuery);

            //Get "userId" value and parse to int
            if (!GETRequestParams.get("userId").isEmpty())
                userId = Integer.parseInt(GETRequestParams.get("userId"));

            //SELECT user's curriculum from database and set JSONResponse
            if (userId > 0) {
                CurriculumDAO curriculumDAO = FactoryDAO.getCurriculumDAO();
                List<Curriculum> curriculumList = curriculumDAO.selectCurriculumByUserId(userId);

                JSONResponse = new ObjectMapper().writer().writeValueAsString(curriculumList);
            }
        }

        // Add the required response header for a JSON Response
        Headers headers = httpExchange.getResponseHeaders();
        headers.add("Content-Type", "appication/json");

        httpExchange.sendResponseHeaders(200, JSONResponse.getBytes().length);
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(JSONResponse.getBytes());
        outputStream.close();
    }
}
