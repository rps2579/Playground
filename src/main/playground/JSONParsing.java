package main.playground;

//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.type.TypeReference;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;

public class JSONParsing {

//    private static final ObjectMapper objectMapper = new ObjectMapper();
//
//    public static Map<String, Object> parseJsonToMap(String json) throws IOException {
//        JsonNode rootNode = objectMapper.readTree(json);
//        return parseJsonNodeToMap(rootNode);
//    }
//
//    private static Map<String, Object> parseJsonNodeToMap(JsonNode node) {
//        Map<String, Object> resultMap = new HashMap<>();
//
//        if (node.isObject()) {
//            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
//            while (fields.hasNext()) {
//                Map.Entry<String, JsonNode> field = fields.next();
//                resultMap.put(field.getKey(), parseJsonNodeValue(field.getValue()));
//            }
//        } else if (node.isArray()) {
//            for (JsonNode arrayElement : node) {
//                resultMap.putAll(parseJsonNodeToMap(arrayElement));
//            }
//        }
//
//        return resultMap;
//    }
//
//    private static Object parseJsonNodeValue(JsonNode node) {
//        if (node.isObject() || node.isArray()) {
//            return parseJsonNodeToMap(node);
//        } else if (node.isTextual()) {
//            return node.asText();
//        } else if (node.isNumber()) {
//            return node.numberValue();
//        } else if (node.isBoolean()) {
//            return node.booleanValue();
//        }
//        return null;
//    }
//
//    public static void main(String[] args) throws IOException {
//        String jsonInput = "[{\"fields\":[{\"name\":\"dupes\",\"type\":\"ewr\",\"value\":{\"abc\":[\"asdf1\",\"asdf2\",\"asdf3\"]}},{\"name\":\"name\",\"type\":\"qwe\",\"value\":{\"en-TT\":\"tran1\",\"en-US\":\"tran2\"}},{\"name\":\"sampNested1\",\"type\":\"qwe\",\"value\":{\"name\":\"qwea\",\"type\":\"asf\",\"value\":{\"qw\":[\"96\"]}}},{\"name\":\"sampNested2\",\"type\":\"qwe\",\"value\":[{\"name\":\"qweart\",\"type\":\"asf\",\"value\":\"96\"}]}],\"deleted\":false}]";
//
//        Map<String, Object> resultMap = parseJsonToMap(jsonInput);
//        System.out.println(resultMap);
//    }
}

