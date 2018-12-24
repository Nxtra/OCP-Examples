package UsingStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class FlatMapInverse {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "C", "B", "AA", "BB", "CC");
        List<List<String>> val = new ArrayList<>(list.stream().sorted().collect(groupingBy(String::length)).values());
        System.out.println("Values " + val);
    }
}
