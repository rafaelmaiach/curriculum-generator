package br.unesp.rc.curriculumGenerator.controller.command;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public interface ICommand extends HttpHandler {
    public void handle(HttpExchange httpExchange) throws IOException;
}
