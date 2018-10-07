package java8;

public class SortHelper {
    public static int compareByName(Animaal a1, Animaal a2){
        return a1.getName().compareTo(a2.getName());
    }

    public static int compareByWeight(Animaal a1, Animaal a2){
        return a1.getWeight() - a2.getWeight();
    }
}
