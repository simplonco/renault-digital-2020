package com.renault.service;

import com.renault.model.Car;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class CarsService {

    public static Set<String> getBrands() {
        // TODO step 1
        return Set.of();
    }

    public static List<Car> getCars(String brand) {
        // TODO step 2
        return List.of();
    }

    private static List<String> getCarsFromCsvFile() {
        InputStream resource = CarsService.class.getResourceAsStream("cars.csv");
        return new BufferedReader(new InputStreamReader(resource)).lines().collect(toList());
    }

}
