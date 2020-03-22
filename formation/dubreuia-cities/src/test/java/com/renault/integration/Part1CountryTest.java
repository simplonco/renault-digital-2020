package com.renault.integration;

import com.renault.CitiesApplication;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.util.List;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CitiesApplication.class, webEnvironment = RANDOM_PORT)
public class Part1CountryTest extends TestCitiesApplication {

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_GET_root_returns_all_the_countries() {
        JsonReader response = get("country/");
        JsonArray countries = response.readArray();
        assertEquals(3, countries.size());

        List<String> countryNames = getCountryNames();
        countries.stream()
                .map(JsonValue::asJsonObject)
                .forEach(country -> {
                    assertTrue(country.getInt("id") > 0);
                    assertTrue(countryNames.contains(country.getString("name")));
                    assertFalse(country.getString("language").isBlank());
                });
    }

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_GET_root_with_id_returns_specific_country() {
        JsonReader response = get("country/");
        JsonArray countriesArray = response.readArray();
        JsonObject countriesObject = countriesArray.get(0).asJsonObject();
        int id = countriesObject.getInt("id");
        String name = countriesObject.getString("name");
        String language = countriesObject.getString("language");

        JsonReader responseCountry = get(format("country/%s", id));
        JsonObject countryObject = responseCountry.readObject();

        assertEquals(id, countryObject.getInt("id"));
        assertEquals(name, countryObject.getString("name"));
        assertEquals(language, countryObject.getString("language"));
    }

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_POST_root_add_new_country() {
        JsonObject uk = Json.createObjectBuilder()
                .add("name", "United Kingdom")
                .add("language", "English")
                .build();
        post("country/", uk);

        List<String> countryNames = getCountryNames();
        assertEquals(4, countryNames.size());
        assertTrue(countryNames.contains("United Kingdom"));
    }

    @Test
    @Disabled("TODO remove when part is ready")
    // TODO add with throws in user test
    public void should_DELETE_root_remove_existing_country() {
        int japanId = getCountryIdForName("Japan").orElseThrow();
        delete(format("country/%s", japanId));

        List<String> countryNames = getCountryNames();
        assertEquals(2, countryNames.size());
        assertFalse(countryNames.contains("Japan"));
    }

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_PUT_root_modify_existing_country() {
        int franceId = getCountryIdForName("France").orElseThrow();
        JsonObject updatedFrance = Json.createObjectBuilder()
                .add("id", franceId)
                .add("name", "United France")
                .add("language", "English")
                .build();
        put("country", updatedFrance);

        List<String> countryNames = getCountryNames();
        assertEquals(3, countryNames.size());
        assertTrue(countryNames.contains("United France"));
    }

}
