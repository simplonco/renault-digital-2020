package com.renault.services;

import com.renault.entities.Country;
import com.renault.entities.Language;
import com.renault.entities.Region;
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

    @Override
    public void deleteAll() {
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

        regionRepository.save(new Region("IDF", france));
        regionRepository.save(new Region("Québec", canada));
    }

}
