package com.renault.servlets;

import com.renault.service.CarsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

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
        Set<String> brands = CarsService.getBrands();
        request.setAttribute("brands", brands);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cars.jsp");
        dispatcher.forward(request, response);
    }

}
