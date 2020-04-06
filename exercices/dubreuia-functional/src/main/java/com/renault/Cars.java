package com.renault;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Cars {

    public static final int DEFAULT_MPG = 100;

    /*
     * Retourne une liste de voiture à partir d'une liste d'un stream de lignes.
     *
     * Utilise la méthode Car.build.
     */
    public static List<Car> getCars(Stream<String> lines) {
        // TODO implement
        return Collections.emptyList();
    }

    /*
     * Retourne la voiture qui correspond à ces critères.
     */
    public static Optional<Car> getCar(List<Car> cars, int year, String brand, String model) {
        // TODO implement
        return Optional.empty();
    }

    /*
     * Retourne la consommation en MPG de la voiture, ou la valeur de DEFAULT_MPG si le MPG n'existe pas.
     */
    public static Integer getMpgOrDefault(Car car) {
        // TODO implement
        return null;
    }

    /*
     * Retourne la consommation unité métrique, pour le calcul,
     * voir https://www.calculateme.com/gas-mileage/us-mpg-to-liters-per-100-km
     */
    public static Optional<Double> getLitersPer100Km(Car car) {
        // TODO implement
        return Optional.empty();
    }

    /*
     * Retourne la somme de tous les MPG pour une marque en particulier.
     */
    public static Optional<Integer> sumMpgForBrand(List<Car> cars, String brand) {
        // TODO implement
        return Optional.empty();
    }

    /*
     * Retourne vrai si ce modèle existe.
     */
    public static boolean containsModelIgnoreCase(List<Car> cars, String model) {
        // TODO implement
        return false;
    }

    /*
     * Retourne une map avec comme clefs les années, comme valeur la liste des voitures pour l'année correspondante.
     */
    public static Map<Integer, List<Car>> getCarsPerYear(List<Car> cars) {
        // TODO implement
        return Collections.emptyMap();
    }

    /*
     * Retourne une map avec comme clefs les années, comme valeur le compte des voitures pour cette année.
     */
    public static Map<Integer, Long> getCarsCountPerYear(List<Car> cars) {
        // TODO implement
        return Collections.emptyMap();
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
