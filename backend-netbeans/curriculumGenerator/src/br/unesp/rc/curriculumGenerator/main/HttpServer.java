package br.unesp.rc.curriculumGenerator.main;

import br.unesp.rc.curriculumGenerator.controller.servlet.SrvController;

import java.io.IOException;

public class HttpServer {
    public static void main(String args[]) {
        SrvController srvController = new SrvController();
        try {
            srvController.startServer();

            System.out.println("Server Running...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
