import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class JsonParser {

    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");
    public List<Map<String, String>> parse(String json) {
        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Não encontrou items.");
        }

        String[] itens = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> dados = new ArrayList<>();

        for (String item : itens) {

            Map<String, String> itemAttributes = new HashMap<>();

            Matcher matcherAttributesJson = REGEX_ATRIBUTOS_JSON.matcher(item);
            while (matcherAttributesJson.find()) {
                String attribute = matcherAttributesJson.group(1);
                String value = matcherAttributesJson.group(2);
                itemAttributes.put(attribute, value);
            }

            dados.add(itemAttributes);
        }

        return dados;
    }
}
