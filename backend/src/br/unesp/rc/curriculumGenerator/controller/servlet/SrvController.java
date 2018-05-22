package br.unesp.rc.curriculumGenerator.controller.servlet;

import br.unesp.rc.curriculumGenerator.controller.command.*;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SrvController {
    public void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/api/word", new DownloadCurriculum());
        server.createContext("/curriculums", new GetCurriculumList());
        server.createContext("/login", new SignIn());
        server.createContext("/registration", new UserRegistration());
        server.createContext("/newcurriculum", new NewCurriculum());
        server.setExecutor(null); // creates a default executor
        server.start();
    }
}
