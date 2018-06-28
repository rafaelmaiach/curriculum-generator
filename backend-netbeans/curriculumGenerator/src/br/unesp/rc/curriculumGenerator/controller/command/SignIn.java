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

/**
 * This class is used as a command to the frontend application to Authenticate the user
 */
public class SignIn implements ICommand {

    /**
     * Receives a POST Request with a Access JSON and verify if the Access already exists in the database
     *
     * @param httpExchange httpExchange
     * @throws IOException IOException
     */
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

            //Don't return Access to Frontend
            user.setAccess(null);

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
