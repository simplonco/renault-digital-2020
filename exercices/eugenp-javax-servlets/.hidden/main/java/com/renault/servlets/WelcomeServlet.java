package com.renault.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeServlet", urlPatterns = "/")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String contentType = request.getHeader("Content-Type");
        if (contentType != null && contentType.equals("application/json")) {
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write("{\"name\": \"" + name + "\"}");
        } else {
            request.setAttribute("name", name);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}
