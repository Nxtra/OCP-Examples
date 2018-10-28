package UsingStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This java program demonstrates the use of 'flatMap()' method in Java8 programming.
 * The 'flatMap()' function is used to convert a Stream of list of values to a Stream of values and this process is called "Flattening of Streams".
 *
 * @author Batra, Yatin
 **/
public class UseFlatMap {

    public static void main(String[] args) {

        List<String> team1 = Arrays.asList("John", "Joe", "Averell");
        List<String> team2 = Arrays.asList("Dede", "Dada", "Doedoe");
        List<String> team3 = Arrays.asList("Sif", "Soef", "Saaf");
        List<String> team4 = Arrays.asList("Teil", "Toel", "Tiel");

        List<List<String>> league = new ArrayList<>();
        league.add(team1);
        league.add(team2);
        league.add(team3);
        league.add(team4);


        List<String> allPlayers = new ArrayList<>();
        for(List<String> team : league) {
            for(String name : team) {
                allPlayers.add(name);
            }
        }
        System.out.println(allPlayers);



        List<String> flatList = league.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(flatList);
    }
}