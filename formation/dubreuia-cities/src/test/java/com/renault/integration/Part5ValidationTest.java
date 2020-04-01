package com.renault.integration;

import com.renault.CitiesApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CitiesApplication.class, webEnvironment = RANDOM_PORT)
public class Part5ValidationTest extends TestCitiesApplication {

    @Test
    public void should_POST_root_country_name_too_short_validation_fails() {
        JsonObject badCountryName = Json.createObjectBuilder()
                .add("name", "ff")
                .add("language", "English")
                .build();
        HttpStatus status = assertThrows(ResponseStatusException.class, () -> post("country/", badCountryName))
                .getStatus();
        assertEquals(BAD_REQUEST, status);

        List<String> countryNames = getCountryNames();
        assertEquals(3, countryNames.size());
    }

    @Test
    public void should_POST_root_region_name_too_short_validation_fails() {
        JsonObject badRegionName = Json.createObjectBuilder()
                .add("country", Json.createObjectBuilder()
                        .add("name", "United Kingdom")
                        .add("language", "English")
                        .build())
                .add("region", Json.createObjectBuilder()
                        .add("name", "ff")
                        .build())
                .build();
        HttpStatus status = assertThrows(ResponseStatusException.class, () -> post("country/region", badRegionName))
                .getStatus();
        assertEquals(BAD_REQUEST, status);

        List<String> countryNames = getCountryNames();
        assertEquals(3, countryNames.size());

        List<String> regionNames = getRegionNames();
        assertEquals(2, regionNames.size());
    }

    @Test
    public void should_POST_root_city_name_too_short_validation_fails() {
        JsonObject badCityName = Json.createObjectBuilder()
                .add("countryName", "United Kingdom")
                .add("countryLanguage", "English")
                .add("regionName", "Midwest")
                .add("cityName", "ff")
                .build();
        HttpStatus status = assertThrows(ResponseStatusException.class, () -> post("country/region/city", badCityName))
                .getStatus();
        assertEquals(BAD_REQUEST, status);

        List<String> countryNames = getCountryNames();
        assertEquals(3, countryNames.size());

        List<String> regionNames = getRegionNames();
        assertEquals(2, regionNames.size());

        List<String> cityNames = getCityNames();
        assertEquals(4, cityNames.size());
    }

    @Test
    public void should_POST_root_user_name_doesnt_match_pattern_validation_fails() {
        JsonObject badUsername = Json.createObjectBuilder()
                .add("name", "Wrong username")
                .build();
        HttpStatus status = assertThrows(ResponseStatusException.class, () -> post("/user", badUsername))
                .getStatus();
        assertEquals(BAD_REQUEST, status);

        List<String> userNames = getUserNames();
        assertEquals(1, userNames.size());
    }

}
