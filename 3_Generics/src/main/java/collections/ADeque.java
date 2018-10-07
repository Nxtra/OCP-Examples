package collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class ADeque {

    public static void main(String[] args) {
        Queue<Integer> arrayDeque = new ArrayDeque<>();

        print(arrayDeque); // []
        print(arrayDeque.offer(12)); // true or false
        print(arrayDeque.add(13)); // true or Exception
        ((ArrayDeque<Integer>) arrayDeque).push(23); // Interface que does not have push method

        print(arrayDeque); // [23, 12, 13]
        print(arrayDeque.poll()); // 23
        print(arrayDeque.remove()); //12

        print(arrayDeque); // [13]
        print(arrayDeque.peek()); // 13
        ((ArrayDeque<Integer>) arrayDeque).pop();

        print(arrayDeque);
        arrayDeque.poll(); // null
        // arrayDeque.remove(); //NoSuchElementException
    }

    private static void print(Object object){
        System.out.println(object.toString());
    }
}
