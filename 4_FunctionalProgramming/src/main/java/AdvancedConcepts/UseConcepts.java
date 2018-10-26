package AdvancedConcepts;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseConcepts {

    public static void main(String[] args) {


        print(getStreamOfStrings().collect(Collectors.averagingInt(String::length)));



        print(getStreamOfStrings().collect(Collectors.groupingBy(String::length)));

        print(getStreamOfStrings().collect(Collectors.groupingBy(String::length, Collectors.toSet())));

        print(getStreamOfStrings().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet())));


        // Trying to figure out why grouping by output seems sorted
        print(getStreamOfShizzle().collect(Collectors.groupingBy(sh -> sh.getShizzleString().length(), Collectors.toSet())));

        print(getStreamOfShizzle().collect(Collectors.groupingBy(sh -> sh.getShizzleString().length(), TreeMap::new, Collectors.toSet())));


    }

    private static void print(Object resource){
        System.out.println(resource);
    }

    private static Stream<String> getStreamOfStrings(){
        return Stream.of("Nick", "Nack", "jes", "in", "Nick", "food", "hungry", "JoMan");
    }

    private static Stream<Shizzle> getStreamOfShizzle(){
        Shizzle shizzle1 = new Shizzle("Nick");
        Shizzle shizzle2 = new Shizzle("Nack");
        Shizzle shizzle3 = new Shizzle("jes");
        Shizzle shizzle4 = new Shizzle("in");
        Shizzle shizzle5 = new Shizzle("Nick");

        return Stream.of(shizzle1,shizzle2, shizzle3, shizzle4, shizzle5);
    }

    @AllArgsConstructor
    @Getter
    static class Shizzle{

        private String shizzleString;

        @Override
        public int hashCode() {

            return new Random().nextInt();
        }

        @Override
        public String toString() {
            return "Shizzle{" +
                    "shizzleString='" + shizzleString + '\'' +
                    '}';
        }
    }
}
