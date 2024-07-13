package main.problems.hackerrank.deliveroo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BestRestaurantRestCal {
    public static void main(String[] args) {
        String city = "delhi";
        int cost = 1000;
        try {
            System.out.println(bestRestaurant(city, cost));
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bestRestaurant(String city, int cost) throws IOException, InterruptedException, URISyntaxException {
        int page = 0;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(getURLString(city, page)))
                .build();

        HttpResponse<String> stringHttpResponse = httpClient.send(request,
                HttpResponse.BodyHandlers.ofString());

//        JSONObject currJSON
        return null;
    }

    private static String getURLString(String city, int page) {
        String baseUrl = "https://jsonmock.hackerrank.com/api/food_outlets";
        String params = "?city=" + city + "&page=" + page;
        return baseUrl + params;
    }
}
