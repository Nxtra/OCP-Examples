package collections;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UseHashSet {

    public static void main(String[] args) {
        Drink firstDrink = new Drink("Cola", true, 13);
        Drink secondDrink = new Drink("Beer", true, 4);
        Drink thirdDrink = new Drink(   "Wiskey", false, 1);
        Drink fourthDrink = new Drink("Water", false, 14);

        Set<Drink> setOfDrinks = new HashSet<>(Arrays.asList(firstDrink, secondDrink, thirdDrink, fourthDrink));

        // [Drink{name='Wiskey', number=1}, Drink{name='Beer', number=4}, Drink{name='Cola', number=13}, Drink{name='Water', number=14}]
        System.out.println(setOfDrinks);
    }

    @AllArgsConstructor
    static class Drink{
        private String name;
        private boolean isSparkley;
        private int number;

        @Override
        public String toString() {
            return "Drink{" +
                    "name='" + name + '\'' +
                    ", number=" + number +
                    '}';
        }

        @Override
        public int hashCode() {
            return number;
        }
    }
}
