package collections;

import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.TreeSet;

public class UseTreeSet {

    @AllArgsConstructor
    static class Duck implements Comparable<Duck>{
        private String name;

        @Override
        public int compareTo(Duck o) {
            return this.name.compareTo(o.name);
        }
    }

    @AllArgsConstructor
    static class Bird{
        private String name;
    }

    public static void main(String[] args) {
        Set<Duck> duckSet = new TreeSet<>();
        Set<Bird> birdSet = new TreeSet<>();
        Set<Bird> birdSet2 = new TreeSet<>((b1,b2) -> b1.name.compareTo(b2.name));
        duckSet.add(new Duck("ducky"));
        // birdSet.add(new Bird("birdy")); // Bird does not implement Comparable and so the position to be inserted cannot be determined
        birdSet2.add(new Bird("birdy"));
    }

}
