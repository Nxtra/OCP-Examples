package nickvanhoof.polymorphism;

public class Polymorphism {

    public static void main(String[] args) {
	    Animal animal1 = new Cat();
        Animal animal2 = new Tiger();
        Animal animal3 = new Lion();
        Animal animal4 = new Puma();

        System.out.println(animal1.getSound());
        System.out.println(animal2.getSound());
        System.out.println(animal3.getSound());
        System.out.println(animal4.getSound());

        System.out.println(((Tiger) animal2).getSound());
        System.out.println(((Lion) animal3).getSound());
        System.out.println(((Puma) animal4).getSound());

        ((Puma) animal4).eatFood();
    }
}

interface Animal{

    public String getSound();
}

class Cat implements Animal{

    public String sound = "meow";

    public String getSound() {
        return sound;
    }
}

class Tiger extends Cat{

    @Override
    public String getSound() {
        return sound;
    }
}

class Lion extends Cat{

    public String sound = "Roar";


}

class Puma extends Cat{

    public String sound = "RRAAAR";

    @Override
    public String getSound(){
        return sound;
    }

    public void eatFood(){
        System.out.println("Yum Yum");
    }
}



