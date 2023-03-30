import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        API api = API.IMDB_TOP_MOVIES;
        String url = api.getUrl();

        var http = new ClientHttp();
        String json = http.getData(url);

        ContentExtractor extractor = api.getExtractor();
        List<Content> contents = extractor.extractContent(json);

        var generator = new StickGenerator();

        String stickerText = "Parabéns";

        for (int i = 0; i < contents.size(); i++) {
            Content content = contents.get(i);

            InputStream inputStream = new URL(content.imageUrl()).openStream();
            String fileName = content.title() + ".png";

            generator.create(inputStream, fileName, stickerText);

            System.out.println("\u001b[1mTítulo: \u001b[m" + content.title());
        }
    }
}