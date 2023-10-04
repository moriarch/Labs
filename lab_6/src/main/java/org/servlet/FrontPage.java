package org.servlet;

import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.servlet.DB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/")

public class FrontPage extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String message = getServletConfig().getInitParameter("message");
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        try {
//            writer.println("<h2>" + message + "</h2>");
//        } finally {
//            writer.close();
//        }
//    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ArrayList<Product> products = DB.selectAll();

        request.setAttribute("products", products);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
