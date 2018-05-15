package br.unesp.rc.curriculumGenerator.controller.helper;

import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Helper {
    public static String getJSONfromHttpExchange(HttpExchange httpExchange) {
        try {
            //We're assuming UTF-8
            InputStreamReader inputStreamReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // From now on, the right way of moving from bytes to utf-8 characters:
            int character;
            StringBuilder buf = new StringBuilder(512);
            while ((character = bufferedReader.read()) != -1)
                buf.append((char) character);

            bufferedReader.close();
            inputStreamReader.close();

            return buf.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
