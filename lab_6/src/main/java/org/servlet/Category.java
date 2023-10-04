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



@WebServlet("/category/*")
public class Category extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        String category = uri.substring(uri.lastIndexOf("/") + 1);

        ArrayList<Product> products = DB.selectByCategory(category);

        request.setAttribute("products", products);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}

