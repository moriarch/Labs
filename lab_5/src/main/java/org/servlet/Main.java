package org.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Lab 5</h1>");
        response.getWriter().println(
                "<form action='/response' method='GET'>" +
                        "<select name='type'>" +
                        "<option value='nature'>природа</option>" +
                        "<option value='auto'>автомобили</option>" +
                        "<option value='child'>дети</option>" +
                        "</select>"+
                        "<input type='submit' value='Отправить' / >"+
                "</form>"
        );

    }
}