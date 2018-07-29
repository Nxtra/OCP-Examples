package nickvanhoof;

class SingletonA{
    private static SingletonA ob = new SingletonA();

    private SingletonA(){}

    public static SingletonA getInstance() {
        return ob;
    }
}