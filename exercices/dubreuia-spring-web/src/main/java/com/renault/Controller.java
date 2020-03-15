package com.renault;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/")
@CrossOrigin
public class Controller extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

    @GetMapping("/persons")
    public List<PersonDto> get() {
        return List.of(
                new PersonDto("Emmanuel", "Macron", "Paris"),
                new PersonDto("François", "Hollande", "Versailles"),
                new PersonDto("Nicolas", "Sarkozy", "Toulouses"),
                new PersonDto("Jacques", "Chirac", "Marseille"),
                new PersonDto("François", "Mitterrand", "Nantes")
        );
    }

    @GetMapping("/weather/{city}")
    public String getWeather(@PathVariable("city") String city) {
        int whereInTheWorldId = getWhereInTheWorldId(city);
        return getLocationWeather(whereInTheWorldId);
    }

    private int getWhereInTheWorldId(String city) {
        String query = format("https://www.metaweather.com/api/location/search/?query=%s", city);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(query)).build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new ResponseStatusException(NOT_FOUND, "Wrong status code: " + response.statusCode());
            }
            String json = response.body();
            LOGGER.info("getWhereInTheWorldId: " + json);
            JsonReader jsonReader = Json.createReader(new StringReader(json));
            JsonArray jsonArray = jsonReader.readArray();
            return jsonArray.stream()
                    .map(JsonValue::asJsonObject)
                    .filter(jsonObject -> jsonObject.getString("title").equals(city))
                    .mapToInt(jsonObject -> jsonObject.getInt("woeid"))
                    .findFirst()
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "City not found: " + city));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getLocationWeather(int whereInTheWorldId) {
        LocalDate now = LocalDate.now();
        String query = format("https://www.metaweather.com/api/location/%s/%s/%s/%s/",
                whereInTheWorldId, now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(query)).build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new ResponseStatusException(NOT_FOUND, "Wrong status code: " + response.statusCode());
            }
            String json = response.body();
            LOGGER.info("getLocationWeather: " + json);
            JsonReader jsonReader = Json.createReader(new StringReader(json));
            JsonArray jsonArray = jsonReader.readArray();
            return jsonArray.stream()
                    .map(JsonValue::asJsonObject)
                    .filter(jsonObject -> jsonObject.getString("applicable_date")
                            .equals(now.format(DateTimeFormatter.ISO_DATE)))
                    .findFirst()
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Date not found: " + now))
                    .toString();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
