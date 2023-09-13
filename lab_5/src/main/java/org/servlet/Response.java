
package org.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;



public class Response extends HttpServlet {
    private String getJsonFromUrl(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer responseBuffer = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            responseBuffer.append(inputLine);
        }
        in.close();
        return responseBuffer.toString();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Lab 5</h1>");
        response.getWriter().println("Selected: "+request.getParameter("type"));
        String json = getJsonFromUrl("https://api.unsplash.com/search/photos?page=1&per_page=1&query="+request.getParameter("type")+"&client_id=99b80bfb380127e953c2835b75c228a16125d0a557c5d943b76405611e966e10"); // замените на нужный URL
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(json).getAsJsonObject();
        String raw = obj.getAsJsonArray("results").get(0).getAsJsonObject().getAsJsonObject("urls").get("raw").getAsString();
        System.out.println(raw);
        response.getWriter().println("<a href='/form'>Get back</a>");
        response.getWriter().println("<img src='" + raw + "' style=\"max-width: 100%;\" />");
    }
}
