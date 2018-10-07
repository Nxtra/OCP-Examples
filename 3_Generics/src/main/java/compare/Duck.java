package compare;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Log
public class Duck implements Comparable<Duck> {

    private String name;
    private int age;
    private int weight;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Duck o) {
        return this.name.compareTo(o.name);
    }

    public static void main(String[] args) {

        Comparator<Duck> byAge = (d1, d2) -> d1.age - d2.age;

        List<Duck> ducks = Arrays.asList(new Duck("Joam", 23, 1), new Duck("Kwak", 21,2), new Duck("Kwib", 21, 1));

        Collections.sort(ducks);
        log.info(ducks.toString());

        Collections.sort(ducks, byAge);
        log.info(ducks.toString());

        Collections.sort(ducks, new ChainedComparator());
        log.info(ducks.toString());


    }

}

class ChainedComparator implements Comparator<Duck>{

    @Override
    public int compare(Duck o1, Duck o2) {
        Comparator<Duck> comparator = Comparator.comparing(duck -> duck.getAge());
        comparator = comparator.thenComparing(duck -> duck.getWeight());
        return comparator.compare(o1, o2);
    }
}
