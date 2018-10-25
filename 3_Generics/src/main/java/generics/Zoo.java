package generics;

import java.lang.reflect.AnnotatedArrayType;

import static java.lang.System.out;

public class Zoo {

    private Bear bear = new Bear("Olaf", "Black");
    private Crate<Animal> crate = new Crate<>();

    public Bear getBear() {
        return bear;
    }

    public Crate<Animal> getCrate() {
        return crate;
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.getCrate().inputCrate(zoo.getBear());
        Animal outputAnimal = zoo.getCrate().getContent(); //cast to Animal will be added at compile time
        out.println(outputAnimal);
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

        Bear(String name, String species) {
            this.name = name;
            this.species = species;
        }

        @Override
        public String toString() {
            return "Bear{" +
                    "name='" + name + '\'' +
                    ", species='" + species + '\'' +
                    '}';
        }
    }

    class Animal implements LivingThing{
        protected String name;
        protected String species;

        public String getSpecies(){
            return species;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", species='" + species + '\'' +
                    '}';
        }

        @Override
        public void think() {
            out.println(String.format("%s is thinking", name));
        }
    }

    interface LivingThing{
        void think();
    }

    public static  <E> boolean containsSomeThing(E [] listOfThings, E someThing){
        for (E e : listOfThings){
            if(e.equals(someThing)){
                return true;
            }
        }
        return false;
    }
}


