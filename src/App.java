import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://api.nasa.gov/planetary/apod?api_key=6QxCgNSDuBbgIhke6m3aymdgbSIRNYndw6p84EhJ&start_date=2023-03-27&end_date=2023-03-30";

        var http = new ClientHttp();
        String json = http.getData(url);

        ContentExtractor extractor = new NasaContentExtractor();
        List<Content> contents = extractor.extractContent(json);

        var generator = new StickGenerator();

        String stickerText = "Parabéns";

        for (int i = 0; i < contents.size(); i++) {
            Content content = contents.get(i);

            InputStream inputStream = new URL(content.getImageUrl()).openStream();
            String fileName = content.getTitle() + ".png";

            generator.create(inputStream, fileName, stickerText);

            System.out.println("\u001b[1mTítulo: \u001b[m" + content.getTitle());
        }
    }
}