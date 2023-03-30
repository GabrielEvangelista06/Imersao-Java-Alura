import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMDBContentExtractor implements ContentExtractor {
    public List<Content> extractContent(String json) {
        var parser = new JsonParser();
        List<Map<String, String>> attributeList = parser.parse(json);

        return attributeList.stream().map(attibutes -> new Content(attibutes.get("title"), attibutes.get("image").replaceAll("(@?\\.)([0-9A-Z,_]+).jpg$", "$1.jpg"))).toList();
    }
}
