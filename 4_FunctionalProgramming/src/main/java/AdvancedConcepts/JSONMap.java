package AdvancedConcepts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JSONMap {

    private static final String JSON = getFile("example.json");
    private static final List<String> ALLOWEDKEYS = Arrays.asList("firstName", "name", "phoneNumbers", "age");

    // if only I'd use Java9 .. Map<String, String> map = Map.of("some", "A", "bla", "B");
    private static final Map<String, String> TRANSFORMATIONS;

    static {
        TRANSFORMATIONS = Collections.unmodifiableMap(new HashMap<String, String>() {
            {
                put("phoneNumbers", "numbers");
                put("name", "lastName");
            }
        });
    }

    public static void main(String[] args){
        Map<String, Object> result = updateJSON(convertJsonToSortedMap(JSON));

        result.put("shizzle", "someShizzle");
        result.put("otherShizzle", "someOtherShizzle");

        printJSON(result);
    }

    // I want the current keys to keep their order and the added keys to be appended at the end
    private static Map<String,Object> updateJSON(Map<String, Object> json) {
        return json.entrySet()
                .stream()
                .filter(e -> ALLOWEDKEYS.contains(e.getKey()))
                .collect(Collectors.toMap(
                        x -> updateKey(x, TRANSFORMATIONS),
                        Map.Entry::getValue,
                        (x, y) -> y,
                        LinkedHashMap::new));
    }

    private static String updateKey(Map.Entry<String, Object> entry, Map<String, String> transformations){
        if (transformations.containsKey(entry.getKey())) {
            return transformations.get(entry.getKey());
        } else {
            return entry.getKey();
        }
    }

    private static void printJSON(Map<String, Object> map) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(map);
        System.out.print(json);
    }

    // I want the JSON keys sorted -> TreeMap
    private static Map<String, Object> convertJsonToSortedMap(String json){
        return (TreeMap<String,Object>) new Gson().fromJson(json, TreeMap.class);
//        return new ObjectMapper().readValue(JSON, HashMap.class);
    }

    private static String getFile(String fileName) {
        StringBuilder result = new StringBuilder();

        //Get file from resources folder
        ClassLoader classLoader = JSONMap.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();

    }
}
