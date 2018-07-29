package nickvanhoof.abstractInterFaceOrClass;

public class AbstractClassExample extends AbstractClass{

    // You have to implement abstract methods unless your are subclassing to an abstract class itself
    @Override
    String yell() {
        return "JOOO";
    }

    // AbstractClass SingletonB = new AbstractClass();
    // Does not compile, you cannot instantiate an abstract class
}

abstract class AbstractClass{
    public void print(){
        System.out.println("PPPRRRRIIIINNNNTTT");
    };

    abstract String yell();


}
