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
        return getCarsFromCsvFile().stream()
                .map(line -> line.split(";")[0].replace('"', ' ').strip())
                .collect(toSet());
    }

    public static List<Car> getCars(String brand) {
        return getCarsFromCsvFile().stream()
                .map(line -> line.split(";"))
                .map(columns -> new String[]{columns[0].replace('"', ' '), columns[1].replace('"', ' ')})
                .map(columns -> new Car(columns[0].strip(), columns[1].strip()))
                .filter(car -> brand == null || brand.isBlank() || car.getBrand().equals(brand))
                .collect(toList());
    }

    private static List<String> getCarsFromCsvFile() {
        InputStream resource = CarsService.class.getResourceAsStream("cars.csv");
        return new BufferedReader(new InputStreamReader(resource)).lines().collect(toList());
    }

}
