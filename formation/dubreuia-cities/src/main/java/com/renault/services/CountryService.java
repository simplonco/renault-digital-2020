package com.renault.services;

import com.renault.entities.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> getCountries();

    Optional<Country> getCountry(int id);

    void saveCountry(Country country);

    void deleteCountry(int id);

}
