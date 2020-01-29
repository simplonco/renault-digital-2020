package com.renault.servlets;

import com.renault.model.Car;
import com.renault.service.CarsService;

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
import java.util.List;
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
        String brand = request.getParameter("brand");
        List<Car> cars = CarsService.getCars(brand);
        JsonArrayBuilder json = Json.createArrayBuilder();
        for (Car car : cars) {
            json.add(car.getBrand() + " - " + car.getModel());
        }
        PrintWriter writer = response.getWriter();
        writer.write(json.build().toString());
        response.setHeader("Content-Type", "application/json");
    }

    private void doGetHtml(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Set<String> brands = CarsService.getBrands();
        request.setAttribute("brands", brands);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cars.jsp");
        dispatcher.forward(request, response);
    }

}
