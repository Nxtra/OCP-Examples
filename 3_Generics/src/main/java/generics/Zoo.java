package generics;

import java.lang.reflect.AnnotatedArrayType;

public class Zoo {

    Bear bear = new Bear();
    Crate<Animal> crate = new Crate<>();

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.crate.inputCrate(zoo.bear);
        Animal outputAnimal = zoo.crate.getContent(); //cast to Animal will be added at compile time
    }



    class Crate <T> {
        private T content;

        public T getContent(){
            return content;
        }

        public void inputCrate(T animal){
            content = animal;
        }
    }

    class Bear extends Animal{

    }

    class Animal implements LivingThing{
        private String name;
        private String species;

        public String getSpecies(){
            return species;
        }

        public String getName() {
            return name;
        }

        @Override
        public void think() {
            System.out.println(String.format("%s is thinking", name));
        }
    }

    interface LivingThing{
        void think();
    }
}
