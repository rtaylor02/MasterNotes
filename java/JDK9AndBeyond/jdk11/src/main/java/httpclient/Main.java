package httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        System.out.println(jsonPlaceholderDemo(1));
    }

    //private static Record BlogPost(int id, int userId, String title, String body) {}

    private static String jsonPlaceholderDemo(int id) {
        final String BASE_URL = "https://jsonplaceholder.typicode.com";

        try (var client = HttpClient.newHttpClient()){
            var request = HttpRequest.newBuilder()
                    .uri(URI.create("%s/posts/%d".formatted(BASE_URL, id)))
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            var responseStatusCode = response.statusCode();
            System.out.println("Response status code: " + responseStatusCode);
            if (responseStatusCode != 200) {
                throw new RuntimeException("Failed to get any response: " + response.body());
            }

            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
