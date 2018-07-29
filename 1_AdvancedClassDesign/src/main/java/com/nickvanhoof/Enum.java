package com.nickvanhoof;

public class Enum {
    public static void main(String []args){
        Animal c = Animal.CAT;
        c.makeNoise();

        Animal m = Animal.MOUSE;
        m.makeNoise();
    }

    enum Animal {
        CAT("meow"){
            public void makeNoise() {
                System.out.println("MEOW");
            }
        },
        MOUSE("peepeep"){
            public void makeNoise(){
                System.out.println("PEEPEEP");
            }
        };

        private final String sound;

        Animal(String sound) { this.sound = sound; }

        public String getSound() { return sound; }
        public abstract void makeNoise();
    }
}
