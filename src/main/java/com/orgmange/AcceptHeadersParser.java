package com.orgmange;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AcceptHeadersParser {
    public void run() {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/anything"))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            String acceptKey = "\"Accept\": \"";
            int acceptIndex = body.indexOf(acceptKey);

            if (acceptIndex != -1) {
                int valueStart = acceptIndex + acceptKey.length();
                int valueEnd = body.indexOf("\"", valueStart);
                String acceptValue = body.substring(valueStart, valueEnd);
                System.out.println("Accept: " + acceptValue);
            } else {
                System.out.println("Accept не найден в ответе");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}