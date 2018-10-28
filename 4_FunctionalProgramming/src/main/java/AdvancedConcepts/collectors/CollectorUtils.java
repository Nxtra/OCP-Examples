package AdvancedConcepts.collectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CollectorUtils
{
    // collect to list

    static List<String> streamAndCollectToList(List<String> list){
        return list.stream().collect(Collectors.toList());
    }

    // collect to linkedlist
    static List<String> streamAndCollectToLinkedList(List<String> list){
        return list.stream().collect(Collectors.toCollection(LinkedList::new));
    }

    // collect to set
    static Set<String> streamAndCollectToSet(List<String> list){
        return list.stream().collect(Collectors.toSet());
    }

    // collect to map without implementation for duplicate keys
    static Map<String, Integer> streamAndCollectToMapNoDuplicateKeys(List<String> list){
        return list.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
    }

    // avoiding duplicate key collisions
    static Map<String, Integer> streamAndCollectToMapWithDuplicateKeysTakeFirst(List<String> list){
        return list.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (i1, i2) -> i1));
    }

    // collect to map and append String when same key
    static Map<Integer, String> streamAndCollectToMapWithDuplicateKeysAppendString(List<String> list){
        return list.stream()
                .collect(Collectors.toMap(String::length, Function.identity(), (i1, i2) -> i1 + ", " + i2));
    }

    // collect to map and combine words with same length in one list
    // sort  alphabetically
    static Map<Integer, Set<String>> streamAndCollectToMapWithDuplicateKeysMakeSortedSet(List<String> list){
        return list.stream()
                .collect(Collectors.toMap(String::length, s -> new TreeSet<>(Arrays.asList(s)),
                        (i1, i2) -> Stream.of(i1, i2).flatMap(Collection::stream)
                                .collect(Collectors.toCollection(() -> new TreeSet<String>(Comparator.comparing(String::toLowerCase))))
                ));
        //  same using Collectors.groupingBy
        //      .collect(Collectors.groupingBy(String::length,
        //                        TreeMap::new,
        //                        Collector.of(() -> new TreeSet<>(Comparator.comparing(String::toLowerCase)), Set::add, (a, b) -> a)));
    }

}
