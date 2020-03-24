package com.renault.controllers;

import com.renault.dtos.CountryDto;
import com.renault.entities.Country;
import com.renault.entities.Language;
import com.renault.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("")
    public List<CountryDto> getCountries() {
        List<CountryDto> coutries = new ArrayList<>();
        for (Country country : countryService.getCountries()) {
            coutries.add(new CountryDto(country.getId(), country.getLanguage().getName(), country.getName()));
        }
        return coutries;
    }

    @GetMapping("/{id}")
    public CountryDto getCountry(@PathVariable("id") int id) {
        Country country = countryService.getCountry(id).orElseThrow();
        return new CountryDto(country.getId(), country.getLanguage().getName(), country.getName());
    }

    @PostMapping("")
    public void createCountry(@RequestBody CountryDto countryDto) {
        Language language = Language.fromName(countryDto.getLanguage()).orElseThrow();
        countryService.saveCountry(new Country(language, countryDto.getName()));
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable("id") int id) {
        countryService.deleteCountry(id);
    }

    @PutMapping("")
    public void updateCountry(@RequestBody CountryDto countryDto) {
        Country country = countryService.getCountry(countryDto.getId()).orElseThrow();
        country.setLanguage(Language.fromName(countryDto.getLanguage()).orElseThrow());
        country.setName(countryDto.getName());
        countryService.saveCountry(country);
    }

}