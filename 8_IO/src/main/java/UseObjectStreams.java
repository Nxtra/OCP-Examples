import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseObjectStreams {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p1 = new Person("Nick", "nxtra", 18);
        Person p2 = new Person("Phil", "fictio", 19);
        Person p3 = new Person("Phoe", "fecteo", 20);
        List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3));

        File dataFile = new File("./8_IO/src/main/resources/objects/people.data");

        writePeople(people, dataFile);
        List<Person> peopleAgain = getPeople(dataFile);
        System.out.println(peopleAgain);
    }

    static void writePeople(List<Person> people, File dataFile) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Person person : people) {
                out.writeObject(person);
            }
        }
    }

    static List<Person> getPeople(File dataFile) throws IOException, ClassNotFoundException {
        List<Person> people = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof Person) {
                    people.add((Person) object);
                }
            }
        } catch (EOFException e){}
        return people;
    }
}

class Person implements Serializable {

    String name;
    transient String nickName; // will be null after deserialization
    int age;
    static String race = "Human";

    public Person(String name, String nickName, int age) {
        this.name = name;
        this.nickName = nickName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }
}
