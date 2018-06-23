package br.unesp.rc.curriculumGenerator.controller.command;

import br.unesp.rc.curriculumGenerator.controller.helper.Helper;
import br.unesp.rc.curriculumGenerator.model.User;
import br.unesp.rc.curriculumGenerator.service.FactoryService;
import br.unesp.rc.curriculumGenerator.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

/**
 * This class is used as a command to the frontend application to insert a New User to database.
 */
public class RegisterUser implements ICommand {

    /**
     * Receives a POST Request with a User JSON and inserts the User to database.
     *
     * @param httpExchange httpExchange
     * @throws IOException IOException
     */
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (Helper.isRequestMethodOptions(httpExchange))
            return;

        String JSONRequest = Helper.getJSONfromHttpExchange(httpExchange);

        //JSON from String to Object
        User user = new ObjectMapper().readValue(JSONRequest, User.class);

        UserService userService = FactoryService.getUserService();
        int idUser = userService.insertUser(user);

        //Set the "userId" as response to the frontend
        String response = Integer.toString(idUser);

        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
