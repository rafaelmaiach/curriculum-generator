package br.unesp.rc.curriculumGenerator.demo;

import br.unesp.rc.curriculumGenerator.utils.FactoryConnection;

import java.sql.Connection;

public class test {
    public static void main(String args[]) {
        Connection con = FactoryConnection.getConnection();

        if (con != null)
            System.out.println("Connected...");
    }
}