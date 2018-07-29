package nickvanhoof.builderPattern;

import java.util.ArrayList;
import java.util.List;

public final class StellarSystem {

    private final String name;
    private final int numberOfStars;
    private final List<String> planets;

    //private constructor forces user to instantiate StellarSystem by using StellarSystemBuilder
    private StellarSystem(StellarSystemBuilder builder){
        this.name = builder.name;
        this.numberOfStars = builder.numberOfStars;
        this.planets = builder.planets;
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

    //Tight coupling between StellarSystem and StellarSystemBuilder
    //In same class to make sure classes can be quickly updated when one of them is changed
    public static class StellarSystemBuilder {
        private String name;
        private int numberOfStars;
        private List<String> planets;

        public StellarSystemBuilder setName(String name){
            this.name = name;
            return this;
        }

        public StellarSystemBuilder setNumberOfStars(int numberOfStars){
            this.numberOfStars = numberOfStars;
            return this;
        }

        public StellarSystemBuilder setPlanets(List<String> planets){
            this.planets = planets;
            return this;
        }

        public StellarSystem build(){
            return new StellarSystem(this);
        }
    }
}
