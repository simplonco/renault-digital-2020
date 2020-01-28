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
        String header = request.getHeader("Content-Type");
        if ("application/json".equals(header)) {
            PrintWriter writer = response.getWriter();
            writer.write("{ name: titi }");
        } else {
            String name = request.getParameter("name");
            request.setAttribute("key", name);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
            dispatcher.forward(request, response);
        }
    }

}
