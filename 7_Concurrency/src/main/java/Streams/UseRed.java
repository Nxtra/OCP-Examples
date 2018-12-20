package Streams;

import java.util.Arrays;

public class UseRed {

    public static void main(String[] args) {
        String house = Arrays.asList('h', 'o', 'u', 's', 'e')
                .stream()
                .reduce("", (c,s1) -> c + s1, (s, t) -> s + t);
        System.out.println(house);

    }
}
