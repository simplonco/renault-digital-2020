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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CitiesApplication.class, webEnvironment = RANDOM_PORT)
public class Part2RegionTest extends TestCitiesApplication {

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_GET_country_with_id_returns_all_the_regions_for_country() {
        int canadaId = getCountryIdForName("Canada").orElseThrow();

        JsonReader response = get(format("country/%s/region", canadaId));
        JsonArray regions = response.readArray();
        assertEquals(1, regions.size());

        List<String> regionNames = getRegionNames();
        regions.stream()
                .map(JsonValue::asJsonObject)
                .forEach(region -> {
                    assertTrue(region.getInt("id") > 0);
                    assertTrue(regionNames.contains(region.getString("name")));
                });
    }

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_GET_country_region_with_id_returns_specific_region() {
        int canadaId = getCountryIdForName("Canada").orElseThrow();

        JsonReader response = get(format("country/%s/region", canadaId));
        JsonArray regionsArray = response.readArray();
        JsonObject regionsObject = regionsArray.get(0).asJsonObject();
        int id = regionsObject.getInt("id");
        String name = regionsObject.getString("name");

        JsonReader responseRegion = get(format("country/region/%s", id));
        JsonObject regionObject = responseRegion.readObject();

        assertEquals(id, regionObject.getInt("id"));
        assertEquals(name, regionObject.getString("name"));
    }

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_POST_root_add_new_region() {
        int franceId = getCountryIdForName("France").orElseThrow();
        JsonObject alpes = Json.createObjectBuilder().add("name", "Alpes").build();
        post(format("country/%s", franceId), alpes);

        List<String> regionNames = getRegionNames();
        assertEquals(3, regionNames.size());
        assertTrue(regionNames.contains("Alpes"));
    }

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_POST_region_add_new_region() {
        JsonObject ukMidwest = Json.createObjectBuilder()
                .add("countryName", "United Kingdom")
                .add("countryLanguage", "English")
                .add("regionName", "Midwest")
                .build();
        post("country/region", ukMidwest);

        List<String> countryNames = getCountryNames();
        assertEquals(4, countryNames.size());
        assertTrue(countryNames.contains("United Kingdom"));

        List<String> regionNames = getRegionNames();
        assertEquals(3, regionNames.size());
        assertTrue(regionNames.contains("Midwest"));
    }

}
