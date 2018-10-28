package AdvancedConcepts.collectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UseCollectors {

    public static void main(String[] args) {

        // when using Arrays.asList the List will be unmodifiable
        List<String> givenList = new ArrayList<>(Arrays.asList("Yes", "No", "Maybe"));


        List<String> list = CollectorUtils.streamAndCollectToList(givenList);

        List<String> linkedList = CollectorUtils.streamAndCollectToLinkedList(givenList);

        Set<String> set = CollectorUtils.streamAndCollectToSet(givenList);


        Map<String, Integer> mapWithoutDuplicatekeys = CollectorUtils.streamAndCollectToMapNoDuplicateKeys(givenList);

        // add new elements to create duplicate keys and entries
        givenList.addAll(Arrays.asList("Yes", "No", "Mmeuh", "Don't care", "four", "go", "omg"));

        System.out.println("<!------------Maps With duplicate keys and sorted: take first--------------->");
        Map<String, Integer> mapWordLength = CollectorUtils.streamAndCollectToMapWithDuplicateKeysTakeFirst(givenList);
        mapWordLength.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("<!------------Maps With duplicate keys and sorted: append--------------->");
        Map<Integer, String> mapLengthWord = CollectorUtils.streamAndCollectToMapWithDuplicateKeysAppendString(givenList);
        mapLengthWord.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("<!------------Maps With duplicate keys and sorted: create sorted set--------------->");
        Map<Integer, Set<String>> mapLengthWordMap = CollectorUtils.streamAndCollectToMapWithDuplicateKeysMakeSortedSet(givenList);
        mapLengthWordMap.forEach((k, v) -> System.out.println(k + " : " + v));

    }


}
