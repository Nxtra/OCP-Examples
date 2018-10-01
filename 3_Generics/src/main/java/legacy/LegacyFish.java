package legacy;

import java.util.ArrayList;
import java.util.List;

class Fish{}
class Reptile{}

public class LegacyFish {

    public static void main(String[] args) {
        List reptiles = new ArrayList();
        reptiles.add(new Reptile());
        printFishes(reptiles);
    }

    private static void printFishes(List<Fish> fishes){
        for(Fish fish: fishes){ // ClassCastException: trying to cast a Reptile to a Fish
            System.out.println(fish);
        }
    }

}
