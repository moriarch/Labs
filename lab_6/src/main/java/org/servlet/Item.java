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



@WebServlet("/item/*")
public class Item extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        String id = uri.substring(uri.lastIndexOf("/") + 1);

        Product product =  DB.selectByID(Integer.parseInt(id));

        request.setAttribute("product", product);

        getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);

    }
}

