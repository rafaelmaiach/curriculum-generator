package br.unesp.rc.curriculumGenerator.controller.helper;

import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Class with static helper methods
 */
public class Helper {

    /**
     * Gets the JSON inside the HttpExchange object
     *
     * @param httpExchange Object with JSON inside
     * @return the JSON String
     */
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

    /**
     * Transform the URIQuery into a Map object
     * @param query The URIQuery from a GET Request
     * @return The Map object with all parameters from the GET Request
     */
    public static Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length > 1)
                result.put(pair[0], pair[1]);
            else
                result.put(pair[0], "");

        }
        return result;
    }

    public static boolean isRequestMethodOptions(HttpExchange httpExchange) throws IOException {
        httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");

        if (httpExchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            httpExchange.getResponseHeaders().add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            httpExchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type,Authorization");
            httpExchange.sendResponseHeaders(204, -1);
            return true;
        }

        return false;
    }
}
