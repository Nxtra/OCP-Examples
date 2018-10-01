package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToys {

    public static void main(String[] args) {
        printFoodList();
        printNumberList();
    }

    private static void printNumberList() {
        List<Integer> numberList = Arrays.asList(1,5,3,4);
        System.out.println(Collections.binarySearch(numberList, 2)); //prints -2, one less then negation of index where it should be inserted
    }

    private static void printFoodList(){
        String[] array = {"hotdog", "hamburger"};
        List<String> list = Arrays.asList(array);
        //list.remove("hotdog"); throws UnsuppportedOperationException
        //list.add("fries"); throws UnsuppportedOperationException
        System.out.println(list);
    }
}
