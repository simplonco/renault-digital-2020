package com.renault.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CarsServlet", value = "/cars")
public class CarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contentType = request.getHeader("Content-Type");
        if ("application/json".equals(contentType)) {
            doGetJson(request, response);
        } else {
            doGetHtml(request, response);
        }
    }

    private void doGetJson(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // TODO step 2
    }

    private void doGetHtml(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO step 1
    }

}
