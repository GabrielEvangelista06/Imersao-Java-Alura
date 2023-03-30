import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {
    public List<Content> extractContent(String json) {
        var parser = new JsonParser();
        List<Map<String, String>> attributeList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        for (Map<String, String> attributes : attributeList) {
            String title = attributes.get("title");
            String imageUrl = attributes.get("url");

            var content = new Content(title, imageUrl);

            contents.add(content);
        }

        return contents;
    }
}
