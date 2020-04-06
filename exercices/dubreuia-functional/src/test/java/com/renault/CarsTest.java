package com.renault;

import com.renault.Cars.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsTest {

    // TODO change path to cars.csv
    public static final String PATH_CSV = "C:\\Users\\alex\\Projects\\renault-digital-2020\\exercices\\dubreuia-functional\\data\\cars.csv";

    private List<Car> cars;

    @BeforeEach
    public void beforeEach() throws IOException {
        Stream<String> lines = Files.lines(Paths.get(PATH_CSV), UTF_8);
        cars = Cars.getCars(lines);
        assertEquals(19772, cars.size());
    }

    @Test
    public void getCar() {
        Optional<Car> carRsx = Cars.getCar(cars, 2002, "ACURA", "RSX");

        assertEquals(2002, carRsx.orElseThrow().getYear());
        assertEquals("ACURA", carRsx.orElseThrow().getBrand());
        assertEquals("RSX", carRsx.orElseThrow().getModel());
        assertEquals(50, carRsx.orElseThrow().getMpg().orElseThrow().intValue());
    }

    @Test
    public void containsModelIgnoreCase() {
        boolean containsModelIgnoreCase = Cars.containsModelIgnoreCase(cars, "550 Iq Shift");
        assertTrue(containsModelIgnoreCase);
    }

    @Test
    public void getMpgOrDefault() {
        Optional<Car> carRsx = Cars.getCar(cars, 2002, "ACURA", "RSX");
        Optional<Car> carAccord = Cars.getCar(cars, 2003, "HONDA", "ACCORD");

        Integer carRsxMpg = Cars.getMpgOrDefault(carRsx.orElseThrow());
        Integer carAccordMpg = Cars.getMpgOrDefault(carAccord.orElseThrow());

        assertEquals(50, carRsxMpg.intValue());
        assertEquals(100, carAccordMpg.intValue());
    }

    @Test
    public void getLitersPer100Km() {
        Optional<Car> carRsx = Cars.getCar(cars, 2002, "ACURA", "RSX");
        Optional<Double> litersPer100Km = Cars.getLitersPer100Km(carRsx.orElseThrow());

        assertEquals(4.704291666666666, litersPer100Km.orElseThrow(), 0.00001);
    }

    @Test
    public void sumMpgForBrand() {
        Optional<Integer> bmwMpgSum = Cars.sumMpgForBrand(cars, "BMW");
        Optional<Integer> titiMpgSum = Cars.sumMpgForBrand(cars, "Titi");

        assertEquals(30673, bmwMpgSum.orElseThrow().intValue());
        assertEquals(Optional.empty(), titiMpgSum);
    }

    @Test
    public void getCarsPerYear() {
        Map<Integer, List<Car>> perYear = Cars.getCarsPerYear(cars);
        assertEquals(16, perYear.size());

        List<Car> year2016 = perYear.get(2016);
        assertEquals(4, year2016.size());
        assertTrue(year2016.stream().anyMatch(car -> car.getModel().equals("SORENTO")));
        assertTrue(year2016.stream().anyMatch(car -> car.getModel().equals("6")));
        assertTrue(year2016.stream().anyMatch(car -> car.getModel().equals("CX-5")));
        assertTrue(year2016.stream().anyMatch(car -> car.getModel().equals("XC90")));
    }

    @Test
    public void getCarsCountPerYear() {
        Map<Integer, Long> carsCountPerYear = Cars.getCarsCountPerYear(cars);

        assertEquals(1385, carsCountPerYear.get(2005).intValue());
        assertEquals(1316, carsCountPerYear.get(2010).intValue());
    }

}
