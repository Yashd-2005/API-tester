package com.example.API_Tester.Service;

import com.example.API_Tester.DTO.Apirequest;
import com.example.API_Tester.DTO.Apiresponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class ApiService {

    private final HttpClient client = HttpClient.newHttpClient();

    public Apiresponse sendRequest(Apirequest request) {

        HttpRequest httpRequest = buildRequest(request);

        long startTime = System.currentTimeMillis();

        try {

            HttpResponse<String> response =
                    client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            long endTime = System.currentTimeMillis();

            Apiresponse apiResponse = new Apiresponse();

            apiResponse.setStatus(response.statusCode());
            apiResponse.setBody(response.body());
            apiResponse.setResponse(endTime - startTime);

            Map<String, String> headers = new HashMap<>();

            response.headers().map().forEach((key, value) ->
                    headers.put(key, String.join(",", value)));

            apiResponse.setHeader(headers);

            return apiResponse;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Request Failed: " + e.getMessage());
        }
    }

    private HttpRequest buildRequest(Apirequest request) {

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(request.getUrl()));

        // Add Headers
        if (request.getHeader() != null) {
            request.getHeader().forEach(builder::header);
        }

        String method = request.getMethod().toUpperCase();

        switch (method) {

            case "GET":
                builder.GET();
                break;

            case "POST":
                builder.POST(HttpRequest.BodyPublishers.ofString(
                        request.getBody() == null ? "" : request.getBody()));
                break;

            case "PUT":
                builder.PUT(HttpRequest.BodyPublishers.ofString(
                        request.getBody() == null ? "" : request.getBody()));
                break;

            case "DELETE":
                builder.DELETE();
                break;

            default:
                throw new IllegalArgumentException("Unsupported HTTP Method: " + method);
        }

        return builder.build();
    }

}