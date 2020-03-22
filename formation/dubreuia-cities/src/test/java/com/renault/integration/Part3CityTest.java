package com.renault.integration;

import com.renault.CitiesApplication;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CitiesApplication.class, webEnvironment = RANDOM_PORT)
public class Part3CityTest extends TestCitiesApplication {

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_POST_region_add_new_region() {
        JsonObject ukMidwest = Json.createObjectBuilder()
                .add("countryName", "United Kingdom")
                .add("countryLanguage", "English")
                .add("regionName", "Midwest")
                .add("cityName", "London")
                .build();
        post("country/region/city", ukMidwest);

        List<String> countryNames = getCountryNames();
        assertEquals(4, countryNames.size());
        assertTrue(countryNames.contains("United Kingdom"));

        List<String> regionNames = getRegionNames();
        assertEquals(3, regionNames.size());
        assertTrue(regionNames.contains("Midwest"));

        List<String> cityNames = getCityNames();
        assertEquals(5, cityNames.size());
        assertTrue(cityNames.contains("London"));
    }

}
