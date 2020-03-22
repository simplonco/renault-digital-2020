package com.renault.integration;

import com.renault.CitiesApplication;
import com.renault.services.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.server.ResponseStatusException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.OptionalInt;

import static java.lang.String.format;
import static java.net.http.HttpClient.newHttpClient;
import static java.net.http.HttpRequest.BodyPublishers.ofString;
import static java.net.http.HttpRequest.newBuilder;
import static java.net.http.HttpResponse.BodyHandlers.ofString;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.valueOf;

@SpringBootTest(classes = CitiesApplication.class)
public abstract class TestCitiesApplication {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private EntityManager entityManager;

    @LocalServerPort
    int port;

    @BeforeEach
    public void beforeEach() {
        applicationService.deleteAll();
        applicationService.insertData();
    }

    JsonReader get(String path) {
        String query = format("http://localhost:%s/%s", port, path);
        HttpClient client = newHttpClient();
        HttpRequest request = newBuilder().uri(URI.create(query)).build();
        try {
            HttpResponse<String> response = client.send(request, ofString());
            if (response.statusCode() != 200) {
                throw new ResponseStatusException(valueOf(response.statusCode()),
                        format("Wrong status code: %d", response.statusCode()));
            }
            String json = response.body();
            json = json.isBlank() ? "(blank)" : json;
            System.out.println(format("Response from '%s' -> %s", query, json));
            return Json.createReader(new StringReader(json));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void post(String path) {
        post(path, null);
    }

    void post(String path, JsonObject body) {
        String query = format("http://localhost:%s/%s", port, path);
        HttpClient client = newHttpClient();
        HttpRequest request = newBuilder()
                .uri(URI.create(query))
                .POST(ofString(body == null ? "" : body.toString()))
                .header("Content-Type", "application/json; charset=utf8")
                .build();
        try {
            HttpResponse<String> response = client.send(request, ofString());
            if (response.statusCode() != 200) {
                throw new ResponseStatusException(valueOf(response.statusCode()),
                        format("Wrong status code: %d", response.statusCode()));
            }
            String json = response.body();
            json = json.isBlank() ? "(blank)" : json;
            System.out.println(format("Response from '%s' -> %s", query, json));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void delete(String path) {
        String query = format("http://localhost:%s/%s", port, path);
        HttpClient client = newHttpClient();
        HttpRequest request = newBuilder().uri(URI.create(query)).DELETE().build();
        try {
            HttpResponse<String> response = client.send(request, ofString());
            if (response.statusCode() != 200) {
                throw new ResponseStatusException(valueOf(response.statusCode()),
                        format("Wrong status code: %d", response.statusCode()));
            }
            String json = response.body();
            json = json.isBlank() ? "(blank)" : json;
            System.out.println(format("Response from '%s' -> %s", query, json));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void put(String path, JsonObject body) {
        String query = format("http://localhost:%s/%s", port, path);
        HttpClient client = newHttpClient();
        HttpRequest request = newBuilder()
                .uri(URI.create(query))
                .PUT(ofString(body.toString()))
                .header("Content-Type", "application/json; charset=utf8")
                .build();
        try {
            HttpResponse<String> response = client.send(request, ofString());
            if (response.statusCode() != 200) {
                throw new ResponseStatusException(valueOf(response.statusCode()),
                        format("Wrong status code: %d", response.statusCode()));
            }
            String json = response.body();
            json = json.isBlank() ? "(blank)" : json;
            System.out.println(format("Response from '%s' -> %s", query, json));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    List<String> getCountryNames() {
        return getNames("SELECT name FROM country");
    }

    OptionalInt getCountryIdForName(String name) {
        return getIdForName(name, "SELECT id FROM country WHERE name = :name");
    }

    List<String> getRegionNames() {
        return getNames("SELECT name FROM region");
    }

    OptionalInt getRegionIdForName(String name) {
        return getIdForName(name, "SELECT id FROM region WHERE name = :name");
    }

    List<String> getCityNames() {
        return getNames("SELECT name FROM city");
    }

    OptionalInt getCityIdForName(String name) {
        return getIdForName(name, "SELECT id FROM city WHERE name = :name");
    }

    List<String> getUserNames() {
        return getNames("SELECT name FROM user");
    }

    OptionalInt getUserIdForName(String name) {
        return getIdForName(name, "SELECT id FROM user WHERE name = :name");
    }

    List<String> getCityNamesForUser(int userId) {
        String sqlString = "SELECT city.name AS city_name " +
                "FROM user, city, user_city " +
                "WHERE user.id = " + userId + " " +
                "AND user.id = user_city.user_id " +
                "AND city.id = user_city.city_id";
        @SuppressWarnings("unchecked")
        List<Object> resultList = entityManager.createNativeQuery(sqlString).getResultList();
        return resultList.stream()
                .map(object -> (String) object)
                .collect(toList());
    }

    private OptionalInt getIdForName(String name, String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql).setParameter("name", name);
        @SuppressWarnings("unchecked")
        List<Object> resultList = nativeQuery.getResultList();
        return resultList.stream().mapToInt(object -> (int) object).findFirst();
    }

    private List<String> getNames(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        @SuppressWarnings("unchecked")
        List<Object> resultList = nativeQuery.getResultList();
        return resultList.stream().map(object -> (String) object).collect(toList());
    }

}
