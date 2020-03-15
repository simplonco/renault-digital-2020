package com.renault;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;
import java.util.logging.Logger;

import static java.lang.String.format;
import static java.time.format.DateTimeFormatter.ISO_DATE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class WeatherService {

    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

    /**
     * Returns the "where in the world id" (woeid) from https://www.metaweather.com/api/#locationsearch.
     *
     * @param city the city to look for
     * @return the woeid for the given city
     */
    public int getWhereInTheWorldId(String city) {
        String query = format("https://www.metaweather.com/api/location/search/?query=%s", city);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(query)).build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new ResponseStatusException(NOT_FOUND,
                        format("Wrong status code: %d", response.statusCode()));
            }
            String json = response.body();
            LOGGER.info("getWhereInTheWorldId: " + json);
            JsonReader jsonReader = Json.createReader(new StringReader(json));
            JsonArray jsonArray = jsonReader.readArray();
            return jsonArray.stream()
                    .map(JsonValue::asJsonObject)
                    .filter(jsonObject -> jsonObject.getString("title")
                            .equalsIgnoreCase(city))
                    .mapToInt(jsonObject -> jsonObject.getInt("woeid"))
                    .findFirst()
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                            format("City not found: %s", city)));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the "consolidated weather" node for today from https://www.metaweather.com/api/#locationday.
     *
     * @param whereInTheWorldId the woeid to seach for
     * @return the consolidated_weather node for the given woeid for today
     */
    public String getLocationWeather(int whereInTheWorldId) {
        LocalDate now = LocalDate.now();
        String query = format("https://www.metaweather.com/api/location/%s/%s/%s/%s/",
                whereInTheWorldId, now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(query)).build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new ResponseStatusException(NOT_FOUND,
                        format("Wrong status code: %d", response.statusCode()));
            }
            String json = response.body();
            LOGGER.info("getLocationWeather: " + json);
            JsonReader jsonReader = Json.createReader(new StringReader(json));
            JsonArray jsonArray = jsonReader.readArray();
            return jsonArray.stream()
                    .map(JsonValue::asJsonObject)
                    .filter(jsonObject -> jsonObject.getString("applicable_date")
                            .equalsIgnoreCase(now.format(ISO_DATE)))
                    .findFirst()
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                            format("Date not found: %s", now)))
                    .toString();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
