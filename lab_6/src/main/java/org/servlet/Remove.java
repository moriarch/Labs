package org.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/remove/*")
public class Remove extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        String id = uri.substring(uri.lastIndexOf("/") + 1);
        DB.removeByID(Integer.parseInt(id));
        getServletContext().getRequestDispatcher("/removed.jsp").forward(request, response);

    }
}

