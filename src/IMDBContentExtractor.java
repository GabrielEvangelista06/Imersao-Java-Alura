import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMDBContentExtractor {
    public List<Content> extractContent(String json) {
        // Pegar somente os dados que interessam (Título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> attributeList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        // Popular a lista de contents

        for (Map<String, String> attributes : attributeList) {
            String title = attributes.get("title");
            String imageUrl = attributes.get("image");
            String urlBigImage = imageUrl.replaceFirst("(@?\\.)([0-9A-Z,_]+).jpg$", "$1.jpg");

            var content = new Content(title, urlBigImage);

            contents.add(content);
        }

        return contents;
    }
}
