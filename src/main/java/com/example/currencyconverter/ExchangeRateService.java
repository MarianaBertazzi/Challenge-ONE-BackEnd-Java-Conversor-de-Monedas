package com.example.currencyconverter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {

    private static final String API_KEY = "1fac2368b11dce23f36714f9";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public double getExchangeRate(String fromCurrency, String toCurrency) {
        String url = API_URL + API_KEY + "/latest/" + fromCurrency;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error al obtener las tasas de cambio: " + response.statusCode());
            }
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            return conversionRates.get(toCurrency).getAsDouble();
        } catch (Exception e) {
            System.out.println("Error al conectar con la API de tasas de cambio: " + e.getMessage());
            return 0.0;
        }
    }
}

