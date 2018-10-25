package collections;

import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.TreeSet;

public class UseTreeSet {

    @AllArgsConstructor
    static class Duck implements Comparable<Duck>{
        private String name;

        @Override
        public String toString() {
            return "Duck{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Duck o) {
            return this.name.compareTo(o.name);
        }
    }

    @AllArgsConstructor
    static class Bird{
        private String name;

        @Override
        public String toString() {
            return "Bird{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Set<Duck> duckSet = new TreeSet<>(); // will sort in natural order
        Set<Bird> birdSet = new TreeSet<>();
        Set<Bird> birdSet2 = new TreeSet<>((b1,b2) -> -b1.name.compareTo(b2.name)); // will sort in reverse order by name
        duckSet.add(new Duck("ducky"));
        duckSet.add(new Duck("dacky"));
        duckSet.add(new Duck("wuckky"));
        System.out.println(duckSet);
        // birdSet.add(new Bird("birdy")); // Bird does not implement Comparable and so the position to be inserted cannot be determined
        birdSet2.add(new Bird("virdy"));
        birdSet2.add(new Bird("birdy"));
        birdSet2.add(new Bird("wirdy"));
        System.out.println(birdSet2);
    }

}
