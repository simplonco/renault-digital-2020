package com.renault;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    public static final int DEFAULT_MPG = 100;

    /*
     * Retourne une liste de voiture à partir d'une liste d'un stream de lignes.
     *
     * Utilise la méthode Car.build.
     */
    public static List<Car> getCars(Stream<String> lines) {
        return lines
                .skip(1)
                .map(line -> line.split(","))
                .map(columns -> Car.build(columns[0], columns[1], columns[2], columns[3]))
                .collect(Collectors.toList());
    }

    /*
     * Retourne la voiture qui correspond à ces critères.
     */
    public static Optional<Car> getCar(List<Car> cars, int year, String brand, String model) {
        return cars.stream()
                .filter(car -> car.getYear() == year)
                .filter(car -> car.getBrand().equals(brand))
                .filter(car -> car.getModel().equals(model))
                .findFirst();
    }

    /*
     * Retourne la consommation en MPG de la voiture, ou la valeur de DEFAULT_MPG si le MPG n'existe pas.
     */
    public static Integer getMpgOrDefault(Car car) {
        return car.getMpg().orElse(DEFAULT_MPG);
    }

    /*
     * Retourne la consommation unité métrique, pour le calcul,
     * voir https://www.calculateme.com/gas-mileage/us-mpg-to-liters-per-100-km
     */
    public static Optional<Double> getLitersPer100Km(Car car) {
        return car.getMpg().map(mpg -> (100 * 3.785411784) / (1.609344 * mpg));
    }

    /*
     * Retourne la somme de tous les MPG pour une marque en particulier.
     */
    public static Optional<Integer> sumMpgForBrand(List<Car> cars, String brand) {
        cars.stream()
                .filter(car -> car.getBrand().equals(brand))
                .map(Car::getMpg)
                .mapToInt(mpg -> mpg.orElse(0))
                .sum();
        return cars.stream()
                .filter(car -> car.getBrand().equals(brand))
                .map(Car::getMpg)
                .map(mpg -> mpg.orElse(0))
                .reduce(Integer::sum);
    }

    /*
     * Retourne vrai si ce modèle existe.
     */
    public static boolean containsModelIgnoreCase(List<Car> cars, String model) {
        return cars.stream().anyMatch(car -> car.getModel().equalsIgnoreCase(model));
    }

    /*
     * Retourne une map avec comme clefs les années, comme valeur la liste des voitures pour l'année correspondante.
     */
    public static Map<Integer, List<Car>> getCarsPerYear(List<Car> cars) {
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getYear));
    }

    /*
     * Retourne une map avec comme clefs les années, comme valeur le compte des voitures pour cette année.
     */
    public static Map<Integer, Long> getCarsCountPerYear(List<Car> cars) {
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getYear, Collectors.counting()));
    }

    /**
     * La classe voiture, ne pas toucher :)
     */
    public static class Car {

        private final int year;
        private final String brand;
        private final String model;
        private final Integer mpg;

        public static Car build(String year, String brand, String model, String mpg) {
            int yearMapped = Integer.parseInt(year);
            Integer mpgMapped;
            try {
                mpgMapped = Integer.parseInt(mpg);
            } catch (NumberFormatException e) {
                mpgMapped = null;
            }
            String brandMapped = brand.replaceAll("\"", "");
            String modelMapped = model.replaceAll("\"", "");
            return new Car(yearMapped, brandMapped, modelMapped, mpgMapped);
        }

        public Car(int year, String brand, String model, Integer mpg) {
            this.year = year;
            this.brand = brand;
            this.model = model;
            this.mpg = mpg;
        }

        public int getYear() {
            return year;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public Optional<Integer> getMpg() {
            return Optional.ofNullable(mpg);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "year=" + year +
                    ", brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", mpg=" + mpg +
                    '}';
        }

    }

}
