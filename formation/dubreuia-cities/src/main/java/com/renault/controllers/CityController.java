package com.renault.controllers;

import com.renault.dtos.CityDto;
import com.renault.dtos.CountryRegionCityDto;
import com.renault.entities.City;
import com.renault.entities.Country;
import com.renault.entities.Language;
import com.renault.entities.Region;
import com.renault.services.CityService;
import com.renault.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping
public class CityController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private CityService cityService;

    @GetMapping("/country/region/{regionId}/city")
    public List<CityDto> getCitiesForRegion(@PathVariable("regionId") int regionId) {
        Region region = regionService.getRegion(regionId).orElseThrow();
        List<CityDto> cityDtos = new ArrayList<>();
        for (City city : region.getCities()) {
            cityDtos.add(new CityDto(city.getId(), city.getName()));
        }
        return cityDtos;
    }

    @PutMapping("/country/region/city/{id}")
    public void updateCity(@PathVariable("id") int id, @RequestBody CityDto cityDto) {
        City city = cityService.getCity(id).orElseThrow();
        city.setName(cityDto.getName());
        cityService.save(city);
    }

    @PostMapping("/country/region/city")
    public void insertCountryRegionCity(@RequestBody CountryRegionCityDto dto) {
        Language countryLanguage = Language.fromName(dto.getCountryLanguage()).orElseThrow();
        Country country = new Country(countryLanguage, dto.getCountryName());
        Region region = new Region(dto.getRegionName(), country);
        City city = new City(dto.getCityName(), region);
        cityService.save(country, region, city);
    }

}
