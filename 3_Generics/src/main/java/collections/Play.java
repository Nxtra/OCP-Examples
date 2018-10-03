package collections;

import java.util.*;

public class Play {

    public static void main(String[] args) {
        List<String> listOfPeople = new ArrayList<>(Arrays.asList("Nick", "Jan", "Pieter"));
        Set<String> setOfPeople = new HashSet<>(Arrays.asList("Nick", "Jan", "Pieter"));
        List<String> pets = Arrays.asList("Pipa", "Raya");
        print(listOfPeople.getClass().getName());
        print(pets.getClass().getName());
        //pets.add("Kita"); not supportedException because this list is immutable
        print(listOfPeople.add("Dieter")); //true
        print(setOfPeople.add("Dieter")); //true
        print(setOfPeople.add("Dieter")); //false
        print(listOfPeople.remove("Dieter")); //True
        print(listOfPeople.remove(2)); //Pieter
        print(listOfPeople.remove("Dieter")); //False
        listOfPeople.add("Jan");
        print(listOfPeople);
        listOfPeople.remove("Jan"); // Removes the first occurrence of the specified element from this list
        print(listOfPeople);
        print(listOfPeople.contains("Jan")); // True
        listOfPeople.clear(); //void
        print(listOfPeople.size()); // 0
        print(listOfPeople.isEmpty()); // true



    }

    private static void print(Object object){
        System.out.println(object.toString());
    }
}
