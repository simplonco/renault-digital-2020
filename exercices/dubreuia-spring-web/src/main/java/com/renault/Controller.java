package com.renault;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

import static java.lang.String.format;

@RestController
@RequestMapping("/")
@CrossOrigin
public class Controller extends HttpServlet {

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
        int woeid = getWoeid(city);
        return getLocationWeather(woeid);
    }

    private int getWoeid(String city) {
        String query = format("https://www.metaweather.com/api/location/search/?query=%s", city);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(query)).build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Wrong status code: " + response.statusCode());
            }
            String json = response.body();
            System.out.println(json);
            JsonReader jsonReader = Json.createReader(new StringReader(json));
            JsonArray jsonArray = jsonReader.readArray();
            return jsonArray.stream()
                    .map(JsonValue::asJsonObject)
                    .filter(jsonObject -> jsonObject.getString("title").equals(city))
                    .mapToInt(jsonObject -> jsonObject.getInt("woeid"))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("City not found: " + city));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getLocationWeather(int woeid) {
        LocalDate now = LocalDate.now();
        String query = format("https://www.metaweather.com/api/location/%s/%s/%s/%s/",
                woeid, now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(query)).build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Wrong status code: " + response.statusCode());
            }
            String json = response.body();
            System.out.println(json);
            JsonReader jsonReader = Json.createReader(new StringReader(json));
            JsonArray jsonArray = jsonReader.readArray();
            return jsonArray.stream()
                    .map(JsonValue::asJsonObject)
                    .filter(jsonObject -> jsonObject.getString("applicable_date")
                            .equals(now.format(DateTimeFormatter.ISO_DATE)))
                    .map(jsonObject -> jsonObject.getString("weather_state_name"))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Date not found: " + now));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
