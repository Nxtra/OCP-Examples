package nickvanhoof;

class SingletonB {
    private static SingletonB ob;

    private SingletonB(){}

    static {
        ob = new SingletonB();
    }

    public static SingletonB getInstance() {
        return ob;
    }
}