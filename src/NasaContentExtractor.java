import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {
    public List<Content> extractContent(String json) {
        var parser = new JsonParser();
        List<Map<String, String>> attributeList = parser.parse(json);

        return attributeList.stream().map(attributes -> new Content(attributes.get("title"), attributes.get("url"))).toList();
    }
}
