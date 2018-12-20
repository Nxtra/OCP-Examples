package ConcurrentCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentColls {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>(); // will not compile goes the iterator will go to next while the current element is gone
        Map<String, String> map = new ConcurrentHashMap<>(); // here iterator  will be updated after the remove of an element
        map.put("Nick", "Nack");
        map.put("Mick", "Mack");
        for(String key: map.keySet()){
            map.remove(key);
        }
    }
}
