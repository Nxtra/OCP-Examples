package nickvanhoof.singleton;

class SingletonB {
    private static SingletonB ob;

    private SingletonB(){}

    static {
        ob = new SingletonB();
    }

    public static synchronized SingletonB getInstance() {
        return ob;
    }
}