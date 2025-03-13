package com.orgmange;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AcceptHeadersParser {
    public void run() {
        ObjectMapper objectMapper = new ObjectMapper();

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/anything"))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            JsonNode headersNode = objectMapper.readTree(body).get("headers");
            if (headersNode != null && headersNode.has("Accept")) {
                String acceptValue = headersNode.get("Accept").asText();
                System.out.println("Accept: " + acceptValue);
            } else {
                System.out.println("Accept не найден в ответе");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}