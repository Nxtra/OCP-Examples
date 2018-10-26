package UsingStreams;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamUtils {

    // Generates an finite stream of random doubles between 0 and 1
    static Stream<Double> randomDoubles(int limit){
        return Stream.generate(Math::random).limit(limit);
    }

    // Finite array of random Integers between range
    static Stream<Integer> generateRandomListInRange(int size, int lowest, int heighest){
        return new Random().ints(size, lowest, heighest).boxed();
    }

    // Finite array of random Integers between range
    static Stream<Integer> generateRandomIntStreamInRange(int size, int lowest, int heighest){
        return new Random().ints(size, lowest, heighest).boxed();
    }

    static Stream<Integer> skipAndLimitStream(Stream<Integer> integerStream, int skipTo, int limitTo){
        return integerStream.skip(skipTo).limit(limitTo);
    }

    static Stream<String> flatmapListsOfStrings(List<String> ... lists){
        return Stream.of(lists).flatMap(list -> list.stream());
    }


}
