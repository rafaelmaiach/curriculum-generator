package br.unesp.rc.curriculumGenerator.controller.command;

import br.unesp.rc.curriculumGenerator.controller.helper.Helper;
import br.unesp.rc.curriculumGenerator.model.Access;
import br.unesp.rc.curriculumGenerator.model.User;
import br.unesp.rc.curriculumGenerator.service.FactoryService;
import br.unesp.rc.curriculumGenerator.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class SignIn implements ICommand {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (Helper.isRequestMethodOptions(httpExchange))
            return;
        
        String JSONRequest = Helper.getJSONfromHttpExchange(httpExchange);
        String JSONResponse = "";

        //JSON from String to Object
        Access access = new ObjectMapper().readValue(JSONRequest, Access.class);

        if (access != null) {
            String login = access.getLogin();
            String password = access.getPassword();

            UserService userService = FactoryService.getUserService();
            User user = userService.selectUserByLogin(login, password);

            JSONResponse = new ObjectMapper().writer().writeValueAsString(user);
        }

        // Add the required response header for a JSON Response
        Headers headers = httpExchange.getResponseHeaders();
        headers.add("Content-Type", "application/json");

        httpExchange.sendResponseHeaders(200, JSONResponse.getBytes().length);
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(JSONResponse.getBytes());
        outputStream.close();
    }
}
