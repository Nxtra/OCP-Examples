package UsingStreams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingStreams {

    private static List<String> list1;
    private static List<String> list2;
    private static List<String> list3;


    public static void main(String[] args) {

        generateResources();

        print(StreamUtils.generateRandomListInRange(10, 0, 46)
                .collect(Collectors.toList()));

        StreamUtils.generateRandomIntStreamInRange(100,0,60)
                .filter(i -> i == 57)
                .findAny()
                .ifPresent(System.out::println);

        print(StreamUtils.generateRandomIntStreamInRange(50,0,100)
                .anyMatch(i -> i == 57));

        print(reduceThreeLetterStreamToString('t', 'h', 'e'));
        print(collectThreeLetterStreamToStringBuilder('t', 'h', 'e'));
        print(collectListOfStringsToTreeSet(Arrays.asList("e", "a", "c", "b", "e", "d")));
        print(collectListOfStringsToReverseOrderTreeSet(Arrays.asList("e", "a", "c", "b", "e", "d")));

        print(StreamUtils.skipAndLimitStream(Stream.iterate(1, n -> n * 2), 3, 20)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll));

        StreamUtils.flatmapListsOfStrings(list1, list2).forEach(System.out::println);



    }

    private static void generateResources(){
        list1 = Arrays.asList("myName", "yourName");
        list2 = Arrays.asList("joo", "jeej");
        list3 = Arrays.asList("stringy", "strangy");
    }

    private static void print(Object resource){
        System.out.println(resource);
    }

    private static String reduceThreeLetterStreamToString(char a, char b, char c){
        return Stream.of(a, b, c).map(Object::toString)
                .reduce("", (first, second) -> String.valueOf(first) + String.valueOf(second));
    }

    private static StringBuilder collectThreeLetterStreamToStringBuilder(char a, char b, char c){
        return Stream.of(a, b, c).map(Object::toString)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
                // . collect
    }

    private static Set<String> collectListOfStringsToReverseOrderTreeSet(List<String> list){
        return list.stream().collect(() -> new TreeSet<>((s1, s2) -> s2.compareTo(s1)), TreeSet::add, TreeSet::addAll);
        //return list.stream().collect(Collectors.toCollection(TreeSet::new));
        //return new TreeSet(list);
    }

    private static Set<String> collectListOfStringsToTreeSet(List<String> list){
        return list.stream().collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        //return list.stream().collect(Collectors.toCollection(TreeSet::new));
        //return new TreeSet(list);
    }




}

