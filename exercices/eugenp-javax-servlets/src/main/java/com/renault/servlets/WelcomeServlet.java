package com.renault.servlets;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "WelcomeServlet", value = "/")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contentType = request.getHeader("Content-Type");
        String parameter = request.getParameter("name");
        if ("application/json".equals(contentType)) {
            JsonArrayBuilder add = Json.createArrayBuilder()
                    .add(1)
                    .add(2)
                    .add(3);
            String json = Json.createObjectBuilder()
                    .add("name", parameter)
                    .add("date", LocalDate.now().toString())
                    .add("list", add)
                    .build()
                    .toString();
            PrintWriter writer = response.getWriter();
            writer.write(json);
        } else {
            request.setAttribute("nom", parameter);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/welcome.jsp");
            dispatcher.forward(request, response);
        }
    }
}
