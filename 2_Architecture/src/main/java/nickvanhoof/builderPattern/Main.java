package nickvanhoof.builderPattern;

import java.util.Arrays;

public class Main {

    public static void main (String... args){

        StarSystemBuilder starSystemBuilder = new StarSystemBuilder();

        StarSystem solarSystem = starSystemBuilder
                .setName("Solar System")
                .setNumberOfStars(1)
                .setPlanets(Arrays.asList("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"))
                .build();

        StellarSystem madeUpStellarSystem = new StellarSystem.StellarSystemBuilder()
                .setName("Uno")
                .setNumberOfStars(2)
                .setPlanets(Arrays.asList("Jakomo", "Jipsy", "Karakov"))
                .build();

        System.out.println(solarSystem);
        System.out.println(madeUpStellarSystem);
    }

}
