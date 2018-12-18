import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

public class Manipulate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2018, Month.JANUARY, 31);
        System.out.println(date);
        date = date.plusMonths(1);
        System.out.println(date);
        date = date.plusMonths(1);
        System.out.println(date);
        date = date.plusDays(4);
        System.out.println(date);

        LocalTime time = LocalTime.of(15, 30);
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);
        time = time.plusHours(5);
        System.out.println(dateTime);
        dateTime = dateTime.plusHours(10);
        System.out.println(dateTime);
        dateTime = dateTime.plusHours(-2);
        System.out.println(dateTime);
        dateTime = dateTime.minusHours(4);
        System.out.println(dateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        Period period = Period.of(3,2,1);
        System.out.println(period);
        Period period1 = Period.ofMonths(1);
        period = period.plus(period1);
        System.out.println(period);
        Period period2 = Period.ofMonths(2).ofYears(1); // Watch out for this!
        System.out.println(period2);

        zonedDateTime = zonedDateTime.plus(period);
        System.out.println(zonedDateTime);

        Duration duration = Duration.ofHours(5);
        Duration duration1 = Duration.of(10, ChronoUnit.HOURS);
        // System.out.println(ChronoUnit.HOURS.between(duration, duration1)); Does not compile
        // Duration duration2 = Duration.between(duration, duration1); Does not compile
        zonedDateTime = zonedDateTime.plus(duration);
        System.out.println(zonedDateTime);

        Instant now = Instant.now();
        System.out.println(IntStream.range(0,1000).sum());
        Instant later = Instant.now();
        System.out.println(Duration.between(now, later).toMillis());
        Instant instant = zonedDateTime.toInstant();
        // the following lines represent the same point in time
        System.out.println(zonedDateTime);
        System.out.println(instant);

        LocalDate d = LocalDate.of(2018, Month.JANUARY, 31);
        LocalTime t = LocalTime.of(15, 30);
        LocalDateTime dt = LocalDateTime.of(date, time);
        ZoneId zone = ZoneId.of("Europe/Paris");
        ZonedDateTime zdt = ZonedDateTime.of(date, time, zone);
        System.out.println(zdt);

        Instant i = Instant.now();
        System.out.println(i);
        Instant nextInstant = i.plus(1, ChronoUnit.DAYS);
        System.out.println(nextInstant);
        // nextInstant = nextInstant.plus(1, ChronoUnit.WEEKS); Not supported

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        // both of the following lines produce the same result
        System.out.println(formatter.format(ldt));
        System.out.println(ldt.format(formatter));


    }
}
