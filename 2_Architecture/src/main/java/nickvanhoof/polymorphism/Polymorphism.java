package nickvanhoof.polymorphism;

import java.util.logging.Logger;

import static java.lang.System.out;

public class Polymorphism {

    private static final Logger LOGGER = Logger.getLogger( Polymorphism.class.getName() );

    public static void main(String[] args) {
	    Animal cat = new Cat();
        Animal tiger = new Tiger();
        Animal lion = new Lion();
        Animal puma = new Puma();
        Cat puma2 = new Puma();
        Cat seaCat = new SeaCat();

        out.println(cat.getSound()); // CatSound
        out.println(tiger.getSound()); // CatSound
        out.println(lion.getSound()); // LionSound
        out.println(puma.getSound()); // PumaSound

        // animal4.eatFood(); does not compile
        ((Puma) puma).eatFood();

        //animal4.climbTree();//does not compile, cause method in unavailable in the reference type of this animal
        ((Puma) puma).climbTree();//does compile, cause we casted the reference type to Puma

        out.println(((Cat) cat).isLandAnimal());//does compile, cause we casted the reference type to Puma
        out.println(((Puma) puma).isLandAnimal());//does compile, cause we casted the reference type to Puma
        out.println(puma2.isLandAnimal());//does compile, cause we casted the reference type to Puma
        out.println(seaCat.isLandAnimal());
    }
}

interface Animal{

    String getSound();
}

class Cat implements Animal{

    protected String sound = "CatSound";
    boolean landAnimal = true;

    public String getSound() {
        return sound;
    }

    boolean isLandAnimal() {
        return landAnimal;
    }
}

class Tiger extends Cat{

    protected String sound = "TigerSound";//will look in Cat for getSound() method but not back in Tiger for sound
}

class Lion extends Cat{

    private String sound = "LionSound";

    @Override
    public String getSound() {
        return sound;
    }

}

class Puma extends Cat{

    private String sound = "PumaSound";

    @Override
    public String getSound(){
        return sound;
    }

    void eatFood(){
        out.println("Yum Yum");
    }

    void climbTree(){
        out.println("I am climbing a tree");
    }
}

class SeaCat extends Cat{

    boolean landAnimal = false;
}



