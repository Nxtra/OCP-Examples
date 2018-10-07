package collections;


import org.apache.commons.lang3.time.StopWatch;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class MapMap {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        
        AnimalA animalA1 = new AnimalA("Nick", 3);
        AnimalA animalA2 = new AnimalA("Lorrie", 23);
        AnimalA animalA3 = new AnimalA("Jos", 34);
        AnimalA animalA4 = new AnimalA("Jan", 43);
        AnimalA animalA5 = new AnimalA("Jakke", 25);
        AnimalA animalA6 = new AnimalA("Nwick", 3);
        AnimalA animalA7 = new AnimalA("Lworrie", 23);
        AnimalA animalA8 = new AnimalA("Jwos", 34);
        AnimalA animalA9 = new AnimalA("Jwan", 43);
        AnimalA animalA10 = new AnimalA("Jwakke", 25);

        Set<AnimalA> animalASet = new HashSet<>(Arrays.asList(animalA1, animalA2, animalA3, animalA4, animalA5, animalA6, animalA7, animalA8, animalA9, animalA10));
        AnimalA animalATest = new AnimalA("Jwan", 43);

        Instant start = Instant.now();
        long startTime = System.nanoTime();
        print(animalASet.contains(animalATest));
        print(System.nanoTime() - startTime);
        Instant end = Instant.now();
        print(Duration.between(start, end));



        AnimalB animalB1 = new AnimalB("Nick", 3);
        AnimalB animalB2 = new AnimalB("Lorrie", 23);
        AnimalB animalB3 = new AnimalB("Jos", 34);
        AnimalB animalB4 = new AnimalB("Jan", 43);
        AnimalB animalB5 = new AnimalB("Jakke", 25);
        AnimalB animalB6 = new AnimalB("Nwick", 3);
        AnimalB animalB7 = new AnimalB("Lworrie", 23);
        AnimalB animalB8 = new AnimalB("Jwos", 34);
        AnimalB animalB9 = new AnimalB("Jwan", 43);
        AnimalB animalB10 = new AnimalB("Jwakke", 25);

        Set<AnimalB> animalBSet = new HashSet<>(Arrays.asList(animalB1, animalB2, animalB3, animalB4, animalB5, animalB6, animalB7, animalB8, animalB9, animalB10));
        AnimalB animalBTest = new AnimalB("Jwan", 43);

        Instant startB = Instant.now();
        long startTimeB = System.nanoTime();
        print(animalBSet.contains(animalBTest));
        print(System.nanoTime() - startTimeB);
        Instant endB = Instant.now();
        print(Duration.between(startB, endB));


    }

    private static void print(Object object){
        System.out.println(object.toString());
    }

    public static void sleep() {
        System.out.println("1 second goes by");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

class AnimalA {
    private String name;
    private int age;

    public AnimalA(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalA animal = (AnimalA) o;
        return age == animal.age &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}

class AnimalB {
    private String name;
    private int age;

    public AnimalB(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalB animal = (AnimalB) o;
        return age == animal.age &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }

}
