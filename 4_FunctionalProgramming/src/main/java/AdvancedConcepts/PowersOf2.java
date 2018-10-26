package AdvancedConcepts;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PowersOf2 {
    public static void main(String[] args) {
        Map<Integer, Integer> powersOf2 = generatePowerMap(2);
        powersOf2.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    private static Map<Integer, Integer> generatePowerMap(int base){
        return IntStream.rangeClosed(0, 20)
                .boxed()
                .collect(Collectors.toMap(n -> n, n -> ((Double) Math.pow(base, n)).intValue()));
    }
}
