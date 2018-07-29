package nickvanhoof.builderPattern;

import java.util.List;

public class StarSystemBuilder {

    private String name;
    private int numberOfStars;
    private List<String> planets;

    public StarSystemBuilder setName(String name){
        this.name = name;
        return this;
    }

    public StarSystemBuilder setNumberOfStars(int numberOfStars){
        this.numberOfStars = numberOfStars;
        return this;
    }

    public StarSystemBuilder setPlanets(List<String> planets){
        this.planets = planets;
        return this;
    }

    public StarSystem build(){
        return new StarSystem(name, numberOfStars, planets);
    }
}
