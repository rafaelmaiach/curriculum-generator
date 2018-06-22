package br.unesp.rc.curriculumGenerator.utils;

import java.sql.*;

/**
 * Class used to Connect to MySQL DataBase
 */
public class FactoryConnection implements IMySQL {

    private FactoryConnection() {
    }

    /**
     * Creates a connection to Database
     *
     * @return the connection created
     */
    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connection Error. Message: " + ex.getMessage());
        }

        return con;
    }

    public static void close(Connection con) {

    }

    public static void close(Connection con, PreparedStatement pstm) {

    }

    public static void close(Connection con, PreparedStatement pstm, ResultSet res) {

    }

}
