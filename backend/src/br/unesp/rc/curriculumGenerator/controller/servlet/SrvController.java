package br.unesp.rc.curriculumGenerator.controller.servlet;

import br.unesp.rc.curriculumGenerator.controller.command.*;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SrvController {
    public void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/registerUser", new RegisterUser());
        server.createContext("/signIn", new SignIn());
        server.createContext("/newCurriculum", new NewCurriculum());
        server.createContext("/listCurriculums", new ListCurriculums());
        server.createContext("/downloadCurriculum", new DownloadCurriculum());
        server.setExecutor(null); // creates a default executor
        server.start();
    }
}
