package nickvanhoof.abstractInterFaceOrClass;

public class AbstractInterfaceExample implements test {


    public void print() {

    }

    public String yell() {
        return "SomeString";
    }
}

//methods in interface are always public
//methods in interface that are not static or default are implicitly abstract
interface test{
    abstract void print();
    String yell();
}
