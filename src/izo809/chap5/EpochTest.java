package izo809.chap5;

import java.time.*;

public class EpochTest {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2018, Month.MARCH, 25);
        LocalTime time = LocalTime.of(2, 30);
        ZoneId zone = ZoneId.of("CET");

        ZonedDateTime cet = ZonedDateTime.of(date, time, zone);
        System.out.println(cet);

        Instant instant = cet.toInstant();
        System.out.println(instant);

        ZonedDateTime gmt = instant.atZone(ZoneId.of("GMT"));
        System.out.println(gmt);

        ZonedDateTime eastern = instant.atZone(ZoneId.of("US/Eastern"));
        System.out.println(eastern);

        System.out.println(cet.toEpochSecond());
        System.out.println(gmt.toEpochSecond());
        System.out.println(eastern.toEpochSecond());
    }

}
