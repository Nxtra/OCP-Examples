package nickvanhoof;

public class AbstractInterfaceExample implements test {


    @Override
    public void print() {

    }

    @Override
    public String yell() {
        return "SomeString";
    }
}

interface test{
    abstract void print();
    String yell();
}
