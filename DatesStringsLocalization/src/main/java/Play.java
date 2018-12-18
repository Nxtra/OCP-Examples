import java.time.Duration;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Play {
    public static void main(String[] args) {
        String m1 = Duration.ofMinutes(1).toString();
        String m2 = Duration.of(60, ChronoUnit.SECONDS).toString();
        System.out.println(m1);
        System.out.println(m2);

        Month month = Month.JANUARY;
        System.out.println(month.getValue());
        Month month1 = Month.of(1);
        System.out.println(month1);
    }
}
