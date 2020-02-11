package com.renault.service;

import com.renault.model.Car;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CarsDatabaseInsert {

    private CarsDatabaseInsert() {
        // static only
    }

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://172.17.0.2:3306/renault";
        try (Connection connection = DriverManager.getConnection(url, "root", "12345")) {
            List<Car> cars = getCars();
            for (Car car : cars) {
                String sql = "INSERT INTO cars VALUES (NULL, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, car.getBrand());
                preparedStatement.setString(2, car.getModel());
                preparedStatement.executeUpdate();
            }
        }
    }

    public static List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        for (String line : getCarsFromCsvFile()) {
            String[] column = line.split(";");
            String carBrand = column[0].replace("\"", "");
            String carModel = column[1].replace("\"", "").strip();
            Car car = new Car(carBrand, carModel);
            cars.add(car);
        }
        return cars;
    }

    public static List<String> getCarsFromCsvFile() {
        InputStream resource = CarsDatabaseInsert.class.getResourceAsStream("cars.csv");
        return new BufferedReader(new InputStreamReader(resource)).lines().collect(toList());
    }

}
