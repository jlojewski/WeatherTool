package bll.openweathermap;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class OpenWeatherClient {

    private final HttpClient httpClient;
    private static final String API_KEY = "replace this with the actual api key";
    private static final String UNITS = "METRIC";

    public OpenWeatherClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Optional<String> sendRequest(String city) throws IOException, InterruptedException {
        HttpRequest weatherRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid="+API_KEY+"&units="+UNITS))
                .build();
        String body = httpClient.send(weatherRequest, HttpResponse.BodyHandlers.ofString()).body();

        if (body!=null & !body.isEmpty()) {
            return Optional.of(body);
        } else {
            return Optional.empty();

        }
        



    }




}

