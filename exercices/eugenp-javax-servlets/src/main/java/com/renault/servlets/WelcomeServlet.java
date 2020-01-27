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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String header = request.getHeader("Content-Type");
        String name = request.getParameter("name");
        if ("application/json".equals(header)) {
            JsonArrayBuilder elements = Json.createArrayBuilder()
                    .add(1)
                    .add(2)
                    .add(3);
            String json = Json.createObjectBuilder()
                    .add("name", name)
                    .add("date", LocalDate.now().toString())
                    .add("elements", elements)
                    .build()
                    .toString();
            PrintWriter writer = response.getWriter();
            writer.write(json);
        } else {
            request.setAttribute("name", name);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}
