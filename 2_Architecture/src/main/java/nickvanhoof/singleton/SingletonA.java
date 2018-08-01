package nickvanhoof.singleton;

class SingletonA{
    private static SingletonA ob = new SingletonA();

    private SingletonA(){}

    public static synchronized SingletonA getInstance() {
        return ob;
    }
}