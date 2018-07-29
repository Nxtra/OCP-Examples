import nickvanhoof.builderPattern.StarSystem;
import nickvanhoof.builderPattern.StarSystemBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class StarSystemTest {

    @Test
    public void toStringTest(){
        StarSystem solarSystem = new StarSystemBuilder()
                .setName("Solar System")
                .setNumberOfStars(1)
                .setPlanets(Arrays.asList("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"))
                .build();

        String expectedResult = "System: Solar System,\n" +
                " numberOfStars: 1,\n" +
                " planets: [Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune]";

        assertEquals("toString did not return expectedResult" ,expectedResult, solarSystem.toString());
    }
}
