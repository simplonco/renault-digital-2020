package com.renault.tests.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

public class IntegrationTests {

    @Test
    public void should_implementation_return_correct_cars() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create("http://localhost:8080/dubreuia-cars/cars"))
                .build();
        List<String> lines = new ArrayList<>();
        client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(lines::add)
                .join();
//        long count = lines.stream().collect(Collectors.joining()).split(",").length
        long count = lines.size();
        Assertions.assertEquals(67, count);
    }

}
