import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Fazer um conexão HTTP e buscar os TOP 250 filmes
        String url = "https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbtop250moviesdata.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> reponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = reponse.body();

        // Pegar somente os dados que interessam (Título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> movieList = parser.parse(body);

        // Exibir e manipular os dados
        for (Map<String, String> movie : movieList) {

            String urlImage = movie.get("image");
            String title = movie.get("title");
            InputStream inputStream = new URL(urlImage).openStream();

            String fileName = title + ".png";

            var generator = new StickGenerator();
            generator.create(inputStream, fileName);

            System.out.println("\u001b[1mTítulo: \u001b[m" + movie.get("title"));
            System.out.println("\u001b[1m\u001b[40m\u001b[34mNota do filme: " + movie.get("imDbRating") + "\u001b[m\u001b[m");

            double rating = Double.parseDouble(movie.get("imDbRating"));
            int starsNumber = (int) rating;

            for (int i = 1; i <= starsNumber; i++) {
                System.out.print("\uD83C\uDF1F");
            }
            System.out.println("\n");
        }
    }
}