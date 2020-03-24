package com.renault.integration;

import com.renault.CitiesApplication;
import com.renault.entities.Country;
import com.renault.entities.Language;
import com.renault.entities.Region;
import com.renault.repositories.CountryRepository;
import com.renault.services.RegionService;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CitiesApplication.class, webEnvironment = RANDOM_PORT)
public class HibernateTest {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RegionService regionService;

    @Test
    public void demoTransaction() {
        Country usa2 = new Country(Language.EN, "USA2");
        Region mordor = new Region("Mordor", usa2);
        assertThrows(RuntimeException.class, () -> regionService.saveCountryRegion(usa2, mordor));
        System.out.println("WITHOUT TRANSACTION : USA2 stored in database");
        System.out.println(countryRepository.findAll());

        Country usa3 = new Country(Language.EN, "USA3");
        Region mordor2 = new Region("Mordor", usa3);
        assertThrows(RuntimeException.class, () -> regionService.saveCountryRegionWithTransaction(usa2, mordor2));
        System.out.println("WITH TRANSACTION : USA3 not stored in database because of transaction rollback");
        System.out.println(countryRepository.findAll());
    }

    @Test
    public void demo_fetch_type_lazy() {
        // country.id -> loaded
        // country.name -> loaded
        // country.language -> loaded
        // select country0_.id as id1_0_, country0_.language as language2_0_, country0_.name as name3_0_ from country country0_
        Country country = countryRepository.findAll().get(0);
        // country.region -> NOT LOADED (LAZY)
        // EXCEPTION failed to lazily initialize a collection of role
        // could not initialize proxy - no Session
        // select regions0_.country_id -- SELECT POUR REGION (EAGER)
        assertThrows(LazyInitializationException.class, () -> {
            // ne fonctionne pas en LAZY
            List<Region> regions = country.getRegions();
            System.out.println(regions);
        });
    }

}
