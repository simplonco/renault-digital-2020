package com.renault.servlets;

import javax.json.Json;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "WelcomeServlet", value = "/")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");

        String name = req.getParameter("name");

        if ("application/json".equals(req.getHeader("Content-Type"))) {
            String json = Json.createObjectBuilder()
                    .add("voiture", name)
                    .add("date", LocalDate.now().toString())
                    .build()
                    .toString();
            resp.getWriter().write(json);
        } else {
            req.setAttribute("name", name);
            requestDispatcher.forward(req, resp);
        }
    }

}
