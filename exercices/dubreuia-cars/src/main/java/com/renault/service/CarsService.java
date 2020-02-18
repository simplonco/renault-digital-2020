package com.renault.service;

import com.renault.model.Car;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarsService {

    private CarsService() {
        // static only
    }

    public static Set<String> getBrands() {
        Set<String> brands = new HashSet<>();
        String url = "jdbc:mysql://172.17.0.2:3306/renault";
        try (Connection connection = DriverManager.getConnection(url, "root", "12345")) {
            String sql = "SELECT brand FROM cars";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String carBrand = resultSet.getString("brand");
                brands.add(carBrand);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return brands;
    }

    public static List<Car> getCars(String brand) {
        List<Car> coche = new ArrayList<>();
        String url = "jdbc:mysql://172.17.0.2:3306/renault";
        try (Connection connection = DriverManager.getConnection(url, "root", "12345")) {
            String sql = "SELECT brand, model FROM cars WHERE brand = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, brand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String carBrand = resultSet.getString("brand");
                String carModel = resultSet.getString("model");
                Car car = new Car(carBrand, carModel);
                coche.add(car);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return coche;
    }

}
