import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttp {
    public String getData(String url) {

        try {
            URI endereco = URI.create(url);
            var client = java.net.http.HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }

    }
}
