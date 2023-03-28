import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Fazer um conexão HTTP e buscar os TOP 250 filmes
        String url = "https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbtop250moviesdata.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> reponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = reponse.body();
        System.out.println(body);

        // Pegar somente os dados que interessam (Título, poster, classificação)

        // Exibir e manipular os dados
    }
}