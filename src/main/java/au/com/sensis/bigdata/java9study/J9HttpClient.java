package au.com.sensis.bigdata.java9study;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;


public class J9HttpClient {

    public static void main(String... args) throws Exception {
        syncCall();
        asyncCall();
    }

    public static void syncCall() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request =
                HttpRequest.newBuilder(URI.create("https://www.yellowpages.com.au"))
                        .GET()
                        .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandler.asString());

        if(response.statusCode() == 200)
            System.out.println(response.headers().map());

    }

    public static void asyncCall() {

        HttpClient.Builder builder = HttpClient.newBuilder();

        builder.version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.ALWAYS);

        HttpClient client = builder.build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com.au"))
                .header("User-Agent", "Java")
                .timeout(Duration.ofMillis(500))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response =
                client.sendAsync(request, HttpResponse.BodyHandler.asString());

        response.thenAccept(r -> {
            System.out.println("Version: " + r.version());
            System.out.println(r.body());
        });

        response.join();

    }
}
