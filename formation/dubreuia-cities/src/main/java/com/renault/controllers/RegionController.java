package com.renault.controllers;

import com.renault.dtos.RegionDto;
import com.renault.entities.Country;
import com.renault.entities.Region;
import com.renault.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/country")
public class RegionController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{countryId}/region")
    public List<RegionDto> getRegionsForCountry(@PathVariable("countryId") int countryId) {
        // TODO load the country, then load the regions
        return List.of();
    }

}