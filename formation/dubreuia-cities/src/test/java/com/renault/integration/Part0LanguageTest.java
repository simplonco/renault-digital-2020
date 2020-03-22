package com.renault.integration;

import com.renault.CitiesApplication;
import com.renault.entities.Language;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.json.JsonString;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CitiesApplication.class, webEnvironment = RANDOM_PORT)
public class Part0LanguageTest extends TestCitiesApplication {

    @Test
    @Disabled("TODO remove when part is ready")
    public void should_GET_root_language_returns_all_languages() {
        JsonReader jsonReader = get("language/");
        JsonArray jsonArray = jsonReader.readArray();
        assertEquals(Language.values().length, jsonArray.size());
        List<Language> languages = asList(Language.values());
        jsonArray.getValuesAs(JsonString.class).stream()
                .map(JsonString::getString)
                .map(Language::fromName)
                .forEach(l -> assertTrue(languages.contains(l.orElseThrow())));
    }

}
