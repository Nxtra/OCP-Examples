package Exceptions;

public class Suppressed {
    static class Tools implements AutoCloseable{
        @Override
        public void close() throws IllegalArgumentException {
            throw new IllegalArgumentException("OMG what did I do");
        }
    }

    public static void main(String[] args) {
        try(Tools tools = new Tools()){
            throw new RuntimeException("Oh No");
        } catch (IllegalArgumentException e){
            System.out.println("Exception occured: " + e.getMessage());
        }
    }
}
