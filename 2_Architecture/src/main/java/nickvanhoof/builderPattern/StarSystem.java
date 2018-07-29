package nickvanhoof.builderPattern;

import java.util.ArrayList;
import java.util.List;

public final class StarSystem {

    private final String name;
    private final int numberOfStars;
    private final List<String> planets;

    public StarSystem(String name, int numberOfStars, List<String> planets){
        this.name = name;
        this.numberOfStars = numberOfStars;
        this.planets = planets;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public List<String> getPlanets() {
        return new ArrayList<String>(planets);
    }

    public String getPlanet(int index){
        return planets.get(index);
    }

    @Override
    public String toString(){
        return "System: " + name + ",\n numberOfStars: " + numberOfStars + ",\n planets: " + planets.toString();
    }
}