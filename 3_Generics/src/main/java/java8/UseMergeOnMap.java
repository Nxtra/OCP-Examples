package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class UseMergeOnMap {

    public static void main(String[] args) {

        Map<String, String> favoriteFood = new HashMap<>();
        favoriteFood.put("Nick", "Fries");
        favoriteFood.put("Tom", null);

        BiFunction<String, String, String> mapper = (s1, s2) -> s1.compareTo(s2) < 0 ? s1 : s2;

        favoriteFood.merge("Nick", "Pancakes", mapper);
        favoriteFood.merge("Loren", "Strawberries", mapper);
        favoriteFood.merge("Tom", "Icecream", mapper);

        favoriteFood.forEach((k,v) -> System.out.println(k + " : " + v));
    }
}
