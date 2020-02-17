package com.renault.service;

import com.renault.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CarsRepository extends JpaRepository<Car, Integer> {

    List<Car> findByBrand(String brand);

    @Query("SELECT c.brand FROM cars c")
    Set<String> findBrands();

}
