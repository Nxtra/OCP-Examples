import java.util.Random;

public class Assert {

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(5);
        System.out.println(number);
        assert 5 == number: "Not smaller";
    }
}
