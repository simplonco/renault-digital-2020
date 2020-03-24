package com.renault.services;

import com.renault.entities.City;
import com.renault.entities.Country;
import com.renault.entities.Language;
import com.renault.entities.Region;
import com.renault.repositories.CityRepository;
import com.renault.repositories.CountryRepository;
import com.renault.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void deleteAll() {
        cityRepository.deleteAll();
        regionRepository.deleteAll();
        countryRepository.deleteAll();
    }

    @Override
    public void insertData() {
        Country france = new Country(Language.FR, "France");
        Country canada = new Country(Language.EN, "Canada");
        Country japan = new Country(Language.JA, "Japan");

        countryRepository.save(france);
        countryRepository.save(canada);
        countryRepository.save(japan);

        Region idf = new Region("IDF", france);
        Region quebec = new Region("Québec", canada);
        regionRepository.save(idf);
        regionRepository.save(quebec);

        cityRepository.save(new City("Paris", idf));
        cityRepository.save(new City("Montreuil", idf));
        cityRepository.save(new City("Montréal", quebec));
        cityRepository.save(new City("Laval", quebec));
    }

}
