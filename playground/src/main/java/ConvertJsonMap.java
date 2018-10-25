import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertJsonMap {

    public static void main(String[] args) {


        /* This is how to declare HashMap */
        Map<String, Object> resources = new LinkedHashMap<>();

        /*Adding elements to HashMap*/
        resources.put("key", "124");
        resources.put("someKey", "235");
        resources.put("fun", "haha");
        resources.put("status", "READY");
        resources.put("date", "today");

        JsonUser jsonUser = new JsonUser();
        Map<String, Object> parsedJson = jsonUser.convertJsonMap(resources);
        System.out.println(parsedJson);


    }

    static class JsonUser{

        LinkedHashMap<String, Object> convertJsonMap(Map<String, Object> json){

            final List<String> keys = Arrays.asList("status", "date");

            LinkedHashMap<String, Object> result = json.entrySet()
                    .stream()
                    .filter(e -> keys.contains(e.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, fresh) -> fresh, LinkedHashMap::new));

            result.put("shizzle", "shiz");

            return result;
        }
    }
}
