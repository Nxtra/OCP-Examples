package nickvanhoof.polymorphism;

public class Polymorphism {

    public static void main(String[] args) {
	    Animal animal1 = new Cat();
        Animal animal2 = new Tiger();
        Animal animal3 = new Lion();
        Animal animal4 = new Puma();

        System.out.println(animal1.getSound()); //meow
        System.out.println(animal2.getSound()); //meow
        System.out.println(animal3.getSound()); //Roar
        System.out.println(animal4.getSound()); //Rraar

        System.out.println(((Tiger) animal2).getSound()); //meow
        System.out.println(((Lion) animal3).getSound());  //Roar
        System.out.println(((Puma) animal4).getSound());  //Rraar

        // animal4.eatFood(); does not compile
        ((Puma) animal4).eatFood();

        //animal4.climbTree();//does not compile, cause method in unavailable in the reference type of this animal
        ((Puma) animal4).climbTree();//does compile, cause we casted the reference type to Puma
    }
}

interface Animal{

    public String getSound();
}

class Cat implements Animal{

    protected String sound = "meow";
    private boolean landAnimal = true;

    public String getSound() {
        return sound;
    }
}

class Tiger extends Cat{

    protected String sound = "Grr";//will look in Cat for getSound() method but not back in Tiger for sound
}

class Lion extends Cat{

    private String sound = "Roar";

    @Override
    public String getSound() {
        return sound;
    }

}

class Puma extends Cat{

    private String sound = "RRAAAR";

    @Override
    public String getSound(){
        return sound;
    }

    public void eatFood(){
        System.out.println("Yum Yum");
    }

    public void climbTree(){
        System.out.println("I'm currently in a tree");
    }
}



