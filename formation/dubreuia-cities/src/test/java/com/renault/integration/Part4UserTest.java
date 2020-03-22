package com.renault.integration;

import com.renault.CitiesApplication;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CitiesApplication.class, webEnvironment = RANDOM_PORT)
public class Part4UserTest extends TestCitiesApplication {

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_POST_follow_city_adds_a_followed_city_for_user() {
        int montreuilId = getCityIdForName("Montreuil").orElseThrow();
        int alexId = getUserIdForName("Alex").orElseThrow();

        post(format("user/%s/followCity/%s", alexId, montreuilId));

        List<String> cityNames = getCityNamesForUser(alexId);
        assertEquals(3, cityNames.size());
        assertTrue(cityNames.contains("Paris"));
        assertTrue(cityNames.contains("Montréal"));
        assertTrue(cityNames.contains("Montreuil"));
    }

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_DELETE_follow_city_removes_a_followed_city_for_user() {
        int parisId = getCityIdForName("Paris").orElseThrow();
        int alexId = getUserIdForName("Alex").orElseThrow();

        delete(format("user/%s/followCity/%s", alexId, parisId));

        List<String> cityNames = getCityNamesForUser(alexId);
        assertEquals(1, cityNames.size());
        assertTrue(cityNames.contains("Montréal"));
    }

}
