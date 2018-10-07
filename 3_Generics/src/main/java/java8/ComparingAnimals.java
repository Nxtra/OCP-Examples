package java8;

import java.util.Comparator;

public class ComparingAnimals {

    public static void main(String[] args) {
        Comparator<Animaal> byName = (a1, a2) -> SortHelper.compareByName(a1,a2);
        Comparator<Animaal> byWeight = SortHelper::compareByName;
    }
}
