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
                .uri(URI.create("localhost:8080/cars/?brand=BMW"))
                .build();
        List<String> lines = new ArrayList<>();
        client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(lines::add)
                .join();
        long count = lines.stream().filter(line -> line.contains("<div>")).count();
        Assertions.assertEquals(67, count);
    }

}
