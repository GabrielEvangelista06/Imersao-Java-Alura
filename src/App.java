import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Fazer um conexão HTTP e buscar os TOP 250 filmes
        String url = "https://api.nasa.gov/planetary/apod?api_key=6QxCgNSDuBbgIhke6m3aymdgbSIRNYndw6p84EhJ";

        var http = new ClientHttp();
        String json = http.getData(url);

        // Pegar somente os dados que interessam (Título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> contentList = parser.parse(json);

        // Exibir e manipular os dados
        for (Map<String, String> content : contentList) {

            String urlImage = content.get("url");
            String urlBigImage = urlImage.replaceFirst("(@?\\.)([0-9A-Z,_]+).jpg$", "$1.jpg");
            String title = content.get("title");
            double rating = Double.parseDouble(content.get("imDbRating"));

            String stickerText;
            if (rating >= 9.0) {
                stickerText = "TOP DEMAIS";
            } else {
                stickerText = "Bom";
            }


            InputStream inputStream = new URL(urlBigImage).openStream();

            String fileName = title + ".png";

            var generator = new StickGenerator();
            generator.create(inputStream, fileName, stickerText);

            System.out.println("\u001b[1mTítulo: \u001b[m" + content.get("title"));
            System.out.println("\u001b[1m\u001b[40m\u001b[34mNota do filme: " + content.get("imDbRating") + "\u001b[m\u001b[m");


            int starsNumber = (int) rating;

            for (int i = 1; i <= starsNumber; i++) {
                System.out.print("\uD83C\uDF1F");
            }
            System.out.println("\n");
        }
    }
}