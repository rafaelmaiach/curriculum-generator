package br.unesp.rc.curriculumGenerator.controller.servlet;

import br.unesp.rc.curriculumGenerator.controller.command.DownloadCurriculum;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SrvController {
    public void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/api/word", new DownloadCurriculum());
        server.setExecutor(null); // creates a default executor
        server.start();
    }
}
