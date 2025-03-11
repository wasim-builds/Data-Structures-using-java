import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTime{
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Date and Time in New York: " + zonedDateTime);
    }
}


