import java.time.*;

public class DaylightSaving {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, Month.MARCH, 31);
        LocalTime time = LocalTime.of(2,30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        ZoneId zone = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zone);
        System.out.println(zonedDateTime);
    }
}
