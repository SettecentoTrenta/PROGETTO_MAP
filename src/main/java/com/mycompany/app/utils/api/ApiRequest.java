package com.mycompany.app.utils.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * API request class.
 */
public final class ApiRequest {

    /**
     * Effettua una richiesta HTTP GET all'URL specificato e stampa la risposta.
     */
    public String fetch() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://opentdb.com/api.php?amount=10&difficulty=easy&type=boolean"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}