package com.renault.service;

import com.renault.model.Car;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class CarsService {

    private CarsService() {
        // static only
    }

    public static Set<String> getBrands() {
        // TODO step 3
        Set<String> brands = new HashSet<>();
        for (String line : CarsService.getCarsFromCsvFile()) {
            String[] column = line.split(";");
            String replace = column[0].replace("\"", "");
            brands.add(replace);
        }
        return brands;
    }

    public static List<Car> getCars(String brand) {
        // TODO step 3
        List<Car> cars = new ArrayList<>();
        for (String line : CarsService.getCarsFromCsvFile()) {
            String[] column = line.split(";");
            String carBrand = column[0].replace("\"", "");
            String carModel = column[1].replace("\"", "").strip();
            if (carBrand.equals(brand)) {
                Car car = new Car(carBrand, carModel);
                cars.add(car);
            }
        }
        return cars;
    }

    private static List<String> getCarsFromCsvFile() {
        // TODO step 3
        InputStream resource = CarsService.class.getResourceAsStream("cars.csv");
        return new BufferedReader(new InputStreamReader(resource)).lines().collect(toList());
    }

}
